import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Entry {
    public static void main(String[] args) throws PythonExecutionException, IOException {
        int[][] test = {
                {1, 2, 3},
                {5, 0, 6},
                {4, 7, 8}
        };

        int[][] test2 = {
                {5, 1, 2, 4},
                {9, 0, 3, 8},
                {13, 6, 7, 12},
                {10, 11, 14, 15}
        };

        int[][] test3 = {
                {2, 7, 3, 5, 10},
                {1, 8, 9, 4, 14},
                {6,12,0,18,13},
                {11,16,23,19,15},
                {21,17,22,24,20}
        };

        int[][] GOAL = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };

        int[][] GOAL2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        int[][] GOAL3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,0}
        };

        ArrayList<int[][]> testList = new ArrayList<>();
        ArrayList<int[][]> goalList = new ArrayList<>();

        testList.add(test);
        testList.add(test2);
        testList.add(test3);

        goalList.add(GOAL);
        goalList.add(GOAL2);
        goalList.add(GOAL3);

        for (int i = 0; i < testList.size(); i++) {
            System.out.println();
            System.out.println("===== i =====");
            long ucsStarTime = System.currentTimeMillis();
            UniformCostSearch ucs = new UniformCostSearch(testList.get(i), goalList.get(i));
            GeneralSearch.Node solution = ucs.solution();
            long ucsEndTime = System.currentTimeMillis();
            System.out.println("UCS visited: " + ucs.getNodeVisited());
            System.out.println(solution + ": UCS spent " + (ucsEndTime - ucsStarTime));

            long assStarTime = System.currentTimeMillis();
            AStarSearch ass = new AStarSearch(testList.get(i), goalList.get(i), "misplaced");
            GeneralSearch.Node solution2 = ass.solution();
            long assEndTime = System.currentTimeMillis();
            System.out.println("Misplaced visited: " + ass.getNodeVisited());
            System.out.println(solution2 + ": Misplaced spent " + (assEndTime - assStarTime));

            long assStarTime2 = System.currentTimeMillis();
            AStarSearch ass2 = new AStarSearch(testList.get(i), goalList.get(i), "manhattan");
            GeneralSearch.Node solution3 = ass2.solution();
            long assEndTime3 = System.currentTimeMillis();
            System.out.println("Manhattan visited: " + ass2.getNodeVisited());
            System.out.println(solution3 + ": Manhattan spent " + (assEndTime3 - assStarTime2));
            System.out.println("===== i =====");
            System.out.println();
        }
    }
}
