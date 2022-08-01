import matplotlib.pyplot as plt

plt.rcParams.update({'font.size': 8})

x = [1, 2, 4, 8, 12, 16, 20, 24, 28, 32]  # 24258.74
# 数据集
y = [16589.46, 24549.4, 24911, 25265.2, 24702, 24092, 24321.6, 24202.2, 24199, 24258.7]
# 误差列表
std_err = [359.321, 1473.38, 915.525, 627.73, 452.44, 197.12, 486.597, 259.844, 527.125, 334.854]

error_params = dict(elinewidth=4, ecolor='coral', capsize=5)  # 设置误差标记参数
# 绘制柱状图，设置误差标记以及柱状图标签
plt.bar(x, y, yerr=std_err, error_kw=error_params)
# tick_label=['blue','green','yellow','orange','gray']

plt.ylabel("MB/s")
plt.xlabel("Number of threads")

# 显示图形
# plt.show()

plt.savefig("ex2.jpg", bbox_inches="tight", dpi=300)
