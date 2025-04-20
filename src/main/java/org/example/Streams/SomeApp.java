package org.example.Streams;
//import org.example.ProducerConsumerMutex.BitUtils;

//import org.example.ProducerConsumerMutex.BitUtils;

//import BitUtils;

public class SomeApp {
    public static void main(String[] args) {
//        byte[] bytes = new byte[256];
//        org.example.ProducerConsumerMutex.BitUtils.process(bytes);
//        IntStream.range(1, 6)
//                .mapToObj(i -> i + " ")
//                .forEach(System.out::print);

        Integer a = 320001;
        Integer c = 320000;
        Integer b = 320001;
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
    }
}
