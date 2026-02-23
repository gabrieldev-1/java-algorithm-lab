package algorithms.memory_allocation_algorithms;

import java.util.Arrays;

public class NextFit {
    // Simulating 15 memory blocks (-1 means free)
    private static int[] memory = new int[15];
    private static int lastPosition = 0; // stores where the last allocation ended

    static {
        Arrays.fill(memory, -1);
    }

    /**
     * Implementation of the Next Fit memory allocation algorithm.
     * 
     * Algorithm:
     * 1. Starts scanning memory from the last successful allocation position.
     * 2. Searches for a contiguous free block large enough for the process.
     * 3. If the end of memory is reached, continues scanning from the beginning.
     * 4. Allocation stops if it returns to the original starting point.
     * 
     * Complexity:
     * - Time: O(n), where n is the total memory size.
     * - Space: O(1) beyond the memory array itself.
     */
    public static boolean allocate(int processId, int requestSize) {
        int freeCounter = 0;
        int scanned = 0;
        int i = lastPosition;

        while (scanned < memory.length) {
            if (memory[i] == -1) {
                freeCounter++;

                if (freeCounter == requestSize) {
                    int startPoint = i - requestSize + 1;

                    // Handles wrap-around case
                    if (startPoint < 0) {
                        startPoint += memory.length;
                    }

                    for (int k = 0; k < requestSize; k++) {
                        memory[(startPoint + k) % memory.length] = processId;
                    }

                    lastPosition = (i + 1) % memory.length;
                    return true;
                }
            } else {
                freeCounter = 0;
            }

            i = (i + 1) % memory.length;
            scanned++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("initial memory: " + Arrays.toString(memory));

        allocate(1, 3);
        allocate(2, 5);
        allocate(3, 4);

        System.out.println("memory after allocation: " + Arrays.toString(memory));
    }
}
