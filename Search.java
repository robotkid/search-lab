import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search {

    // Returns the index of `target` in `words`, or -1 if not found
    public static int linearSearch(String target, String[] words) {
        return -1;
    }

    public static int binarySearch(String target, String[] words) {
        return -1;
    }

    public static void main(String[] args) throws IOException {
        String[] words = Files.readAllLines(Paths.get("words.txt")).toArray(new String[0]);

        long startTime = System.nanoTime();
        int index = linearSearch("zulu", words);
        index = linearSearch("zulu", words);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Found 'zulu' at index " + index);
        System.out.println("Time taken for linear search: " + (duration / 1e3) + " microseconds");

        startTime = System.nanoTime();
        index = binarySearch("zulu", words);
        index = binarySearch("zulu", words);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Found 'zulu' at index " + index);
        System.out.println("Time taken for binary search: " + (duration / 1e3) + " microseconds");

    }

}