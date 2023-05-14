import java.util.Arrays;
import java.util.HashSet;

public class Entry {
    public static void main(String[] args) {

//        int[][] state = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 0, 8}
//        };
//
//        int[][] copy = new int[state.length][];
//        for (int i = 0; i < copy.length; i++) {
//            copy[i] = Arrays.copyOf(state[i], state[0].length);
//        }

        int[][] test = {
                {1, 6, 7},
                {5, 0, 3},
                {4, 8, 2}
        };

        int[][] GOAL = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };



        long ucsStarTime = System.currentTimeMillis();
        UniformCostSearch ucs = new UniformCostSearch(test, GOAL);
        GeneralSearch.Node solution = ucs.solution();
        long ucsEndTime = System.currentTimeMillis();
        System.out.println("UCS visited: " + ucs.getNodeVisited());
        System.out.println(solution + ": UCS spent " + (ucsEndTime - ucsStarTime));

        long assStarTime = System.currentTimeMillis();
        AStarSearch ass = new AStarSearch(test, GOAL, "misplaced");
        GeneralSearch.Node solution2 = ass.solution();
        long assEndTime = System.currentTimeMillis();
        System.out.println("Misplaced visited: " + ass.getNodeVisited());
        System.out.println(solution2 + ": Misplaced spent " + (assEndTime - assStarTime));

        long assStarTime2 = System.currentTimeMillis();
        AStarSearch ass2 = new AStarSearch(test, GOAL, "manhattan");
        GeneralSearch.Node solution3 = ass2.solution();
        long assEndTime3 = System.currentTimeMillis();
        System.out.println("Manhattan visited: " + ass2.getNodeVisited());
        System.out.println(solution3 + ": Manhattan spent " + (assEndTime3 - assStarTime2));


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
