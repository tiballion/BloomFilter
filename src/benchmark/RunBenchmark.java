package benchmark;

import filtres.BloomFilterArray;
import filtres.BloomFilterLinked;
import filtres.BloomFilterArrayList;

import static benchmark.BloomFilterBenchmark.exportBloomFilterStats;

public class RunBenchmark {

    public static void exportArray(int ite) {
        exportBloomFilterStats(new BloomFilterArray(10000, 1), "BloomArray1-100", ite, 100);
        exportBloomFilterStats(new BloomFilterArray(10000, 3), "BloomArray3-100", ite, 100);
        exportBloomFilterStats(new BloomFilterArray(10000, 5), "BloomArray5-100", ite, 100);
        exportBloomFilterStats(new BloomFilterArray(10000, 1), "BloomArray1-500", ite, 500);
        exportBloomFilterStats(new BloomFilterArray(10000, 3), "BloomArray3-500", ite, 500);
        exportBloomFilterStats(new BloomFilterArray(10000, 5), "BloomArray5-500", ite, 500);
        exportBloomFilterStats(new BloomFilterArray(10000, 1), "BloomArray1-1000", ite, 1000);
        exportBloomFilterStats(new BloomFilterArray(10000, 3), "BloomArray3-1000", ite, 1000);
        exportBloomFilterStats(new BloomFilterArray(10000, 5), "BloomArray5-1000", ite, 1000);
    }

    public static void exportArraylist(int ite) {
        exportBloomFilterStats(new BloomFilterArrayList(10000, 1), "BloomArrayList1-100", ite, 100);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 3), "BloomArrayList3-100", ite, 100);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 5), "BloomArrayList5-100", ite, 100);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 1), "BloomArrayList1-500", ite, 500);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 3), "BloomArrayList3-500", ite, 500);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 5), "BloomArrayList5-500", ite, 500);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 1), "BloomArrayList1-1000", ite, 1000);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 3), "BloomArrayList3-1000", ite, 1000);
        exportBloomFilterStats(new BloomFilterArrayList(10000, 5), "BloomArrayList5-1000", ite, 1000);
    }

    public static void exportLinked(int ite) {
        exportBloomFilterStats(new BloomFilterLinked(10000, 1), "BloomLinked1-100", ite, 100);
        exportBloomFilterStats(new BloomFilterLinked(10000, 3), "BloomLinked3-100", ite, 100);
        exportBloomFilterStats(new BloomFilterLinked(10000, 5), "BloomLinked5-100", ite, 100);
        exportBloomFilterStats(new BloomFilterLinked(10000, 1), "BloomLinked1-500", ite, 500);
        exportBloomFilterStats(new BloomFilterLinked(10000, 3), "BloomLinked3-500", ite, 500);
        exportBloomFilterStats(new BloomFilterLinked(10000, 5), "BloomLinked5-500", ite, 500);
        exportBloomFilterStats(new BloomFilterLinked(10000, 1), "BloomLinked1-1000", ite, 1000);
        exportBloomFilterStats(new BloomFilterLinked(10000, 3), "BloomLinked3-1000", ite, 1000);
        exportBloomFilterStats(new BloomFilterLinked(10000, 5), "BloomLinked5-1000", ite, 1000);
    }

    public static void main(String[] args) {
        int ite = 50;
        exportArray(ite);
        exportArraylist(ite);
        exportLinked(ite);
    }
}
