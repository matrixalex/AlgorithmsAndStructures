package Classes;

public class Item {
    private Item next = null;
    private int value;
    public Item getNext() { return next; }
    public int getValue() { return value; }
    public Item(int value){ this.value = value; }
    public Item(int value, Item next){
        this.value = value;
        this.next = next;
    }

    public void setNext(Item newItem) { this.next = newItem; }
}
