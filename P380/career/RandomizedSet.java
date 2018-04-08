import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;


    /** Initialize your data structure here. */
    public RandomizedSet() {
      map = new HashMap<Integer, Integer>();
      list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if (map.containsKey(val)) return false;
      int pos = list.size();
      list.add(val);
      map.put(val, pos);
      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (map.get(val) == null) return false;
      int pos = map.get(val);
      int lastItemIdx = list.size() - 1;
      map.remove(val);
      if (lastItemIdx == pos)
        list.remove(lastItemIdx);
      else{
        int exchangedItem = list.remove(lastItemIdx);
        list.set(pos, exchangedItem);
        map.put(exchangedItem, pos);
      }
      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
