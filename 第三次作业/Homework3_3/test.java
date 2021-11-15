package Homework3_3;

public class test {
    public static void main(String[] args){
        //利用多态，向上转型
      PhoneCard card01 = new ip(888666,30,5);
      PhoneCard card02 = new _201(999888,30,5);
      //调用父类中具有的minMoney方法
      card01.minMoney();
      card02.minMoney();
    }
}
