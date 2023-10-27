# Clojure object pool benchmarks

Super basic benchmarks for comparing various Clojure object pool libraries.

* [clj-pool-party](https://github.com/enragedginger/clj-pool-party)
* [pool](https://github.com/kul/pool)
* [deepend](https://github.com/biiwide/deepend)

## Usage

Run `-main` in core.

## Example Results

Run on an M2 Mac with openjdk 21.

```
Running clj-pool-party benchmark
Evaluation count : 158640 in 60 samples of 2644 calls.
             Execution time mean : 311.507718 µs
    Execution time std-deviation : 12.638268 µs
   Execution time lower quantile : 275.760960 µs ( 2.5%)
   Execution time upper quantile : 324.708318 µs (97.5%)
                   Overhead used : 1.238141 ns

Found 6 outliers in 60 samples (10.0000 %)
	low-severe	 3 (5.0000 %)
	low-mild	 3 (5.0000 %)
 Variance from outliers : 27.0633 % Variance is moderately inflated by outliers
Running deepend benchmark
Evaluation count : 88140 in 60 samples of 1469 calls.
             Execution time mean : 656.919770 µs
    Execution time std-deviation : 9.726561 µs
   Execution time lower quantile : 630.546074 µs ( 2.5%)
   Execution time upper quantile : 673.678597 µs (97.5%)
                   Overhead used : 1.238141 ns

Found 7 outliers in 60 samples (11.6667 %)
	low-severe	 5 (8.3333 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
Running kul pool benchmark
Evaluation count : 77280 in 60 samples of 1288 calls.
             Execution time mean : 731.420297 µs
    Execution time std-deviation : 32.729010 µs
   Execution time lower quantile : 602.098823 µs ( 2.5%)
   Execution time upper quantile : 759.303268 µs (97.5%)
                   Overhead used : 1.238141 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 3 (5.0000 %)
	high-mild	 1 (1.6667 %)
 Variance from outliers : 30.3625 % Variance is moderately inflated by outliers
```

## License

Copyright © 2023 Enraged Ginger LLC

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
