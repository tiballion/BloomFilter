package filtres;

public class Hash {

    /**
     * Hash function that returns a hash code for a given string.
     * @param s The string to hash
     * @param i The number of the hash function
     * @param len The length of the Bloom filter
     * @return The hash code
     */
    public static int hash(String s, int i, int len) {
        return (s.hashCode() + i) % len;
    }

}
