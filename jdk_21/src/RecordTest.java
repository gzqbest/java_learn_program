public class RecordTest {
    // 常量数据结构，简化书写
    public static record Person(String name,Integer age){

    }

    public static record Shape(double width,double height){

    }

    public static void main(String[] args) {
        Person person = new Person("gzq", 23);
        System.out.printf("年龄：%d%n",person.age());
        System.out.printf("姓名: %s%n",person.name());

        // 模式匹配记录模式
        System.out.println(getArea(new Shape(10.0,10.0)));
    }

    public static double getArea(Shape shape){
        if(shape instanceof Shape(double length,double width)){
            return length * width;
        }
        return 0;
    }
}
