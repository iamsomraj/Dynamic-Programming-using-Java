import java.util.Arrays;

// Given two strings str1 and str2, find the shortest string length that has
// both str1 and str2 as subsequences.
// Examples :

// Input: str1 = "geek", str2 = "eke"
// Output: "geeke"

// Input: str1 = "AGGTAB", str2 = "GXTXAYB"
// Output: "AGXGTXAYB"

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
      String x = "geeke";
      String y = "eke";
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      System.out.println("SCS Length : " + ((m + n) - lcs(x.toCharArray(), y.toCharArray(), m, n)));
      for (int array[] : t) {
         System.out.println(Arrays.toString(array));                 
      }
   }
}

// output
// SCS Length : 5
// [0, 0, 0, 0]
// [0, 0, 0, 0]
// [0, 1, 1, 1]
// [0, 1, 1, 2]
// [0, 1, 2, 2]
// [0, 1, 2, 3]