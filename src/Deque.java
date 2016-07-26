/**
 * Created by VeraZhou on 6/7/16.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Deque<Item> implements Iterable<Item> {
    private class Node{
        Item item;
        Node next;
        Node prev;
    }
    private Node first;
    private Node last;
    private int n;

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }                           // construct an empty deque
    public boolean isEmpty() {
        return n == 0;
    }                 // is the deque empty?
    public int size() {
        return n;
    }                        // return the number of items on the deque
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException("Null item!");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (isEmpty()) {
            last = first;
        }
        else{
            oldFirst.prev = first;
        }
        n++;
    }         // insert the item at the front
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException("Null item!");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        n++;
    }          // insert the item at the end
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty()) {
            last = null;
        }
        else{
            first.prev = null;
        }
        return item;
    }                // delete and return the item at the front
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.item;
        last = last.prev;
        n--;
        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }                 // delete and return the item at the end
    public Iterator<Item> iterator() {
        return new dequeIterable();
    }   // return an iterator over items in order from front to end
    private class dequeIterable implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current !=null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
    public static void main(String[] args) {
        Deque deque = new Deque();
        for(int i = 0; i < 1; i++) {
            deque.addFirst(i);
        }
        deque.removeFirst();

        Iterator<Integer> itr = deque.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }   // unit testing
}
