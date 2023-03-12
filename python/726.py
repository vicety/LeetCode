class Solution:
    def countOfAtoms(self, formula: str) -> str:
        def mergeDict(to, frm: dict):
            for k, v in frm.items():
                if to.get(k) is None:
                    to[k] = v
                else:
                    to[k] += v

        ans = dict()
        token = []
        buf = ""
        for c in formula:
            if c == '(' or c == ')':
                if buf:
                    token.append(buf)
                buf = ""
                token.append(c)
            elif c.isupper() or (c.isnumeric() and not buf.isnumeric()):
                if buf:
                    token.append(buf)
                buf = c
            else:
                buf += c
        if buf:
            token.append(buf)
        for i in range(len(token)):
            if token[i].isnumeric():
                token[i] = int(token[i])

        pos = 0

        def parse(tokens):
            nonlocal pos
            ansStat = dict()
            nowStat = dict()
            while pos < len(tokens):
                c = tokens[pos]
                if c == '(':
                    mergeDict(ansStat, nowStat)
                    pos += 1
                    # handle closing parenthesis inside
                    nowStat = parse(tokens)
                elif c == ')':
                    pos += 1
                    if len(nowStat) > 0:
                        mergeDict(ansStat, nowStat)
                        return ansStat
                elif isinstance(c, int):
                    pos += 1
                    for k in nowStat.keys():
                        nowStat[k] *= c
                else:
                    pos += 1
                    mergeDict(ansStat, nowStat)
                    nowStat = dict()
                    nowStat[c] = 1
            if len(nowStat) > 0:
                mergeDict(ansStat, nowStat)
            return ansStat

        stat = parse(token)
        data = sorted(list(stat.items()))
        ans = ""
        for k, v in data:
            ans += k
            if v > 1:
                ans += str(v)
        return ans


s = Solution()
print(s.countOfAtoms("Mg(OH)2"))
