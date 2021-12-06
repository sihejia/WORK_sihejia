package B;

public class exer {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        System.out.println("输入"+node1.val+node2.val+node3.val);
        Node.reversePrint(node1);
    }
}
class Node{
    public Node next;
    public int val;

    public Node(int val) {
        this.next = null;
        this.val = val;
    }
    public static void reversePrint(Node head){
        Node cur = head;
        if(cur==null){
            System.out.println("为空");
        }
        int count = 0;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        int[] result = new int[count];
        for(int i=count-1;i>=0;i--){
            result[i] = head.val;
            head = head.next;
        }
        System.out.println("输出");
        for (int i = 0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}