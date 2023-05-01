public class Entry {
    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] GOAL = {
                {1,2,3},
                {4,5,6},
                {7,8,0},
        };
        UniformCostSearch ucs = new UniformCostSearch(GOAL);
        ucs.printTool(test);
    }
}
