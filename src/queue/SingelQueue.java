package queue;

import java.util.LinkedList;

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
//        HeroNode heroNode2 = new HeroNode(9, "222", "222");
        HeroNode heroNode3 = new HeroNode(6, "333", "333");
        HeroNode heroNode4 = new HeroNode(1, "444", "444");
        SingelLinkedList singelLinkedList = new SingelLinkedList();
        singelLinkedList.addByOrder(heroNode1);
        singelLinkedList.addByOrder(heroNode3);
        singelLinkedList.addByOrder(heroNode4);
        singelLinkedList.delByIndex(4);
        singelLinkedList.list();

        LinkedList linkedList = new LinkedList();
    }
}


class SingelLinkedList {
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 在插入的使用最新的方式：
     * 根据id编号进行排序
     * 1.
     *
     * @param node
     */
    public void add(HeroNode node) {
        // 1. 由于头结点不能动，需要使用
        HeroNode heroNode = head;

        while (true) {
            if (heroNode.getNext() == null) {
                break;
            }
            heroNode = heroNode.getNext();
        }
        heroNode.setNext(node);

    }

    /**
     * 在插入的使用最新的方式：
     * 使用id编号进行排序，在查找的时候使用id进行排序查找
     *
     * @param node
     */
    public void addByOrder(HeroNode node) {
        // 1. 由于头结点不能动，需要使用
        HeroNode heroNode = head;
        boolean flag = false;
        while (true) {
            if (heroNode.getNext() == null) {
                break;
            }
            // 寻找编号大于被插入节点的节点，因为只能找被插入的节点的上一个节点
            if (heroNode.getNext().getNo() > node.getNo()) {
                // 获取原来数据的下一个节点一个节点
                break;
            } else if (heroNode.getNext().getNo() == node.getNo()) {
                //说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            heroNode = heroNode.getNext();
        }

        if (flag) {
            System.err.println("被插入的节点已经存在");
        } else {
            node.setNext(heroNode.getNext());
            heroNode.setNext(node);
        }


    }


    /**
     * 被更新的节点，根据编号匹配找到对应节点
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag){
            temp.setNo(heroNode.getNo());
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        }else{
            System.err.println("没有找到对应的节点");
        }
    }

    /**
     * 删除方式，
     * 第一种方式： 使用编号删除对应的节点
     *
     * @param no 节点编号
     */
    public void del(int no) {
        HeroNode temp = head;
        // 如果是头节点指向节点，需要变更头节点指向节点再删除节点
        if (temp.getNext().getNo() == no) {
            // 指向下一个节点的下一个节点
            head.setNext(head.getNext().getNext());
            return;
        }
        // 判断是否找到了节点
        boolean flag = false;
        while (true) {
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        // 找到节点进行替换
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.err.println("没有找到对应编号的英雄");
        }

    }

    /**
     * 删除的第二张方式‘：
     * 根据index索引进行删除
     *
     * @param index
     */
    public void delByIndex(int index) {
        HeroNode temp = head;
        // 如果是头节点指向节点，需要变更头节点指向节点再删除节点
        if (index == 1) {
            // 指向下一个节点的下一个节点
            head.setNext(head.getNext().getNext());
            return;
        }
        // 判断是否找到了节点
        boolean flag = false;
        int count = 0;
        while (true) {
            if(index > count){
                break;
            }
            if (index == count++) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        // 找到节点进行替换
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.err.println("没有找到对应编号的英雄");
        }

    }

    public void list() {
        HeroNode heroNode = head.getNext();

        while (true) {
            if (heroNode == null) {
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
//                ", next=" + next +
                '}';
    }
}
