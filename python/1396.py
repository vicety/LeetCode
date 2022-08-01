class UndergroundSystem:

    def __init__(self):
        self.stat = dict()  # (from, to) -> (val, n)
        self.data = dict()
        # (new - last_avg) / n+1

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.data[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        from_station, in_time = self.data[id]
        time_used = t - in_time
        if self.stat.get((from_station, stationName)) is None:
            self.stat[(from_station, stationName)] = (0.0, 0)
        val, n = self.stat[(from_station, stationName)]
        self.stat[(from_station, stationName)] = (val + (time_used - val) / (n + 1), n + 1)
        del self.data[id]

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        return self.stat[(startStation, endStation)][0]

# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)
