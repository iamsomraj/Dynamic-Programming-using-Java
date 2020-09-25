import java.util.Arrays;

class App {
   static int t[][];

   static int countOfSubsets(int arr[], int sum, int n) {
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
      int arr[] = { 2, 3, 5, 6, 11 };
      System.out.println(Arrays.toString(arr));
      int n = arr.length;
      System.out.println(n);
      int sum = 11;
      System.out.println(sum);
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
      System.out.println(countOfSubsets(arr, sum, n));
      for (int i[] : t) {
         System.out.println(Arrays.toString(i));
      }
   }
}

// output

// [2, 3, 5, 6, 11]
// 5
// 11
// 3
// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
// [1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
// [1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0]
// [1, 0, 1, 1, 0, 2, 0, 1, 1, 0, 1, 0]
// [1, 0, 1, 1, 0, 2, 1, 1, 2, 1, 1, 2]
// [1, 0, 1, 1, 0, 2, 1, 1, 2, 1, 1, 3]