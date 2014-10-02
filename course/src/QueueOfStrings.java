/**
 * Created by eduardo on 02/10/2014.
 */
public class QueueOfStrings {
    private LinkedListNode first;
    private LinkedListNode last;

    public void enqueue(String item) {
        LinkedListNode oldLast = last;

        last = new LinkedListNode();
        last.item = item;

        oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;

        first = first.next;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
