package DataStructure;


import java.util.ArrayList;

public class TreeClass {
    public static void main(String[] args) {
        Tree a = new Tree(10);
        a.insert(6);
        a.insert(20);
        a.insert(3);
        a.insert(9);
        a.insert(18);
        a.insert(7);
        printTree(a.root);
        sumTree(a.root);
        System.out.println();
        printTree(a.root);
        System.exit(0);
        TreeNode xu = new TreeNode(-1000) ;
        System.out.println(findParent(a.root,new TreeNode(6),xu).rightChild);
        System.out.println(xu.leftChild);
        //System.out.println(a.successorPre(new TreeNode(7), copy(a.root)));
        System.exit(0);
        System.out.println(maximumDifference(a.root, -1));
        Tree b = new Tree(10);
        b.insert(5);
        b.insert(8);
        b.insert(12);
        b.insert(4);
        b.insert(7);
        b.insert(9);
        TreeNode x = mirror(copy(a.root));
        printTree(x);
        System.out.println();
        System.out.println(maxLevel(a.root, a.root.data, 0));
        //        System.out.println(identical(a.root,mirror(a.root)));

    }

  


    public static TreeNode findParent(TreeNode root, TreeNode node, TreeNode parent) {
        if (root == null)
            return null;
        if (root.data == node.data) {
            return parent;
        } else {
            TreeNode x = findParent(root.leftChild, node, root);
            TreeNode y = findParent(root.rightChild, node, root);
            if (x != null)
                return x;
            if (y != null)
                return y;
        }
        return null;
    }


    public static int maximumDifference(TreeNode t, int max) {
        int difference = t.data - getTheLastLeft(t);
        if (difference > max)
            max = difference;
        if (t.rightChild == null)
            return max;
        if (t.rightChild.data - t.data > max)
            max = maximumDifference(t.rightChild, max);
        return max;
    }


    public static int getTheLastLeft(TreeNode t) {
        if (t.leftChild != null)
            return getTheLastLeft(t.leftChild);
        return t.data;
    }

    public static TreeNode copy(TreeNode t) {
        if (t == null)
            return null;
        TreeNode n = new TreeNode(t.getData());
        if (t.rightChild != null)
            n.leftChild = copy(t.leftChild);
        if (t.rightChild != null)
            n.rightChild = copy(t.rightChild);
        return n;
    }

    public static void printTree(TreeNode root) {
        System.out.print(root.getData() + " +> ");
        if (root.getLeftChild() != null) {
            printTree(root.getLeftChild());
        }
        if (root.getRightChild() != null)
            printTree(root.getRightChild());
    }

    public static TreeNode mirror(TreeNode root) {
        TreeNode temp = null;
        if (root != null) {
            temp = root.rightChild;
            root.rightChild = copy(mirror(root.leftChild));
            root.leftChild = copy(mirror(temp));
        }
        return root;
    }

    public static boolean identical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 != null && root2 != null) {
            if (root1.data != root2.data)
                return false;
            else {
                return identical(root1.leftChild, root2.leftChild) && identical(root1.rightChild, root2.rightChild);
            }
        } else {
            return false;
        }
    }

    public static int maxLevel(TreeNode t, int sum, int level) {
        if (t.data == 0)
            return level;
        sumC(t);
        if (t.data > sum) {
            level++;
            sum = t.data;
        }
        return maxLevel(t, sum, level);
    }

    public static void sumC(TreeNode t) {
        int l = 0;
        int r = 0;
        if (t == null)
            return;
        if (t.rightChild != null)
            r = t.rightChild.data;
        if (t.leftChild != null)
            l = t.leftChild.data;
        t.data = l + r;
        sumC(t.rightChild);
        sumC(t.leftChild);
    }
    public static TreeNode sumTree(TreeNode t){
        int l = 0;
        int r = 0;
        TreeNode temp = new TreeNode(0);
        if (t == null)
            return null;
        if (t.rightChild != null){
            TreeNode x = sumTree(t.rightChild);
            r = x.data ;
        }
        if (t.leftChild != null){
            TreeNode y = sumTree(t.leftChild);
            l = y.data ;
        }
        if (l == 0 && r == 0){
            temp.data = t.data ;
            t.data = 0 ;
            return temp ;
        }else
            t.data += r + l ;
        return t ;
    }

}

class Tree {

    TreeNode root;

    public Tree() {
    }

    public Tree(int value) {
        insert(value);
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    public TreeNode findParent(TreeNode root, TreeNode node, TreeNode parent) {
        if (root == null)
            return null;
        if (root.data == node.data) {
            return parent;
        } else {
            TreeNode x = findParent(root.leftChild, node, root);
            TreeNode y = findParent(root.rightChild, node, root);
            if (x != null)
                return x;
            if (y != null)
                return y;
        }
        return null;
    }

    public TreeNode preorderSuccessor(TreeNode n) {
        ArrayList<TreeNode> x = preorder(root);
        int index = x.indexOf(n);
        return x.get(index + 1);
    }

    public ArrayList<TreeNode> preorder(TreeNode t) {
        ArrayList<TreeNode> tree = new ArrayList<>();
        tree.add(t);
        if (t == null)
            return tree;
        else {
            ArrayList<TreeNode> right = preorder(t.rightChild);
            ArrayList<TreeNode> left = preorder(t.leftChild);
            tree.addAll(right);
            tree.addAll(left);
        }
        return tree;
    }

    public TreeNode successorPre(TreeNode t, TreeNode root) {
        if (t.leftChild != null)
            return t.leftChild;
        if (t.rightChild != null)
            return t.rightChild;
        TreeNode curr = t, parent = findParent(this.root, t, root);
        System.out.println(curr);
        System.out.println(parent);
        while (parent != null && parent.rightChild == curr) {
            curr = findParent(this.root, curr, root);
            parent = findParent(this.root, parent, root);
            System.out.println(curr);
            System.out.println(parent);
        }

        // If we reached root, then the given
        // node has no preorder successor
        if (parent == null)
            return curr.rightChild;

        return parent.rightChild;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
        }

        return subtreeRoot;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void print(TreeNode root) {
        try {
            System.out.print(root.getData() + " => ");
            TreeNode l = root.getLeftChild();
            TreeNode r = root.getRightChild();
            print(l);
            print(r);
        } catch (Exception e) {

        }

    }

}

class TreeNode {

    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insertLeft(int value) {
        leftChild = new TreeNode(value);
    }

    public void insertRight(int value) {
        rightChild = new TreeNode(value);
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    public void traverseInOrder() {   // visit: leftChild >> Node >> rightChild
        if (leftChild != null) {   // leftChild
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");   // Node
        if (rightChild != null) {   // rightChild
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder() {   // visit: Node >> leftChild >> rightChild

        System.out.print(data + ", ");   // Node

        if (leftChild != null) {   // leftChild
            leftChild.traversePreOrder();
        }

        if (rightChild != null) {   // rightChild
            rightChild.traversePreOrder();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public String toString() {
        return "Data = " + data;
    }
}



