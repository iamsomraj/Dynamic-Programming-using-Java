// Equal Sum Partition Problem
// Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
// Examples:

// arr[] = {1, 5, 11, 5}
// Output: true 
// The array can be partitioned as {1, 5, 5} and {11}

import java.util.Arrays;

class App {

   public static boolean subsetEquipartitionProblem(int arr[], int sum, int n) {
      if (n == 0 && sum != 0) {
         return false;
      }
      if (sum == 0) {
         return true;
      }
      if (arr[n - 1] <= sum) {
         return subsetEquipartitionProblem(arr, sum - arr[n - 1], n - 1) || subsetEquipartitionProblem(arr, sum, n - 1);
      } else {
         return subsetEquipartitionProblem(arr, sum, n - 1);
      }
   }

   public static void main(String[] args) {
      int arr[] = { 2, 3, 8, 6 };
      System.out.println(Arrays.toString(arr));
      int sum = 11;
      System.out.println(sum);
      System.out.println(subsetEquipartitionProblem(arr, sum, arr.length));
   }
}
// output
// [2, 3, 8, 6]
// 11
// true