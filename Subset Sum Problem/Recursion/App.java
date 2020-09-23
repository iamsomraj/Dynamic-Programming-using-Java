import java.util.Arrays;

class App {
   public static boolean subsetSum(int arr[], int sum, int n) {
      if (n == 0 && sum == 0) {
         return true;
      }

      if (n == 0 && sum != 0) {
         return false;
      }

      if (arr[n - 1] <= sum) {
         return subsetSum(arr, sum - arr[n - 1], n - 1) || subsetSum(arr, sum, n - 1);
      } else {
         return subsetSum(arr, sum, n - 1);
      }
   }

   public static void main(String[] args) {
      // items array
      int arr[] = { 1, 2, 3, 4 };
      System.out.println(Arrays.toString(arr));
      // target sum
      int sum = 11;
      System.out.println(sum);
      System.out.println(subsetSum(arr, sum, arr.length));
   }
}
