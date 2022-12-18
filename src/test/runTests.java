package test;

public class runTests {
    public static void main(String[] args) {
        FiltreDeBloomLinkedTest test = new FiltreDeBloomLinkedTest();
        FiltreDeBloomArrayTest test2 = new FiltreDeBloomArrayTest();
        FiltreDeBloomTest test3 = new FiltreDeBloomTest();
        test.test();
        test2.test();
        test3.test();
    }
}
