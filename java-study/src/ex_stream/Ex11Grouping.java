package ex_stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Student3 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student3(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }
    
    //groupingBy() 에서 사용
    enum Level {HIGH, MID, LOW} //성적을 상, 중, 하 세 단계로 분류
}

public class Ex11Grouping {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("A", true, 1, 1, 300),
                new Student2("B", false, 1, 1, 250),
                new Student2("C", true, 1, 1, 200),
                new Student2("D", false, 1, 2, 150),
                new Student2("E", true, 1, 2, 100),
                new Student2("F", false, 1, 2, 50),
                new Student2("G", true, 1, 3, 100),
                new Student2("H", false, 1, 3, 150),
                new Student2("I", true, 1, 3, 200),
                new Student2("J", false, 2, 1, 350),
                new Student2("K", true, 2, 1, 250),
                new Student2("L", false, 2, 1, 200),
                new Student2("M", true, 2, 2, 150),
                new Student2("N", false, 2, 2, 100),
                new Student2("O", true, 2, 2, 50),
                new Student2("P", false, 2, 3, 100),
                new Student2("Q", true, 2, 3, 150),
                new Student2("R", false, 2, 3, 200)
        };


    }
}
