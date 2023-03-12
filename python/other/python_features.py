from typing import Optional


def f(arg: Optional[str]):
    if not arg:
        print("=None")
    else:
        print(arg)


f(None)
f("s")

from collections import deque
print(len(deque()))
