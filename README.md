# Codility Challenge: Rubidium 2018

## SheepAndSunshades

- Difficulty: Hard
- Given a set of points on a cartesian plane, find the minimum distance between some pair of them to maximise another metric.
- <https://app.codility.com/programmers/challenges/rubidium2018/>
- <https://app.codility.com/programmers/task/sheep_and_sunshades/>

## Versions

- Result
  - `Good`: Correctness 100%, Performance 100%.
  - `OK`: Correctness 100%, Performance <100%.
  - `Fail`: Correctness <100%, Performance <100%.
- File naming convention
  - Code `A`: `Rubidium2018A.java`
  - etc

| File | Description                   | Complexity    | Result | Report                                                                  |
| ---- | ----------------------------- | ------------- | ------ | ----------------------------------------------------------------------- |
| `A`  | Simple point to point compare | `O(N**2)`     | `OK`   | [EM5538-K23](https://app.codility.com/demo/results/trainingEM5538-K23/) |
| `B`  | BTree on X                    | `O(N*log(N))` | `Good` | [YD2SKC-TCX](https://app.codility.com/demo/results/trainingYD2SKC-TCX/) |
