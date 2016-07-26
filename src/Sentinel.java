import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by VeraZhou on 25/7/16.
 */
public class Sentinel<Item> implements Iterable<Item> {
    private class Node{
        Item item;
        Node next;
        Node prev;
    }
    private Node first;
    private int n;

    public Sentinel() {
        Node first = new Node();
        this.first = first;
        first.item = null;
        first.next = first;
        first.prev = first;
        n = 0;
    }                           // construct an empty Dlist
    public boolean isEmpty() {
        return n == 0;
    }                 // is the Dlist empty?
    public int size() {
        return n;
    }                        // return the number of items on the Dlist
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException("Null item!");
        Node newItem = new Node();
        newItem.item = item;
        newItem.next = first.next;
        newItem.prev = first;
        first.next.prev = newItem;
        first.next = newItem;
        n++;
    }         // insert the item at the front
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException("Null item!");
        Node newItem = new Node();
        newItem.item = item;
        newItem.next = first;
        newItem.prev = first.prev;
        first.prev.next = newItem;
        first.prev = newItem;
        n++;
    }          // insert the item at the end
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.next.item;
        first.next = first.next.next;
        first.next.prev = first;
        n--;
        return item;
    }                // delete and return the item at the front
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.prev.item;
        first.prev = first.prev.prev;
        first.prev.next = first;
        return item;
    }                 // delete and return the item at the end
    public Iterator<Item> iterator() {
        return new sentIterable();
    }   // return an iterator over items in order from front to end
    private class sentIterable implements Iterator<Item> {
        private Node current = first.next;
        public boolean hasNext() {
            return current != first;
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
        Sentinel sentinel = new Sentinel();
        for(int i = 0; i < 10; i++) {
            sentinel.addLast(i);
        }
        sentinel.removeLast();

        Iterator<Integer> itr = sentinel.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }   // unit testing
}
