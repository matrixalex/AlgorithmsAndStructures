package Classes;

public class MyLinkedList {


    private Item head;
    private Item current;

    public MyLinkedList(){

    }
    public MyLinkedList(int value){
        head = new Item(value);
        current = head;
    }

    public void addFirst(int value){
        head = new Item(value, head);
        current = head;
    }

    public boolean hasNext(){
        return current.getNext() != null;
    }

    public boolean itemExists(){
        return current != null;
    }

    public void getNext(){
        current = current.getNext();
    }

    public Item peek(){
        return current;
    }

    public void addLast(int value){
        Item temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        Item newItem = new Item(value, null);
        temp.setNext(newItem);
    }
    public int size(){
        Item temp = head;
        int size = 0;
        while(temp.getNext() != null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }
    public void insertValue(int index, int value){
        current = head;
        if (index >= size()){
            System.out.println("index " + index + " out of range " + size());
            return;
        }
        int currentIndex = 0;
        Item past = current;
        while(currentIndex < index){
            past = current;
            current = current.getNext(); //current
            currentIndex++;
        }
        Item newItem = new Item(value);
        newItem.setNext(current);
        past.setNext(newItem);
        current = head;

    }
    public void reset(){
        current = head;
    }
    public String toString(){
        String result = "MyLinkedList object: [";
        reset();
        while (current.getNext() != null){
            result += current.getValue() + ", ";
            current = current.getNext();

        }
        result += current.getValue() + "]";
        return result;
    }
}
