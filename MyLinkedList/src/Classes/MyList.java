package Classes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList <T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T i) {
        Node<T> newNode = new Node<>(i);
        if(head ==null){
            head = newNode;
            tail = newNode;
        }
        else{
          tail.nextNode = newNode;
          newNode.prewNode = tail;
          tail = newNode;
        }
        size++;
    }

    public void add(int ind, T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> curNode = head;
        Node<T> prewNode;


        if(ind> size){
            System.out.println(new IndexOutOfBoundsException());
        }

        if(ind == 0){
            if(head!=null){
                head.prewNode = newNode;
                newNode.nextNode = head;
                head =newNode;
            }
            else {
                head = newNode;
                tail = newNode;
            }
        }

        else if(ind == size){
            tail.nextNode = newNode;
            newNode.prewNode = tail;
            tail = newNode;
        }

        else{
            for(int i=0; i<size; i++){
                if(i == ind) {
                    prewNode = curNode.prewNode;
                    prewNode.nextNode = newNode;
                    newNode.prewNode = prewNode;
                    newNode.nextNode = curNode;
                    curNode.prewNode = newNode;
                }
                curNode = curNode.nextNode;
            }
        }

        size++;
    }

    public T get(int index){
        if(index >=size){
            System.out.println(new IndexOutOfBoundsException());
            return null;
        }
        int i =0;
        for (T item : this) {
            if (i == index) {
                return item;
            }
            i++;
        }
        System.out.println("Element don't exist");
        return null;
    }

    public T remove(int index){

        int i =0;

        Node<T> delNode;
        Node<T> prewNode;
        Node<T> curNode = head;

        if(index >=size){
            System.out.println(new IndexOutOfBoundsException());
            return null;
        }

        else if(index==0){
            delNode = head;
            T obj = delNode.value;
            if(head.nextNode !=null){
                head = head.nextNode;
                delNode = null;
                return obj;
            }
            return null;
        }

        else if(index== size-1){
            delNode = tail;
            T obj = delNode.value;
            if(tail.prewNode != null){
                tail = tail.prewNode;
                tail.nextNode = null;
                delNode = null;
                return obj;
            }
            return null;
        }

        else {
            for (T item :this) {
                if (i == index) {
                    delNode = curNode;
                    prewNode = curNode.prewNode;
                    prewNode.nextNode = curNode.nextNode;
                    curNode.nextNode.prewNode = prewNode;
                    delNode = null;
                    curNode = null;
                    return item;
                }
                i++;
                curNode = curNode.nextNode;
            }
        }

        System.out.println("Element don't exist");
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = currentNode.value;
                currentNode = currentNode.nextNode;
                return value;
            }
        };
    }

   public int size(){
        return size;
    }

   public boolean isEmpty(){
        if(head ==null){
            return true;
        }
        return false;
    }

}
