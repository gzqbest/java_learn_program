public class StringTemplateTest {
    public static void main(String[] args) {
        /**
         *  字符串模板，动态拼接,方便拼接字符串
         */
        String name = "gzq";
        String str1 = STR."欢迎您,\{name}";
        System.out.println(str1);

        String size = "13L";
        String address = "jiangxi";
        Integer age = 23;
        String str2 = STR."""
                {
                    "size":\{size},
                    "address":\{address},
                    "age":\{age}
                }
                """;
        System.out.println(str2);
    }
}
