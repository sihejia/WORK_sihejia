package Homework06;

/**
 * @author 司贺嘉
 * @date 2021.12.6
 */
@SuppressWarnings({"all"})
public class homework6 {
    public static void main(String[] args) {
        Node no1 = new Node(1, "李白");
        Node no2 = new Node(2, "杜甫");
        Node no3 = new Node(3, "苏轼");
        Node no4 = new Node(4, "王维");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(no1);
        singleLinkedList.add(no2);
        singleLinkedList.add(no3);
        singleLinkedList.add(no4);
        System.out.println("============第一次遍历===========");
        singleLinkedList.list();
        System.out.println("============删除===========");
        singleLinkedList.del(2);
        System.out.println("============删除后遍历===========");
        singleLinkedList.list();
        System.out.println("=============查找序号为3的节点=================");
        singleLinkedList.findNode(3);
        System.out.println("============查找序号错误的节点============");
        singleLinkedList.findNode(5);
        System.out.println("===============销毁链表=============");
        singleLinkedList.destroy();
        singleLinkedList.list();


    }
}
@SuppressWarnings({"all"})
class SingleLinkedList {
    private Node first;
    private int size;

    public SingleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void add(Node newNode) {
        if (first == null) {
            first = newNode;
            size++;
        } else {
            Node temp = first;
            while (temp.next != null) {
                size++;
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void del(int no) {
        Node temp = first;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("所删除节点是" + temp.next);
            temp.next = temp.next.next;

        } else {
            System.out.println("找不到所要删除的节点");
        }

    }

    public void findNode(int no) {
        Node temp = first;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("查找到的数据为：" + temp);
        } else {
            System.out.println("未能查找到到该数据");
        }
    }

    public void list(){
        if(first==null){
            System.out.println("链表为空");
        }
        Node temp = first;
        boolean flag = false;
        do {
            System.out.println(temp);
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }while (true);
    }
    public void destroy(){
       first = null;
    }
}
@SuppressWarnings({"all"})
class Node{
    public int no;
    public Node next;
    public Object data;

    public Node() {
    }

    public Node(int no,Object data) {
        this.no = no;
        this.next = null;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                "  data=" + data +
                '}';
    }
}