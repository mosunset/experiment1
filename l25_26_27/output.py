# -*- coding: utf-8 -*-
import csv
flg = 10
nowi = ''
savei = 0
nowi2 = ''
savei2 = 0
nowi3 = ''
savei3 = 0
min = 100000.000
min2 = 1000.00
min3 = 1000.00
with open('output.csv') as f:
    reader = csv.reader(f)
    for row in reader:
        if row[0] == '配列の要素数' and int(float(row[1])) == 100:
            flg = 100
        elif row[0] == '配列の要素数' and int(float(row[1])) == 1000:
            flg = 1000
        elif row[0] == '配列の要素数' and int(float(row[1])) == 10000:
            flg = 10000
        #print(flg)
        if flg == 100:
            if row[0] == '閾値':
                nowi = float(row[1])
            if row[0] == 'avetime' and float(row[1]) < min:
                savei = nowi
                min = float(row[1])
        elif flg == 1000:
            if row[0] == '閾値':
                nowi2 = float(row[1])
            if row[0] == 'avetime' and float(row[1]) < min2:
                savei2 = nowi2
                min2 = float(row[1])
        elif flg == 10000:
            if row[0] == '閾値':
                nowi3 = float(row[1])
            if row[0] == 'avetime' and float(row[1]) < min3:
                savei3 = nowi3
                min3 = float(row[1])
    print(100)
    print(savei)
    print(min)
    print("---")
    print(1000)
    print(savei2)
    print(min2)
    print("---")
    print(10000)
    print(savei3)
    print(min3)

