import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class myList<Type> implements java.util.List<Type> {
    private myListItem head;
    private myListItem tail;

    public myList() {
        tail = null;
        head = null;
    }

    @Override
    public int size() {
        if (this.head == null)
            return 0;
        else if(this.head.next == null)
            return 1;
        else {
            myListItem current = this.head;
            int size = 1;
            while (current.next != null) {
              //  System.out.print(" In the Cycle ");
                current = current.next;
                size++;
            }
          //  System.out.print(" List size = "+size+"; ");
            return size;
        }
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null)
            return true;
        return false;
    }

    @Override
    public boolean add(Type type) {
        if (type == null) {
            throw new NullPointerException("Null values are not permitted");
        } else if (this.isEmpty()) {
           // System.out.println("List is empty");
            myListItem newElem = new myListItem(null, null, type);
            this.head = newElem;
            this.tail = newElem;
            return true;
        } /*else if (this.size() == 100) {
            System.out.println("Size is 1");
            myListItem newElem = new myListItem(this.head, null, type);
            this.head.next = newElem;
            this.tail = newElem;
            return true;
        } */else {
            //System.out.println("Size is more");
            myListItem newElem = new myListItem(this.tail, null, type);
            this.tail.next = newElem;
            this.tail = newElem;
            return true;
        }
    }

    @Override
    public Type remove(int index) {
        if (index >= this.size())
            throw new IndexOutOfBoundsException("Index is greater than list size");
        else if (index < 0) {
            throw new IndexOutOfBoundsException("Negative indexes are not supported");
        } else {
            int currInd = 0;
            myListItem current = this.head;
            while (currInd < index) {
                current = current.next;
                currInd++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            return (Type) current.data;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Null elements are not supported");
        } else if (this.size() == 0) {
            return false;
        } else if (this.size() == 1) {
            if (this.head.data == o) {
                return true;
            } else
                return false;
        } else {
            myListItem current = this.head;
            while (current.next != null) {
                if (current.data == o)
                    return true;
                current = current.next;
            }
            return false;
        }
    }

    @Override
    public Type get(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is greater than list size");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index are not supported");
        } else {
            int currInd = 0;
            myListItem current = this.head;
            while (currInd < index) {
                current = current.next;
                currInd++;
            }
            return (Type) current.data;
        }
    }

    @Override
    public void add(int index, Type element) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is greater than list size");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index are not supported");
        } else if (element == null) {
            throw new NullPointerException("Null elements are not permitted");
        } else {
            int currInd = 0;
            myListItem current = this.head;
            while (currInd < index) {
                current = current.next;
                currInd++;
            }
            myListItem newElem = new myListItem(current.prev, current, element);
            current.prev.next = newElem;
            current.prev = newElem;
        }
    }

    @Override
    public Iterator<Type> iterator() {
        throw new UnsupportedOperationException("This operation is not supported");

    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("This operation is not supported");

    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("This operation is not supported");
    }


    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean addAll(Collection<? extends Type> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean addAll(int index, Collection<? extends Type> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Type set(int index, Type element) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public ListIterator<Type> listIterator() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public ListIterator<Type> listIterator(int index) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public List<Type> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This operation is not supported");
    }
    /*
    public boolean isEmpty() {
        if (this.head == this.tail && this.head == null)
            return true;
        else
            return false;
    }

    public void addToTheEnd(Type elem) {

        if (this.isEmpty()) {
            myListItem newElem = new myListItem(null, null, elem);
            this.head = newElem;
            this.tail = newElem;
        } else {
            myListItem newElem = new myListItem(this.tail, null, elem);
            this.tail.next = newElem;
            this.tail = newElem;
        }
    }

    public Type getByIndex(int index) {
        myListItem Current = head;
        int currInd = 0;
        while (Current.next != null) {
            if (currInd == index)
                return (Type) Current.data;
            Current = Current.next;
            currInd++;
        }
        return null;
    }

    public boolean isIn(Type value) {
        myListItem Current = head;
        while (Current.next != null) {
            if (Current.data == value)
                return true;
            Current = Current.next;
        }
        return false;
    }

    public void deleteByIndex(int index){
        myListItem Current = head;
        int currInd = 0;
        while(Current.next!=null){
           Current = Current.next;
           currInd++;
        }
    }*/

}
