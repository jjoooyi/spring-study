package ex_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//java.util.function 패키지
public class Ex03Function {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i%2 == 0;
        Function<Integer, Integer> f = i -> i/10*10; // i의 일의 자리를 없앤다

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list); //list 를 랜덤값으로 채운다.
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T t : list) {
            newList.add(f.apply(t));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T t : list) {
            if(p.test(t)) c.accept(t);
        }
        System.out.print("]");
    }

    static <T> void makeRandomList(Supplier<Integer> s, List<Integer> list) {
        for(int i=0; i<10; i++) {
            list.add(s.get()); //Supplier 로 부터 1~100의 난수를 받아서 list 에 추가
        }
    }


}
