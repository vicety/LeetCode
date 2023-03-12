from typing import List, Dict, Tuple


class Transaction:
    def __init__(self, index: int, name: str, time: int, amount: int, city: str):
        self.index = index
        self.name = name
        self.time = time
        self.amount = amount
        self.city = city


class Underwriter:

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

        # invalid because of time window + exact price / time window + different city / same time + same name
        invalidExactPrice = set()
        invalidDifferentCity = set()
        invalidSameTime = set()
        structuredTransactionsSortedByTime = sorted(structuredTransactions, key=lambda txn: txn.time)
        # group by person, record their last transaction
        history: Dict[str, Transaction] = dict()
        # group by person + time
        historyByPersonAndTime: Dict[Tuple[str, int], List[Transaction]] = dict()
        for txn in structuredTransactionsSortedByTime:
            if historyByPersonAndTime.get((txn.name, txn.time)) is None:
                historyByPersonAndTime[(txn.name, txn.time)] = []
            historyByPersonAndTime[(txn.name, txn.time)].append(txn)

        for txn in structuredTransactionsSortedByTime:
            if history.get(txn.name) is not None:
                last_txn = history[txn.name]
                if txn.time - last_txn.time <= timeThreshold:
                    if txn.amount == last_txn.amount:
                        invalidExactPrice.add(txn.index)
                        for item in historyByPersonAndTime[(last_txn.name, last_txn.time)]:
                            invalidExactPrice.add(item.index)
                    if txn.city != last_txn.city:
                        invalidDifferentCity.add(txn.index)
                        for item in historyByPersonAndTime[(last_txn.name, last_txn.time)]:
                            invalidDifferentCity.add(item.index)
                    if txn.time == last_txn.time:
                        invalidSameTime.add(txn.index)
                        for item in historyByPersonAndTime[(last_txn.name, last_txn.time)]:
                            invalidSameTime.add(item.index)
            history[txn.name] = txn

        invalid_indexes = invalidAmount.union(invalidExactPrice).union(invalidDifferentCity).union(invalidSameTime)
        return list(map(lambda idx: transactions[idx], invalid_indexes))


print(Underwriter.identify_invalid_transactions(["john,20,150,stockholm", "john,20,300,stockholm"]))
