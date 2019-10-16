package Classes;

public class MapItem {
    public int getKey() {
        return key;
    }

    private int key;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public MapItem(int key, String value){
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return key + "->" + value;
    }

    public int myHashCode()
    {
        return key*997;
    }

    public static int getHashCode(int key){
        return key*997;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof MapItem)) return false;
        MapItem other = (MapItem)object;
        return (this.key == other.key && this.value.equals(other.value));
    }
}
