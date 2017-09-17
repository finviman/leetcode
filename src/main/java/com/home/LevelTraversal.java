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
        //root.left.left = new Node(4);
        root.left.right = new Node(5);
        //root.right.left = new Node(6);
        root.right.right = new Node(7);
        traversal(root);
    }

    public void traversal(Node root){
        int thisLevelNumber = 1;
        int nextLevelNumber = 0;
        assistQueue.offer(root);
        while (thisLevelNumber > 0) {
            Node thisLevels = assistQueue.poll();
            System.out.println(thisLevels.data);
            thisLevelNumber--;
            if (thisLevels.left!=null) {
                assistQueue.offer(thisLevels.left);
                nextLevelNumber++;
            }
            if (thisLevels.right!=null) {
                assistQueue.offer(thisLevels.right);
                nextLevelNumber++;
            }
            if (thisLevelNumber==0) {
                thisLevelNumber= nextLevelNumber;
                nextLevelNumber=0;
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
