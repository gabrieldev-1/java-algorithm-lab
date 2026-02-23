package algorithms.memory_allocation_algorithms;

import java.util.Arrays;

public class FirstFit {
    // Simulating 15 memory blocks (-1 means free)
    private static int[] memory = new int[15];

    static {
        Arrays.fill(memory, -1);
    }

    /**
     * Implementation of the First Fit memory allocation algorithm.
     * * Algorithm:
     * 1. Scans memory blocks from the beginning.
     * 2. Finds the first contiguous free block large enough to hold the process.
     * 3. Allocates immediately, potentially leaving smaller unused fragments.
     * * Complexity:
     * - Time: O(n), where n is the total memory size.
     * - Space: O(1) beyond the memory array itself.
     */
    public static boolean allocate(int processId, int requestSize) {
        int freeCounter = 0;

        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == -1) {
                freeCounter++;
                
                if (freeCounter == requestSize) {
                    int startPoint = i - requestSize + 1;
                    for (int k = startPoint; k <= i; k++) {
                        memory[k] = processId;
                    }
                    return true;
                }
            } else {
                freeCounter = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("initial memory: " + Arrays.toString(memory));
        
        allocate(1, 3);
        allocate(2, 5);
        
        System.out.println("memory after allocation: " + Arrays.toString(memory));
    }
}
