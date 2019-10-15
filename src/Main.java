import Classes.MyArrayList;
import Classes.MyLinkedList;
import Classes.MyTree;

import java.sql.SQLOutput;

public class Main {
    private static void myArrayListExample(){
        System.out.println("MyArrayList Class example");
        MyArrayList arr = new MyArrayList(10);
        arr.setAdvanced_view(true);
        int n = 25;
        System.out.println("init");
        for (int i = 0; i < n; i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        System.out.println("remove 3");
        for (int i = 0; i < 3; i++) {
            arr.remove(0);
        }
        System.out.println(arr);
        arr.trim();
        System.out.println(arr);
        System.out.println("insert 3");
        for (int i = 0; i < 3; i++) {
            arr.insert(i, i);
        }
        System.out.println(arr);
        arr.trim();
        System.out.println(arr);
    }
    private static void myTreeExample(){
        System.out.println("MyTree & TreeItem Classes example");
        MyTree myTree = new MyTree();
        myTree.add(10);
        myTree.add(100);
        myTree.add(1000);
        myTree.add(1010);
        myTree.add(101);
        System.out.println("Добавлено");
        myTree.printTree();
        System.out.println("Поддрево");
        myTree.printTree(101);
        System.out.println("Второе поддрево");
        myTree.printTree(1);
    }
    public static void main(String[] args) {
        //myArrayListExample();
        myTreeExample();
    }
}
