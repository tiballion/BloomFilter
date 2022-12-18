package test;

import filtres.BloomFilterLinked;

public class FiltreDeBloomLinkedTest {
    public void test() {
        BloomFilterLinked f = new BloomFilterLinked(10, 3);
        System.out.println("Testing FiltreDeBloom LinkedList");
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