package test;

import filtres.BloomFilterArray;

public class FiltreDeBloomTest {
    public void test() {
        BloomFilterArray f = new BloomFilterArray(10, 3);
        System.out.println("Testing FiltreDeBloom Array");
        f.add("uno");
        f.add("dos");
        f.add("tres");
        assert (f.contains("uno"));
        assert (f.contains("dos"));
        assert (f.contains("tres"));
        assert (!f.contains("no"));
        System.out.println("Test passed");
    }
}
