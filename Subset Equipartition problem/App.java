import java.util.Arrays;

class App {

   static boolean t[][];

   public static boolean subsetEquipartitionProblem(int arr[], int sum, int n) {
      for (int i = 1; i < arr.length + 1; i++) {
         for (int j = 1; j < sum + 1; j++) {
            if (arr[i - 1] <= j) {
               t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
            } else {
               t[i][j] = t[i - 1][j];
            }
         }
      }
      return t[n][sum];
   }

   public static void main(String[] args) {
      int arr[] = { 2, 3, 8, 6 };
      System.out.println(Arrays.toString(arr));
      int sum = 11;
      System.out.println(sum);
      t = new boolean[arr.length + 1][sum + 1];
      for (int i = 0; i < arr.length + 1; i++) {
         for (int j = 0; j < sum + 1; j++) {
            if (i == 0)
               t[i][j] = false;
            if (j == 0)
               t[i][j] = true;
         }
      }
      System.out.println(subsetEquipartitionProblem(arr, sum, arr.length));
   }
}