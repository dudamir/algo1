/**
 * Created by eduardo on 02/10/2014.
 */
public class StringStack {

    private LinkedListNode first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void Push(String value) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.item = value;
        newNode.next = first;

        first = newNode;
    }

    public String Pop() {

        String ret = first.item;

        first = first.next;

        return ret;
    }
}
