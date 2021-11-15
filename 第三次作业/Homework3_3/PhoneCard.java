package Homework3_3;

public class PhoneCard {
     private long cardNumber;
     private double initMoney;
     public int time ;

     public PhoneCard(long cardNumber, double initMoney, int time) {
          this.cardNumber = cardNumber;
          this.initMoney = initMoney;
          this.time = time;
     }

     public long getCardNumber() {
          return cardNumber;
     }

     public void setCardNumber(long cardNumber) {
          this.cardNumber = cardNumber;
     }

     public double getInitMoney() {
          return initMoney;
     }

     public void setInitMoney(double initMoney) {
          this.initMoney = initMoney;
     }
     public  void minMoney(){

     }
}
 class ip extends PhoneCard{
      public ip(long cardNumber, double initMoney, int time) {
           super(cardNumber, initMoney, time);
      }
      public  void minMoney(){
           double rest;
           rest = this.getInitMoney() - 0.3*5;
           System.out.println("余额为："+rest);

      }
 }
 class _201 extends PhoneCard {
      public _201(long cardNumber, double initMoney, int time) {
           super(cardNumber, initMoney, time);
      }
      public  void minMoney(){
           double rest;
           rest = this.getInitMoney() - 0.45*5;
           System.out.println("余额为："+rest);

      }
 }