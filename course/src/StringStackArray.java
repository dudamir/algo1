/**
 * Created by eduardo on 02/10/2014.
 */
public class StringStackArray {

    private String[] s;
    private int N;

    public StringStackArray(int capacity) {
        s = new String[capacity];
    }
    public boolean isEmpty() {
        return s.length > 0;
    }

    public void Push(String value) {
        s[N++] = value;
    }

    public String Pop() {
        return s[N--];
    }
}
