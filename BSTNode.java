// package Practice08;

/**
 * Mark Codd
 * Prof. David Guy Brizan
 * TA: Razan Said
 * CS 245-01
 *
 * Practice08 - Binary Search Tree Node
 * ------------------------------------
 * Node for storing data, left subtree and right subtree
 *
 * @param <T> arr: Template for data structure
 */

public class BSTNode<T>{

    public T data;  // data to be stored
    public BSTNode<T> left;  // left subtree
    public BSTNode<T> right;  // right subtree

    // constructor
    public BSTNode(T data){
        this.data = data;
    }
}
