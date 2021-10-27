import java.util.Scanner;
public class homework02 {
    public static void main(String[] args){
        double s,c;
   Scanner scan =new Scanner(System.in);
        System.out.println("请输入半径: ");
        double r=scan.nextDouble();
        c=3.14*2*r;
        s=3.14*r*r;
        System.out.println("周长是:"+c+"\n"+"面积是:"+s+"\n");

    }
}
