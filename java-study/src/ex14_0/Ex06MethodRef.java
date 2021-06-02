package ex14_0;

import java.util.function.Function;
import java.util.function.Supplier;

public class Ex06MethodRef {
    public static void main(String[] args) {

        Function<String, Integer> f = s -> Integer.parseInt(s);
        System.out.println(f.apply("100")+200);

        f = Integer::parseInt;
        System.out.println(f.apply("100")+200);


        //== == == == == == == == == == == == == == == == == ==
        //생성자에 매개변수 없는 경우
//        Supplier<MyClass> s = () -> new MyClass();
//
//        MyClass mc = s.get();
//        System.out.println("mc = " + mc);
//        System.out.println(s.get());
//
//        s = MyClass::new;
//        System.out.println(s.get());

        //생성자에 매개변수 있는 경우
        Function<Integer, MyClass> f1 = (i) -> new MyClass(i);
        f1 = MyClass::new;

        MyClass mc2 = f1.apply(100);
        System.out.println("mc2.iv = " + mc2.iv);
        System.out.println(f1.apply(200).iv);


        //== == == == == == == == == == == == == == == == == ==
        //배열 메서드 참조
        Function<Integer, int[]> f2 = (i) -> new int[i];
        f2 = int[]::new;

        int[] arr = f2.apply(5);
        System.out.println(arr.length);

        System.out.println(f2.apply(10).length);
    }
}

class MyClass {
    int iv;

//    public MyClass() {}

    public MyClass(int iv) {
        this.iv = iv;
    }

}
