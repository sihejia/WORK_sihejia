
import  java.util.Scanner;
public class homework2_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入储存学生的个数:");
        int n = input.nextInt();
        String[] arr01 = new String[n];
        int[] arr02 = new int[n];
        int[] CLASS  =new int[n];
        double[] arr03 = new double[n];
        double[] arr04 = new double[n];
        double[] arr05 = new double[n];
        double[] aver = new double[n];

// 从键盘输入学生的一些信息————————————————————————————————————————————————
        System.out.println("请分别输入学生的信息:");
        for (int i = 0; i < n; i++) {
            System.out.println("第" + i+1 + "名学生的信息如下:");
            System.out.println("姓名为:");
            arr01[i] = input.next();
            System.out.println("学号为:");
            arr02[i] = input.nextInt();
            System.out.println("班级为:");
            CLASS[i] = input.nextInt();
            System.out.println("语文分数为:");
            arr03[i] = input.nextDouble();
            System.out.println("数学分数为:");
            arr04[i] = input.nextDouble();
            System.out.println("英语分数为:");
            arr05[i] = input.nextDouble();
        }
//将该几名学生的平均成绩分别求出并在屏幕输出————————————————————————————————————————————————
        for (int i = 0; i < n; i++) {
            aver[i] = (arr03[i] + arr04[i] + arr05[i]) / 3.0;
            int j = i+1;
            System.out.println("第"+j+"名学生的平均成绩为:");
            System.out.println (String.format("%.2f",aver[i]));
        }
//将这些学生按照平均成绩从低到高进行排序——————————————————————————————————————————————————————
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (aver[j] > aver[i + 1]) {
                    double temp = aver[i];
                    aver[j] = aver[j + 1];
                    aver[j + 1] = temp;
                }
            }
        }
//遍历排列后的学生平均成绩————————————————————————————————————————————————————————————
        System.out.println("学生成绩排名由低到高为:");
        for (int i = 0; i < n; i++) {
            int m = i+1;
            System.out.println("第" + m + "个学生的成绩是:" );
            System.out.println (String.format("%.2f",aver[i]));
        }
//根据学生的平均成绩对学生的学习情况进行分类——————————————————————————————————————————————
        System.out.println("这些学生的成绩评价如下:");
        for (int i = 0; i < n; i++) {
            int m = i+1;
            if (aver[i] >= 90.0) {
                System.out.println("第" + m + "名学生成绩优异");
            } else if (aver[i] >= 80.0) {
                System.out.println("第" + m + "名学生成绩优良");
            } else if (aver[i] >= 70.0) {
                System.out.println("第" + m + "名学生成绩普通");
            } else if (aver[i] >= 60.0) {
                System.out.println("第" + m + "名学生成绩合格");
            } else {
                System.out.println("第" + m + "名学生成绩不合格");
            }
        }
    }
}
/*
由于对构造器和封装运用的不熟练以及赶作业时间吃紧，没有用封装和构造器对输入的数据进行相应的限制，同时也因为对面向对象以及传参的不熟练也没有分别写多个方法而是在
主方法中将所有的步骤一起写完，通过这次考核也认识到了自己的很多不足，争取下次加油!
 */

