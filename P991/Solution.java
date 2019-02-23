/*
    Contest 123
    Feb 9, 2019
*/
class Solution {
    int X;
    Set<Integer> set;
    public int brokenCalc(int X, int Y) {
        set = new HashSet();
        return brokenCalc1(X, Y);
    }
    public int brokenCalc1(int X, int Y) {
        if (X == Y) return 0;
        if (set.contains(Y)) return 200000;
        set.add(Y);
        if (Y > X) {
            if (Y % 2 == 0) {
                return 1 + brokenCalc1(X, Y / 2);
            } else {
                return 1 + brokenCalc(X, Y + 1);
            }
        } else {
            return X - Y;
        } 
    }
}