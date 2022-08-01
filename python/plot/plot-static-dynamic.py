import matplotlib.pyplot as plt
import numpy as np

x = np.array(["1", "2", "4", "8", "12", "16", "20", "24", "28", "32"])
y = np.array([1, 1.761, 3.125, 5.277, 6.812, 9.106,
              13.903153, 16.532327, 21.691194, 20.705869])

plt.bar(x, y)

plt.xlabel("Number of threads")
plt.ylabel("Speed-up rate")

# plt.show()

plt.savefig("ex4-1.jpg", bbox_inches="tight", dpi=300)
