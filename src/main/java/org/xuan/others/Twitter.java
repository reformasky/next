package org.xuan.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xzhou2 on 1/23/17.
 */
public class Twitter {
    private static Integer counter = 0;
    Map<Integer, User> users;

    /** Initialize your data structure here. */
    public Twitter() {
        //assume that all userId is valid.
        users = new HashMap<>();
    }

    private User getUser(int userId) {
        User result = users.get(userId);
        if (result == null) {
            result = new User(userId);
            users.put(userId, result);
        }
        return result;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        return user.getNewsFeed();
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        follower.follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        follower.unfollow(followeeId);
    }

    private  class User{
        private static final int SIZE = 10;
        private int userId;
        private Set<Integer> followeeIds;
        private List<Tweet> tweets;

        public User(int userId){
            this.userId = userId;
            this.followeeIds = new HashSet<>();
            this.tweets = new ArrayList<>();
        }

        public void follow(int followeeId) {
            followeeIds.add(followeeId);
        }

        public void unfollow(int followeeId) {
            followeeIds.remove(followeeId);
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, this.userId);
            tweets.add(tweet);
        }

        private Tweet getTweet(int index) {
            return tweets.get(index);
        }

        public List<Integer> getNewsFeed() {
            List<Integer> result = new ArrayList<>();
            Queue<Tweet> queue = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();
            map.put(userId, tweets.size() - 1);
            for(Integer followeeId : followeeIds) {
                User curr = getUser(followeeId);
                map.put(curr.userId, curr.tweets.size() - 1);
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                User user = getUser(entry.getKey());
                int index = entry.getValue();
                if (index >= 0) {
                    queue.offer(user.getTweet(index));
                    entry.setValue(index-1);
                }
            }
            while(!queue.isEmpty() && result.size() < SIZE) {
                Tweet curr = queue.poll();
                result.add(curr.tweetId);
                User user = getUser(curr.userId);
                Integer index = map.get(curr.userId);
                if (index >= 0) {
                    queue.offer(user.getTweet(index));
                    map.put(curr.userId, index - 1);
                }
            }
            return result;
        }

    }

    private class Tweet implements Comparable<Tweet> {
        int tweetId;
        int timeStamp;
        int userId;

        public Tweet(int id, int userId) {
            this.tweetId = id;
            this.userId = userId;
            //sync
            this.timeStamp = counter++;
        }

        @Override
        public int compareTo(Tweet that) {
            return that.timeStamp - this.timeStamp;
        }
    }
}

