#![feature(control_flow_enum)]

mod aoc2018;
mod util;

pub trait Solution {
    fn run(&mut self, input: &str, output: &str);
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn run() {
        aoc2018::q1::Solution::default().run("../aoc/aoc.2018.1.in", "../aoc/aoc.2018.1.rs.out");
        aoc2018::q2::Solution::default().run("../aoc/aoc.2018.2.in", "../aoc/aoc.2018.2.rs.out");
    }
}
