import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] array2 = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        boolean result = Arrays.deepEquals(array1, array2);
        System.out.println(result);
    }
}
