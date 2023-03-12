class Solution:
    """
    @param s: a string
    @param k: an integer
    @return: a string such that the same characters are at least distance k from each other
    """
    def rearrange_string(self, s: str, k: int) -> str:
        # Write your code here
        from collections import deque
        from queue import PriorityQueue
        q = deque()
        st = set()
        sLst = [0 for _ in range(26)]
        for c in s:
            sLst[ord(c)-ord('a')] += 1
        pq = PriorityQueue()
        for i, cnt in enumerate(sLst):
            if cnt > 0:
                pq.put((-cnt, i))

        ans = ""
        loopS = len(s)
        while loopS:
            loopS -= 1
            if len(q) == k:
                l = q.popleft()
                st.remove(l)
            tmp = []
            chosn = None
            while len(pq.queue):
                cnt, i = pq.get()
                if i in st:
                    tmp.append((cnt, i))
                else:
                    chosn = i
                    if cnt + 1 != 0:
                        pq.put((cnt+1, i))
                    break
            for item in tmp:
                pq.put(item)
            if chosn is None:
                return ""
            q.append(chosn)
            st.add(chosn)
            ans += chr(ord('a') + chosn)
        return ans

s = Solution()
print(s.rearrange_string("aabbcc", 3))