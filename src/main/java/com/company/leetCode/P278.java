package com.company.leetCode;

public class P278 {
    public class VersionControl {
        public boolean isBadVersion(int version) {
            return true;
        }
    }

    public class Solution extends VersionControl {
//        public int firstBadVersion(int n) {
//            if (n == 1) return 1;
//            int l = 1, r = n - 1;
//            while (l <= r) {
//                int mid = l + (r - l) / 2;
//                if (!isBadVersion(mid) && isBadVersion(mid + 1)) return mid + 1;
//                else if(isBadVersion(mid)) r = mid - 1;
//                else l = mid + 1;
//            }
//            return 1;
//        }

        public int firstBadVersion(int n) {
            if (n == 1) return 1;
            int l = 1, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if(!isBadVersion(mid)) l = mid + 1;
                else r = mid - 1;
            }
            return l;
        }
    }
}
