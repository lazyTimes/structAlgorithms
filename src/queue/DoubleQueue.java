package queue;

/**
 * 双向链表
 * 1. 遍历方和单链表一样只是可以朝前，可以向后
 * 2. 添加
 * 1. 默认添加到双向链表的最后
 * 2. 先找到双向链表的最后这个节点
 * 3. temp.next = new heronode
 * 4. newheronode.pre = temp
 * 3. 删除
 * 1. 因为是双向的，可以自我删除
 * 2. 找到要删除的这个节点，temp
 * 3. temp.next.pre = temp.pre
 * 4. temp.pre.next = temp.next
 * 4. 修改
 * 1. 不需要太大变动，和原来的链表类似
 *
 * @author zhaoxudong
 * @title: DoubleQueue
 * @projectName structAlgorithms
 * @description: 双向链表
 * @date 2019/8/29 15:00
 */
public class DoubleQueue {
    public static void main(String[] args) {
        DoubleQueueList doubleQueueList = new DoubleQueueList();
        doubleQueueList.add(new DoubleHeroNode(5, "", ""));
        doubleQueueList.add(new DoubleHeroNode(6, "", ""));
        doubleQueueList.add(new DoubleHeroNode(1, "", ""));
        doubleQueueList.del(1);
        doubleQueueList.del(5);
        doubleQueueList.list();

    }


}

/**
 * 双向链表
 */
class DoubleQueueList {
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    /**
     * 删除方式，
     *   1. 因为是双向的，可以自我删除
     *   2. 找到要删除的这个节点，temp
     *   3. temp.next.pre = temp.pre
     *   4. temp.pre.next = temp.next
     *
     * @param no 节点编号
     */
    public void del(int no) {
        DoubleHeroNode temp = head;
        if(head.getNext() == null){
            System.err.println("空链表");
            return;
        }
        boolean flag = false;
        // 查找节点
        while(true){
            if(temp.getNo() == no){
                flag = true;
                break;
            }
            if(temp.getNext() == null){

                break;
            }
            temp = temp.getNext();
        }

        if(flag){
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if(temp.getNext() != null){

                temp.getNext().setPrev(temp.getPrev());
            }
            temp.getPrev().setNext(temp.getNext());
            temp = null;
        }else{
            System.err.println("没有找到相应的节点");
        }



    }

    /**
     * 更新节点
     * @param heroNode
     */
    public void update(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = head;
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
     * 双链表的个数
     *
     * @return 有效节点的个数
     */
    public int count() {
        DoubleHeroNode heroNode = head.getNext();
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
     * 双向链表的添加
     * 无需改动太大，只需要加入新插入节点的上一个节点为当前遍历的节点
     * @param add
     */
    public void add(DoubleHeroNode add) {
        DoubleHeroNode heroNode = head;

        while (true) {
            if (heroNode.getNext() == null) {
                break;
            }
            heroNode = heroNode.getNext();
        }
        heroNode.setNext(add);
        add.setPrev(heroNode);
    }

    /**
     * 展示链表
     */
    public void list() {
        DoubleHeroNode heroNode = head.getNext();

        while (true) {
            if (heroNode == null) {
                break;
            }
            System.err.println(heroNode);
            heroNode = heroNode.getNext();
        }

    }


    public DoubleHeroNode getHead() {
        return head;
    }

    public void setHead(DoubleHeroNode head) {
        this.head = head;
    }
}


/**
 * 构造函数的节点
 */
class DoubleHeroNode {
    private int no;
    private String name;
    private String nickName;
    private DoubleHeroNode next;
    private DoubleHeroNode prev;

    public DoubleHeroNode(int no, String name, String nickName) {
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


    public DoubleHeroNode getNext() {
        return next;
    }

    public void setNext(DoubleHeroNode next) {
        this.next = next;
    }

    public DoubleHeroNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleHeroNode prev) {
        this.prev = prev;
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