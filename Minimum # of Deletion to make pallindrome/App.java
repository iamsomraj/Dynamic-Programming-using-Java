import java.util.Arrays;

// Minimum number of deletions to make a string palindrome
// Last Updated: 11-07-2019
// Given a string of size ‘n’. The task is to remove or delete minimum number
// of characters from the string so that the resultant string is palindrome.

// Note: The order of characters should be maintained.

// Examples :

// Input : aebcbda
// Output : 2
// Remove characters 'e' and 'd'
// Resultant string will be 'abcba'
// which is a palindromic string

// Input : geeksforgeeks
// Output : 8

/**
 * App
 */
public class App {

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
      String x = "geeksforgeeks";
      // first calculate Long. Pallindromic Subseq
      String y = new StringBuffer(x).reverse().toString();
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      int lps = lcs(x.toCharArray(), y.toCharArray(), m, n);
      // at last subtract LPS from length of the actual string
      System.out.println("Minimum number of deletions : " + (x.length() - lps));
      for (int a[] : t) {
         System.out.println(Arrays.toString(a));
      }
   }
}

// Output
// Minimum number of deletions : 8
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
// [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
// [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2]
// [0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3]
// [0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3]
// [0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3]
// [0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3]
// [0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3]
// [0, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3]
// [0, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4]
// [0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4]
// [0, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5]
// [0, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5]
// [0, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5]