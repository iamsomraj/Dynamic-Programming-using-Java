import java.util.*;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter the number of items:\n");
    int number = sc.nextInt();
    ArrayList<Integer> values = new ArrayList<Integer>();
    ArrayList<Integer> weights = new ArrayList<Integer>();
    System.out.println("\nEnter the values one by one : \n");
    for (int i = 0; i < number; i++) {
      values.add(sc.nextInt());
    }
    System.out.println("\nEnter the weights one by one: \n");
    for (int i = 0; i < number; i++) {
      weights.add(sc.nextInt());
    }
    System.out.println("\nEnter the maximum weight of knapsack: \n");
    int capacity = sc.nextInt();
    // for the main table rows, we need equal number rows for the items
    // for the main table columns, we need number equal to capacity starting from 0
    int t[][] = new int[number][capacity + 1];
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < capacity + 1; j++) {
        // for capacity 0, we can not have a value
        if (i == 0 || j == 0) {
          t[i][j] = 0;
        }
        // when the capacity is less than weight of the item
        else if (j < weights.get(i)) {
          t[i][j] = t[i - 1][j];
        } else {
          // compare with value plus remaining value wrt weight and upper cell
          t[i][j] = Math.max(values.get(i) + t[i - 1][j - weights.get(i)], t[i - 1][j]);
        }
      }
    }
    System.out.println("\nThe maximized answer : \n");
    // the answer is always the bottom right element
    System.out.println(t[number - 1][capacity]);
  }
}
