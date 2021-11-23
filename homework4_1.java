package homework4_1;

import java.util.Scanner;
public class homework4_1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入两个数（a、b）");
        double a = input.nextDouble();
        double b = input.nextDouble();
        System.out.println("请选择运算类型（1，2，3，4）:" + "\n" + "1.加法  2.减法  3.乘法  4.除法");
        int choice = input.nextInt();
        if(choice==1){
             Calculator calculator = new Add();
             calculator.add(a,b);
        }
        else if(choice==2){
            Calculator calculator = new Reduce();
            calculator.reduce(a,b);
        }
        else if(choice==3){
            Calculator calculator = new Multi();
            calculator.multi(a,b);
        }
        else if(choice==4){
            Calculator calculator = new Divide();
        }
        else{
            System.out.println("你输入的数字有误");
        }
    }
}
    class Calculator{
    public  void add(double a,double b){

    }
    public  void reduce(double a,double b){

    }
    public  void multi(double a,double b){

    }
    public  void divide(double a,double b){

    }

}
class Add extends Calculator{
    @Override
    public void add(double a, double b) {
        double res;
        res = a + b;
        System.out.println("a + b ="+res);

    }
}
class Reduce extends Calculator{

    @Override
    public void reduce(double a, double b) {
        double res;
        res = a - b;
        System.out.println("a - b ="+res);
    }
}
class Multi extends Calculator{

    @Override
    public void multi(double a, double b) {
        double res;
        res = a * b;
        System.out.println("a * b ="+res);
    }
}
class Divide extends Calculator{

    @Override
    public void divide(double a, double b) {
        double res;
        res = a/b;
        System.out.println("a / b ="+res);
    }
}