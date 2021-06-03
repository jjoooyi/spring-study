package ex_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex01Stream {
    public static void main(String[] args) {
        // Collection -> Stream
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();

        intStream.forEach(System.out::print);

        list.stream()
                .forEach(System.out::print);

        Arrays.asList(4,5,6,7,8)
                .stream()
                .forEach(System.out::print);


        // 배열 -> Stream
        String[] strArr = new String[]{"a", "b", "c"};
        Stream<String> strStream = Stream.of(strArr);
        strStream = Stream.of("a", "b", "c");
        strStream = Stream.of(new String[]{"a", "b", "c"});
        Stream.of("a", "b", "c").forEach(System.out::println);
        Stream<String> stream = Arrays.stream(strArr);
        stream.forEach(System.out::println);

        Integer[] intArr1 = {1, 2, 3, 4, 5};
        Stream<Integer> intStream1 = Arrays.stream(intArr1);
        intStream1.forEach(System.out::print);
        System.out.println("count="+intStream1.count()); //count 만 존재

        int[] intArr2 = {1, 2, 3, 4, 5};
        IntStream intStream2 = Arrays.stream(intArr2);
        System.out.println("average="+intStream2.average()); //count, sum, ...

    }
}
