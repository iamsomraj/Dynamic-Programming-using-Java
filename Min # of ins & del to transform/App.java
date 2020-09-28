import java.util.*;

// Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

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
      String x = "heap";
      String y = "pea";
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      int lcs = lcs(x.toCharArray(), y.toCharArray(), m, n);
      int deletions = x.length() - lcs;
      int insertions = y.length() - lcs;
      System.out.println("Deletion : " + deletions);
      System.out.println("Insertion : " + insertions);
   }
}


// output
// Deletion : 2
// Insertion : 1