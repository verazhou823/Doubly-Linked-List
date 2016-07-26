/**
 * Created by VeraZhou on 6/7/16.
 */
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class subset {
    public static void main(String[] args) {
        RandomizedQueue rQueue = new RandomizedQueue();
        int k = Integer.parseInt(args[0]);
        System.out.println("Enter the string");
        while (!StdIn.isEmpty()) {
            rQueue.enqueue(StdIn.readString());
        }
        for(int i = 0; i<k; i++) {
            System.out.println(rQueue.dequeue());
        }


    }
}
