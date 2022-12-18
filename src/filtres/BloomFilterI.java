package filtres;

public interface BloomFilterI {
    /**
     * Add a string to the filter
     * @param s the string to add
     */
    void add(String s);

    /**
     * Check if a string is in the filter
     * @param s the string to check
     * @return true if the string is in the filter, false otherwise
     */
    boolean contains(String s);

    /**
     * Empty the filter
     */
    void empty();
}
