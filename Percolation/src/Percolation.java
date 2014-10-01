/**
 * Created by eduardo on 24/09/2014.
 */
public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF neighborhood;
    private int size;
    private int height;
    public Percolation(int N) {
        height = N;
        size = N * N;
        grid = new boolean[N][N];
        neighborhood = new WeightedQuickUnionUF(size + 2);
    }

    public void open(int i, int j) {

        check(i, j);

        if (isOpen(i, j)) return;

        int opening = position(i, j);

        grid[i - 1][j - 1] = true;

        if (i == 1)
            union(0, opening);

        if (i == height)
            union(size + 1, opening);

        if (i > 1)
            if (isOpen(i - 1, j))
                union(opening, position(i - 1, j));

        if (i < height)
            if (isOpen(i + 1, j))
                union(opening, position(i + 1, j));

        if (j > 1)
            if (isOpen(i, j - 1))
                union(opening, position(i, j - 1));

        if (j < height)
            if (isOpen(i, j + 1))
                union(opening, position(i, j + 1));

    }

    public boolean isOpen(int i, int j) {
        check(i, j);

        return grid[i - 1][j - 1];
    }

    public boolean isFull(int i, int j) {
        check(i, j);

        return !isOpen(i, j);
    }

    public boolean percolates() {
        return neighborhood.connected(0, size + 1);
    }

    private int position(int i, int j) {
        if (i < 1 || i > height)
            throw new IndexOutOfBoundsException("i is out of bound");

        if (j < 1 || j > height)
            throw new IndexOutOfBoundsException("j is out of bound");

        return ((i - 1) * height) + (j - 1) + 1;
    }

    private void check(int i, int j) {
        if (i < 1 || i > height)
            throw new IndexOutOfBoundsException("i is out of bound");

        if (j < 1 || j > height)
            throw new IndexOutOfBoundsException("j is out of bound");
    }

    private void union(int p, int q) {
        neighborhood.union(p, q);
    }

    public static void main(String[] args) {
        Percolation per = new Percolation(3);

        System.out.println(per.percolates());

        per.open(1, 1);

        System.out.println(per.isOpen(1, 1));
        System.out.println(per.isFull(1, 1));

        System.out.println(per.percolates());

        per.open(1, 3);

        System.out.println(per.percolates());

        per.open(1, 2);

        System.out.println(per.percolates());

        per.open(2, 2);

        System.out.println(per.percolates());

        per.open(3, 2);

        System.out.println(per.percolates());
    }
}