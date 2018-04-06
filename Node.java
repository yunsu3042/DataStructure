public class Node<T>
{
    private T data;
    private Node next = null;
    private Node prev = null;

    public Node(T x)
    {
        data = x;
    }

    public Node(T x, Node nextNode)
    {
        data = x;
        next = nextNode;
        nextNode.prev = this;
    }

    public Node()
    {
        data = null;
    }

    public T getItem()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }

    public Node getPrev()
    {
        return prev;
    }
    public void setNext(Node nextNode)
    {
        next = nextNode;
        nextNode.prev = this;
    }

    public void setPrev(Node prevNode)
    {
        this.prev = prevNode;
    }
}