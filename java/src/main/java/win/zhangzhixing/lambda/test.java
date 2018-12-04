package win.zhangzhixing.lambda;

public class test {
    public static void main(String[] args) {
        // 不用lambda
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        System.out.println(new test().operate(100, 50, mathOperation));

        // 用lambda
        System.out.println(new test().operate(100, 50, (a, b) -> a + b));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
