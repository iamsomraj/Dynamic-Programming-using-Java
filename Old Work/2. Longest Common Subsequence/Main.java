import java.util.*;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter the first string : \n");
    char input1[] = sc.nextLine().toCharArray();
    System.out.println("\nEnter the second string : \n");
    char input2[] = sc.nextLine().toCharArray();
    int t[][] = new int[input1.length + 1][input2.length + 1];
    for (int i = 0; i <= input1.length; i++) {
      for (int j = 0; j <= input2.length; j++) {
        if (i == 0 || j == 0) {
          t[i][j] = 0;
          // checking is for i - 1 and j - 1 because we are one index ahead in the matrix
          // of T
        } else if (input1[i - 1] == input2[j - 1]) {
          t[i][j] = t[i - 1][j - 1] + 1;
        } else {
          t[i][j] = Math.max(t[i][j - 1], t[i - 1][j - 1]);
        }
      }
    }
    System.out.println("\nThe length of the longest common subsequence : \n");
    System.out.println(t[input1.length][input2.length]);
  }
}