package tree;

public class Node<T> {

    public T info;
    public Node<T> next;

    public Node(T el) {
        info = el;
        next = null;
    }

    public Node(T el, Node<T> ptr) {
        info = el;
        next = ptr;
    }

    public String toString() {
        return info.toString();
    }
}
