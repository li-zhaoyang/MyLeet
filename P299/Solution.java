class Solution {
    public String getHint(String secret, String guess) {
      if (secret == null || guess == null || secret.length() == 0)  return "0A0B";
      int l = secret.length();
      boolean[] used = new boolean[l];
      boolean[] guessed = new boolean[l];
      int samePos = 0;
      int diffPos = 0;
      for (int i = 0; i < l; i++) {
        if (guess.charAt(i) == secret.charAt(i)){
          used[i] = true;
          guessed[i] = true;
          samePos++;
        }
      }
      for (int i = 0; i < l; i++) {
        for (int j = 0; j < l; j++) {
          if (used[j] || guessed[i]) continue;
          if (guess.charAt(i) == secret.charAt(j)) {
            used[j] = true;
            guessed[i] = true;
            diffPos++;
            break;
          }
        }
      }
      return samePos + "A" + diffPos + "B";
    }
}
