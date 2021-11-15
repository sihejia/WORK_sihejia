package homework3_1;

public class homework3_1 {
    public  static void main(String[] args){





    }
}

//父类people的属性以及共有的方法
class People {
    String name;
    int age;
    double high;
    double weight;


    public void breath(){
        System.out.println("我可以呼吸");
    }

    public void run(){
        System.out.println("我可以跑步");
    }

}

//子类teacher特有的属性和方法
class Teacher extends People {
    public Teacher(double salary){
        setSalary(salary);
    }
    Teacher(){
    }
    double salary;
    public void skill(){
        System.out.println("skill是教书育人");
    }
    private void setSalary(double salary){
        this.salary = salary;
    }
    private double getSalary(){
        return salary;
    }


}

//子类student特有的属性以及方法
class Student extends People {

}