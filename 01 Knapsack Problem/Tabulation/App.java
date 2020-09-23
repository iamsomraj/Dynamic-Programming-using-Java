import java.util.Arrays;

class App {
   // matrix for the tabulation
   static int t[][];

   public static int knapsack(int wt[], int val[], int w, int n) {
      for (int i = 1; i < n + 1; i++) {
         for (int j = 1; j < w + 1; j++) {
            if (wt[i - 1] <= j) {
               t[i][j] = Math.max((val[i - 1] + t[i - 1][j - wt[i - 1]]), t[i - 1][j]);
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][w];
   }

   public static void main(String[] args) {
      // weight array
      int wt[] = { 1, 2, 5, 6, 7 };
      System.out.println(Arrays.toString(wt));
      // value array
      int val[] = { 1, 6, 18, 22, 28 };
      System.out.println(Arrays.toString(val));
      // capacity of the knapsack
      int w = 11;
      System.out.println(w);
      // number of the items
      int n = wt.length;
      System.out.println(n);
      t = new int[n + 1][w + 1];
      // initialization based on the base case
      // loop starts from 0
      for (int i = 0; i < n + 1; i++) {
         for (int j = 0; j < w + 1; j++) {
            if (i == 0 || j == 0)
               t[i][j] = 0;
         }
      }
      System.out.println(knapsack(wt, val, w, n));
      // dp matrix
      for (int i[] : t) {
         System.out.println(Arrays.toString(i));
      }
   }
}

// Output
// [1, 2, 5, 6, 7]
// [1, 6, 18, 22, 28]
// 11
// 5
// 40
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
// [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
// [0, 1, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7]
// [0, 1, 6, 7, 7, 18, 19, 24, 25, 25, 25, 25]
// [0, 1, 6, 7, 7, 18, 22, 24, 28, 29, 29, 40]
// [0, 1, 6, 7, 7, 18, 22, 28, 29, 34, 35, 40]