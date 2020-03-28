package com.company.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P300 {
    public int lengthOfLIS(int[] nums) {
        // ans[i]存储list长度为i + 1时最后一个元素的值
        List<Integer> ans = new ArrayList<>();
        for (int item : nums) {
            if (ans.isEmpty() || item > ans.get(ans.size() - 1)) ans.add(item);
            else if (item < ans.get(ans.size() - 1)) {
                // 找第一个比item大的数，确保一定存在
                int l = 0, r = ans.size() - 1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if(ans.get(mid) >= item) r = mid - 1;
                    else l = mid + 1;
                }
                ans.set(l, item);
            }
        }
        return ans.size();
    }
}
