public class BinarySearch {
	/** 
	 * Find the index of a target using binary search.
	 *
	 * Time complexity: O(log n)
	 * Space complexity: O(1)
	 *
	 * @param target element sought
	 * @param list array of numbers
	 * @return target index
	 */ 
	public static int search(int target, int[] list) {
		int l = 0;
		int r = list.length - 1;

		while(l <= r) {
			int mid = l + (r - l) / 2;

			if(list[mid] == target) {
				return mid;
			}

			else if(list[mid] > target) {
				r = mid - 1;
			}

			else  {
				l = mid + 1;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
	    // Test casese
    	int[] list = {2, 6, 9, 10, 22, 44};
   		int[] emptyList = {};
    	int[] singleElement = {10};

    	System.out.println("--- Running Tests ---");

    	// TEST 01
    	assertTest(search(9, list) == 2, "Element in the middle");
		// TEST 02
    	assertTest(search(2, list) == 0, "Element at the start");

    	// TEST 03
    	assertTest(search(44, list) == 5, "Element at the end");

    	// TEST 04
    	assertTest(search(100, list) == -1, "Element not in list");

    	// TEST 05
    	assertTest(search(10, emptyList) == -1, "Empty list");

    	// TEST 06
    	assertTest(search(10, singleElement) == 0, "Single element list (Found)");

    	// TEST 07
    	assertTest(search(5, singleElement) == -1, "Single element list (Not Found)");
}

	private static void assertTest(boolean condition, String testName) {
    	if (condition) {
        	System.out.println("[PASS] " + testName);
    	} else {
        	System.out.println("[FAIL] " + testName);
    	}
	}
}
