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
               t[i][j] = Math.min(1 + t[i][j - coin[i - 1]], t[i - 1][j]);
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   public static void main(String[] args) {
      int coin[] = { 9, 6, 5, 1 };
      System.out.println(Arrays.toString(coin));
      int sum = 11;
      System.out.println(sum);
      int n = coin.length;
      t = new int[n + 1][sum + 1];
      for (int i = 0; i < coin.length + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            if (i == 0) {
               t[i][j] = Integer.MAX_VALUE - 1;
            }
            if (j == 0) {
               t[i][j] = 0;
            }
         }
      }
      System.out.println(coinChange(coin, sum, n));
      t = new int[3 + 1][30 + 1];
      for (int i = 0; i < 3 + 1; i++) {
         for (int j = 0; j < 30 + 1; j++) {
            if (i == 0) {
               t[i][j] = Integer.MAX_VALUE - 1;
            }
            if (j == 0) {
               t[i][j] = 0;
            }
         }
      }
      System.out.println(Arrays.toString(new int[] { 25, 10, 5 }));
      System.out.println(30);
      System.out.println(coinChange(new int[] { 25, 10, 5 }, 30, 3));
   }
}
