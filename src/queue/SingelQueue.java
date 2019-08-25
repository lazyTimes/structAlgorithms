package queue;

/**
 * 单链表实现
 *
 * @author zhaoxudong
 * @title: SpareceArray
 * @projectName structAlgorithms
 * @description: 单链表实现
 * @date 2019/8/19 14:54
 */
public class SingelQueue {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(0, "111", "111");
        HeroNode heroNode2 = new HeroNode(0, "222", "222");
        HeroNode heroNode3 = new HeroNode(0, "333", "333");
        HeroNode heroNode4 = new HeroNode(0, "444", "444");
        SingelLinkedList singelLinkedList = new SingelLinkedList();
        singelLinkedList.add(heroNode1);
        singelLinkedList.add(heroNode2);
        singelLinkedList.add(heroNode3);
        singelLinkedList.add(heroNode4);
        singelLinkedList.list();


    }
}


class SingelLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode node) {
        // 1. 由于头结点不能动，需要使用
        HeroNode heroNode = head;

        while (true) {
            if(heroNode.getNext() == null){
                break;
            }
            heroNode = heroNode.getNext();
        }
        heroNode.setNext(node);

    }

    public void list(){
        HeroNode heroNode = head;

        while (true) {
            if(heroNode.getNext() == null){
                break;
            }
            System.err.println(heroNode);
            heroNode = heroNode.getNext();
        }

    }
}


/**
 * 构造函数的节点
 */
class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    /**
     * 初始化构造函数
     *
     * @param no
     * @param name
     * @param nickName
     */
    public HeroNode(int no, String name, String nickName) {
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}
