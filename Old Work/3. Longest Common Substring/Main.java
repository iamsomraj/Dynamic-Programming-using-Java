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
    int max = -1;
    int row = -1;
    int col = -1;
    for (int i = 1; i <= input1.length; i++) {
      for (int j = 1; j <= input2.length; j++) {
        if (input1[i - 1] == input2[j - 1]) {
          t[i][j] = t[i - 1][j - 1] + 1;
          if (max < t[i][j]) {
            max = t[i][j];
            row = i;
            col = j;
          }
        }
      }
    }
    String substring = "";
    System.out.println("\nThe longest common substring is : \n");
    int num = t[row][col];
    while (num != 0) {
      substring = String.valueOf(input1[row - 1]) + substring; // bottom up reverse concat
      row--;
      col--;
      num = t[row][col];
    }

    System.out.println(substring);
    System.out.println("\nThe length of the longest common substring : \n");
    System.out.println(max);

  }
}