package org.example.Streams;
//import org.example.ProducerConsumerMutex.BitUtils;

//import org.example.ProducerConsumerMutex.BitUtils;

//import BitUtils;

import java.util.stream.IntStream;

public class SomeApp {
    public static void main(String[] args) {
//        byte[] bytes = new byte[256];
//        org.example.ProducerConsumerMutex.BitUtils.process(bytes);
        IntStream.range(1, 6)
                .mapToObj(i -> i + " ")
                .forEach(System.out::print);
    }
}
