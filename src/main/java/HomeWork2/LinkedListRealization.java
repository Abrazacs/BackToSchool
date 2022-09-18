package HomeWork2;

import java.util.NoSuchElementException;

public class LinkedListRealization<E> {

    private Node<E> first =null;
    private Node<E> last = null;
    private int size = 0;

    private static class Node<E>{
        E item;
        Node<E> left;
        Node<E> right;

        Node(Node<E> left, Node<E> right, E item){
            this.left = left;
            this.right = right;
            this.item = item;
        }
    }

    public void add (E e){
        if(size==0){
            first = new Node<>(null, last, e);
            last = first;
            size++;
        }else {
            Node<E> newNode = new Node<>(last,null, e);
            last.right = newNode;
            last = newNode;
            size++;
        }

    }

    public E get(int index){
        if(size == 0) throw new NoSuchElementException("List is empty");
        if(size == index+1) return last.item;
        else {
            if (index<=(size-1)/2){
                int i = 0;
                Node<E> currentNode = first;
                while (i<index){
                    currentNode = currentNode.right;
                    i++;
                }
                return currentNode.item;
            }else {
                int i = size-1;
                Node<E> currentNode = last;
                while (i>=index){
                    currentNode = last.left;
                    i--;
                }
                return currentNode.item;
            }
        }
    }


    public boolean remove (E e){
        if (first.item.equals(e)){
            first=first.right;
            first.left = null;
            size--;
            return true;
        }
        if(last.item.equals(e)){
            last = last.left;
            last.right = null;
            size--;
            return true;
        }
        Node<E> currentNode = first;
        while (currentNode.right!=null){
            currentNode = currentNode.right;
            if(currentNode.item.equals(e)){
                Node<E> left = currentNode.left;
                Node<E> right = currentNode.right;
                left.right = right;
                right.left = left;
                size--;
                return true;
            }
        }
        return false;
    }

    public String toString(){
        if(size==0) {return "It is empty list";}
        StringBuilder sb = new StringBuilder();
        sb.append(first.item);
        Node<E> currentNode = first;
        while (currentNode.right!=null){
            currentNode = currentNode.right;
            sb.append(",");
            sb.append(currentNode.item);
        }
        return sb.toString();
    }

}
