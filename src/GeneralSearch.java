public abstract class GeneralSearch {
    protected int[][] board;
    protected final int[][] GOAL;
    protected final int[][] direction = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    protected String mode;

    public int getNodeVisited() {
        return nodeVisited;
    }

    protected int nodeVisited;

    public GeneralSearch(int[][] GOAL) {
        this.GOAL = GOAL;
    }

    public GeneralSearch(int[][] board, int[][] GOAL) {
        this.board = board;
        this.GOAL = GOAL;
    }

    public GeneralSearch(int[][] board, int[][] GOAL, String mode) {
        this.board = board;
        this.GOAL = GOAL;
        this.mode = mode;
    }

    public abstract Node solution();

    protected int[] findZeroPosition(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public void printTool(int[][] result) {
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                if (j != result[0].length - 1) {
                    System.out.print(ints[j] + ", ");
                } else {
                    System.out.print(ints[j]);
                }
            }
            System.out.println("");
        }
    }

    protected class Node implements Comparable<Node> {
        private final int[][] state;
        private final int cost;

        public Node(int[][] state, int cost) {
            this.state = state;
            this.cost = cost;
        }

        public int[][] getState() {
            return state;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int[] ints : this.state) {
                for (int j = 0; j < this.state[0].length; j++) {
                    builder.append(ints[j]);
                }
            }
            return builder.toString();
        }

        @Override
        public int compareTo(Node node) {
            if (this.cost > node.getCost()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
