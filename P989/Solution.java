/*
    Contest 123
    Feb 9, 2019
*/
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int l = A.length;
        int carry = 0;
        int i = A.length - 1;
        Stack<Integer> stk = new Stack();
        while (i >= 0 || K > 0 || carry > 0) {
            int t = ( i < 0 ? 0 : A[i--]) + carry + K % 10;
            stk.push(t % 10);
            carry = t / 10;
            K /= 10;
        }
        List<Integer> ans = new ArrayList();
        while (!stk.isEmpty()) {
            ans.add(stk.pop());
        }
        return ans;
    }
}