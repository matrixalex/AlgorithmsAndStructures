package Classes;

public class MyHashMap {
    private MyMap[] box;
    private int countOfBoxes = 3;
    public MyHashMap(int countOfBoxes){
        this.countOfBoxes = countOfBoxes;
        box = new MyMap[countOfBoxes];
        for (int i = 0; i < countOfBoxes; i++) box[i] = new MyMap();
    }
    public MyHashMap(){
        box = new MyMap[countOfBoxes];
        for (int i = 0; i < countOfBoxes; i++) box[i] = new MyMap();
    }

    public void add(MapItem item){
        int hash = item.myHashCode();
        box[hash % countOfBoxes].add(item);
    }

    @Override
    public String toString(){
        String result = "{\n";
        for (MyMap map: box){
            if (!map.isEmpty()) result += map + ",\n";
        }
        result += "}";
        return result;
    }
    private int getIndex(MapItem item){
        return item.myHashCode() % countOfBoxes;
    }
    private int getIndex(int key){
        return MapItem.getHashCode(key) % countOfBoxes;
    }
    public boolean contains(MapItem item){
        return box[getIndex(item)].contains(item);
    }

    public MapItem get(int key){
        return box[getIndex(key)].get(key);
    }
}
