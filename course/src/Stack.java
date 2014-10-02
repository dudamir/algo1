/**
 * Created by eduardo on 02/10/2014.
 */
public class Stack<Item> {
    private LinkedListNode<Item> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void Push(Item item) {
        LinkedListNode<Item> node = new LinkedListNode<Item>();
        node.item = item;
        node.next = first;

        first = node;
    }
    public Item Pop() {
        Item item = first.item;

        first = first.next;

        return item;
    }
}
