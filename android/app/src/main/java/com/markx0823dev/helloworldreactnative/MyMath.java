package com.markx0823dev.helloworldreactnative;

public class MyMath {

    private MyMathLogger logger;

    public MyMath() {
    }

    public MyMath(MyMathLogger logger) {
        this.logger = logger;
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int multiple(int first, int second) {
        return first * second;
    }

    public int mockAdd(int first, int second) {
        int sum = first + second;
        if (sum < 0) {
            logger.log(Integer.toString(sum));
        }
        return sum;
    }
}
