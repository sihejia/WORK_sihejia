package Assessment04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        boolean loop = true;
        //从键盘输入n，用Student类数组储存这n个对象的信息——————————————————————————————————————————————
        System.out.println("请输入储存学生信息的数量:");
        num = input.nextInt();
        Student[] number = new Student[num];
        for(int i = 0;i< number.length;i++){
            System.out.println("请输入第"+i+1+"个学生的个人信息：  ----------");
            System.out.println("请输入学生的ID号：");
            String ID = input.next();
            System.out.println("请输入学生的姓名：");
            String name = input.next();
            System.out.println("请输入学生的年龄：");
            int age = input.nextInt();
            System.out.println("请分别输入学生的成绩：（数学/语文/英语）");
            double math = input.nextDouble();
            double chinese = input.nextDouble();
            double English = input.nextDouble();
            number[i] = new Student(name,age,math,chinese,English,ID);

            //用Class类的一个属性集合来储存学生和老师两种不同类型的对象————————————————————————————————
            Class.people.add(number[i]);
        }
        Class.people.add(new Teacher("李老师","数学",32));
        Class.people.add(new Teacher("刘老师","java",33));
        Class.people.add(new Teacher("王老师","C语言",36));

        //设计管理系统的菜单，循环进行操作直至手动退出——————————————————————————————————————————————————
        String key = "";
        do {
            System.out.println("===============学生管理系统菜单==================");
            System.out.println("1.得到学生的语文平均成绩=====");
            System.out.println("2.得到学生的高数平均成绩=====");
            System.out.println("3.得到学生的英语平均成绩=====");
            System.out.println("4.得到学生的语文成绩单======");
            System.out.println("5.得到学生的高数成绩单=====");
            System.out.println("6.得到学生的英语成绩单=====");
            System.out.println("7.得到学生的成绩评级======");
            System.out.println("8.得到班级成员的信息======");
            System.out.println("9.查看每日班级活动");
            System.out.println("10.退出========");

            System.out.println("请选择（1——8）");
            key = input.next();

            switch (key) {
                case "1":
                    Class.averChinese(number);  break;
                case "2":
                    Class.averMath(number);  break;
                case "3":
                    Class.averEnglish(number);  break;
                case "4":
                    Class.getChinese(number);  break;
                case "5":
                    Class.getMath(number);  break;
                case "6":
                    Class.getEnglish(number);  break;
                case "7":
                    Class.showGrade(number);  break;
                case "8":
                    Class.showPeople(Class.people);  break;
                case "9":
                    Class.activity();
                case "10":
                    loop = false;    break;
                default: System.out.println("你输入的数据有误，请重新输入"); break;

            }

        }   while (loop) ;
    }
}

class Student{
    //Student类属性
    private String ID;
    private String name;
    private int age;
    private double math;
    private double chinese;
    private double English;
    private double aver;

    //构造器
    public Student(String name, int age, double math, double chinese, double English,String ID) {
        this.name = name;
        this.age = age;
        this.math = math;
        this.chinese = chinese;
        this.English = English;
        this.ID = ID;
        aver = (this.math+this.chinese+this.English)/3.0;
    }

    //set和gst方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getEnglish() {
        return English;
    }

    public void setEnglish(double english) {
        English = english;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getAver() {
        return aver;
    }

    public void setAver(double aver) {
        this.aver = aver;
    }
    //重写toString方法，使其输出所需输出的对象信息
    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Teacher{
    //Teacher的属性
    private String name;
    private String subject;
    private int age;
//构造器
    public Teacher(String name, String subject, int age) {
        this.name = name;
        this.subject = subject;
        this.age = age;
    }
//set和get方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void teach(){
        System.out.println(name+"老师可以教"+subject);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                '}';
    }
}
class Class{
    public String classNumber;
    //创一个ArrayNumber集合，将学生和老师俩个不同类的对象储存在一起
    public static List people = new ArrayList();
    //创建一个static方法，用来得到集合的成员信息
    public static void showPeople(List people){
        System.out.println("——————————————班级成员信息————————————");
        for(Object obj:Class.people){
            System.out.println(obj.toString());
        }
    }
    //public方法用来输出班级活动
    public static void activity(){
        System.out.println("每天需要做早操");

    }
    //创三个方法分别输出三科的排名表——————————————————————————————————————————————————
    public static void getChinese(Student[] number){
        System.out.println("----------全班语文成绩的排名表为：--------");
        Student temp;
        for(int i=0;i< number.length-1;i++){
            for(int j = 0;j< number.length-1-i;j++){
                if(number[j].getChinese()<number[j+1].getChinese()){
                    temp = number[j];
                    number[j]= number[j+1];
                    number[j+1] = temp;
                }
            }
        }
        for(int i = 0;i< number.length;i++){
            System.out.println("学生： "+number[i].getName()+"语文："+number[i].getChinese());
        }

    }
    public static void getMath(Student[] number){
        System.out.println("-----------全班数学成绩的排名表为：--------");
        Student temp;
        for(int i=0;i< number.length-1;i++){
            for(int j = 0;j< number.length-1-i;j++){
                if(number[j].getMath()<number[j+1].getMath()){
                    temp = number[j];
                    number[j]= number[j+1];
                    number[j+1] = temp;
                }
            }
        }
        for(int i = 0;i< number.length;i++){
            System.out.println("学生： "+number[i].getName()+"数学："+number[i].getMath());
        }

    }
    public static void getEnglish(Student[] number){
        System.out.println("------------全班英语成绩的排名表为：--------");
        Student temp;
        for(int i=0;i< number.length-1;i++){
            for(int j = 0;j< number.length-1-i;j++){
                if(number[j].getEnglish()<number[j+1].getEnglish()){
                    temp = number[j];
                    number[j]= number[j+1];
                    number[j+1] = temp;
                }
            }
        }
        for(int i = 0;i< number.length;i++){
            System.out.println("学生： "+number[i].getName()+"英语："+number[i].getEnglish());
        }

    }
//创三个方法用来输出每科的平均成绩————————————————————————————————————————————————————————
    public static void averMath(Student[] number ){
        double sum=0,aver=0;
        for(Student x:number){
            sum += x.getMath();
        }
        aver = sum/(number.length);
        System.out.println("学生数学的平均成绩的平均为："+aver);
    }
    public static void averChinese(Student[] number ){
        double sum=0,aver=0;
        for(Student x:number){
            sum += x.getMath();
        }
        aver = sum/(number.length);
        System.out.println("学生语文的平均成绩的平均为："+aver);
    }
    public static void averEnglish(Student[] number ){
        double sum=0,aver=0;
        for(Student x:number){
            sum += x.getMath();
        }
        aver = sum/(number.length);
        System.out.println("学生英语的平均成绩的平均为："+aver);
    }
//创建static方法输出学生的成绩评级——————————————————————————————————————————————————————————————
    public static void showGrade(Student[] number){
        for(int i = 0;i< number.length;i++){
            if(number[i].getAver()>=90){
                System.out.println(number[i].getName()+"学生的成绩为--S");
            }
            else if(number[i].getAver()>=80){
                System.out.println(number[i].getName()+"学生的成绩为--A");
            }
            else if(number[i].getAver()>=70){
                System.out.println(number[i].getName()+"学生的成绩为--B");
            }
            else if(number[i].getAver()>=60){
                System.out.println(number[i].getName()+"学生的成绩为--C");
            }

            else{
                System.out.println(number[i].getName()+"学生的成绩较差--D，没有合格，请继续努力！");
            }
        }

    }

}