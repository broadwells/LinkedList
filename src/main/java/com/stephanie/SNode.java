package com.stephanie;

public class SNode {

    public int element;

    public SNode getNext() {
        return nextNode;
    }

    public void setNext(SNode nextNode) {
        this.nextNode = nextNode;
    }

    SNode nextNode;

    public SNode() {

    }

    public SNode(int element) {
        this.element = element;
    }

    public SNode(int element, SNode next) {
        this.element = element;
        this.nextNode = next;
    }
}


