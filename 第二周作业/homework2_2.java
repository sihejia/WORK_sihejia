import java.util.Scanner;
public class homework2_2 {
    public static void main(String[] args) {
        int a, b;
        char x;
        int h;
        double res;
        Scanner input = new Scanner(System.in);
        tools s = new tools();
        System.out.println("输入数据前：输入0运算结束,输入1计算开始\n");
        System.out.println("请输入计算数据（a，b，运算符）\n");
        do {
            h = input.nextInt();
            if (h != 0) {


                a = input.nextInt();
                x = input.next().charAt(0);
                b = input.nextInt();

                res = s.calculate(a, x, b);
                System.out.println(a);
                System.out.println(x);
                System.out.println(b + " = " + res);
            }
         else{
                    System.out.println("程序结束\n");
                }
            }
            while (h != 0) ;

    }
}
class tools{
    public double calculate(int a,char x,int b){
        double sum=0;
        if(x=='+'){
         sum=a+b;
        }
        else if(x=='-'){
            sum=a-b;
        }
        else if(x=='*'){
            sum=a*b;
        }
        else if(x=='/'){
            sum=a/b;
        }
        else{
            System.out.println("您输入的运算符有误");
        }
        return sum;
    }
}