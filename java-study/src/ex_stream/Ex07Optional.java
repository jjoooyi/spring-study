package ex_stream;

import java.util.Optional;

public class Ex07Optional {
    public static void main(String[] args) {
//        int[] arr = null;
        int[] arr = new int[0];
        System.out.println("arr.length = " + arr.length);

//        Optional<String> opt = null; // 가능하지만 바람직하지 X!
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("abc");
        System.out.println("opt = " + opt);
//        System.out.println("opt = " + opt.get()); //NullPointerException 발생, get()잘 사용하지 않음

        String str = "";

//        try {
//            str = opt.get(); //예외 발생
//        } catch (Exception e) {
//            str = ""; //예외가 발생하면 빈문자열("")로 초기화
//        }

//        str = opt.orElse("EMPTY"); //Optional에 저장된 값이 null이면 ""반환
//        str = opt.orElseGet(() -> "Empty");
        str = opt.orElseGet(String::new); // () -> new String()

        System.out.println("str = " + str);
    }
}
