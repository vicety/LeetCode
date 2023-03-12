from typing import List, Dict, Any


# 不支持非字符串类型 key，因为在 deep_keys 的返回值中如何区分字符串与非字符串类型的需求不明确，如 "a"/1 和 "a"/"1"

class SlashDictError(Exception):
    pass


class SlashDict:
    def __init__(self, initDict: Dict[str, Any] = None):
        self.childDict = dict()
        if initDict is None:
            return
        deepKV = self.toDeep(initDict, "")
        for k, v in deepKV:
            self.put(k, v)

    def toDeep(self, initDict: Dict, prefix):
        ans = []
        for k, v in initDict.items():
            if not isinstance(k, str):
                raise SlashDictError("expect key {} from initDict to be a string".format(k))
            if not isinstance(v, dict):
                key = prefix + k
                ans.append((key, v))
            else:
                ans += self.toDeep(v, prefix + k + "/")
        return ans

    def __getitem__(self, key: str):
        return self._get(key, False, None)

    def __setitem__(self, key: str, value):
        self.put(key, value)

    def __len__(self):
        return len(self.deep_keys())

    # 仅支持打印一层
    def __str__(self):
        return self.childDict.__str__()

    def deep_keys(self):
        return self._deep_keys("")

    def _deep_keys(self, prefix):
        ans = []
        for k, v in self.childDict.items():
            if isinstance(v, SlashDict):
                ans += v._deep_keys(prefix + str(k) + "/")
            else:
                ans.append(prefix + str(k))
        return ans

    def get(self, key, defaultValue=None):
        return self._get(key, True, defaultValue)

    def pop(self, key: str):
        keySep = key.split("/")
        now = self._moveAndCheck(keySep[:-1])
        return now.childDict.pop(keySep[-1])

    def put(self, key: str, value):
        keySep = key.split("/")
        di = self._moveAndCreate(keySep[:-1])
        di.childDict[keySep[-1]] = value

    def items(self):
        keys = self.deep_keys()
        return list(map(lambda x: (x, self[x]), keys))

    def clear(self):
        self.childDict = dict()

    def _get(self, key: str, allowDefaultValue: bool, defaultValue):
        keySep = key.split("/")
        now = self._moveAndCheck(keySep[:-1])

        if not keySep[-1] in now.childDict:
            if not allowDefaultValue:
                raise SlashDictError(
                    "SlashDict under key '{}' does not have key {}".format("/".join(keySep[:-1]), keySep[-1]))
            else:
                return defaultValue
        return now.childDict[keySep[-1]]

    def _moveAndCheck(self, pathSeg: List[str]):
        now = self
        for i, sep in enumerate(pathSeg):
            if not sep in now.childDict:
                raise SlashDictError("SlashDict under key '{}' does not have key {}".format(pathSeg[:i], sep))
            if not isinstance(now.childDict[sep], SlashDict):
                raise SlashDictError("Path '{}' does not refer to a SlashDict".format("/".join(pathSeg[:i + 1])))
            now = now.childDict[sep]
        return now

    def _moveAndCreate(self, pathSeg: List[str]):
        now = self
        for path in pathSeg:
            if not path in self.childDict:
                now.childDict[path] = SlashDict()
            if not isinstance(now.childDict[path], SlashDict):
                raise SlashDictError("Path '{}' does not refer to a SlashDict".format("/".join(pathSeg)))
            now = now.childDict[path]
        return now


# 非嵌套读写
di = SlashDict()
di["1"] = 2
assert di["1"] == 2

# error case 1: 非结尾路径指向的不是一个 SlashDict
try:
    di["1/2"] = 3
except SlashDictError:
    print("expected error, since di['1'] is not of SlashDict type")

# 嵌套读写
di["2/3/4"] = 5
assert di["2/3/4"] == 5
print(di)  # {'1': 2, '2': <__main__.SlashDict object at 0x000002AAECAFB760>}
print(di.deep_keys())  # ['1', '2/3/4']

# 遍历
for k, v in di.items():
    # key: 1 value: 2
    # key: 2/3/4 value: 5
    print("key: {} value: {}".format(k, v))

# 更多读写
di["2/3"] = 4
assert di["2/3"] == 4
di["5/6"] = dict()
print(di["5/6"])  # {}

# 删除
print(di.deep_keys())  # ['1', '2/3', '5/6']
print(di.pop("2/3"))  # 4
print(di.deep_keys())  # ['1', '5/6']

# len
assert len(di) == 2

# clear
di.clear()

# 能够区分 None 与 空
di["1/2"] = None
print(di["1/2"])  # None
try:
    print(di["3/4"])
except SlashDictError:
    print("expected error, that key is empty")

# get不到则返回默认值
print(di.get("1/100"))  # None
print(di.get("1/100", 5))  # 5

# 如果访问路径不存在会抛出异常，而不是返回默认值
try:
    print(di.get("100/1"))
except SlashDictError:
    print("expected error, since first path 100 does not exist")

# init from nested dict
di.clear()
nativeDi = dict()
nativeDi["1"] = 2
nativeDi["2"] = dict()
nativeDi["2"]["3"] = 4
di = SlashDict(nativeDi)
for k, v in di.items():
    # ('1', 2)
    # ('2/3', 4)
    print((k, v))
