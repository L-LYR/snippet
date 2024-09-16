use crate::util::{read_lines, write_lines};
use std::{collections::HashSet, ops::ControlFlow};

#[derive(Default)]
pub struct Solution {}

impl crate::Solution for Solution {
    fn run(&mut self, input: &str, output: &str) {
        // part 1
        let s: i32 = read_lines(input)
            .unwrap()
            .flatten()
            .map(|l| l.parse::<i32>().unwrap())
            .sum();
        // part 2
        let dup_freq = read_lines(input)
            .unwrap()
            .flatten()
            .map(|l| l.parse::<i32>().unwrap())
            .collect::<Vec<i32>>()
            .iter()
            .cycle()
            .try_fold((0, HashSet::new()), |(freq, mut freq_met), x| {
                if !freq_met.insert(freq) {
                    ControlFlow::Break((freq, freq_met))
                } else {
                    ControlFlow::Continue((freq + x, freq_met))
                }
            })
            .break_value()
            .unwrap()
            .0;
        write_lines(vec![s.to_string(), dup_freq.to_string()], output).unwrap();
    }
}
