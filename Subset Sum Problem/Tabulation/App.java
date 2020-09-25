
// Subset Sum Problem(Dynamic Programming)
// Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
// Example:

// Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
// Output:  True  //There is a subset (4, 5) with sum 9.

import java.util.Arrays;
class App {
   // matrix for the tabulation
   static boolean t[][];

   public static boolean subSetSumProblem(int arr[], int sum) {
      for (int i = 1; i < (arr.length + 1); i++) {
         for (int j = 1; j < (sum + 1); j++) {
            if (arr[i - 1] <= j) {
               t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[arr.length][sum];
   }

   public static void main(String[] args) {
      // items array
      int arr[] = { 1, 2, 3, 7, 8 };
      System.out.println(Arrays.toString(arr));
      // target sum
      int sum = 11;
      System.out.println(sum);
      // initialization of the matrix
      t = new boolean[arr.length + 1][sum + 1];
      for (int i = 0; i < arr.length + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            if (i == 0)
               t[i][j] = false;
            if (j == 0)
               t[i][j] = true;
         }
      }
      System.out.println(subSetSumProblem(arr, sum));
      for (boolean[] a : t) {
         System.out.println(Arrays.toString(a));
      }
   }
}

// output
// 11
// true
// [true, false, false, false, false, false, false, false, false, false, false,
// false]
// [true, true, false, false, false, false, false, false, false, false, false,
// false]
// [true, true, true, true, false, false, false, false, false, false, false,
// false]
// [true, true, true, true, true, true, true, false, false, false, false, false]
// [true, true, true, true, true, true, true, true, true, true, true, true]
// [true, true, true, true, true, true, true, true, true, true, true, true]