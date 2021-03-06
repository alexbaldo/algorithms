import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item> 
{
    private Node first; // link to least recently added node
    private Node last;  // link to most recently added node
    private int N;      // number of items

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }

    public void enqueue (Item item)
    {
        // Add item to the end of the list.
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) 
            first = last;
        else           
            oldlast.next = last;
        N++;
    }

    public Item dequeue()
    {
        // Remove item from the beginning of the list.
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext ()
        { 
            return current != null;
        }

        public Item next ()
        { 
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove()  { }
    }

    public static void main (String[] args)
    {
        // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on queue)");
    }

}