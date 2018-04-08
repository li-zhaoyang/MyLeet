import java.util.*;
class Solution {
  boolean[] marked;
  Stack<Integer> stack;
  boolean cycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      //TODO Input: 1 [] Output:[] Expected: [0]
      int[] ansNull = new int[0];
      if(numCourses == 0 || prerequisites == null)
        return ansNull;
      int[] ans = new int[numCourses];
      ArrayList<ArrayList<Integer>> vArray = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < numCourses; i++) {
        vArray.add(new ArrayList<Integer>());
      }
      for (int[] pair: prerequisites) {
        vArray.get(pair[0]).add(pair[1]);
      }
      stack = new Stack<Integer>();
      marked = new boolean[numCourses];
      cycle = false;
      for (int i = 0; i < numCourses; i++) {
        if (marked[i]) continue;
        dfs(i, vArray, new boolean[numCourses]);
        if (cycle == true)  return  ansNull;
      }
      for (int i = 0; i < numCourses; i++) {
        ans[numCourses - i - 1] = stack.pop();
      }
      return ans;
    }

    private void dfs(int v,ArrayList<ArrayList<Integer>> vArray, boolean[] onTheWay) { //
      marked[v] = true;
      onTheWay[v] = true;
      for (int w: vArray.get(v)) {
        if (onTheWay[w]) {
          cycle = true;
          return;
        }
        if (!marked[w]){
          dfs(w, vArray, onTheWay);
          if(cycle == true) return;
        }
      }
      onTheWay[v] = false;
      stack.push(v);
    }
}
