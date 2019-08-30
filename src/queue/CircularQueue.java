package queue;

/**
 * 环形链表
 * 构建一个环形链表的思路
 * 1. 先创建一个节点，first 指向改节点， 并且形成环形
 * 2. 后面当我们每创建一个新的节点，就把该节点，加入到已有的环形链表当中即可
 * <p>
 * 遍历环形链表
 * 1. 先让一个辅助指针 curBoy ， 指向first
 * 2. 通过while循环，遍历环形链表，当curBoy.next  == first 结束
 *
 * @author zhaoxudong
 * @title: CircularQueue
 * @projectName structAlgorithms
 * @description: 环形链表
 * @date 2019/8/29 16:30
 */
public class CircularQueue {

    public static void main(String[] args) {
        CircularQueueList circularQueueList = new CircularQueueList();
        circularQueueList.add(6);
//        circularQueueList.add(new CircularNode(1, "aaa", "aaa"));
//        circularQueueList.add(new CircularNode(2, "222", "222"));
//        circularQueueList.add(new CircularNode(3, "ccc", "ccc"));
//        circularQueueList.add(new CircularNode(4, "444", "444"));
        circularQueueList.list();
    }

}

class CircularQueueList {
    /**
     * 头指针
     */
    private CircularNode first = new CircularNode(0, "", "");

    /**
     * 环形链表如何添加
     * @param node
     */
    public void add(CircularNode node){
        CircularNode firstNext = first;
        while(true){
            if(firstNext.getNext() == null){
                break;
            }
            firstNext = firstNext.getNext();
        }
        // 单项链表的插入节点思路，但是最后一个节点需要特殊处理
        firstNext.setNext(node);
        firstNext.getNext().setNext(first.getNext());
    }

    /**
     * 环形链表的添加和原来的添加代码有所不同
     * @param size
     */
    public void add(int size){
        if(size < 1){
            System.out.println("size的值不正确");
            return;
        }

        CircularNode cur = null;
        for (int i = 1; i <= size; i++) {
            CircularNode newcur = new CircularNode(i, "小孩"+i, "小孩昵称"+i);
            // 如果是第一个节点，则需要特殊处理
            if(i == 1){
                // 第一个节点复制给first节点
                first = newcur;
                first.setNext(first);
                // 将当前操作指针指向第一个节点
                cur = first;
            }else{
                cur.setNext(newcur);
                newcur.setNext(first);
                cur = newcur;
            }
        }

    }

    /**
     * 遍历节点
     */
    public void list(){
        if(first == null){
            System.err.println("循环链表为空");
            return;
        }
        CircularNode circularQueue = first;
        while(circularQueue.getNext() != first){
            System.err.println(circularQueue);
            circularQueue = circularQueue.getNext();
        }
    }


    public CircularNode getFirst() {
        return first;
    }

    public void setFirst(CircularNode first) {
        this.first = first;
    }
}

/**
 * 环形链表的节点
 */
class CircularNode {
    /**
     * 编号
     */
    private int no;
    /**
     * 名词
     */
    private String name;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 下一个节点
     */
    private CircularNode next;

    /**
     * 构造函数
     *
     * @param no
     * @param name
     * @param nickName
     */
    public CircularNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public CircularNode getNext() {
        return next;
    }

    public void setNext(CircularNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircularNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
