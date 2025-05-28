import java.util.*;

public class ShortDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 65,76, 6, 33);
//        list.add(25); // not possible as list as become immutable
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(23, 65,76, 6, 33));
        list2.add(25);
        list2.add(99);
        System.out.println(list2);

        ArrayList<String> str = new ArrayList<>();
        str.add("Harsit");
        str.add("Aman");
        str.add("Rohan");

        System.out.println(str);
        Collections.sort(str);
        System.out.println(str);
    }
}
