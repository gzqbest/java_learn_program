import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        judge("a");
        switchJudge("b");
    }

    public static void judge(Object o){
        if(o instanceof String s){
            System.out.println(s.length());
        }
        if(o instanceof Integer i){
            Integer i1 = i++;
            System.out.println(i1);
        }
    }

    public static String switchJudge(Object o){
        return switch(o){
            case Integer i ->String.format(Locale.ROOT,"这是一个整数,%d",i);
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }
}