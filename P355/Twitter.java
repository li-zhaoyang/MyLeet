import java.util.*;
class Twitter {
    class Tweet {
      public int userId;
      public int id;
      public Tweet(int uid, int tid) {
        userId = uid;
        id = tid;
      }
    }
    ArrayList<Tweet> tweetList;
    HashMap<Integer, Set<Integer>> followMap;

    /** Initialize your data structure here. */
    public Twitter() {
      tweetList = new ArrayList<Tweet>();
      followMap = new HashMap<Integer, Set<Integer>>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
      Tweet thisTweet = new Tweet(userId, tweetId);
      tweetList.add(thisTweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
      List<Integer> ans = new ArrayList<Integer>();
      for (int i = tweetList.size() - 1; i >= 0; i--) {
        Tweet t = tweetList.get(i);
        if (followMap.getOrDefault(userId, new HashSet<Integer>()).contains(t.userId) || t.userId == userId) {
          ans.add(t.id);
          if (ans.size() == 10) break;
        }
      }
      return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
      Set<Integer> updatedSet = followMap.getOrDefault(followerId, new HashSet<Integer>());
      updatedSet.add(followeeId);
      followMap.put(followerId, updatedSet);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
      Set<Integer> updatedSet = followMap.getOrDefault(followerId, new HashSet<Integer>());
      updatedSet.remove(followeeId);
      followMap.put(followerId, updatedSet);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
