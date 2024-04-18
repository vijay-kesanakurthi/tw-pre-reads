import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    SimpleLinkedList() {
        head = null;
    }

    SimpleLinkedList(T[] values) {
        for (T value : values) {
            push(value);
        }
    }

    void push(T value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(value);
    }

    T pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            T value = head.value;
            head = null;
            return value;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T value = temp.next.value;
        temp.next = null;
        return value;
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    T[] asArray(Class<T> clazz) {
        T[] arr = (T[]) Array.newInstance(clazz, size());
        Node temp = head;
        int i = size() - 1;
        while (temp != null) {
            arr[i] = temp.value;
            temp = temp.next;
            i--;
        }
        return arr;
    }

    int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
