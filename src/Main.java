import Classes.*;

import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {
    /*
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
    private static void sortExample(){
        SortingClass sorter = new SortingClass(200);
        System.out.println(sorter);
        sorter.bubbleSort();
        System.out.println(sorter);
    }
    public static void main(String[] args) {
        sortExample();
    }
    */
    private static void insertSortExample(int[] a){
        for (int i = 1; i < a.length; i++){
            int j = i;
            while (j > 0 && a[j - 1] > a[j]){
                int temp = a[j - 1];
                a[j-1] = a[j];
                a[j] = temp;
                j--;
            }
        }
        //System.out.println(Arrays.toString(a));
    }
    private static int[] merge_sort(int[] a){
        if (a.length <= 1) return a;
        int middle = a.length / 2;
        int[] left = new int[middle]; //4
        int[] right = new int[a.length - middle]; //5
        for (int i = 0; i < middle; i++){
            left[i] = a[i];
        }
        int j = 0;
        for (int i = middle; i < a.length; i++){
            right[j] = a[i];
            j++;
        }
        int[] new_left = merge_sort(left);
        int[] new_right = merge_sort(right);
        int[] result = merge(new_left, new_right);
        return result;
    }
    private static int[] merge(int[] a1, int[] a2){
        int[] result = new int[a1.length + a2.length];
        int i1 = 0, i2 = 0, j=0;
        while (i1 < a1.length && i2 < a2.length){
            if (a1[i1] <= a2[i2]){
                result[j] = a1[i1];
                i1++;
            } else {
                result[j] = a2[i2];
                i2++;
            }
            j++;
        }
        for (int i = i1; i < a1.length; i++){
            result[j] = a1[i];
            j++;
        }
        for (int i = i2; i < a2.length; i++){
            result[j] = a2[i];
            j++;
        }
        return result;
    }
    private static void choiseSortExample(int[] a){
        for (int i = 0; i < a.length - 1; i++){ // 0..6 (n-1) + (n-2) + (n-3) + ... + 2 + 1 ~ n*(n-1)/2
            int min_index = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < a[min_index]){
                    min_index = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }
        //System.out.println(Arrays.toString(a));
    }

    private static void piramid_sort(int[] a, int heapSize){
        for (int i = heapSize / 2; i >= 0; i--){
            checkIndex(a, i, heapSize);
        }
    }

    private static void swap(int[] a, int i1, int i2){
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
    public static void heapSort(int[] array) {
        int heapSize = array.length;
        System.out.println(heapSize);
        piramid_sort(array, array.length);
        int k = 0;
        while (heapSize > 0){
            swap(array, 0, heapSize - 1);
            heapSize--;
            checkIndex(array, 0, heapSize);
            k++;
        }
        System.out.println(k);
    }
    private static void checkIndex(int[] a, int index, int heapSize){
        int l_index = index * 2 + 1;
        int r_index = (index + 1) * 2;
        int large_index = index;
        if (l_index < heapSize && a[index] < a[l_index]) {large_index = l_index;}
        if (r_index < heapSize && a[large_index] < a[r_index]) {large_index = r_index;}
        if (index != large_index){
            swap(a,index, large_index);
            checkIndex(a, large_index, heapSize);
        }

    }
    private static int[] generate(int n){
        Random r = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = r.nextInt(50000);
        }
        return result;
    }
    private static void sortExamples(){
        int n = 1000000;
        long start, end;
        int[] original = generate(n);
        System.out.println(Arrays.toString(Arrays.copyOf(original,50)));

        int[] a = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        insertSortExample(a);
        end = System.currentTimeMillis();
        System.out.println("insertSortExample time: " + (end - start));
        System.out.println(Arrays.toString(Arrays.copyOf(a,50)));

        a = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        choiseSortExample(a);
        end = System.currentTimeMillis();
        System.out.println("choiseSortExample time: " + (end - start));
        System.out.println(Arrays.toString(Arrays.copyOf(a,50)));

        a = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        a = merge_sort(a);
        end = System.currentTimeMillis();
        System.out.println("merge_sort time: " + (end - start));
        System.out.println(Arrays.toString(Arrays.copyOf(a,50)));

        a = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        heapSort(a);
        end = System.currentTimeMillis();
        System.out.println("piramid_sort time: " + (end - start));
        System.out.println(Arrays.toString(Arrays.copyOf(a,50)));
    }
    public static void main(String[] args) {

    }


}
