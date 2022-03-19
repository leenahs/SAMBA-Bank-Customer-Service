package queuecustomerservice;

public interface QueueInterface {
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public void push(Object item);
    public Object pop();
    public Object front();
    public Object back();

}
