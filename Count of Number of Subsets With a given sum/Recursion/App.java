// Count of subsets sum with a Given sum
// Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
// Example:

// Input: arr[] = {1, 2, 3, 3}, X = 6
// Output: 3
// All the possible subsets are {1, 2, 3},
// {1, 2, 3} and {3, 3}

import java.util.Arrays;

/**
 * App
 */
public class App {

   static int countOfSubset(int arr[], int sum, int number) {
      if (number == 0 & sum != 0) {
         return 0;
      }
      if (sum == 0) {
         return 1;
      }
      if (arr[number - 1] <= sum) {
         return countOfSubset(arr, sum - arr[number - 1], number - 1) + countOfSubset(arr, sum, number - 1);
      } else {
         return countOfSubset(arr, sum, number - 1);
      }
   }

   public static void main(String[] args) {
      int arr[] = { 2, 3, 8, 6, 5 };
      System.out.println(Arrays.toString(arr));
      int sum = 11;
      System.out.println(sum);
      int number = arr.length;
      System.out.println(countOfSubset(arr, sum, number));

   }
}

// output
// [2,3,8,6,5]
// 11
// 3