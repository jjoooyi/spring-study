package ex_stream;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex02RandomStream {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(); //무한 난수 스트림
        intStream
                .limit(5) //5개만 자르기
                .forEach(System.out::println);

        intStream = new Random().ints(5); //유한 난수 스트림
        intStream
                .forEach(System.out::println);
    }
}
