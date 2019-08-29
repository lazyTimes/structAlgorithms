package queue;

import javax.annotation.Resource;
import java.util.Stack;

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
//        singelLinkedList.delByIndex(4);
        singelLinkedList.reverse();
//        singelLinkedList.list();
//        System.err.println("count =  " + singelLinkedList.count());
//        System.err.println("倒数" + singelLinkedList.getLastIndexHeroNode(4));

        // 合并两个有序列表
        HeroNode heroNode9 = new HeroNode(19, "aaa", "aaa");
        HeroNode heroNode5 = new HeroNode(5, "bbb", "bbb");
        HeroNode heroNode6 = new HeroNode(23, "ccc", "ccc");
        HeroNode heroNode7 = new HeroNode(66, "ddd", "ddd");
        HeroNode heroNode8 = new HeroNode(3, "eee", "eee");
        SingelLinkedList singelLinkedList2 = new SingelLinkedList();
        SingelLinkedList singelLinkedList3 = new SingelLinkedList();
        singelLinkedList2.add(heroNode9);
        singelLinkedList2.add(heroNode8);
        singelLinkedList2.add(heroNode6);
        singelLinkedList3.add(heroNode5);
        singelLinkedList3.add(heroNode7);
        SingelLinkedList list = SingelLinkedList.mergeList(singelLinkedList2, singelLinkedList3);
        list.list();
        list.reversePrint();


    }
}


class SingelLinkedList {
    /**
     * 头节点，用来存储首节点的位置
     * 不存储数据
     */
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 合并两个链表，合并之后依然有序
     * 1. 计算两个链表的个数
     * 2. 循环总数，判断两个节点的当前节点更大，
     *
     * @param list1
     * @param list2
     * @return
     */
    public static SingelLinkedList mergeList(SingelLinkedList list1, SingelLinkedList list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        SingelLinkedList result = new SingelLinkedList();
        HeroNode next1 = list1.getHead();
        while (true) {
            if (next1 == null) {
                break;
            }
            HeroNode next = next1.getNext();
            SingelLinkedList.addByOrder(result, next1);
            next1 = next;

        }
        HeroNode next2 = list2.getHead().getNext();
        while(true){
            if(next2 == null) {
                break;
            }
            HeroNode next = next2.getNext();
            SingelLinkedList.addByOrder(result, next2);
            next2 = next;

        }
        return result;
    }

    /**
     * 反序打印链表里面的内容
     * 使用的栈结构进行存放数据，然后使用栈进行输出操作
     */
    public void reversePrint() {
        System.err.println();
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            System.err.println("无需反转打印");
            return;
        }
        HeroNode hero = head.getNext();
        Stack<HeroNode> stack = new Stack<>();
        while (hero != null) {
            stack.push(hero);
            hero = hero.getNext();
        }
        while(stack.size()>0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转节点
     * 1. 定义一个反转节点的head
     * 2. 遍历原来的链表，使用类似入栈的方式，将每个节点接入到反转节点的指向节点，被接入节点指向原来的节点
     * 3. 反转节点完成
     */
    public void reverse() {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            System.err.println("无需反转");
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode temp = head.getNext();
        HeroNode next = null;
        while (temp != null) {
            // 让当前节点接到新链表的下一个节点
            next = temp.getNext();
            temp.setNext(reverseHead.getNext());
            reverseHead.setNext(temp);
            temp = next;
        }
        // 使用反转节点替换原来的节点
        head.setNext(reverseHead.getNext());
    }

    /**
     * 获取倒数第index个节点的值
     *
     * @param index
     * @return
     */
    public HeroNode getLastIndexHeroNode(int index) {
        // 1. 获取链表的总个数
        int count = count();
        if (index <= 0 || index > count) {
            return null;
        }
        HeroNode temp = head.getNext();
        // 2. 根据size - index , 循环获取倒数第 index 节点
        int i = 0;
        int size = count - index;
        while (true) {
            if (i == size) {
                break;
            }
            i++;
            temp = temp.getNext();
        }
        // 3. 遍历拿到数据，返回结果
        return temp;
    }

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

    public static void addByOrder(SingelLinkedList singelLinkedList, HeroNode add) {
        if (singelLinkedList == null) {
            return;
        }
        HeroNode listHead = singelLinkedList.getHead();
// 1. 由于头结点不能动，需要使用
//        HeroNode heroNode = mytest;
        boolean flag = false;
        while (true) {
            if (listHead.getNext() == null) {
                break;
            }
            // 寻找编号大于被插入节点的节点，因为只能找被插入的节点的上一个节点
            if (listHead.getNext().getNo() > add.getNo()) {
                // 获取原来数据的下一个节点一个节点
                break;
            } else if (listHead.getNext().getNo() == add.getNo()) {
                //说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            listHead = listHead.getNext();
        }

        if (flag) {
            System.err.println("被插入的节点已经存在");
        } else {
            add.setNext(listHead.getNext());
            listHead.setNext(add);
        }

    }

    /**
     * 在插入的使用最新的方式：
     * 使用id编号进行排序，在查找的时候使用id进行排序查找
     *
     * @param hero
     */
    public void addByOrder(HeroNode hero) {
        HeroNode temp = hero;
        // 1. 由于头结点不能动，需要使用
        HeroNode heroNode = head;
        boolean flag = false;
        while (true) {
            if (heroNode.getNext() == null) {
                break;
            }
            // 寻找编号大于被插入节点的节点，因为只能找被插入的节点的上一个节点
            if (heroNode.getNext().getNo() > temp.getNo()) {
                // 获取原来数据的下一个节点一个节点
                break;
            } else if (heroNode.getNext().getNo() == temp.getNo()) {
                //说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            heroNode = heroNode.getNext();
        }

        if (flag) {
            System.err.println("被插入的节点已经存在");
        } else {
            temp.setNext(heroNode.getNext());
            heroNode.setNext(temp);
        }


    }


    /**
     * 被更新的节点，根据编号匹配找到对应节点
     *
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNo(heroNode.getNo());
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        } else {
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
     * 单链表当中有效节点的个数
     *
     * @return 有效节点的个数
     */
    public int count() {
        HeroNode heroNode = head.getNext();
        int count = 0;
        while (true) {
            if (heroNode == null) {
                break;
            }
            count++;
            heroNode = heroNode.getNext();
        }
        return count;
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
            if (index > count) {
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

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
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
