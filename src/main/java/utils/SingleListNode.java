package utils;

public class SingleListNode implements Cloneable {

    private int val;
    private SingleListNode next;

    public SingleListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

    @Override
    public SingleListNode clone() throws CloneNotSupportedException{
        return (SingleListNode) super.clone();
    }
}
