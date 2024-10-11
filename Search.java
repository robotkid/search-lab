import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search {

    // Linear search: Returns the index of `target` in `words`, or -1 if not found
    public static int linearSearch(String target, String[] words) {
        // Loop through the array, checking each element one by one
        for (int i = 0; i < words.length; i++) {
            // If the target word is found at the current index, return the index
            if (target.equals(words[i])) {
                return i;
            }
        }
        // If the target word is not found, return -1
        return -1;
    }

    // Binary search: Requires that the array `words` is sorted
    // Returns the index of `target` in `words`, or -1 if not found
    public static int binarySearch(String target, String[] words) {
        // Initialize the low and high pointers
        int lo = 0;
        int hi = words.length - 1;

        // Continue searching while the low pointer is less than or equal to the high
        // pointer
        while (lo <= hi) {
            // Calculate the middle index of the current search range
            int mid = (lo + hi) / 2;

            // If the target word is found at the middle index, return the index
            if (target.equals(words[mid])) {
                return mid;
            }
            // If the target is alphabetically before the middle word, search in the left
            // half
            else if (target.compareTo(words[mid]) < 0) {
                hi = mid - 1;
            }
            // If the target is alphabetically after the middle word, search in the right
            // half
            else {
                lo = mid + 1;
            }
        }
        // If the target word is not found, return -1
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // Read all lines from the "words.txt" file into an array of strings
        // Converts the list to a String array
        String[] words = Files.readAllLines(Paths.get("words.txt")).toArray(new String[0]);

        // Measure time taken for linear search
        long startTime = System.nanoTime(); // Get the current time in nanoseconds before starting
        int index = linearSearch("zymoid", words); // Perform the linear search
        index = linearSearch("zymoid", words); // Perform the search again for consistency in timing
        long endTime = System.nanoTime(); // Get the current time in nanoseconds after finishing
        long duration = endTime - startTime; // Calculate the time taken by the search
        System.out.println("Found 'zymoid' at index " + index);
        System.out.println("Time taken for linear search: " + (duration / 1e3) + " microseconds");

        // Measure time taken for binary search
        startTime = System.nanoTime(); // Reset start time
        index = binarySearch("zymoid", words); // Perform the binary search
        index = binarySearch("zymoid", words); // Perform the search again for consistency in timing
        endTime = System.nanoTime(); // Reset end time
        duration = endTime - startTime; // Calculate the time taken by the search
        System.out.println("Found 'zymoid' at index " + index);
        System.out.println("Time taken for binary search: " + (duration / 1e3) + " microseconds");

    }

}
