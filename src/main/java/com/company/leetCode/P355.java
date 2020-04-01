package com.company.leetCode;

import java.util.*;

public class P355 {
    class Twitter {

        private class User {
            int[] queue = new int[11];
            int st = 0;
            int ed = 0;
            Set<Integer> follows = new HashSet<>();
        }

        Map<Integer, User> idToUser = new HashMap<>();
        int tweetTimeStamp = 0;
        List<Integer> tweets = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public Twitter() {

        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (idToUser.get(userId) == null) idToUser.put(userId, new User());
            tweets.add(tweetId);
            User user = idToUser.get(userId);
            user.st = (user.st + 10) % 11;
            user.queue[user.st] = tweetTimeStamp++;
            if (user.st == user.ed) user.ed = (user.ed + 10) % 11;
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            if(idToUser.get(userId) == null) return new ArrayList<>();
            List<Integer> ans = new ArrayList<>();
            // val, userId, ptr, assume tweet id ascends by time
            Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(list -> -list.get(0)));
            for (Integer followId : idToUser.get(userId).follows) {
                User user = idToUser.get(followId);
                if (user.st == user.ed) continue; // contains no tweet
                queue.offer(Arrays.asList(user.queue[user.st], followId, user.st));
            }
            User self = idToUser.get(userId);
            if (self.st != self.ed) {
                queue.offer(Arrays.asList(self.queue[self.st], userId, self.st));
            }
            while(ans.size() < 10 && !queue.isEmpty()) {
                List<Integer> now = queue.poll();
                int val = now.get(0), id = now.get(1), ptr = now.get(2);
                ans.add(tweets.get(val));
                User nowUser = idToUser.get(id);
                if((ptr + 1) % 11 == nowUser.ed) continue;
                int nextIndex = (ptr + 1) % 11;
                queue.offer(Arrays.asList(nowUser.queue[nextIndex], id, nextIndex));
            }
            return ans;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (idToUser.get(followerId) == null) idToUser.put(followerId, new User());
            if (idToUser.get(followeeId) == null) idToUser.put(followeeId, new User());
            if(followeeId == followerId) return;
            idToUser.get(followerId).follows.add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (idToUser.get(followerId) == null) idToUser.put(followerId, new User());
            idToUser.get(followerId).follows.remove(followeeId);
        }
    }

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.
    }
}
