package test;

import filtres.BloomFilterArrayList;

public class FiltreDeBloomArrayTest {
    public void test() {
        BloomFilterArrayList f = new BloomFilterArrayList(100, 3);
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
