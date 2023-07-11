import numpy as np
import matplotlib.pyplot as plt

# Data
# throughput_data = [664.87, 2876.86, 109409.35]
latency_data = [36.56, 23.66, 2.88]
labels = ["baseline", "non-txn", "hand-optimized"]

# Width of each bar
bar_width = 0.35

# Create an array of indices for the x-axis locations
x = np.arange(len(labels))

# Plotting the grouped bar chart
# plt.bar(x, throughput_data, width=bar_width, label='Throughput')
# plt.bar(x + bar_width, latency_data, width=bar_width, label='Latency (ms)', color='orange')
plt.bar(x, latency_data, width=bar_width, label='Latency (ms)')

# Add exact numbers above each bar
for i in range(3):
    # plt.text(i, throughput_data[i], str(throughput_data[i]), ha='center', va='bottom')
    # plt.text(i + bar_width, latency_data[i], str(latency_data[i]), ha='center', va='bottom')
    plt.text(i, latency_data[i], str(latency_data[i]), ha='center', va='bottom')

# Axis labels and title
# plt.xlabel("Bars")
# plt.ylabel("Value")
plt.title("Throughput and Latency Comparison")

# Set x-axis tick labels
plt.xticks(x, labels)

plt.yscale("log")

# Add legend
plt.legend()

plt.savefig("latency.jpg", bbox_inches="tight", dpi=300)

# Display the chart
plt.show()

