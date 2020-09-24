import java.util.NoSuchElementException;

public class myQueue<Type> extends myList<Type> implements java.util.Queue<Type> {

    public myQueue() {
        super();
    }

    @Override
    public boolean offer(Type type) {
        return this.add(type);
    }

    @Override
    public Type remove() {
        if(this.isEmpty())
            throw new NoSuchElementException("The queue is empty. There is nothing to remove");
        else{
            return this.remove(0);
        }
    }

    @Override
    public Type poll() {
        if(this.isEmpty())
            return null;
        else{
            return this.remove(0);
        }
    }

    @Override
    public Type element() {
        if(this.isEmpty())
            throw new NoSuchElementException("The queue is empty. There is nothing to retrieve");
        else{
            return this.get(0);
        }
    }

    @Override
    public Type peek() {
        if(this.isEmpty())
            return null;
        else{
            return this.get(0);
        }
    }
}
