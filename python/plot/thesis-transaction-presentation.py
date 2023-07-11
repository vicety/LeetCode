import numpy as np
import matplotlib.pyplot as plt

# Data
data = [
    [2876.86, 23.66, 0],
    [1440.50, 2.60, 0],
    # [1418.44, 7.67, 0.166],
    [1420.05, 16.88, 0.460],
    [1181.19, 82.60, 1.857],
    [1257.86, 62.40, 1.321],
    [1304.12, 59.03, 1.129]
]

labels = ["non-txn", "c1", "c25", "c100", "c100b1", "c100b3"]
x = np.arange(len(labels))
bar_width = 0.2

# Set the figure size
fig, ax = plt.subplots(figsize=(12, 6))

legends = ["Throughput", "Latency (ms)", "Abort Rate"]

# Plotting the grouped bar chart
for i in range(3):
    ax.bar(x + (i * bar_width), [row[i] for row in data], width=bar_width, label=f"{legends[i]}")

# Add exact numbers above each bar
for i in range(len(data)):
    for j in range(3):
        plt.text(x[i] + (j * bar_width), data[i][j], str(data[i][j]), ha='center', va='bottom')

# Axis labels and title
# plt.xlabel("Groups")
# plt.ylabel("Value")
plt.title("Throughput, Latency, and Abort Rate Comparison")

# Set x-axis tick labels
plt.xticks(x + bar_width, labels)

plt.yscale("log")

# Add legend
plt.legend()

plt.savefig("txn-compare.jpg")

# Display the chart
plt.show()