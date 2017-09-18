#!/bin/bash

cd /Users/youkai/Documents/workspace/alivepush-service

for file in ./scripts/modules/*
do
    ./scripts/iTerm.sh $file
done
