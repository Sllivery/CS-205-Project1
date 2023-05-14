import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[][] test = {
                {1, 6, 7},
                {5, 0, 3},
                {4, 8, 2}
        };

        Node node = new Node(test, 4);
        Node node2 = new Node(test, 3);
        Node node3 = new Node(test, 2);
        Node node4 = new Node(test, 1);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(node);
        q.add(node2);
        q.add(node3);
        q.add(node4);
        while (!q.isEmpty()) {
            System.out.println(q.poll().getCost());
        }
    }

    static class Node implements Comparable<Node> {
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
