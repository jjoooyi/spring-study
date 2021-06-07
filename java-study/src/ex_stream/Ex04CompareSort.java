package ex_stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex04CompareSort {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("studentA", 3, 300),
                new Student("studentB", 1, 200),
                new Student("studentC", 2, 100),
                new Student("studentD", 2, 150),
                new Student("studentE", 1, 300),
                new Student("studentF", 3, 290),
                new Student("studentG", 3, 180)
        );

//        studentStream.sorted(Comparator.comparing(Student::getBan) //1. 반별 정렬
        studentStream.sorted(Comparator.comparing((Student s)->(s.getBan())) //1. 반별 정렬
            .thenComparing(Comparator.naturalOrder()).reversed()) //2. 기본 정렬 - Student 객체에서 정의해둔 기준!
            .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    //총점 내림차순을 기본 정렬로 한다
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }
}
