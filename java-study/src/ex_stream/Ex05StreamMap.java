package ex_stream;

import java.io.File;
import java.util.stream.Stream;

public class Ex05StreamMap {
    public static void main(String[] args) {

        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};

        Stream<File> fileStream = Stream.of(fileArr);

        //map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map(File::getName); //(f) -> f.getName()
        filenameStream.forEach(System.out::println); //모든 파일의 이름을 출력

        fileStream = Stream.of(fileArr); //스트림을 다시 생성

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.')!= -1)
                .map(s -> s.substring(s.indexOf('.')+1))
                .peek(s -> System.out.printf("filename=%s%n", s))
                .map(String::toUpperCase)
                .peek(s -> System.out.printf("extension=%s%n", s))
                .distinct()
                .forEach(System.out::println);

        System.out.println();

    }
}
