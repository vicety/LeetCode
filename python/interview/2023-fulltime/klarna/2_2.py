from collections import deque
from typing import List, Dict, Deque


class Transaction:
    def __init__(self, index: int, name: str, time: int, amount: int, city: str):
        self.index = index
        self.name = name
        self.time = time
        self.amount = amount
        self.city = city


class Underwriter:
    # 1. string to Transaction object
    # 2. filter invalid transactions by the rules
    # 3. union the result got from different rules
    def identify_invalid_transactions(transactions: List[str]):
        amountThreshold = 2000
        timeThreshold = 60
        txnIndex = -1

        def stringToTransaction(s: str):
            nonlocal txnIndex
            splitted = s.split(",")
            txnIndex += 1
            return Transaction(txnIndex, splitted[0], int(splitted[1]), int(splitted[2]), splitted[3])

        structuredTransactions = list(map(stringToTransaction, transactions))

        # invalid because of the amount
        invalidAmount = set(
            map(lambda x: x.index, filter(lambda txn: txn.amount > amountThreshold, structuredTransactions)))

        # invalid because of same name + time window + same price
        invalidExactPrice = set()
        # invalid because of same name + time window + different city
        invalidDifferentCity = set()
        # # invalid because of same name + same time
        invalidSameTime = set()

        # group by name, collect their transactions ordered by time
        structuredTransactionsSortedByTime = sorted(structuredTransactions, key=lambda txn: txn.time)
        history: Dict[str, List[Transaction]] = dict()
        for txn in structuredTransactionsSortedByTime:
            if history.get(txn.name) is None:
                history[txn.name] = []
            history[txn.name].append(txn)

        # maintain a time window for each name's transaction list
        # for each transaction record, traverse the time window and try to match with the rules
        for historyForEachName in history.values():
            histDict: Dict[int, Transaction] = dict()
            q: Deque[Transaction] = deque()
            for txn in historyForEachName:
                while len(q) > 0 and txn.time > q[0].time + timeThreshold:
                    popped = q.popleft()
                    del histDict[popped.index]
                for otherTxnInWindow in histDict.values():
                    if otherTxnInWindow.amount == txn.amount:
                        invalidExactPrice.add(otherTxnInWindow.index)
                        invalidExactPrice.add(txn.index)
                    if otherTxnInWindow.city != txn.city:
                        invalidDifferentCity.add(otherTxnInWindow.index)
                        invalidDifferentCity.add(txn.index)
                    if otherTxnInWindow.time == txn.time:
                        invalidSameTime.add(otherTxnInWindow.index)
                        invalidSameTime.add(txn.index)
                q.append(txn)
                histDict[txn.index] = txn

        invalid_indexes = invalidAmount.union(invalidExactPrice).union(invalidDifferentCity).union(invalidSameTime)
        return list(map(lambda idx: transactions[idx], invalid_indexes))

