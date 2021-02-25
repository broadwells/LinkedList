package test

import com.stephanie.SNode
import com.stephanie.StephanieLinkedList
import spock.lang.Specification

class StephanieLinkedListTest extends Specification {


    def "add element to linked list node"() {
        given: 'a valid integer element'
        int element = 23
        StephanieLinkedList linkedList = new StephanieLinkedList()

        when: 'I call add'
        linkedList.add(element)

        then: 'the last com.stephanie.Node element equals the element integer provided'
        linkedList.head.element == 0
        linkedList.head.next == linkedList.last
        linkedList.head.next.element == element
        linkedList.last.element == element
        linkedList.last.next == null
    }

    def "add  two elements to linked list node"() {
        given: 'two valid integer elements'
        int element23 = 23
        int element6 = 6
        StephanieLinkedList linkedList = new StephanieLinkedList()

        when: 'I call add with element23'
        linkedList.add(element23)

        and: 'call add again with element6'
        linkedList.add(element6)

        then: 'the last com.stephanie.Node element equals the element integer provided'
        linkedList.head.element == 0
        linkedList.head.next.element == element23
        linkedList.head.next.next.element == element6
        linkedList.last.element == element6
        linkedList.last.next == null
    }

    def "add two elements to linked list node"() {
        given: 'two valid integer elements'
        int element23 = 23
        StephanieLinkedList linkedList = new StephanieLinkedList()

        when: 'I call add with element23'
        linkedList.add(element23)

        and: 'call add again with element6'
        linkedList.add(element23)

        then: 'the last com.stephanie.Node element equals the element integer provided'
        linkedList.head.element == 0
        linkedList.head.next.element == element23
        linkedList.head.next.next.element == element23
        linkedList.last.element == element23
        linkedList.last.next == null
    }

    def "create two nodes"() {
        when: 'two nodes created with same elements'
        SNode first = new SNode(6)
        SNode second = new SNode(6)

        then: 'I expect the two to match in comparison'
        first != second
    }

    def "create node with transform"() {
        given: 'a new node created with element 6 and valid element int'
        SNode first = new SNode(6)
        int element = 23
        StephanieLinkedList linkedList = new StephanieLinkedList()
//        SNode second = new SNode()

        when: 'transform is called'
        SNode transformedNode = linkedList.transform(first, element)

        then: 'I expect the two not to match in comparison'
        transformedNode != first
    }

    def 'get node by index'() {
        given: 'a valid linked list'
        StephanieLinkedList linkedList = new StephanieLinkedList()
        linkedList.add(23)
        linkedList.add(6)
        linkedList.add(15)

        when: 'get is called with index int'
        SNode node = linkedList.get(1)

        then: 'I expect node with element 6 to be returned'
        node != null
        node.element == 6

        when: 'get is called with index'
        SNode node1 = linkedList.get(5)

        then: 'I expect null is returned'
        node1 == null

        and: 'new linked list'
        StephanieLinkedList emptyList = new StephanieLinkedList()

        when: 'get is called with int'
        node1 = emptyList.get(0)

        then: 'I expect null to be returned'
        node1 == null
    }

    def 'get node index by element'() {
        given: 'a valid linked list'
        StephanieLinkedList linkedList = new StephanieLinkedList()
        linkedList.add(23)
        linkedList.add(6)
        linkedList.add(15)

        when: 'get by element is called'
        int index = linkedList.getByElement(23)

        then: 'I expect index of 0 to be returned'
        index == 0

        when: 'get by element is called'
        index = linkedList.getByElement(15)

        then: 'I expect index of 2 to be returned'
        index == 2

        when: 'get by element is called again'
        index = linkedList.getByElement(1)

        then: 'I expect index of -1 is returned'
        index == -1

        and: 'new empty linked list'
        StephanieLinkedList emptyList = new StephanieLinkedList()

        when: 'get by element is called'
        index = emptyList.getByElement(0)

        then: 'I expect index of -1 to be returned'
        index == -1
    }

    def 'remove node by index'() {
        given: 'a valid linked list'
        StephanieLinkedList linkedList = new StephanieLinkedList()
        linkedList.add(23)
        linkedList.add(6)
        linkedList.add(15)
        linkedList.add(12)
        linkedList.add(8)

        when: 'remove by index is called'
        int element = linkedList.remove(3)

        // write size method to also validate that the linked list size decreases
        then: 'I expect element 12 will be returned'
        element == 12

        when: 'remove by index is called on first index'
        element = linkedList.remove(0)

        then: 'I expect element 23 will be returned'
        element == 23

        when: 'remove by index is called on the last index'
        element = linkedList.remove(2)

        then: 'I expect element 8 will be returned'
        element == 8

        when: 'add new element to linked list'
        linkedList.add(52)

        then: 'I expect last node element equals 52'
        notThrown(NullPointerException)
        linkedList.last.element == 52
        linkedList.last.next == null
    }

    def 'delete node by element'() {
        given: 'a valid linked list'
        StephanieLinkedList linkedList = new StephanieLinkedList()
        linkedList.add(23)
        linkedList.add(6)
        linkedList.add(15)
        linkedList.add(12)
        linkedList.add(8)

        when: 'delete by element is called'
        int index = linkedList.delete(6)

        // write size method to also validate that the linked list size decreases
        then: 'I expect index of 1 to be returned'
        index == 1

        when: 'delete by element is called'
        index = linkedList.delete(23)

        then: 'I expect index of 1 to be returned'
        index == 0

        when: 'remove by index is called on the last index'
        index = linkedList.delete(8)

        then: 'I expect element 8 will be returned'
        index == 2

        when: 'add new element to linked list'
        linkedList.add(52)

        then: 'I expect last node element equals 52'
        notThrown(NullPointerException)
        linkedList.last.element == 52
        linkedList.last.next == null
    }

    def 'retrieve size of linked list'() {
        given: 'a valid linked list'
        StephanieLinkedList linkedList = new StephanieLinkedList()
        linkedList.add(23)
        linkedList.add(6)
        linkedList.add(15)
        linkedList.add(12)
        linkedList.add(8)

        when: 'size is called'
        int size = linkedList.size()

        then: 'I expect the list size to equal 5'
        size == 5

        when: 'remove by index is called'
        linkedList.remove(2)

        and: 'size is called'
        size = linkedList.size()

        then: 'I expect the list size to equal 4'
        size == 4

        when: 'add is called with two new elements'
        linkedList.add(45)
        linkedList.add(7)

        and: 'size is called'
        size = linkedList.size()

        then: 'I expect the list size to equal 6'
        size == 6

        and: 'new empty linked list'
        StephanieLinkedList emptyList = new StephanieLinkedList()

        when: 'size is called'
        size = emptyList.size()

        then: 'size of 0 is returned'
        size == 0
    }
}
