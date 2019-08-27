package array;

/**
 * 使用数组实现队列
 *
 * @author zhaoxudong
 * @title: MyQueue
 * @projectName structAlgorithms
 * @description: 使用数组实现队列
 * @date 2019/8/23 15:27
 */
public class MyQueue {

    /**
     * 队尾指针
     */
    private int rear;
    /**
     * 队头指针
     */
    private int front;
    /**
     * 最大数
     */
    private int maxSize;
    /**
     * 队列
     */
    private int[] arr;

    public MyQueue(int size) {
        if (size <= 0) {
            System.err.println("队列不能小于或者等于 0");
            return;
        }
        // 注意此处为什么是-1 ：因为队列的头部不应该执行队伍的第一个元素，因为此时是出于队列的头部，并没有数据
        rear = front = 0;
        this.arr = new int[size];
        this.maxSize = size;
    }


    /**
     * 出队操作：
     * 1. 队伍头部的元素删除即，使 return arr[front]
     * 2. 将队伍后面的元素向前拷贝
     */
    public int removeQueue() {
        if (isEmpty()) {
            System.err.println("队列为空，不能移除");
            return -1;
        }
//        for (int i = 1; i < rear; i++) {
//            arr[i - 1] = arr[i];
//        }
//        arr[--rear] = 0;

        return arr[++front];
    }

    /**
     * 队尾+1 入队操作
     * 需要判断队列是否为空并且是否不满
     *
     * @param val
     */
    public void addQueue(int val) {
        // 判断是否为空或者是否已经满了
        boolean empty = isFull();
        if (empty) {
            System.err.println("队列已满，无法添加");
            return;
        }
        arr[rear] = val;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 判断队列是否可以加入数据
     *
     * @return
     */
    private boolean isFull() {
//        return rear != maxSize - 1;
        // 这是最新的一种判定方式： rear =
        return (rear  + 1) % maxSize == front;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    public void showQueue(){
        if(arr == null || arr.length == 0){
            System.err.println("队列为空，不能遍历");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.err.print(arr[i % maxSize] + "\t");

        }
//        System.err.println(Arrays.toString(this.arr));
    }


    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(8);
        myQueue.addQueue(2);
        myQueue.addQueue(55);
        myQueue.addQueue(35);
        myQueue.addQueue(25);
        myQueue.addQueue(65);
        myQueue.addQueue(85);
        myQueue.addQueue(75);
//        myQueue.addQueue(6);
        myQueue.removeQueue();
        myQueue.removeQueue();
        myQueue.removeQueue();
        // 这里出现问题，因为队头和队尾都指向队列的尾部，会出现无法添加和无法删除掉问题
//        myQueue.addQueue(6);
//        myQueue.removeQueue();

        myQueue.showQueue();
    }
}
