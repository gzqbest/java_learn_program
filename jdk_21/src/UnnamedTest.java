public class UnnamedTest {
    public static record Point(int x,int y){

    }

    public static enum Color{
        RED,GREEN;
    }

    public static record SPoint(Point p, Color c){}

    public static void main(String[] args) {
        /*
           如果变量不需要使用，直接使用_ 替代名称，简介书写
         */
        int[] arr = {34,45,23,27,15};
        int total = 0;
        for(int _ : arr){
            total ++;
        }
        System.out.println(total);

        /*
           模式匹配中未命名,instanceof 中 record 没有使用变量，使用 _ 替代
         */
        System.out.println(getInstance(new SPoint(new Point(1,0),Color.GREEN),
                new SPoint(new Point(2,0),Color.GREEN)));
    }

    public static double getInstance(Object object1,Object object2){
        if(object1 instanceof SPoint(Point p1,_) && object2 instanceof SPoint(Point p2, _)){
            return Math.sqrt(Math.pow(p2.x()-p1.x(),2) + Math.pow(p2.y()-p1.y(),2));
        }
        return -1;
    }
}
