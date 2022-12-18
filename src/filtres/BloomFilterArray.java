package filtres;

public class BloomFilterArray implements BloomFilterI {
    private final int[] tab;
    private final int len;
    private final int nbHash;

    public BloomFilterArray(int len, int nbHash) {
        this.len = len;
        this.nbHash = nbHash;
        this.tab = new int[len];
    }

    public void add(String s) {
        for (int i = 0; i < nbHash; i++) {
            int h = Hash.hash(s, i, len);
            tab[h] = 1;
        }
    }

    public boolean contains(String s) {
        for (int i = 0; i < nbHash; i++) {
            int h = Hash.hash(s, i, len);
            if (tab[h] == 0) {
                return false;
            }
        }
        return true;
    }

    public void empty() {
        for(int i = 0; i < len; i++) {
            tab[i] = 0;
        }
    }

}
