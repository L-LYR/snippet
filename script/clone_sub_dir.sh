#!/bin/bash

git_url=$1
sub_dir=$2
where=$3

git clone -n --depth=1 --filter=tree:0 "$git_url" "$where" &&
    cd where ||
    git sparse-checkout set --no-cone "$sub_dir" &&
    git checkout
