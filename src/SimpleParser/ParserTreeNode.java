/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SimpleParser;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;



public class ParserTreeNode<T extends Comparable<?>>  {

        public ParserTreeNode   leftTree;
        public ParserTreeNode   rightTree;
        public Object           value;
        public  StringBuilder builder=new StringBuilder();
        public ParserTreeNode(ParserTreeNode l, ParserTreeNode r, Object v)
        {
            leftTree = l;
            rightTree = r;
            value = v;
        }

        public ParserTreeNode(Object l, Object r, Object v)
        {
            leftTree = new ParserTreeNode(l);
            rightTree = new ParserTreeNode(r);
            value = v;
        }

        public ParserTreeNode()
        {
            leftTree = rightTree = null;
            value = null;
        }

        public ParserTreeNode(Object v)
        {
            leftTree = rightTree = null;
            value = v;
        }

        public void printTreePostOrder()
        {
            printTreePostOrder(this);
            System.out.println();
        }

        private void printTreePostOrder(ParserTreeNode tree)
        {
            if (tree == null)
                return;
            //System.out.println(tree.value.toString() + " ");
            //arrayList.add(tree.value);
            printTreePostOrder(tree.leftTree);
            System.out.println(tree.value.toString() + " ");
            printTreePostOrder(tree.rightTree);

        }
        public int size() {
            return(size(this));
        }
        private int size(ParserTreeNode node) {
            if (node == null) return(0);
            else {
                return(size(node.leftTree) + 1 + size(node.rightTree));
            }
        }
        ArrayList<String> data=new ArrayList<>();

        public void printTree() {
            LinkedBlockingQueue<ParserTreeNode> q = new LinkedBlockingQueue<>();
            q.add(this);
            while (true) {
                LinkedBlockingQueue<ParserTreeNode> subQueue = new LinkedBlockingQueue<>();
                while (!q.isEmpty()) {
                    ParserTreeNode aTree = q.remove();


                    System.out.print(aTree.value + ", ");


                    if (aTree.leftTree != null) {
                        subQueue.add(aTree.leftTree);
                    }
                    if (aTree.rightTree != null) {
                        subQueue.add(aTree.rightTree);
                    }
                }
                System.out.println("");
                if (subQueue.isEmpty()) {
                    return;
                } else {
                    q = subQueue;
                }
            }
        }
    public  <T extends Comparable<?>> void printNode(ParserTreeNode<T> root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private  <T extends Comparable<?>> void printNodeInternal(List<ParserTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<ParserTreeNode<T>> newNodes = new ArrayList<ParserTreeNode<T>>();
        for (ParserTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                builder.append(node.value);
                newNodes.add(node.leftTree);
                newNodes.add(node.rightTree);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
                builder.append(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");
        builder.append(System.lineSeparator());

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftTree != null){
                    System.out.print("/");
                    builder.append("/");
                }
                else
                    printWhitespaces(1);

                  printWhitespaces(i + i - 1);

                if (nodes.get(j).rightTree != null) {
                    System.out.print("\\");
                    builder.append("\\");
                }
                else
                printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
            builder.append(System.lineSeparator());
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private  void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
            builder.append(" ");
        }
    }

    private  <T extends Comparable<?>> int maxLevel(ParserTreeNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.leftTree), maxLevel(node.rightTree)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public boolean isValueDouble()
        {
            String s = value.toString();
            for (int i = 0; i < s.length(); i++)
                if ( !( (s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.') )
                    return false;
            return true;
        }
}
