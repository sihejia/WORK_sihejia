package Homework08;

import java.util.EmptyStackException;

public class Homework08 {
    public static void main(String[] args) {
        //测试顺序栈的方法
        MyArrayStack myArrayStack = new MyArrayStack(10);
        myArrayStack.push("小明");
        myArrayStack.push(10);
        myArrayStack.findTop();
        myArrayStack.push('s');
        myArrayStack.findTop();
        System.out.println(myArrayStack.pop());
        myArrayStack.findTop();
        System.out.println(myArrayStack.isEmpty());
        myArrayStack.clear();
        //myArrayStack.findTop();
        //侧式链实现栈的方法
        MyLinkStack myLinkStack = new MyLinkStack();
        myLinkStack.push("张伟");
        myLinkStack.push(666);
        myLinkStack.push('A');
        System.out.println(myLinkStack.findTop());
        myLinkStack.pop();
        System.out.println(myLinkStack.findTop());
        myLinkStack.clear();
        System.out.println(myLinkStack.isEmpty());
        myLinkStack.pop();

    }
}
class MyArrayStack{
    private int size;//栈的大小
    private int top;//栈顶元素下标
    private Object[] stackArray;
    public MyArrayStack(int size){
        stackArray = new Object[size];
        top = -1;//栈顶下标设为-1
        this.size = size;
    }
    //入栈，栈顶下表+1
    public void push(Object item){
        stackArray[++top] = item;
        size++;
    }
    //出栈，删除栈顶元素，栈顶下表——1
    public Object pop(){
        if(top==-1){
            throw new EmptyStackException();
        }
        size--;
        return stackArray[top--];
    }
    //查看栈顶元素
    public void findTop(){
        if(top==-1){
            throw new EmptyStackException();
        }
        System.out.println("top="+stackArray[top]);
    }
    //判断是否为空
    public boolean isEmpty(){
        return (top==-1);
    }
    public void clear(){
        for(int i=0;i<size;size++){
            stackArray[i] = null;
        }
        size=0;
        top=-1;
    }

}
class MyLinkStack{
    link head = null;//栈顶

    public MyLinkStack() {
        head = new link(null);
    }

    //入栈
    public void push(Object data){
        if(head.data==null) {
            head.data = data;
        }else {
            link node = new link(data);
            node.next=head;
            head = node;
        }
    }
    //出栈，栈顶元素下移
    public void pop(){
        if(head.data==null){
            System.out.println("没有栈元素");
        } else{
            head.show();
            head=head.next;
        }
    }
    //查找栈顶元素
    public Object findTop(){
        if(head.data==null){
            System.out.println("没有栈顶元素");
            return 0;
        }else {
            return head.data;
        }
    }
    //判断是否为空
    public boolean isEmpty(){
        return (head.data==null);
    }
    public void clear(){
        head.data=null;
    }
}
//创建一个链表
class link{
    public Object data;//链表储存的数据
    public link next;
    public void show(){
        System.out.println("出栈元素"+data);
    }
    public link(Object data){
        this.data = data;
    }

    public link() {
    }
}