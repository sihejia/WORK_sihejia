package homework3_2;

class Tools {
    //构造一个方法用来算两个数的加减乘除
    public double calculate(int a, char x, int b) {
        double sum = 0;
        if (x == '+') {
            sum = a + b;
        } else if (x == '-') {
            sum = a - b;
        } else if (x == '*') {
            sum = a * b;
        } else if (x == '/') {
            sum = 1.0*a / b;
        } else {
            System.out.println("您输入的运算符有误");
        }
        return sum;
    }

    //构造一个方法用来得到三个数中的最大值
    public double chooseMax(double a, double b, double c) {
        double max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }

        if (max <= c) {
            max = c;
        }
        return max;
    }

    //构造一个方法对数组进行遍历
    public void ergodic(int[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    //构造一个方法进行int类型的数组的冒泡排序
    public int[] rank(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    //构造一个方法对学生的绩点划分等级
    private void score(double x) {
        if (x <= 4.0) {
            if (x == 4.0) {
                System.out.println("开挂了吧？");
            } else if (x >= 3.5) {
                System.out.println("WOC!,这也太强了吧");
            } else if (x >= 3.0) {
                System.out.println("挺不错你嘛");
            } else if (x >= 2.0) {
                System.out.println("啧啧，不够卷啊");
            } else if (x >= 0) {
                System.out.println("我的建议是寄！");
            }
        } else {
            System.out.println("你这绩点输错了吧，这么离谱");
        }
    }
    //对score方法进行封装，让它不能被随意使用，需要运用下面public方法进行访问
    public void getScore(double x){
        score(x);
    }
}