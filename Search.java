import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search {

    // Returns the index of `target` in `words`, or -1 if not found
    public static int linearSearch(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(String target, String[] words) {
        int lo = 0;
        int hi = words.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target.equals(words[mid])) {
                return mid;
            } else if (target.compareTo(words[mid]) < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        String[] words = Files.readAllLines(Paths.get("words.txt")).toArray(new String[0]);

        long startTime = System.nanoTime();
        int index = linearSearch("zymoid", words);
        index = linearSearch("zymoid", words);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Found 'zymoid' at index " + index);
        System.out.println("Time taken for linear search: " + (duration / 1e3) + " microseconds");

        startTime = System.nanoTime();
        index = binarySearch("zymoid", words);
        index = binarySearch("zymoid", words);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Found 'zymoid' at index " + index);
        System.out.println("Time taken for binary search: " + (duration / 1e3) + " microseconds");

    }

}