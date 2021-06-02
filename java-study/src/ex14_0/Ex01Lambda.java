package ex14_0;

public class Ex01Lambda {
    public static void main(String[] args) {
//        Object obj = (Object) (a, b) -> a > b ? a : b; // 람다식, 익명객체
//        Object obj = new Object() {
//        MyFunction f = new MyFunction() {
//            public int max(int a, int b) {
//                return a > b ? a : b;
//            }
//        };

        //람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
        MyFunction f = (a, b) -> a > b ? a : b;// 람다식, 익명객체

        int value = f.max(3, 5); //함수형 인터페이스
        System.out.println("value = " + value);

        //== == == == == == == == == == == == == == == == == ==
        MyFunction2 f2 = () -> System.out.println("myMethod()");
        aMethod(f2);

        aMethod(() -> System.out.println("hello"));
        //== == == == == == == == == == == == == == == == == ==

    }
    static void aMethod(MyFunction2 f) {
        f.myMethod();
    }
}

@FunctionalInterface
interface MyFunction {
//    public abstract int max(int a, int b);
    int max(int a, int b); // 인터페이스 메서드는 기본적으로 다 public abstract 임
}

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}
