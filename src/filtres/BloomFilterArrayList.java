package filtres;

import java.util.ArrayList;

public class BloomFilterArrayList implements BloomFilterI {
    private final ArrayList<Integer> tab;
    private final int len;
    private final int nbHash;

    public BloomFilterArrayList(int len, int nbHash) {
        this.len = len;
        this.nbHash = nbHash;
        this.tab = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            tab.add(0);
        }
    }

    public void add(String s) {
        for (int i = 0; i < nbHash; i++) {
            int h = Hash.hash(s, i, len);
            tab.set(h, 1);
        }
    }

    public boolean contains(String s) {
        for (int i = 0; i < nbHash; i++) {
            int h = Hash.hash(s, i, len);
            if (tab.get(h) == 0) {
                return false;
            }
        }
        return true;
    }

    public void empty() {
        for(int i = 0; i < len; i++) {
            tab.set(i, 0);
        }
    }

}
