package ex_stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex09FinalOp {
    public static void main(String[] args) {

        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel() //병렬로 처리, 실행할때마다 순서 달라짐
                .forEachOrdered(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();
        Optional<String> pWord = Stream.of(strArr)
                .parallel()
                .filter(s -> s.charAt(0) == 's').findAny();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.get());

        //Stream<String> -> Stream<Integer> 변환
        Stream<Integer> intStream = Stream.of(strArr).map(String::length);

        //Stream<String> -> IntStream 변환, mapToInt-기본형 스트림으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min.getAsInt());

        OptionalInt empty = IntStream.empty().reduce(Integer::max);
        System.out.println("empty = " + empty.orElse(0)); //.orElseGet(() -> 0)
    }
}
