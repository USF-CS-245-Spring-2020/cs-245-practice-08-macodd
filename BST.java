// package Practice08;

/**
 * Mark Codd
 * Prof. David Guy Brizan
 * TA: Razan Said
 * CS 245-01
 *
 * Practice08 - Binary Search Tree
 * -------------------------------
 * Binary tree used to keep a sorted list
 * allows users to find, insert, print, and delete
 *
 * @param <T> arr: Template for data structure
 */

public class BST<T extends Comparable<T>> {

    private BSTNode<T> root;  // first node of tree

    /**
     * Function: find
     * --------------
     * looks for a specific item within the tree.
     * @param item: item to be searched for in tree.
     * @return bool: true if item is found.
     */
    public boolean find(T item){
        return find(this.root, item);  // calls private find function
    }

    /**
     * Function: find
     * --------------
     * Looks for a specific item within the tree.
     * @param node: Node to be check for data equivalency.
     * @param item: item to be searched for.
     * @return bool: true if found.
     */
    private boolean find(BSTNode<T> node, T item){
        if (node == null)
            return false;  // item not found
        if (item.compareTo(node.data) == 0)
            return true;  // item found
        else if (item.compareTo(node.data) < 0)
            return find(node.left, item);  // if item is less than current node
        else
            return find(node.right, item);  // if item is higher than current node
    }

    /**
     * Function: insert
     * ----------------
     * Inserts an item into its correct position in the tree.
     * @param item: item to be inserted.
     */
    public void insert(T item){
        this.root = insert(this.root, item);  // starts with inserting root
    }

    /**
     * Function: insert
     * ----------------
     * Inserts an item into its correct position in the tree.
     * @param node: node to compare to item
     * @param item: item to be inserted
     * @return BSTNode: node inserted into tree
     */
    private BSTNode<T> insert(BSTNode<T> node, T item){
        if (node == null)
            return new BSTNode<T>(item);  // empty
        if (item.compareTo(node.data) < 0)
            node.left = insert(node.left, item);  // item less than current node data
        else
            node.right = insert(node.right, item);  // item greater than current node data
        return node;
    }

    /**
     * Function: print
     * ---------------
     * Prints the tree in alphabetical order
     */
    public void print(){
        print(this.root);  // starts with root node
    }

    /**
     * Function: print
     * ---------------
     * Prints the tree in alphabetical order
     */
    private void print(BSTNode<T> node){
        if (node != null){
            print(node.left);  // looks for lowest value in left subtrees
            System.out.println(node.data);  // prints current node
            print(node.right);  // looks for lowest values in right subtrees
        }
    }

    /**
     * Function: delete
     * ----------------
     * Deletes node and rearranges tree if necessary
     * @param item: item to be deleted
     */
    public void delete(T item){
        this.root = delete(this.root, item);  // starts with root node
    }

    /**
     * Function: delete
     * ----------------
     * Deletes node and rearranges tree if necessary
     * @param node: node to be compared with item to be deleted
     * @param item: item to be deleted
     * @return BSTNode: deleted node
     */
    public BSTNode<T> delete(BSTNode<T> node, T item){
        if (node == null)
            return null;  // not found
        if (item.compareTo(node.data) < 0) {
            node.right = delete(node.right, item);  // checks right side
            return node;
        }
        else if (item.compareTo(node.data) > 0){
            node.left = delete(node.left, item);  // checks left side
        }
        else {
            if (node.left == null)
                return node.right;  // returns right subtree
            else if (node.right == null)
                return node.left;  // returns left subtree
            else {
                if (node.right.left == null){
                    node.data = node.right.data;
                    node.right = node.right.right;
                }
                else {
                    node.data = removeSmallest(node.right);  // removes the node
                }
            }
        }
        return node;
    }

    /**
     * Function: removeSmallest
     * ------------------------
     * removes the smallest node and rearranges it into tree
     * @param node: node to be removed
     * @return T: data of left subtree
     */
    private T removeSmallest(BSTNode<T> node){
        if (node.left.left == null){
            T smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        else {
            return removeSmallest(node.left);
        }
    }
}
