use std::{collections::HashMap, iter::zip};

use crate::util::{read_lines, write_lines};

#[derive(Default)]
pub struct Solution {}

impl crate::Solution for Solution {
    fn run(&mut self, input: &str, output: &str) {
        // part1
        let r = read_lines(input)
            .unwrap()
            .flatten()
            .collect::<Vec<String>>()
            .iter()
            .fold((0, 0), |(two, three), s| {
                let count = s.chars().fold(HashMap::new(), |mut count, c| {
                    *count.entry(c).or_insert(0) += 1;
                    count
                });
                (
                    count
                        .values()
                        .any(|&x| x == 2)
                        .then_some(two + 1)
                        .unwrap_or(two),
                    count
                        .values()
                        .any(|&x| x == 3)
                        .then_some(three + 1)
                        .unwrap_or(three),
                )
            });
        // part2
        let ids = read_lines(input)
            .unwrap()
            .flatten()
            .collect::<Vec<String>>();

        let common_letters = (0..ids.len())
            .flat_map(|i| (i + 1..ids.len()).map(move |j| (i, j)))
            .flat_map(|(i, j)| {
                let diff = zip(ids[i].chars(), ids[j].chars())
                    .enumerate()
                    .filter(|(_, (ci, cj))| ci != cj)
                    .map(|(idx, _)| idx)
                    .collect::<Vec<usize>>();
                match diff[..] {
                    [idx] => Some(
                        ids[i]
                            .chars()
                            .take(idx)
                            .chain(ids[i].chars().skip(idx + 1))
                            .collect::<String>(),
                    ),
                    _ => None,
                }
            })
            .collect::<Vec<String>>();
        write_lines(
            vec![(r.0 * r.1).to_string()]
                .into_iter()
                .chain(common_letters.into_iter())
                .collect::<Vec<String>>(),
            output,
        )
        .unwrap();
    }
}
