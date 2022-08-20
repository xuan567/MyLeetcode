package test;

public class Test {
    public static class Inner{
        public static void paint(){
            System.out.println("inner?");
        }
    }

    public static void main(String[] args) {
        Test.Inner inner = new Test.Inner();
        inner.paint();
    }

}
