import Classes.*;

import java.util.HashMap;

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
        myTree.add(1);
        myTree.add(10);
        myTree.add(101);
        myTree.add(11);
        myTree.add(111);
        myTree.add(12);
        System.out.println(myTree.findInt(11));
    }
    private static void myMapExample(){
        MyHashMap map = new MyHashMap(5);
        for (int i = 0; i < 25; i++){
            map.add(new MapItem(i, "Item_" + i));
        }
        System.out.println(map);
        System.out.println(map.contains(new MapItem(20, "Item_" + 20)));
        System.out.println(map.contains(new MapItem(20, "Item_" + 255)));
        System.out.println(map.get(20));
        System.out.println(map.get(Integer.MAX_VALUE));
    }
    public static void main(String[] args) {
        //myArrayListExample();
        //myTreeExample();
        myMapExample();
    }
}
