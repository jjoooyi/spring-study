package ex_stream;

import java.util.stream.Stream;

public class Ex03LambdaStream {
    public static void main(String[] args) {
        //iterate(T seed, UnaryOperator f) 단항 연산자 하나 -> 하나
        Stream<Integer> intStream = Stream.iterate(0, n -> n + 2); //무한 스트림
        intStream
                .limit(10)
                .forEach(System.out::println);

        //generate(Supplier s) : 입력X 출력O
        Stream<Integer> oneStream = Stream.generate(() -> 1); //무한 스트림
        oneStream
                .limit(10)
                .forEach(System.out::println);

    }
}
