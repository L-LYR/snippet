use std::{
    fs::File,
    io::{self, BufRead, LineWriter, Write},
    path::Path,
};

pub fn read_lines<P>(path: P) -> io::Result<io::Lines<io::BufReader<File>>>
where
    P: AsRef<Path>,
{
    Ok(io::BufReader::new(File::open(path)?).lines())
}

pub fn write_lines<P>(lines: Vec<String>, path: P) -> io::Result<()>
where
    P: AsRef<Path>,
{
    let mut w = LineWriter::new(File::create(path)?);
    lines.iter().try_for_each(|l| -> io::Result<()> {
        w.write(l.as_bytes())?;
        w.write(b"\n")?;
        Ok(())
    })
}
