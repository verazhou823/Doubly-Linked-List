/**
 * Created by VeraZhou on 6/7/16.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int n;
    public RandomizedQueue() {
        array = (Item[])new Object[2];
        n = 0;
    }// construct an empty randomized queue
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i < n; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }
    public boolean isEmpty() {
        return n == 0;
    }              // is the queue empty?
    public int size() {
        return n;
    }                        // return the number of items on the queue
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException("Null item!");
        if (n == array.length) {
            resize(array.length*2);
        }
        array[n++] = item;
    }           // add the item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int random = StdRandom.uniform(n);
        Item item = array[random];
        array[random] = array[--n];
        array[n] = null;
        if (n > 0 && n == array.length/4) {
           resize(array.length/2);
        }
        return item;
    }                    // delete and return a random item
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int random = StdRandom.uniform(n);
        return array[random];
    }                     // return (but do not delete) a random item
    private class reverseArray<Item> implements Iterator<Item> {
        private int i = n;
        public boolean hasNext() {
            return i > 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (i == 0) throw new NoSuchElementException("Queue underflow");
            return (Item) array[--i];
        }

    }
    public Iterator<Item> iterator() {
        return new reverseArray();
    }        // return an independent iterator over items in random order

    public static void main(String[] args) {
        RandomizedQueue rQueue = new RandomizedQueue();
//        rQueue.enqueue("aaa");
//        rQueue.enqueue("bbb");
//        System.out.println(rQueue.sample()+"!");
//        System.out.println(rQueue.dequeue()+"?");
//        rQueue.dequeue();
//        rQueue.enqueue("bbb");
//        rQueue.enqueue("ccc");
//        rQueue.enqueue("ddd");
//        rQueue.enqueue("eee");
//        rQueue.enqueue("fff");




        System.out.println("Enter the string");
        while (StdIn.hasNextLine()) {
            String s = StdIn.readLine();
            System.out.println(s);
            rQueue.enqueue(s);
        }
//        while (!StdIn.isEmpty()) {
//            rQueue.enqueue(StdIn.readString());
//        }

//        while(rQueue.n > 1) {
//            System.out.println(rQueue.dequeue());
//        }
        System.out.println(rQueue.sample()+"!");

//         unit testing
    }

}
