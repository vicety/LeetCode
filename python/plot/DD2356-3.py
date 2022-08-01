import matplotlib.pyplot as plt
import numpy as np

plt.rcParams.update({'font.size': 8})

x = [i for i in range(3, 29)]  # 24258.74
# 数据集
y1 = [0.000000344
    , 0.000000334
    , 0.000000332
    , 0.000000334
    , 0.000000336
    , 0.000000344
    , 0.000000352
    , 0.000000390
    , 0.000000436
    , 0.000000610
    , 0.000000773
    , 0.000001151
    , 0.000001933
    , 0.000002451
    , 0.000004653
    , 0.000012378
    , 0.000020365
    , 0.000034617
    , 0.000062911
    , 0.000180949
    , 0.001513120
    , 0.002374133
    , 0.004074029
    , 0.007506326
    , 0.014245296
    , 0.027954517]

y2 = [
    0.000003967
    , 0.000004021
    , 0.000004014
    , 0.000004034
    , 0.000003980
    , 0.000004087
    , 0.000004182
    , 0.000004205
    , 0.000004446
    , 0.000015142
    , 0.000013539
    , 0.000014160
    , 0.000017050
    , 0.000019729
    , 0.000024736
    , 0.000035330
    , 0.000057100
    , 0.000099290
    , 0.000184548
    , 0.000355910
    , 0.000700784
    , 0.001386464
    , 0.002760392
    , 0.005501925
    , 0.011002402
    , 0.023912412

]

import math

originalX = list(map(lambda y: math.pow(2, y), x))

z = np.polyfit(originalX, y1, 1)
y3 = []

p1 = np.poly1d(z)  # 转成1D函数，当然也可以自己拼 ref https://www.jianshu.com/p/44baeed131df

for i in originalX:
    y3.append(p1(i))

z1 = np.polyfit(originalX, y2, 1)
y4 = []

p2 = np.poly1d(z1)
for i in originalX:
    y4.append(p2(i))

y1 = list(map(lambda x: math.log2(x), y1))
y2 = list(map(lambda x: math.log2(x), y2))
y3 = list(map(lambda x: math.log2(x), y3))
y4 = list(map(lambda x: math.log2(x), y4))

# 绘制柱状图，设置误差标记以及柱状图标签
plt.plot(x, y1, "bo-", label="intra-node")
plt.plot(x, y2, "ro-", label="inter-node")
plt.plot(x, y3, "go-", label="intra-node-fit")
plt.plot(x, y4, "yo-", label="inter-node-fit")
# tick_label=['blue','green','yellow','orange','gray']

plt.ylabel("Ping-Pong Time in second (Log base of 2)")
plt.xlabel("Data Transferred in Byte (Log base of 2)")

plt.legend()

# 显示图形
# plt.show()

plt.savefig("DD2356-3.jpg", bbox_inches="tight", dpi=300)
