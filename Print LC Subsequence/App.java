class App {

   static int t[][];

   static int lcs(char x[], char y[], int m, int n) {
      for (int i = 1; i < x.length + 1; i++) {
         for (int j = 1; j < y.length + 1; j++) {
            if (x[i - 1] == y[j - 1]) {
               t[i][j] = 1 + t[i - 1][j - 1];
            } else {
               t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
         }
      }
      return t[m][n];
   }

   public static void main(String[] args) {
      String x = "abcde";
      String y = "abxgtcdejgf";
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      System.out.println("Length : " + lcs(x.toCharArray(), y.toCharArray(), m, n));

      char a[] = x.toCharArray();
      char b[] = y.toCharArray();
      int i = m, j = n;
      String lcs = "";
      while (i > 0 && j > 0) {
         if (a[i - 1] == b[j - 1]) {
            lcs = a[i - 1] + lcs;
            i--;
            j--;
         } else {
            if (t[i - 1][j] > t[i][j - 1]) {
               i--;
            } else {
               j--;
            }
         }
      }
      System.out.println("LCS : " + lcs);
   }
}

// output
// Length : 5
// LCS : abcde