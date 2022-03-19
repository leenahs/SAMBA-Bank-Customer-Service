package queuecustomerservice;

public class Main {
    public void line(){
        QueueInterface c = new Queue();

        int time_start=0, time_finish=4;

        for(int i=1;i<=59;i++){
            time_start = time_start +4;
            if(time_start<60){
                c.push("#"+i);
                System.out.println("a new customer #"+i+" has arrived after "+time_start+" minutes.");
            }
        }
        System.out.println("\nthere are total "+c.size()+" customer(s) in the queue.");
        System.out.println("------------------------------------");
        for(int j=0;j<60;j++){
            time_finish=time_finish+7;
            if(time_finish<60){
                System.out.println("customer "+c.pop()+" has been served after "+time_finish+" minutes.");
            }
        }
        System.out.println("\nthere are "+c.size()+" customer(s) left in the queue.");
        System.out.println("the current customer is "+c.front());
    }
    public static void main(String[] args) {
        Main l = new Main();

        System.out.println("Information about the customer service queue after 60 minutes...");
        l.line();
    }
}

class Queue implements QueueInterface{
    private static int defaultCapacity = 100;
    private Object queue[];
    private int rear, front;

    public Queue() {
        this(defaultCapacity);
    }
    public Queue(int capacity) {
        if (capacity < 2) {
            throw new IllegalArgumentException("Capacity must be less than 2.");
        }
        queue = new Object[capacity + 1];
        rear = front = 0;
    }
    @Override
    public int size() {
        if (rear >= front) {
            return (rear - front);
        } else {
            return (rear - front + queue.length);
        }
    }
    @Override
    public boolean isEmpty() {
        return (rear == front);
    }
    @Override
    public boolean isFull() {
        return (size() == queue.length - 1);
    }
    @Override
    public void push(Object item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
    }
    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object frontItem = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        return frontItem;
    }
    @Override
    public Object front() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return queue[front];
    }
    @Override
    public Object back() {
        return (queue[rear - 1]);
    }
}

