package Classes;

import java.util.ArrayList;

public class MyMap {
    private ArrayList<MapItem> map;
    public MyMap(){
        map = new ArrayList<MapItem>();
    }

    public boolean isEmpty(){
        return map.size() == 0;
    }

    public boolean add(MapItem item){
        boolean flag = false;
        for (MapItem it: map){
            if (it.getKey() == item.getKey()) {
                it.setValue(item.getValue());
                flag = true;
                break;
            }
        }
        if (!flag) map.add(item);
        return true;
    }

    public String toString(){
        if (map.size() == 0) return "[]";
        String result = "[";
        for (int i = 0; i < map.size() - 1; i++){
            result += map.get(i) + ", ";
        }
        result += map.get(map.size() - 1) + "]";
        return result;
    }

    public boolean contains(MapItem item){
        for (MapItem it: map)
            if (it.equals(item)) return true;
        return false;
    }

    public MapItem get(int key){
        for (MapItem item: map)
            if (item.getKey() == key) return item;
        return null;
    }
}
