class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        c_list = preorder.split(",")
        waiting_node = [1]
        for c in c_list:
            if c != "#":
                if len(waiting_node) == 0:
                    return False
                waiting_node[-1] += 1
                waiting_node.append(0)
            else:
                if len(waiting_node) == 0:
                    return False
                else:
                    waiting_node[-1] += 1
                    while len(waiting_node) > 0 and waiting_node[-1] == 2:
                        waiting_node.pop()

        return len(waiting_node) == 0


s = Solution()
print(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
print(s.isValidSerialization("9,#,92,#,#"))
