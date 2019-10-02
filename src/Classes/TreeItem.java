package Classes;

public class TreeItem {
    private int value;
    private TreeItem[] connections;
    private boolean isEnd = false;

    public TreeItem(int value){
        this.value = value % 10;
        connections = new TreeItem[10];
    }

    public TreeItem(){
        value = -1;
    }
    public void setEnd(boolean end) { isEnd = end; }
    public TreeItem[] getConnections() { return connections; }



    public boolean isEnd() { return isEnd; }
    public String toString(){
        return "" + value;
    }
}
