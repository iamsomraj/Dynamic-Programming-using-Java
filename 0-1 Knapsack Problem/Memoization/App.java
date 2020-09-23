import java.util.Arrays;

class App {

   static int t[][];

   public static int knapsack(int wt[], int val[], int w, int n) {
      if (n == 0 || w == 0) {
         return 0;
      }
      if (t[n][w] != -1) {
         return t[n][w];
      }
      if (wt[n - 1] <= w) {
         t[n][w] = Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
         return t[n][w];
      } else {
         t[n][w] = knapsack(wt, val, w, n - 1);
         return t[n][w];
      }
   }

   public static void main(String[] args) {
      // weight array
      int wt[] = { 10, 20, 30 };
      System.out.println(Arrays.toString(wt));
      // value array
      int val[] = { 60, 100, 120 };
      System.out.println(Arrays.toString(val));
      // capacity of the knapsack
      int w = 50;
      System.out.println(w);
      // number of the items
      int n = wt.length;
      System.out.println(n);

      // initializing the matrix for memoization
      t = new int[n + 1][w + 1];
      for (int i = 0; i < n + 1; i++) {
         for (int j = 0; j < w + 1; j++) {
            t[i][j] = -1;
         }
      }
      System.out.println(knapsack(wt, val, w, n));
   }
}