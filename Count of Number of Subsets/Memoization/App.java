import java.util.Arrays;

/**
 * App
 */
public class App {

   static int t[][];

   static int countOfSubset(int arr[], int sum, int number) {
      if (number == 0 & sum != 0) {
         return 0;
      }
      if (sum == 0) {
         return 1;
      }
      if (t[number][sum] != -1) {
         return t[number][sum];
      }
      if (arr[number - 1] <= sum) {
         t[number][sum] = countOfSubset(arr, sum - arr[number - 1], number - 1) + countOfSubset(arr, sum, number - 1);
         return t[number][sum];

      } else {
         t[number][sum] = countOfSubset(arr, sum, number - 1);
         return t[number][sum];
      }
   }

   public static void main(String[] args) {
      int arr[] = { 2, 3, 8, 6, 5, 11 };
      System.out.println(Arrays.toString(arr));
      int sum = 11;
      System.out.println(sum);
      int number = arr.length;
      t = new int[number + 1][sum + 1];
      for (int i = 0; i < arr.length + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            t[i][j] = -1;
         }
      }
      System.out.println(countOfSubset(arr, sum, number));

   }
}

// output
// [2,3,8,6,5,11]
// 11
// 4