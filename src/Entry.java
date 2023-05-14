import java.util.Arrays;
import java.util.HashSet;

public class Entry {
    public static void main(String[] args) {

        int[][] state = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 8}
        };

        int[][] copy = new int[state.length][];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = Arrays.copyOf(state[i], state[0].length);
        }

        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 8}
        };

        int[][] GOAL = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };
        UniformCostSearch ucs = new UniformCostSearch(test, GOAL);
        boolean solution = ucs.solution();
        System.out.println(solution);


//        int[] test = {1, 2, 3, 4};
//        int[] test2 = {1, 2, 3, 4};
//        HashSet<int[]> set = new HashSet<>();
//        set.add(test);
//        boolean contains = set.contains(test2);
//        System.out.println(contains);
//
//        String tests1 = "1,2,3,4";
//        String tests2 = "1,2,3,4";
//        HashSet<String> set2 = new HashSet<>();
//        set2.add(tests1);
//        boolean contains1 = set2.contains(tests2);
//        System.out.println(contains1);
    }
}
