// Sum of subset differences
// Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
// If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

// Example:
// Input:  arr[] = {1, 6, 11, 5} 
// Output: 1
// Explanation:
// Subset1 = {1, 5, 6}, sum of Subset1 = 12 
// Subset2 = {11}, sum of Subset2 = 11 

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