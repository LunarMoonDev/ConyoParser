package tree;

public class SLL<T> {

    private Node<T> head, tail;

    public void insertDesc(T el) {
        if (isEmpty()) {
            head = tail = new Node(el, null);
        } else if (((Comparable) head.info).compareTo(el) <= 0) {
            addToHead(el);
        } else if (((Comparable) tail.info).compareTo(el) >= 0) {
            addToTail(el);
        } else {
            Node<T> p;
            for (p = head; ((Comparable) p.next.info).compareTo(el) >= 0; p = p.next);
            Node<T> a = new Node(el, p.next);
            p.next = a;
        }
    }

    public String toString() {
        Node<T> p;
        String s = "";
        for (p = head; p != null; p = p.next) {
            s = s + p.info.toString() + " ";
        }
        return s;
    }

    public void addToHead(T el) {
        head = new Node<T>(el, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void addToTail(T el) {
        if (isEmpty()) {
            head = tail = new Node(el, null);
        } else {
            tail.next = new Node(el, null);
            tail = tail.next;
        }
    }

    public T deleteFromHead() {
        if (isEmpty()) {
            return null;
        }
        T el = head.info;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty()) {
            return null;
        }
        T el = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> p;
            for (p = head; p.next != tail; p = p.next);
            tail = p;
            tail.next = null;
        }
        return el;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public Node find(T el) {
        Node<T> p = head;
        while (p != null && p.info != el) {
            p = p.next;
        }
        return p;
    }

    public T delete(T el) {
        if (isEmpty()) {
            return null;
        }
        if (el == head.info) {
            return deleteFromHead();
        }
        if (el == tail.info) {
            return deleteFromTail();
        }
        Node<T> pred = head;
        Node<T> t = head.next;
        while (t != null && t.info != el) {
            pred = pred.next = t.next;
            t = t.next;
        }
        if (t == null) {
            return null;
        } else {
            pred.next = t.next;
        }
        return el;
    }
}
