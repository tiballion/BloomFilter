package benchmark;

import filtres.BloomFilterI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;

public class BloomFilterBenchmark {

    /**
     * Return the average time that it takes to insert an element inside a Bloom filter.
     * @param f The filter to test
     * @param nbElem the number of element to test, the higher, the more accurate the result
     * @return the average insert duration in microseconds
     */
    public static double insertSpeed(BloomFilterI f, int nbElem) {
        f.empty();
        double startTime = System.nanoTime();
        for(int i = 0; i < nbElem; i++) {
            f.add(Integer.toString(i));
        }
        double endTime = System.nanoTime();
        return (endTime - startTime)/nbElem/1000;
    }

    /**
     * Returns the error rate of the contains method of a Bloom filter.
     * @param f The filter to test.
     * @param nbElem the number of numbers that is going to be inserted in the Bloom filter
     * @return the error rate (0 <= errorRate <= 1)
     */
    public static double errorRate(BloomFilterI f, int nbElem) {
        f.empty();
        int max = 10000;
        int falsePositives = 0;
        HashSet<String> present = new HashSet<>();
        for (int i = 0; i < nbElem; i++) {
            String r = Integer.toString(new Random().nextInt(max));
            present.add(r);
            f.add(r);
        }
        for (int i = 0; i < max; i++) {
            String s = Integer.toString(i);
            if (f.contains(s) && !present.contains(s)) {
                falsePositives++;
            }
        }
        return (double) falsePositives / max;
    }


    /**
     * Exports both the error rate and the insert speed of a given Bloom filter.
     * @param f The Bloom filter
     * @param fileName The name of the output file
     */
    public static void exportBloomFilterStats(BloomFilterI f, String fileName, int iterations, int nbElem) {
        System.out.println("Exporting " + fileName + "...");
        long startTime = System.nanoTime();
        double[] errorRatesArray = new double[iterations];
        double[] insertSpeedArray = new double[iterations];
        for(int i = 0; i < iterations; i++) {
            errorRatesArray[i] = BloomFilterBenchmark.errorRate(f, nbElem);
            insertSpeedArray[i] = BloomFilterBenchmark.insertSpeed(f, nbElem);
        }
        serialize(errorRatesArray, insertSpeedArray, fileName);
        long endTime = System.nanoTime();
        System.out.println("Exported " + fileName + " in " + (endTime - startTime)/1000000 + " milliseconds.");
    }

    public static String getName(String s) {
        String[] parts = s.split("(?<=\\D)(?=\\d)");
        return parts[0];
    }

    /**
     * Serialize 2 arrays into a CSV file.
     * @param error The error rate array
     * @param insert The insert speed array
     * @param name The name of the file
     */
    public static void serialize(double[] error, double[] insert, String name) {
        StringBuilder csv = new StringBuilder("Error rate,Insert speed \n");
        String folderName = getName(name);
        File folder = new File(folderName);
        if(!folder.exists()) {
            folder.mkdir();
        }
        for(int i = 0; i < error.length; i++) {
            csv.append(error[i]).append(",").append(insert[i]).append("\n");
        }
        File file = new File(folderName+"/"+name+".csv");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(csv);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
