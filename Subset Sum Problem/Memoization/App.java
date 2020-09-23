import java.util.Arrays;

class App {

   static int t[][];

   public static int subsetSum(int arr[], int sum, int n) {
      if (n == 0 && sum == 0) {
         return 1;
      }

      if (n == 0 && sum != 0) {
         return 0;
      }

      if (t[n][sum] != -1) {
         return t[n][sum];
      }

      if (arr[n - 1] <= sum) {
         t[n][sum] = Math.max(subsetSum(arr, sum - arr[n - 1], n - 1), subsetSum(arr, sum, n - 1));
      } else {
         t[n][sum] = subsetSum(arr, sum, n - 1);
      }
      return t[n][sum];
   }

   public static void main(String[] args) {
      // items array
      int arr[] = { 1, 2, 3, 8 };
      System.out.println(Arrays.toString(arr));
      // target sum
      int sum = 11;
      // define matrix
      t = new int[arr.length + 1][sum + 1];
      // init matrix
      for (int i = 0; i < arr.length + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            t[i][j] = -1;
         }
      }
      System.out.println(sum);
      if (subsetSum(arr, sum, arr.length) == 1) {
         System.out.println(true);
      } else {
         System.out.println(false);
      }
   }
}
