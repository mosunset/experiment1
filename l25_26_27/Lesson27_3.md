# Lesson27_3
## Q. それぞれのソートの代入回数や比較回数、実行時間などを比較しなさい。
### その結果から各ソートの特徴を以下のポイントに注目し, 考察をまとめなさい
- 与えられた配列の大きさや状態によって結果がどう変わるか
- その結果から各ソートがどのような場合に適したものであるか
- なぜ適しているか, 適していないのか

## A.
昇順に並んでいる場合はインサートソートが一番はやく、代入・比較回数が少なかった。
降順に並んでいる場合はインサートソートが一番おそくなった。

データが大きい場合クイックソートの2つがどの状態でもとても早くなった。
また、シェルソートはランダムな場合に一番はやくなった。
しかし、データの個数が少ない場合は、インサートソート・シェルソートが早かった。

バブルソート・選択ソートは、データが小さく昇順に並んでいる場合は、善戦していた。

この結果から
- バブルソートや選択ソートは簡単に実装できるが、データセットが大きくなると性能が著しく低下する。これらは小さなデータで部分的にソートされたデータに対して適している。
- シェルソートや挿入ソートは、平均的に高速に動作し、中程度のデータや(挿入ソートで逆順以外で)部分的にソートされたデータに適している。
- クイックソートは、ランダムなデータに対して非常に高速に動作し、大規模なデータに最適。ただし、データが整列されている場合には性能が低下することがあるため、データの状態を考慮する必要がある。

と言える


# 出力結果
また, Lesson27 3.java は, 実行時に引数として配列の要素数 (N) と繰り返し計測する回数 (M) をとる.<br>
Lesson27 3.java は各ソートアルゴリズムについて以下の出力を行う.
- ランダムに生成された長さ N の配列をソートするときに起こった代入の回数
- ランダムに生成された長さ N の配列をソートするときに起こった比較の回数
- ランダムに生成された長さ N の同じ配列を, M 回ソートを行い, そのソート実行時間の平均
- 
```sh
$java Lesson27_3 10000 300
=== ascending  =============================
- BubbleSort -
	assignCount:   0
	compareCount:  49995000
	average time:  30.222861556666672[ms]
- SelectionSort -
	assignCount:   29997
	compareCount:  49995000
	average time:  30.415381753333342[ms]
- ShellSort -
	assignCount:   150486
	compareCount:  75243
	average time:  0.17502292999999988[ms]
- InsertionSortX -
	assignCount:   19998
	compareCount:  9999
	average time:  0.07327234666666659[ms]
- QuickSort -
	assignCount:   19485
	compareCount:  126976
	average time:  0.49345455999999976[ms]
- InsertionQuickSort -
	assignCount:   18758
	compareCount:  116342
	average time:  0.4938849666666659[ms]
=== descending =============================
- BubbleSort -
	assignCount:   149981742
	compareCount:  49995000
	average time:  82.76999302666664[ms]
- SelectionSort -
	assignCount:   29997
	compareCount:  49995000
	average time:  128.4000276533333[ms]
- ShellSort -
	assignCount:   203586
	compareCount:  119586
	average time:  0.4912635666666666[ms]
- InsertionSortX -
	assignCount:   50013912
	compareCount:  49994908
	average time:  99.44984136333326[ms]
- QuickSort -
	assignCount:   34512
	compareCount:  127069
	average time:  0.3637686[ms]
- InsertionQuickSort -
	assignCount:   33783
	compareCount:  116356
	average time:  0.29802550999999977[ms]
=== random     =============================
- BubbleSort -
	assignCount:   74960871
	compareCount:  49995000
	average time:  214.57171281999996[ms]
- SelectionSort -
	assignCount:   29997
	compareCount:  49995000
	average time:  131.83055556666662[ms]
- ShellSort -
	assignCount:   317921
	compareCount:  238341
	average time:  1.1852135199999994[ms]
- InsertionSortX -
	assignCount:   25006955
	compareCount:  24996950
	average time:  47.27517087666669[ms]
- QuickSort -
	assignCount:   101940
	compareCount:  178493
	average time:  1.394835549999999[ms]
- InsertionQuickSort -
	assignCount:   100941
	compareCount:  168702
	average time:  1.3673975199999995[ms]
```
```sh
$java Lesson27_3 10 300
=== ascending  =============================
- BubbleSort -
	assignCount:   0
	compareCount:  45
	average time:  0.003392016666666666[ms]
- SelectionSort -
	assignCount:   27
	compareCount:  45
	average time:  0.005048343333333335[ms]
- ShellSort -
	assignCount:   30
	compareCount:  15
	average time:  0.0025904799999999996[ms]
- InsertionSortX -
	assignCount:   18
	compareCount:  9
	average time:  0.0011716433333333325[ms]
- QuickSort -
	assignCount:   18
	compareCount:  32
	average time:  0.004757933333333335[ms]
- InsertionQuickSort -
	assignCount:   20
	compareCount:  23
	average time:  0.004067413333333333[ms]
=== descending =============================
- BubbleSort -
	assignCount:   135
	compareCount:  45
	average time:  0.004177816666666664[ms]
- SelectionSort -
	assignCount:   27
	compareCount:  45
	average time:  6.602700000000001E-4[ms]
- ShellSort -
	assignCount:   43
	compareCount:  21
	average time:  4.355733333333337E-4[ms]
- InsertionSortX -
	assignCount:   63
	compareCount:  45
	average time:  0.0027855066666666642[ms]
- QuickSort -
	assignCount:   33
	compareCount:  34
	average time:  0.003923909999999998[ms]
- InsertionQuickSort -
	assignCount:   31
	compareCount:  18
	average time:  8.608033333333331E-4[ms]
=== random     =============================
- BubbleSort -
	assignCount:   84
	compareCount:  45
	average time:  7.154500000000003E-4[ms]
- SelectionSort -
	assignCount:   27
	compareCount:  45
	average time:  5.908599999999996E-4[ms]
- ShellSort -
	assignCount:   43
	compareCount:  25
	average time:  3.7061333333333337E-4[ms]
- InsertionSortX -
	assignCount:   46
	compareCount:  36
	average time:  4.483033333333334E-4[ms]
- QuickSort -
	assignCount:   33
	compareCount:  48
	average time:  5.893600000000006E-4[ms]
- InsertionQuickSort -
	assignCount:   31
	compareCount:  39
	average time:  5.906900000000006E-4[ms]
```


