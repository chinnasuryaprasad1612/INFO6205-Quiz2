public class BinarySearchRotatedArray {
    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param arr            The rotated sorted array to search in
     * @param target         The value to search for
     * @param rotationIndex  The index at which the array is rotated
     * @return               The index of the target value if found, -1 otherwise
     */
    public int search(int[] arr, int target, int rotationIndex){
        //TODO
        /*
         * You have to check if the rotatedIndex is 0,
         * that means the array is not rotated at all or
         * the smallest index is at position 0.(remember the array is sorted)
         */
        int size = arr.length;
        if (rotationIndex == 0) {
            return binarySearch(arr, 0, size - 1, target);
        }
        
        if (target >= arr[0]) {
            return binarySearch(arr, 0, rotationIndex - 1, target);
        } else {
            return binarySearch(arr, rotationIndex, size- 1, target);
        }
        
    }

    /**
     * Performs a binary search on a sorted array within the specified range.
     *
     * @param arr     The sorted array to search in
     * @param left    The left boundary of the search range (inclusive)
     * @param right   The right boundary of the search range (inclusive)
     * @param target  The value to search for
     * @return        The index of the target value if found, -1 otherwise
     */
    private int binarySearch(int[] arr, int left, int right, int target){
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target) {
                return middle; 
            }
            if (arr[middle] < target) {
                left = middle + 1; 
            } else {
                right = middle - 1; 
            }
        }
        
        return -1;
        
    }
}