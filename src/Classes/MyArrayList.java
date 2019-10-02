package Classes;

public class MyArrayList {
    private final int DEFAULT_CAPACITY = 10;
    private String outOfBoundsMsg = "Index out of bounds";
    private boolean advanced_view = false;
    public int getSize() {
        return size;
    }

    private int size = 0;
    private int[] arr;
    public MyArrayList(){
        arr = new int[DEFAULT_CAPACITY];
    }
    public MyArrayList(int capacity){
        if (capacity < 1) capacity = DEFAULT_CAPACITY;
        arr = new int[capacity];

    }

    public void setAdvanced_view(boolean advanced_view){
        this.advanced_view = advanced_view;
    }

    public int get(int index) {
        if (index < 0 || index >= size){
            System.out.println(outOfBoundsMsg);
            return -Integer.MAX_VALUE;
        }
        return arr[index];
    }

    public void addLast(int value){
        if (size >= arr.length){
            arr = arrayCopy();
        }
        arr[size++] = value;
    }

    public String toString(){

        int l = size - 1;
        if (advanced_view) l = arr.length - 1;
        String result = "MyArrayList object: [";
        for (int i = 0; i < l; i++){
            result += arr[i] + ", ";
        }
        result += arr[l];
        return result + "]";
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println(outOfBoundsMsg);
            return false;
        }

        if (size >= arr.length) {
            arr = arrayCopy();
        }
        for (int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size++;
        return true;
    }

    private int[] arrayCopy(){
        int[] newArr = new int[arr.length*2];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size){
            System.out.println(outOfBoundsMsg);
            return false;
        }
        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return true;
    }

    public void trim() {
        if (arr.length > size){
            int[] newArr = new int[size];
            for (int i = 0; i < size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }

}
