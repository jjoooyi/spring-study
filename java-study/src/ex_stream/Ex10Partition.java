package ex_stream;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
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
}
public class Ex10Partition {
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

        System.out.println("1. 단순분할(성별로 분할)");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        System.out.println("maleStudent = " + maleStudent);
        System.out.println("femaleStudent = " + femaleStudent);

        //=====================================================
        System.out.println("\n2. 단순분할 + 통계(성별, 학생 수)");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, counting()));
        System.out.println("남학생 수 = " + stuNumBySex.get(true));
        System.out.println("여학생 수 = " + stuNumBySex.get(false));
        
        //=====================================================
        System.out.println("\n3. 단순분할 + 통계(성별, 1등)");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        maxBy(Comparator.comparingInt(Student2::getScore))));
        System.out.println("남학생 1등 = " + topScoreBySex.get(true));
        System.out.println("여학생 1등 = " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Student2::getScore)), Optional::get
                        )
                ));
        System.out.println("남학생 1등 = " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 = " + topScoreBySex2.get(false));

        //=====================================================
        System.out.println("\n4. 성별 불합격자, 100점 이하");
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                                        partitioningBy(s -> s.getScore()<=100)));
        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        System.out.println("failedMaleStu = " + failedMaleStu);
        System.out.println("failedFemaleStu = " + failedFemaleStu);
    }
}
