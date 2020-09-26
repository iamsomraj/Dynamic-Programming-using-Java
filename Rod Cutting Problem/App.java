import java.util.Arrays;

// Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

// length   | 1   2   3   4   5   6   7   8  
// --------------------------------------------
// price    | 1   5   8   9  10  17  17  20
// And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

// length   | 1   2   3   4   5   6   7   8  
// --------------------------------------------
// price    | 3   5   8   9  10  17  17  20

// variant of unbounded knapsack

class App {

   static int t[][];

   static int rodCuttingProblem(int length[], int price[], int n, int rod) {
      for (int i = 1; i < n + 1; i++) {
         for (int j = 1; j < rod + 1; j++) {
            if (length[i - 1] <= j) {
               t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][rod];
   }

   public static void main(String[] args) {
      int rod = 8;
      int length[] = new int[rod];
      for (int i = 0; i < length.length; i++) {
         length[i] = i + 1;
      }
      System.out.println(Arrays.toString(length));
      int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
      System.out.println(Arrays.toString(price));
      int n = length.length;
      t = new int[n + 1][rod + 1];
      System.out.println(rodCuttingProblem(length, price, n, rod));
      for (int a[] : t)
         System.out.println(Arrays.toString(a));

   }
}

// output
// [1, 2, 3, 4, 5, 6, 7, 8]
// [1, 5, 8, 9, 10, 17, 17, 20]
// 22
// [0, 0, 0, 0, 0, 0, 0, 0, 0]
// [0, 1, 2, 3, 4, 5, 6, 7, 8]
// [0, 1, 5, 6, 10, 11, 15, 16, 20]
// [0, 1, 5, 8, 10, 13, 16, 18, 21]
// [0, 1, 5, 8, 10, 13, 16, 18, 21]
// [0, 1, 5, 8, 10, 13, 16, 18, 21]
// [0, 1, 5, 8, 10, 13, 17, 18, 22]
// [0, 1, 5, 8, 10, 13, 17, 18, 22]
// [0, 1, 5, 8, 10, 13, 17, 18, 22]