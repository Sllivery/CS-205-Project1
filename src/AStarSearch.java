import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarSearch extends GeneralSearch{
    public AStarSearch(int[][] GOAL) {
        super(GOAL);
    }

    public AStarSearch(int[][] board, int[][] GOAL) {
        super(board, GOAL);
    }

    public AStarSearch(int[][] board, int[][] GOAL, String mode) {
        super(board, GOAL, mode);
    }

    @Override
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
            try {
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
                        int heuristic = 0;
                        if (this.mode.equals("misplaced")) {
                            heuristic = misplacedTiles(copy);
                        } else if (this.mode.equals("manhattan")) {
                            heuristic = manhattanDistance(copy);
                        } else {
                            throw new Exception("Parameter error: Please use 'misplaced' or 'manhattan'");
                        }
                        Node newNode = new Node(copy, currentNode.getCost() + 1 + heuristic);
                        queue.add(newNode);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    private int misplacedTiles(int[][] currentState) {
        int result = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[0].length; j++) {
                if (currentState[i][j] != GOAL[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

    private int manhattanDistance(int[][] currentState) {
        int mispalcedNumber;
        int MD = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[0].length; j++) {
                if (currentState[i][j] != GOAL[i][j]){
                    mispalcedNumber = currentState[i][j];
                    for (int k = 0; k < GOAL.length; k++) {
                        for (int l = 0; l < GOAL[0].length; l++) {
                            if (mispalcedNumber == GOAL[k][l]) {
                                MD += Math.abs(i - k) + Math.abs(j - l);
                            }
                        }
                    }
                }
            }
        }
        return MD;
    }
}
