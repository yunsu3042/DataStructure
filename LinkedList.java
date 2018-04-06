/*
 *  2018.4.5
 *          0.1v : Double LinkedList
 *  2018.4.6
 *          0.2v : DummyHead Circular LinkedList
 *
 *
 *
 *
 * */

import com.sun.xml.internal.rngom.digested.DUnaryPattern;

public class LinkedList<K> {
    //    Node<K> head = null;
    Node<K> Dummyhead = new Node<K>();
    int count = 0;

    public LinkedList()
    {
        Dummyhead.setNext(Dummyhead);
        Dummyhead.setPrev(Dummyhead);
    }

    public boolean isEmpty() {
        return count == 0;
//        return DummyHead.getItem() == 0;
    }

    public int size() {
        return count;
//        return DummyHead.getItem();
    }

    public void add(int index, K data) throws Exception {
        if (index < 0 | index > count)
            throw new Exception("a");
//        if(head == null)
//        {
//            Node newNode = new Node(data);
//            head = newNode;
//        }
//        else if (index == 0) {
//            Node newNode = new Node(data);
//            newNode.setNext(head);
//            head.setPrev(newNode);
//            head = newNode;
//        }

//        else if (index == count) // 마지막 노드일 경우 예외처리
//        {
//            Node cur = find(index - 1);
//            Node newNode = new Node<K>(data);
//            cur.setNext(newNode);
//            newNode.setPrev(cur);
//        }
//        else // 일반적인 노드 처리.
//        {
//            Node cur = find(index - 1);
//            Node newNode = new Node<K>(data);
//            Node next = cur.getNext();
//
//            next.setPrev(newNode);
//            cur.setNext(newNode);
//            newNode.setPrev(cur);
//            newNode.setNext(next);
//        }
        if(count == 0)
        {
            Node newNode = new Node<K>(data);
            Dummyhead.setNext(newNode);
            newNode.setPrev(Dummyhead);
            newNode.setNext(Dummyhead);
            Dummyhead.setPrev(newNode);
        }

        Node cur = find(index);
        Node newNode = new Node<K>(data);
        Node prev = cur.getPrev();
        prev.setNext(newNode);
        newNode.setNext(cur);
        newNode.setPrev(prev);
        cur.setPrev(newNode);
        count++;
    }

    public Object get(int index) throws Exception {
//        if(index >= 1 && index < DummyHead.getItem())
        if (index >= 0 && index < count) {
            Node ptr = find(index);
            return ptr.getItem();
        } else {
            throw new Exception("IndexOutOfBoundError");
        }
    }

    public void remove(int index) throws Exception {
        if (index >= 0 && index < count) {
//            if (index == 0) {
//                head = head.getNext();
//            }
//            else if (index == count - 1) {
//                Node cur = find(index);
//                Node prev = cur.getPrev();
//                prev.setNext(null);
//            }
//            else {
//                Node cur = find(index);
//                Node prev = cur.getPrev();
//                Node next = cur.getNext();
//                prev.setNext(next);
//                next.setPrev(prev);
//            }
            Node cur = find(index);
            Node prev = cur.getPrev();
            Node next = cur.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            count--;
        } else {
            throw new Exception("IndexOutOfBoundError");
        }
    }

    public void removeAll() {
        Dummyhead.setNext(null);
        Dummyhead.setPrev(null);
    }


    private Node find(int index) {
        Node ptr = Dummyhead;
        for (int i = 0; i < index + 1; i++) {
            ptr = ptr.getNext();
        }
        return ptr;
    }

    public void print()
    {
        for(int i = 0; i < count; i++)
        {
            System.out.println(find(i).getItem());
        }
    }

    public static void main(String args[])
    {
        LinkedList list = new LinkedList<Integer>();
        try
        {
            list.add(0, 1);
            list.add(1, 2);
            list.add(2, 3);
            list.print();
            list.remove(0);
            list.remove(0);
            list.remove(0);
            list.print();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
