import numpy as np
import matplotlib.pyplot as plt

x1 = [1, 2, 4, 8, 16, 20, 24, 28, 32]
y1 = [0.4661, 2.7040, 9.2207, 15.0127, 23.2345, 17.4242, 17.8445, 18.0545, 18.1159]
y2 = [0.2643, 0.8792, 1.1395, 0.8091, 0.5554, 0.4396, 0.3725, 0.3139, 0.2716]
y3 = [0.2628, 0.1335, 0.0687, 0.0358, 0.0277, 0.0299, 0.0269, 0.0239, 0.0252]
l1 = plt.plot(x1, y1, 'bo-', label='critical')
# l2 = plt.plot(x1, y2, 'r--', label='local sum no padding')
# l3 = plt.plot(x1, y3, 'b--', label='local sum padding')
# plt.plot(x1, y2, 'ro-', x1, y3, 'bo-')
plt.plot(x1, y1, 'bo-')
# plt.title('The Lasers in Three Conditions')
plt.xlabel('Execution time')
plt.ylabel('Number of threads')
plt.legend()
# plt.show()

plt.savefig("ex3-1.jpg", bbox_inches="tight", dpi=300)