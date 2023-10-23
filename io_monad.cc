// Reference: https://anurudhp.github.io/blogs/2021/06/23/io-monad-in-cpp.html

#include <functional>
#include <iostream>
#include <string>

using std::function;
using std::string;

// type IO a
template <class A>
struct IO {
  function<A()> recipe;
  IO(function<A()> r) : recipe(r) {}
  A run() const { return recipe(); }
};

// instance Functor IO where
// fmap :: (a -> b) -> IO a -> IO b
template <typename A, typename B>
IO<B> fmap(function<B(A)> fn, IO<A> io_a) {
  return IO<B>([=]() { return fn(io_a.run()); });
}

// instance Applicative IO where
// pure :: a -> IO a
template <typename A>
IO<A> pure(A val) {
  return IO<A>([=]() { return val; });
}

// (<*>) :: IO (a -> b) -> IO a -> IO b
template <typename A, typename B>
IO<B> fappl(IO<function<B(A)>> io_a__b, IO<A> io_a) {  // (<*>)
  return IO<B>([=]() {
    function<B(A)> f = io_a__b.run();
    A a = io_a.run();
    return f(a);
  });
}

// instance Monad IO where
// return :: a -> IO a
// return = pure
#define Return pure

// bind :: IO a -> (a -> IO b) -> IO b
template <typename A, typename B>
IO<B> bind(IO<A> io_a, function<IO<B>(A)> fn) {
  return IO<B>([=]() {
    A a = io_a.run();
    IO<B> io_b = fn(a);
    return io_b.run();
  });
}

// (>>=) = bind
template <typename A, typename B>
IO<B> operator>>=(IO<A> io_a, function<IO<B>(A)> fn) {
  return bind(io_a, fn);
}

// seq :: IO a -> IO b -> IO b
template <typename A, typename B>
IO<B> seq(IO<A> io_a, IO<B> io_b) {
  return IO<B>([=]() {
    io_a.run();
    return io_b.run();
  });
}
// (>>) = seq
template <typename A, typename B>
IO<B> operator>>(IO<A> io_a, IO<B> io_b) {
  return seq(io_a, io_b);
}

// type () = ()
struct Unit {
} unit;

// putChar :: Char -> IO ()
function<IO<Unit>(char)> putChar = [](char c) {
  return IO<Unit>([=]() {
    std::cout << c;
    return unit;
  });
};

// putStr :: String -> IO ()
function<IO<Unit>(string)> putStr = [](string s) {
  return IO<Unit>([=]() {
    std::cout << s;
    return unit;
  });
};

// putStrLn :: String -> IO ()
function<IO<Unit>(string)> putStrLn = [](string s) { return putStr(s + "\n"); };

// getChar :: IO Char
IO<char> getChar([]() {
  char c;
  std::cin >> c;
  return c;
});

// getLine :: IO String
IO<string> getLine([]() {
  string s;
  getline(std::cin, s);
  return s;
});

// main1 :: IO ()
// main1 = putStrLn "Hello World!"
IO<Unit> Main1 = putStrLn("Hello World!");

// main2 :: IO ()
// main2 = putStr "Name: " >>
//           fmap (\s -> "Hello " ++ s ++ "!") getLine
//             >>= putStrLn
IO<Unit> Main2 = putStr("Name: ") >>
                 fmap<string, string>([](string s) -> string { return "Hello " + s + "!"; },
                                      getLine) >>= putStrLn;

// main :: IO ()
IO<Unit> Main = Main1;

int main() { Main.run(); }