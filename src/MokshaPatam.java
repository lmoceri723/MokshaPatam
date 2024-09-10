import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Landon Moceri
 *
 */

public class MokshaPatam {

    public static int[] formatRealPaths(int boardsize, int[][] ladders, int[][] snakes) {
        int[] realPaths = new int[boardsize + 1];

        // Add all ladders to realPaths
        for (int[] ladder : ladders) {
            realPaths[ladder[0]] = ladder[1];
        }

        // Add all snakes to realPaths
        for (int[] snake : snakes) {
            realPaths[snake[0]] = snake[1];
        }

        // Fill in the rest of the board with the same value as the index
        for (int i = 1; i <= boardsize; i++) {
            if (realPaths[i] == 0) {
                realPaths[i] = i;
            }
        }

        return realPaths;
    }

    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        // Format snakes and ladders into a single array to reduce the search time to O(1)
        int[] realPaths = formatRealPaths(boardsize, ladders, snakes);

        // Create a BFS queue to store future moves to be checked
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        // Create a visited map to keep track of which squares have been visited
        boolean[] visited = new boolean[boardsize + 1];
        visited[1] = true;

        int moves = 0;

        // If the queue is empty, all possible moves have been checked and no solution exists
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            // This loop processes one level of the BFS tree at a time
            while (queueSize > 0) {
                queueSize--;

                int currentSquare = queue.remove();

                if (currentSquare == boardsize) {
                    return moves;
                }

                // Adds all possible moves from the current square to the queue
                for (int i = 1; i <= 6; i++) {
                    int nextSquare = currentSquare + i;
                    if (nextSquare <= boardsize && !visited[nextSquare]) {
                        // Does not add to queueSize, as these moves are on the next level of the BFS tree
                        queue.add(realPaths[nextSquare]);
                        visited[nextSquare] = true;
                    }
                }
            }
            // Once a level of the BFS tree has been processed and no solution found, increment the number of moves
            moves++;
        }

        return -1;
    }
}