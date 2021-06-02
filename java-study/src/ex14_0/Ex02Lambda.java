package ex14_0;

@FunctionalInterface
interface MyFunction3 {
    void run(); // == public abstract void run();
}

public class Ex02Lambda {
    static void execute(MyFunction3 f) { //매개변수의 타입이 MyFunction3인 메서드
        f.run();
    }

    static MyFunction3 getMyFunction() { //반환 타입이 MyFunction3인 메서드
//        MyFunction3 f = () -> System.out.println("f3.run()");
//        return f;
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        //람다식으로 MyFunction3의 run()을 구현
        MyFunction3 f1 = () -> System.out.println("f1.run()");
        
        MyFunction3 f2 = new MyFunction3() { // 익명클래스로 run()을 구현
            @Override
            public void run() { //public 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        MyFunction3 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("run()"));
    }

}
