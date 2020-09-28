import java.util.Arrays;

// LCS Problem Statement: Given two sequences, find the length of longest
// subsequence present in both of them. A subsequence is a sequence that appears
// in the same relative order, but not necessarily contiguous. For example,
// “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
class App {

   static int t[][];

   static int longComSubseq(char x[], char y[], int m, int n) {
      if (m == 0 || n == 0) {
         return 0;
      }
      if (t[m][n] != -1) {
         return t[m][n];
      }
      if (x[m - 1] == y[n - 1]) {
         t[m][n] = (1 + longComSubseq(x, y, m - 1, n - 1));
         return t[m][n];
      } else {
         t[m][n] = Math.max(longComSubseq(x, y, m - 1, n), longComSubseq(x, y, m, n - 1));
         return t[m][n];
      }
   }

   public static void main(String[] args) {
      String x = "AGGTAB";
      System.out.println(x);
      String y = "GXTXAYB";
      System.out.println(y);
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      for (int i = 0; i < x.length() + 1; i++) {
         for (int j = 0; j < y.length() + 1; j++) {
            t[i][j] = -1;
         }
      }
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