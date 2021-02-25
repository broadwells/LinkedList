package com.stephanie;

/**
 * 1. O(1) - constant time; flat line across the graph
 * 2. O(n) - linear time; linear curve on graph (flat line up)
 * 3. O(n^2) - parabolic time; parabolic curve on graph (gets to the top of y real quick)
 * 4. O(n^3) - if get here, gone too far; line straight up vertical; still parabolic but faster
 */

/**
 * Java Generics 3/2 exercise
 */

public class StephanieLinkedList {
    public final SNode head;
    public SNode last;
    // get past time complexity with space
    public SNode[] sNodeArray;
    private int lastIndex;

    public StephanieLinkedList() {
        head = new SNode();
        last = head;
    }

    /**
     * Constant time - O(1); number of steps never changes even with the growing list
     *
     * @param element
     * @return
     */
    public SNode add(int element) {
        SNode next = new SNode(element);
        last.setNext(next);
        last = next;
        return next;
    }

//    public SNode transform(SNode node, int element){
//        node = new SNode(element);
//        return node;
//    }

    /**
     * O(n)
     *
     * @param index
     * @return
     */
    public SNode get(int index) {
        if (head.nextNode == null) {
            return null;
        }

        int i = 0;
        SNode node = head.nextNode;
        while (i < index) {
            if (node == null) {
                return null;
            }
            node = node.nextNode;
            i++;
        }

        return node;
    }

    /**
     * O(2n+2) >> O(2n) >> O(n)
     *
     * @param element
     * @return
     */
    public int getByElement(int element) {
        if (head.nextNode == null) {
            return -1;
        }

        int index = 0;
        boolean indexFound = false;
        SNode node = head.nextNode;
        while (!indexFound) {
            if (node == null) {
                return -1;
            }

            if (node.element == element) {
                indexFound = true;
            } else {
                node = node.nextNode;
                index++;
            }
        }
        return index;
    }

    /**
     * O(n)
     *
     * @return
     */
    public int size() {
        SNode node = head.nextNode;
        int size = 0;
        while (node != null) {
            node = node.nextNode;
            size++;
        }
        return size;
    }

    // 23,6,15,12,8
    /**
     * O(n)
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (head.nextNode == null) {
            return -1;
        }

        int i = 0;
        SNode prevNode = head;
        SNode nodeToRemove = prevNode.nextNode;
        while (i < index) {
            if (nodeToRemove == null) {
                return -1;
            }
            prevNode = nodeToRemove;
            nodeToRemove = nodeToRemove.nextNode;
            i++;
        }
        prevNode.setNext(nodeToRemove.nextNode);
        if (nodeToRemove == last) {
            last = prevNode;
        }
        return nodeToRemove.element;
    }

    /**
     * O(n)
     *
     * @param element
     * @return
     */
    public int delete(int element) {
        if (head.nextNode == null) {
            return -1;
        }

        int index = 0;
        boolean indexFound = false;
        SNode prevNode = head;
        SNode nodeToRemove = prevNode.nextNode;
        while (!indexFound) {
            if (nodeToRemove == null) {
                return -1;
            }

            if (nodeToRemove.element == element) {
                indexFound = true;
            } else {
                prevNode = nodeToRemove;
                nodeToRemove = nodeToRemove.nextNode;
                index++;
            }
        }
        prevNode.setNext(nodeToRemove.nextNode);
        if (nodeToRemove == last) {
            last = prevNode;
        }
        return index;
    }

}
