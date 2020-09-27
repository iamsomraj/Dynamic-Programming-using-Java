import java.util.Arrays;

// LCS Problem Statement: Given two sequences, find the length of longest
// subsequence present in both of them. A subsequence is a sequence that appears
// in the same relative order, but not necessarily contiguous. For example,
// “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
class App {

   static int t[][];

   static int longComSubseq(char x[], char y[], int m, int n) {
      for (int i = 1; i < m + 1; i++) {
         for (int j = 1; j < n + 1; j++) {
            if (x[i - 1] == y[j - 1]) {
               t[i][j] =  1 + t[i - 1][j - 1];
            } else {
               t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
         }
      }
      return t[m][n];
   }

   public static void main(String[] args) {
      String x = "AGGTAB";
      System.out.println(x);
      String y = "GXTXAYB";
      System.out.println(y);
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      System.out.println("Longest Common Subsequence length is ");
      System.out.println(longComSubseq(x.toCharArray(), y.toCharArray(), m, n));
      for (int a[] : t) {
         System.out.println(Arrays.toString(a));
      }
   }
}

// Output
// AGGTAB
// GXTXAYB
// Longest Common Subsequence length is
// 4
// [-1, -1, -1, -1, -1, -1, -1, -1]
// [-1, 0, 0, 0, 0, 1, 1, -1]
// [-1, 1, 1, 1, 1, 1, 1, -1]
// [-1, 1, 1, 1, 1, 1, 1, -1]
// [-1, -1, -1, 2, 2, 2, 2, -1]
// [-1, -1, -1, -1, -1, 3, 3, -1]
// [-1, -1, -1, -1, -1, -1, -1, 4]