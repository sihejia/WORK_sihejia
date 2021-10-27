import java.util.Scanner;
public class homework04 {
    public static void main(String[] args){
        int i,j;
        int k=0;
        System.out.println("请输入一个数:");
        Scanner scan = new Scanner(System.in);
        int a= scan.nextInt();
        for(i=1;i<a;i++){
            j=a%i;
            if(j==0){
                k=1;
                break;
            }
        }
        if(k==1){
            System.out.println(a+"是素数");
        }
        else{
            System.out.println(a+"不是是素数");

        }

    }
}
