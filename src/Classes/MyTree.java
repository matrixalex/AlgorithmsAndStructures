package Classes;

public class MyTree {
    private TreeItem root;
    public MyTree(){ root = new TreeItem(-1); }

    public void add(int value){ add(root, value + ""); }

    private void add(TreeItem item, String number){
        //Useless check?
        if (number.length() == 0) {
            System.out.println("Пустая строка");
            return;
        }

        //Recursive base
        if (number.length() == 1){
            int num = Integer.parseInt(number);
            TreeItem[] connections = item.getConnections();
            if (connections[num] == null) connections[num] = new TreeItem(num);
            connections[num].setEnd(true);
            return;
        }

        //Recursive step
        int num = number.charAt(0) - '0';
        TreeItem[] connections = item.getConnections();
        if (connections[num] == null) connections[num] = new TreeItem(num);
        add(connections[num], number.substring(1));
    }

    public void printTree(){
        TreeItem[] connections = root.getConnections();
        for (int i = 0; i < connections.length; i++)
            if (connections[i] != null) printTree(connections[i], "");
    }

    private void printTree(TreeItem item, String number){
        number += item; //toString() method Override
        if (item.isEnd()) System.out.println(number);
        TreeItem[] connections = item.getConnections();
        for (int i = 0; i < connections.length; i++)
            if (connections[i] != null) printTree(connections[i], number);
    }
}
