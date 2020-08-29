package demo.java8.functionalInterface;

@FunctionalInterface
public interface Adder {
    default int multiply(int x, int y){
        return isInteger(x * y) ? x * y : x;
    }

    static boolean isInteger(int x){
        x = x * x;
        return x > 0;
    }

    int sum(int x, int y);
}

class InterfaceDemo{
    public static void main(String[] args) {
        Adder adder = (x, y) -> x + y;
        System.out.println(adder.multiply(5,6));
    }
}
