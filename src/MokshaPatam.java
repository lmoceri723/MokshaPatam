import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */

    public static int[] formatRealPaths(int boardsize, int[][] ladders, int[][] snakes) {
        int[] realPaths = new int[boardsize];

        // Add all snakes to realPaths
        for (int i = 0; i < ladders.length; i++) {
            realPaths[ladders[i][0]] = ladders[i][1] - 1;
        }

        // Add all ladders to realPaths
        for (int i = 0; i < snakes.length; i++) {
            realPaths[snakes[i][0]] = snakes[i][1] - 1;
        }

        // Add all normal squares to realPaths
        for (int i = 0; i < boardsize; i++) {
            if (realPaths[i] == 0) {
                realPaths[i] = i;
            }
        }

        return realPaths;
    }

    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        // Format snakes and ladders into a single array to reduce the search time to O(1)
        int[] realPaths = formatRealPaths(boardsize, ladders, snakes);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean[] visited = new boolean[boardsize];
        int moves = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                queueSize--;

                int currentSquare = queue.remove();

                if (currentSquare == boardsize - 1) {
                    return moves;
                }

                for (int i = 1; i <= 6; i++) {

                    if (currentSquare + i <= boardsize - 1 && !visited[currentSquare + i - 1]) {
                        queue.add(realPaths[currentSquare + i]);
                        visited[currentSquare + i - 1] = true;
                    }
                }

            }

            moves++;
        }

        return -1;
    }
}
