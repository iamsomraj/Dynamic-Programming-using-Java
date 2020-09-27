import java.util.Arrays;

// Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
// Examples :

// Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
// Output : 5
// The longest common substring is “Geeks” and is of length 5.

// Input : X = “abcdxyz”, y = “xyzabcd”
// Output : 4
// The longest common substring is “abcd” and is of length 4.

// Input : X = “zxabcdezy”, y = “yzabcdezx”
// Output : 6
// The longest common substring is “abcdez” and is of length 6.
class App {

   static int t[][];

   static void longComSubstring(char x[], char y[], int m, int n) {
      for (int i = 1; i < m + 1; i++) {
         for (int j = 1; j < n + 1; j++) {
            if (x[i - 1] == y[j - 1]) {
               t[i][j] = 1 + t[i - 1][j - 1];
            } else {
               t[i][j] = 0;
            }
         }
      }
   }

   public static void main(String[] args) {
      String x = "GeeksforGeeks";
      System.out.println(x);
      String y = "GeeksQuiz";
      System.out.println(y);
      int m = x.length();
      int n = y.length();
      t = new int[m + 1][n + 1];
      longComSubstring(x.toCharArray(), y.toCharArray(), m, n);
      int length = Integer.MIN_VALUE;
      for (int a[] : t) {
         System.out.println(Arrays.toString(a));
         for (int element : a) {
            length = Math.max(element, length);
         }
      }
      System.out.println(length);
   }
}
