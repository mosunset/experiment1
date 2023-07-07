# Lesson24_4
## 1. ハッシュテーブルのサイズや、追加する要素の数を変更することで、検索時間や衝突回数がどのように変化するのか調査し、説明しなさい（その変化の理由まで説明できれば尚良）

ハッシュテーブルのサイズと追加する要素数が近くなるほど衝突回数が増えた。

しかし、検索時間はハッシュサイズが10倍に増えても、誤差の範囲と言える差であった。後述するようにハッシュ探索での計算量は **O(1)** だからであると考えられる。

```java
// 文字列の各文字を Unicode 数値として扱い、足し合わせる
int intKey = 0;
for (int count = 0; count < aKey.length(); count++) {
    intKey += 0xffff & aKey.charAt(count);
}
// 合計値からハッシュ値を求める
return intKey % this.table.length;
```

## 2. ハッシュテーブルを用いた検索と、配列を用いた検索の計算時間の差について調査し説明しなさい（その変化の理由まで説明できれば尚良）

ハッシュテーブルのほうが配列を用いた検索より計算時間が短かった。<br>
配列では、線形探索をしていて計算量は **O(n)** 、ハッシュ探索の計算量は衝突が一つもない理想的な関数の場合 **O(1)** なので、今回のような衝突がある場合でも、ほとんどの場合でハッシュテーブルを用いたほうが早くなる。

```java
# ハッシュ
for (int i = 0; i < REP; i++) {
    result = table.get("nakayama");
}

# 配列
for (int i = 0; i < REP; i++) {
    for (int j = 0; j < address.length; j++) {
        result = address[j];
        if (result != null && result.getName().equals("nakayama")) {
            pos = j;
            break;
        }
    }
}
```

## 実行結果
※ 検索時間を調べるには，サイズや追加する要素を変更して，ハッシュテーブルと配列でそれぞれ検索時間にどのような変化が生じるかを観察すればよい．

また，ハッシュテーブルや配列のサイズ，変更する要素数は，少なくとも以下の組み合わせは試すようにしなさい．

### テーブルでのまとめ
※サイズ>=要素数となるようにする
|| サイズ | 要素数 | Hash→ | 実行後要素数 | 衝突回数 | 検索時間 |  Array→   |    検索時間     |
| :----: | :----: | :---: | :----------: | :------: | :------: | :-------: | :-------------: | :--------: |
|   1    |  100   |  100  |    found     |    64    |    36    | 10.376222 | found(pos: 50)  | 47.184452  |
|   2    |  500   |  100  |    found     |    94    |    6     | 11.342132 | found(pos: 250) | 78.901957  |
|   3    | 1,000  | 1,000 |    found     |   617    |   383    | 11.381503 | found(pos: 500) | 138.192497 |
|   4    | 1,000  |  500  |    found     |   387    |   113    |  9.57303  | found(pos: 500) | 153.205385 |
|   5    | 1,000  |  300  |    found     |   258    |    42    | 7.252711  | found(pos: 500) | 107.754884 |
|   6    | 1,000  |  100  |    found     |    93    |    7     | 10.459174 | found(pos: 500) | 104.074072 |

### 出力原文
```sh
=== Hash ===
Key(nakayama): found
Size of the hashtable: 100
Number of added elements: 100
Number of elements in the hashtable: 64
Collision times: 36
Start time : 320334184118100
End time   : 320334194494322
Search time: 10.376222ms

=== Array ===
Key(nakayama): found (pos: 50)
Size of the array: 100
Start time : 320334266686557
End time   : 320334313871009
Search time: 47.184452ms

=== Hash ===
Key(nakayama): found
Size of the hashtable: 500
Number of added elements: 100
Number of elements in the hashtable: 94
Collision times: 6
Start time : 320459151507111
End time   : 320459162849243
Search time: 11.342132ms

=== Array ===
Key(nakayama): found (pos: 250)
Size of the array: 500
Start time : 320459231680081
End time   : 320459310582038
Search time: 78.901957ms

=== Hash ===
Key(nakayama): found
Size of the hashtable: 1000
Number of added elements: 1000
Number of elements in the hashtable: 617
Collision times: 383
Start time : 320502502114063
End time   : 320502513495566
Search time: 11.381503ms

=== Array ===
Key(nakayama): found (pos: 500)
Size of the array: 1000
Start time : 320502580852124
End time   : 320502719044621
Search time: 138.192497ms

=== Hash ===
Key(nakayama): found
Size of the hashtable: 1000
Number of added elements: 500
Number of elements in the hashtable: 387
Collision times: 113
Start time : 320526929287742
End time   : 320526938860772
Search time: 9.57303ms

=== Array ===
Key(nakayama): found (pos: 500)
Size of the array: 1000
Start time : 320527000528232
End time   : 320527153733617
Search time: 153.205385ms

=== Hash ===
Key(nakayama): found
Size of the hashtable: 1000
Number of added elements: 300
Number of elements in the hashtable: 258
Collision times: 42
Start time : 320553045506652
End time   : 320553052759363
Search time: 7.252711ms

=== Array ===
Key(nakayama): found (pos: 500)
Size of the array: 1000
Start time : 320553159067500
End time   : 320553266822384
Search time: 107.754884ms

=== Hash ===
Key(nakayama): found
Size of the hashtable: 1000
Number of added elements: 100
Number of elements in the hashtable: 93
Collision times: 7
Start time : 320583733678246
End time   : 320583744137420
Search time: 10.459174ms

=== Array ===
Key(nakayama): found (pos: 500)
Size of the array: 1000
Start time : 320583823994963
End time   : 320583928069035
Search time: 104.074072ms

```


