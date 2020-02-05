package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 1/27/2020.
 */
public class MemoryTest {
    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void memoryTest(){
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= 100000; i++) {
            list.add(new String("Jim"));
        }
//        // Get the Java runtime
//        Runtime runtime = Runtime.getRuntime();
//        // Run the garbage collector
//        runtime.gc();
//        // Calculate the used memory
//        long memory = runtime.totalMemory() - runtime.freeMemory();
//        System.out.println("Used memory is bytes: " + memory);
//        System.out.println("Used memory is megabytes: "
//                + bytesToMegabytes(memory));
        MemoryTest.memoryTest();
    }
}
