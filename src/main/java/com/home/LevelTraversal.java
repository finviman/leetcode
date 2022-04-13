package com.home;

import java.util.LinkedList;

/**
 * 二叉树的广度优先遍历，即分层遍历
 * Created by liyang on 18/9/2017.
 */
public class LevelTraversal {

    LinkedList<Node> assistQueue = new LinkedList<>();

    public static void main(String[] args) {
        LevelTraversal traversal = new LevelTraversal();
        traversal.wocao();
    }

    public void wocao() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
//        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(6);
        root.right.right = new Node(7);
        traversal(root);
    }

    public void traversal(Node root){
        assistQueue.add(root);
        Node cur = null;
        while (assistQueue.size()>0) {
            cur = assistQueue.pop();
            System.out.println(cur.data);
            if (cur.left!=null) {
                assistQueue.add(cur.left);
            }
            if (cur.right!=null) {
                assistQueue.add(cur.right);
            }
        }
    }

    class Node{
        Node(int data) {
            this.data= data;
        }
        Node left;
        Node right;
        int data;
    }

}
