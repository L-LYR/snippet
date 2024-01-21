/*
 * @lc app=leetcode.cn id=224 lang=scala
 *
 * [224] 基本计算器
 */
package Q224

// @lc code=start
object Solution {
  def calculate(s: String): Int = {
    calculator.rule(s.replace(" ", "").toList) match {
      case Success(v, _) => v
      case _             => throw new RuntimeException("?")
    }
  }

  sealed abstract class Result[+R]
  private case class Success[R](v: R, r: List[Char]) extends Result[R]
  private case class Failure(r: List[Char]) extends Result[Nothing]

  private case class Parser[A](rule: List[Char] => Result[A]) { self =>
    def map[B](f: A => B): Parser[B] = new Parser[B](l =>
      self.rule(l) match {
        case failure @ Failure(_) => failure
        case Success(v, r)        => Success(f(v), r)
      }
    )
    def flatMap[B](f: A => Parser[B]) = new Parser[B](l =>
      self.rule(l) match {
        case failure @ Failure(_) => failure
        case Success(v, r)        => f(v).rule(r)
      }
    )
  }

  private val fail: Parser[Nothing] = Parser(l => Failure(l))

  private def unit[A](a: A): Parser[A] = Parser(l => Success(a, l))
  private def or[A](p1: Parser[A], p2: Parser[A]): Parser[A] =
    Parser(l =>
      p1.rule(l) match {
        case success @ Success(_, _) => success
        case _                       => p2.rule(l)
      }
    )
  private val char: Parser[Char] = Parser {
    case Nil     => Failure(Nil)
    case c :: cs => Success(c, cs)
  }
  private def satisfy(p: Char => Boolean): Parser[Char] = for {
    c <- char
    r <- if (p(c)) unit(c) else fail
  } yield r

  private val digit = satisfy(c => c >= '0' && c <= '9')
  private val lp = satisfy(_ == '(')
  private val rp = satisfy(_ == ')')
  private val plus: Parser[(Int, Int) => Int] =
    satisfy(_ == '+').map(_ => (lopd, ropd) => lopd + ropd)
  private val minus: Parser[(Int, Int) => Int] =
    satisfy(_ == '-').map(_ => (lopd, ropd) => lopd - ropd)

  private def many[A](p: Parser[A]): Parser[List[A]] = or(many1(p), unit(Nil))
  private def many1[A](p: Parser[A]): Parser[List[A]] = for {
    a <- p
    as <- many(p)
  } yield a :: as

  private val number: Parser[Int] = many1(digit).map(_.mkString.toInt)
  private val factor: Parser[Int] = or(
    number,
    for {
      _ <- lp
      e <- expression
      _ <- rp
    } yield e
  )
  private val term = or(
    factor,
    for {
      _ <- satisfy(_ == '-')
      n <- factor
    } yield n * -1
  )

  private def chainl[A](p: Parser[A], ops: Parser[(A, A) => A]): Parser[A] =
    for {
      l <- p
      fs <- many(for {
        op <- ops
        r <- p
      } yield (op, r))
    } yield fs.foldLeft(l) { case (acc, (f, y)) => f(acc, y) }

  private val expression: Parser[Int] = chainl(term, or(plus, minus))
  private val eof: Parser[Unit] = Parser {
    case Nil => Success((), Nil)
    case _   => Failure(Nil)
  }

  private val calculator: Parser[Int] = for {
    n <- expression
    _ <- eof
  } yield n
}
// @lc code=end
