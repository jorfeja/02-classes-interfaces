package ohm.softa.a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {
    /// The first element in the list.
    Element head;
    /// Get the number of elements in the list.
    public int size() {
        // Iterate through list until next is empty
        Element current = head;
        int size = 1;
        while (current != null) {
            current = current.next;
            size++;
        }
        // Return number of iterations
        return  size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        return null;
    }

    public void add(Object item) {
        if (head == null) {
            head = new Element(item);
        } else {
            // Iterate through list until Element.next is empty
            Element current = head;
            while (current != null) {
                current = current.next;
            }
            // Set next to new item
            current.next = new Element(item);
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Element current = head;
            private int position = 0;
            @Override
            public boolean hasNext() {
                return position < size();
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = current.next;
                position++;
                return current.item;
            }
        };
    }

    private class Element {
        Object item;
        Element next;
        public Element(Object item) {
            this.item = item;
            next = null;
        }
    }
}
