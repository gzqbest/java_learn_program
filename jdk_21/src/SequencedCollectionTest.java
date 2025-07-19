import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

public class SequencedCollectionTest {
    public static void main(String[] args) {
        /*
         * 统一对有序集合首尾元素的操作，或者进行反转，hashset不是有序的
         */
        List<Integer> list = new ArrayList<>();
        list.addFirst(2);
        list.addLast(3);
        System.out.println(list);
        list.addLast(4);
        // 对原数据结构不变 创建一个新的数据结构
        List<Integer> list1 = list.reversed();
        System.out.println(list);
        System.out.println(list1);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addFirst(1);
        linkedHashSet.addFirst(1);
        Integer lastElement = linkedHashSet.removeLast();
        System.out.println(lastElement);

        System.out.println(linkedHashSet);

        linkedHashSet.addFirst(2);
        linkedHashSet.addFirst(3);
        System.out.println(linkedHashSet);
        linkedHashSet.addFirst(2);
        System.out.println(linkedHashSet);

        SequencedMap<Integer,String > sequencedMap = new LinkedHashMap();
        sequencedMap.putFirst(1,"1");
        sequencedMap.putFirst(2,"2");
        Map.Entry<Integer, String> firstEntry = sequencedMap.pollFirstEntry();
        System.out.println(STR."FIRST KEY IS \{firstEntry.getKey()}, VALUE IS \{firstEntry.getValue()}");
    }
}
