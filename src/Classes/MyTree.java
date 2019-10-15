package Classes;

import com.sun.source.tree.Tree;

public class MyTree {
    private TreeItem root;
    public MyTree(){ root = new TreeItem(-1); }

    public void add(int value){ add(root, value + ""); }

    private void add(TreeItem item, String number){
        //Recursive base
        if ("".equals(number)) {
            item.setEnd(true);
            return;
        }
        int num = number.charAt(0) - 48;
        String result = number.substring(1);
        TreeItem[] connections = item.getConnections();
        if(connections[num] == null){
            TreeItem newItem = new TreeItem(num);
            connections[num] = newItem;
            add(newItem, result);
        } else {
            add(connections[num], result);
        }
    }

    public void printTree(){
        TreeItem[] connections = root.getConnections();
        for (int i = 0; i < connections.length; i++)
            if (connections[i] != null) printTree(connections[i], "");
    }

    public void printTree(int startValue){
        String startString = startValue + "";
        int index = startString.charAt(0) - '0';
        TreeItem connection = root.getConnections()[index];
        if (connection == null) return;
        if (startString.length() == 1) { printTree(connection, ""); return;}
        printSubTree(connection, 1, startString);
    }

    private void printTree(TreeItem item, String number){
        number += item; //toString() method Override
        if (item.isEnd()) System.out.println(number);
        TreeItem[] connections = item.getConnections();
        for (int i = 0; i < connections.length; i++)
            if (connections[i] != null) printTree(connections[i], number);
    }

    public boolean findInt(int value){
        String number = value + "";
        TreeItem[] connections = root.getConnections();
        if (connections[number.charAt(0)-'0'] == null) return false;
        return findInt(connections[number.charAt(0)-'0'], number.substring(1));
    }

    private boolean findInt(TreeItem root, String number){
        if ("".equals(number) && root.isEnd()) return true;
        if ("".equals(number)) return false;
        TreeItem[] connections = root.getConnections();
        if (connections[number.charAt(0)-'0'] == null) return false;
        return findInt(connections[number.charAt(0)-'0'], number.substring(1));
    }

    public void deleteInt(int value){
        String number = value + "";
        TreeItem[] connections = root.getConnections();
        int index = number.charAt(0) - '0';
        if (connections[index] == null) return;
        if (number.length() == 1) {
            connections[index].setEnd(false);
            if (isEndOfBranch(connections[index])) connections[index] = null;
            return;
        }
        deleteInt(connections[index], number.substring(1));
    }



    public void deleteInt(TreeItem item, String number){
        TreeItem[] connections = item.getConnections();
        int index = number.charAt(0) - '0';
        if (connections[index] == null) return;
        if (number.length() == 1) {
            connections[index].setEnd(false);
            if (isEndOfBranch(connections[index])) connections[index] = null;
            return;
        }
        deleteInt(connections[index], number.substring(1));
    }

    private boolean isEndOfBranch(TreeItem item){
        boolean result = true;
        for (TreeItem connection: item.getConnections())
            if (connection != null) {
                result = false;
                break;
            }
        return result;
    }

    private void printSubTree(TreeItem item, int ind, String startString){
        int num = startString.charAt(ind) - '0';
        TreeItem connection = item.getConnections()[num];
        if (ind == startString.length() - 1){
            if (connection != null) printTree(connection, startString.substring(0, startString.length()-1));
            return;
        }
        if (connection == null) return;
        printSubTree(connection, ++ind, startString);
    }
}
