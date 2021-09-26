import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Bag<Item> implements Iterable<Item> 
{
    private Node first; // first node in list

    private class Node
    {
        Item item;
        Node next;
    }

    public void add (Item item)
    {
        // Same as push() in Stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
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