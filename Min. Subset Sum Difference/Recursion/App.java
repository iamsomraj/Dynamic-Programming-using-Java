import java.util.Arrays;

// input - one array
// output - minimum subset sum difference

class App {

   static boolean t[][];

   static int minSubsetDifference(int arr[], int n, int sum, int range) {
      if (n == 0) {
         return Math.abs(range - 2 * sum);
      }
      return Math.min(minSubsetDifference(arr, n - 1, sum + arr[n - 1], range),
            minSubsetDifference(arr, n - 1, sum, range));
   }

   public static void main(String[] args) {
      int arr[] = { 1, 6, 11, 5 };
      System.out.println(Arrays.toString(arr));
      int range = 0;
      for (int i = 0; i < arr.length; i++) {
         range += arr[i];
      }
      int n = arr.length;
      int sum = 0;
      System.out.println(minSubsetDifference(arr, n, sum, range));
   }
}