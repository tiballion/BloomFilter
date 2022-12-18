package filtres;

// arnaud.casteigts@u-bordeaux.fr

public class Main {
    public static void main(String[] args) {
        BloomFilterArray f = new BloomFilterArray(100, 3);
        System.out.println("Testing filtres.FiltreDeBloom Array");
        f.add("uno");
        f.add("dos");
        f.add("tres");
        System.out.println(f.contains("uno"));
        System.out.println(f.contains("dos"));
        System.out.println(f.contains("tres"));
        System.out.println(f.contains("no"));
        BloomFilterArrayList f2 = new BloomFilterArrayList(100, 3);
        System.out.println("Testing filtres.FiltreDeBloom ArrayList");
        f2.add("uno");
        f2.add("dos");
        f2.add("tres");
        System.out.println(f2.contains("uno"));
        System.out.println(f2.contains("dos"));
        System.out.println(f2.contains("tres"));
        System.out.println(f2.contains("no"));
        BloomFilterLinked f3 = new BloomFilterLinked(100, 3);
        System.out.println("Testing filtres.FiltreDeBloom LinkedList");
        f3.add("uno");
        f3.add("dos");
        f3.add("tres");
        System.out.println(f3.contains("uno"));
        System.out.println(f3.contains("dos"));
        System.out.println(f3.contains("tres"));
        System.out.println(f3.contains("no"));
    }
}