import java.util.Arrays;

class App {

   static int t[][];

   public static int subsetEquipartitionProblem(int arr[], int sum, int n) {
      if (n == 0 && sum != 0) {
         return 0;
      }
      if (sum == 0) {
         return 1;
      }
      if (t[n][sum] != -1) {
         return t[n][sum];
      }
      if (arr[n - 1] <= sum) {
         t[n][sum] = Math.max(subsetEquipartitionProblem(arr, sum - arr[n - 1], n - 1),
               subsetEquipartitionProblem(arr, sum, n - 1));
         return t[n][sum];
      } else {
         t[n][sum] = subsetEquipartitionProblem(arr, sum, n - 1);
         return t[n][sum];

      }
   }

   public static void main(String[] args) {
      int arr[] = { 2, 3, 8, 6 };
      int n = arr.length;
      System.out.println(Arrays.toString(arr));
      int sum = 11;
      System.out.println(sum);
      t = new int[n + 1][sum + 1];
      for (int i = 0; i < n + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            t[i][j] = -1;
         }
      }
      System.out.println(subsetEquipartitionProblem(arr, sum, n));
   }
}
// output
// [2, 3, 8, 6]
// 11
// 1