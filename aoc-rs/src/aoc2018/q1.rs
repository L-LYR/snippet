use crate::util::{read_lines, write_lines};

#[derive(Default)]
pub struct Solution {}

impl crate::Solution for Solution {
    fn run(&mut self, input: &str, output: &str) {
        let s: i32 = read_lines(input)
            .unwrap()
            .flatten()
            .map(|l| l.parse::<i32>().unwrap())
            .sum();
        write_lines(vec![s.to_string()], output).unwrap();
    }
}
