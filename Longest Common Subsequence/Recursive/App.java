// LCS Problem Statement: Given two sequences, find the length of longest
// subsequence present in both of them. A subsequence is a sequence that appears
// in the same relative order, but not necessarily contiguous. For example,
// “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
class App {

   static int longComSubseq(char x[], char y[], int m, int n) {
      if (m == 0 || n == 0) {
         return 0;
      }
      if (x[m - 1] == y[n - 1]) {
         return (1 + longComSubseq(x, y, m - 1, n - 1));
      } else {
         return Math.max(longComSubseq(x, y, m - 1, n), longComSubseq(x, y, m, n - 1));
      }
   }

   public static void main(String[] args) {
      String x = "AGGTAB";
      System.out.println(x);
      String y = "GXTXAYB";
      System.out.println(y);
      int m = x.length();
      int n = y.length();
      System.out.println("Longest Common Subsequence length is -");
      System.out.println(longComSubseq(x.toCharArray(), y.toCharArray(), m, n));
   }
}