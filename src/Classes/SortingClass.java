package Classes;

import java.util.Arrays;
import java.util.Random;

public class SortingClass {
    private int[] array;
    private int length;
    public void bubbleSort(){
        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
    }

    public SortingClass(){
        length = 100;
        array = new int[length];
        generate();
    }
    public SortingClass(int length){
        this.length = length;
        array = new int[length];
        generate();
    }
    public void generate(){
        Random r = new Random();
        for (int i=0; i<array.length;i++){
            array[i] = r.nextInt(500);
        }
    }
    public String toString(){
        return Arrays.toString(array);
    }
}
