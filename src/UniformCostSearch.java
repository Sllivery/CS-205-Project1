import java.util.Arrays;
import java.util.PriorityQueue;

public class UniformCostSearch {
    private int[][] board;
    private final int[][] GOAL;
    private final int[][] direction = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public UniformCostSearch(int[][] GOAL) {
        this.GOAL = GOAL;
    }

    public UniformCostSearch(int[][] board, int[][] GOAL) {
        this.board = board;
        this.GOAL = GOAL;
    }

    public boolean solution() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        //initialize the queue
        queue.add(new Node(this.board, 0));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int[][] state = currentNode.getState();
            if (Arrays.deepEquals(state, GOAL)) {
                return true;
            }
            // find 0 position
            int[] zeroPosition = findZeroPosition(state);
            // for i in directions
            for (int[] item : direction) {
                int newRow = zeroPosition[0] + item[0];
                int newCol = zeroPosition[1] + item[1];
                if (newRow > 0 && newRow < state.length && newCol > 0 && newCol < state[0].length) { // if position is legal
                    // then sawp 0 position with these new Position
                    int temp = state[zeroPosition[0]][zeroPosition[1]];
                    state[zeroPosition[0]][zeroPosition[1]] = state[newRow][newCol];
                    state[newRow][newCol] = temp;
                    // push state that's after the swap into the queue
                    Node newNode = new Node(state, currentNode.getCost() + 1);
                    queue.add(newNode);
                }
            }
        }

        return false;
    }

    private int[] findZeroPosition(int[][] array) {
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

    private class Node implements Comparable<Node> {
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
        public int compareTo(Node node) {
            if (this.cost > node.getCost()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
