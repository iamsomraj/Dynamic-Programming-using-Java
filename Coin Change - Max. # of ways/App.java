import java.util.Arrays;

/**
 * App
 */
public class App {

   static int t[][];

   static int coinChange(int coin[], int sum, int n) {
      for (int i = 1; i < coin.length + 1; i++) {
         for (int j = 1; j < sum + 1; j++) {
            if (coin[i - 1] <= j) {
               t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }

      return t[n][sum];
   }

   public static void main(String[] args) {
      int coin[] = { 2, 5, 3, 6 };
      int sum = 10;
      int n = coin.length;
      t = new int[n + 1][sum + 1];
      for (int i = 0; i < coin.length + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            if (i == 0)
               t[i][j] = 0;
            if (j == 0)
               t[i][j] = 1;
         }
      }
      System.out.println(coinChange(coin, sum, n));
      for (int a[] : t)
         System.out.println(Arrays.toString(a));
   }
}

// output
// 5
// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
// [1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
// [1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 2]
// [1, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4]
// [1, 0, 1, 1, 1, 2, 3, 2, 4, 4, 5]