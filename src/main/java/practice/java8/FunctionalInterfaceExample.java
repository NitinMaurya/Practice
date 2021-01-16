package practice.java8;

public class FunctionalInterfaceExample {

    @FunctionalInterface
    interface Adder {
        default int multiply(int x, int y){
            return isInteger(x * y) ? x * y : x;
        }

        static boolean isInteger(int x){
            x = x * x;
            return x > 0;
        }

        int sum(int x, int y);
    }

    public static void main(String[] args) {
        Adder adder = (x, y) -> x + y;
        Adder adder1 = Integer::sum;
        System.out.println(adder.multiply(5,6));
        System.out.println(adder.sum(6,8));
        System.out.println(adder1.sum(4,9));
    }
}
