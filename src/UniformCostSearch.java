import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UniformCostSearch extends GeneralSearch{
    public UniformCostSearch(int[][] GOAL) {
        super(GOAL);
    }

    public UniformCostSearch(int[][] board, int[][] GOAL) {
        super(board, GOAL);
    }

    public boolean solution() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        HashSet<String> set = new HashSet<>();
        //initialize the queue
        queue.add(new Node(this.board, 0));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (set.contains(currentNode.toString())) {
                continue;
            } else {
                set.add(currentNode.toString());
            }
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
                if (newRow >= 0 && newRow < state.length && newCol >= 0 && newCol < state[0].length) { // if position is legal
                    //make a copy
                    int[][] copy = new int[state.length][];
                    for (int i = 0; i < copy.length; i++) {
                        copy[i] = Arrays.copyOf(state[i], state[0].length);
                    }
                    // then sawp 0 position with these new Position
                    int temp = copy[zeroPosition[0]][zeroPosition[1]];
                    copy[zeroPosition[0]][zeroPosition[1]] = copy[newRow][newCol];
                    copy[newRow][newCol] = temp;
                    // push state that's after the swap into the queue
                    Node newNode = new Node(copy, currentNode.getCost() + 1);
                    queue.add(newNode);
                }
            }
        }
        return false;
    }
}
