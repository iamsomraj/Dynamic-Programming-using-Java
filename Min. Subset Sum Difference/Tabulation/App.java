// Sum of subset differences
// Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
// If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

// Example:
// Input:  arr[] = {1, 6, 11, 5} 
// Output: 1
// Explanation:
// Subset1 = {1, 5, 6}, sum of Subset1 = 12 
// Subset2 = {11}, sum of Subset2 = 11 

import java.util.ArrayList;
import java.util.Arrays;

// input - one array
// output - minimum subset sum difference

class App {

   static boolean t[][];

   static void subsetSumProblem(int arr[], int n, int sum) {
      for (int i = 1; i < n + 1; i++) {
         for (int j = 1; j < sum + 1; j++) {
            if (arr[i - 1] <= j) {
               t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
   }

   public static void main(String[] args) {
      int arr[] = { 1, 6, 11, 5 };
      System.out.println(Arrays.toString(arr));
      int range = 0;
      for (int i = 0; i < arr.length; i++) {
         range += arr[i];
      }
      int n = arr.length;
      // subset sum problem with range
      // initialization
      t = new boolean[n + 1][range + 1];
      for (int i = 0; i < n + 1; i++) {
         for (int j = 0; j < range + 1; j++) {
            if (i == 0)
               t[i][j] = false;
            if (j == 0)
               t[i][j] = true;
         }
      }
      subsetSumProblem(arr, n, range);

      // take the last row and make array till half
      ArrayList<Integer> indexArr = new ArrayList<>();
      boolean lastRow[] = t[n];
      for (int i = 0; i < lastRow.length / 2; i++) {
         if (lastRow[i] == true) {
            indexArr.add(i);
         }
      }
      int mn = Integer.MAX_VALUE;
      for (int i = 0; i < indexArr.size(); i++) {
         mn = Math.min(mn, range - 2 * indexArr.get(i));
      }
      System.out.println(mn);

   }
}