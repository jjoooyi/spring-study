package ex_stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex06SteamFlatMap {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

//        Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toUpperCase) //스트림의 요소를 모두 소문자로 변경
                .distinct() //중복 제거
                .sorted() //정렬
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +"))) //하나 이상의 공백
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}
