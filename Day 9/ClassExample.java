//interface MyInterface {
//    void hello();
//    void bye();
//}
//
//class Sample implements MyInterface {
//    public void hello() {
//        System.out.println("This is hello method");
//    }
//
//    public void bye() {
//        System.out.println("This is bye method");
//    }
//}
//
//public class ClassExample {
//    public static void main(String[] args) {
//        MyInterface mi = new Sample();
//        mi.hello();
//        mi.bye();
//
//        System.out.println();
//
//        // Anonymous class
//        MyInterface mi2 = new MyInterface() {
//            @Override
//            public void hello() {
//                System.out.println("This is anonymous hello method");
//            }
//
//            @Override
//            public void bye() {
//                System.out.println("This is anonymous bye method");
//            }
//        };
//
//        mi2.hello();
//        mi2.bye();
//    }
//}

// Functional Interface
interface MyInterface {
    void hello();
}

interface MyNewInterface {
    int cal(int a, int b);
}

public class ClassExample {
    public static void main(String[] args) {

        MyInterface mi = () -> System.out.println("This is lambda expression example");
        mi.hello();

        MyNewInterface mni = (a, b) -> a+b;
        System.out.println(mni.cal(4, 5));
    }
}
