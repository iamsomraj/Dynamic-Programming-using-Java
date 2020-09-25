import java.util.Arrays;

class App {

   static int t[][];

   static int countOfSubset(int arr[], int n, int sum) {
      for (int i = 1; i < n + 1; i++) {
         for (int j = 1; j < sum + 1; j++) {
            if (arr[i - 1] <= j) {
               t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];

            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   public static void main(String[] args) {
      int arr[] = { 1, 1, 2, 3 };
      System.out.println(Arrays.toString(arr));
      int diff = 1;
      System.out.println(diff);
      int n = arr.length;
      int range = 0;
      for (int i = 0; i < arr.length; i++) {
         range = range + arr[i];
      }
      int sum = (diff + range) / 2;
      // init
      t = new int[n + 1][sum + 1];
      for (int i = 0; i < n + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            if (i == 0) {
               t[i][j] = 0;
            }
            if (j == 0) {
               t[i][j] = 1;
            }
         }
      }
      System.out.println(countOfSubset(arr, n, sum));

   }
}

// output
// [1,1,2,3]
// 1
// 3