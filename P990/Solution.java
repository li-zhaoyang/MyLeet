/*
    Contest 123
    Feb 9, 2019
*/
class Solution {
    int[] id;
    private int find(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    private void connect(int i, int j) {
        i = find(i);
        j = find(j);
        if (i != j) {
            id[i] = j;
        }
    }
    public boolean equationsPossible(String[] equations) {
        id = new int[26];
        for (int i = 0; i < 26; i++) {
            id[i] = i;
        }
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                connect((int)(e.charAt(0) - 'a'), (int) (e.charAt(3) - 'a'));
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (find((int)(e.charAt(0) - 'a')) == find((int)(e.charAt(3) - 'a'))) return false;
            }
        }
        return true;
    }
}