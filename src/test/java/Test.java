import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void ucs(){
        int[][] test = {
            {5, 1, 2, 4},
            {9, 6, 3, 8},
            {13, 11, 7, 12},
            {0, 10, 14, 15}
        };
        int[][] GOAL2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };

        long ucsStarTime = System.currentTimeMillis();
        UniformCostSearch ucs = new UniformCostSearch(test, GOAL2);
        GeneralSearch.Node solution = ucs.solution();
        long ucsEndTime = System.currentTimeMillis();
        System.out.println("UCS visited: " + ucs.getNodeVisited());
        System.out.println(solution + ": UCS spent " + (ucsEndTime - ucsStarTime));
    }

    @org.junit.Test
    public void aStar() {
        int[][] test = {
                {2, 7, 3, 5, 10},
                {1, 8, 9, 4, 14},
                {6,12,0,18,13},
                {11,16,23,19,15},
                {21,17,22,24,20}
        };

        int[][] GOAL3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,0}
        };

        long assStarTime = System.currentTimeMillis();
        AStarSearch ass = new AStarSearch(test, GOAL3, "misplaced");
        GeneralSearch.Node solution2 = ass.solution();
        long assEndTime = System.currentTimeMillis();
        System.out.println("Misplaced visited: " + ass.getNodeVisited());
        System.out.println(solution2 + ": Misplaced spent " + (assEndTime - assStarTime));

        long assStarTime2 = System.currentTimeMillis();
        AStarSearch ass2 = new AStarSearch(test, GOAL3, "manhattan");
        GeneralSearch.Node solution3 = ass2.solution();
        long assEndTime3 = System.currentTimeMillis();
        System.out.println("Manhattan visited: " + ass2.getNodeVisited());
        System.out.println(solution3 + ": Manhattan spent " + (assEndTime3 - assStarTime2));
    }

    @org.junit.Test
    public void plot() throws PythonExecutionException, IOException {
        Plot plt = Plot.create(PythonConfig.pyenvConfig("anaconda3-4.4.0"));
        plt.plot()
                .add(Arrays.asList(1.3, 2))
                .label("label")
                .linestyle("--");
        plt.xlabel("xlabel");
        plt.ylabel("ylabel");
        plt.text(0.5, 0.2, "text");
        plt.title("Title!");
        plt.legend();
        plt.show();
    }
}
