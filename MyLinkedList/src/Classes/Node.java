package Classes;

public class Node<T> {

    Node nextNode;
    Node prewNode;
    T value;

    Node(T value) {
        this.value = value;
    }
}
