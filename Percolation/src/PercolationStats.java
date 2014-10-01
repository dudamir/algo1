/**
 * Created by eduardo on 25/09/2014.
 */
public class PercolationStats {

    private final int[] runs;
    private final int numberOfRuns;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N < 0) throw new IllegalArgumentException();
        if (T < 0) throw new IllegalArgumentException();

        numberOfRuns = T;

        runs = new int[numberOfRuns];

        for (int i = 0; i < T; i++) {
            runs[i] = runPercolation(N);
        }
    }

    private int runPercolation(int N) {
        Percolation percolation = new Percolation(N);

        int openedSites = 0;
        while (!percolation.percolates()) {
            int i = StdRandom.uniform(1, N+1);
            int j = StdRandom.uniform(1, N+1);

            if (percolation.isFull(i, j)) {
                percolation.open(i, j);
                openedSites++;
            }
        }

        return openedSites;
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(runs);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(runs);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - confidenceMultiplier();
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + confidenceMultiplier();
    }

    private double confidenceMultiplier() {
        return ((1.96*stddev())/Math.sqrt(numberOfRuns));
    }

    // test client, described below
    public static void main(String[] args) {

        int n = 0;
        int t = 0;

        int i = 0;
        while (i < args.length - 1)
        {
            if (args[i].equals("N"))
                n = Integer.parseInt(args[++i]);
            else if (args[i].equals("T"))
                t = Integer.parseInt(args[++i]);

            i++;
        }

        if (n <= 0 || t <= 0)
            throw new IllegalArgumentException("must inform N <int> T <int>");

        PercolationStats stats = new PercolationStats(n, t);

        StdOut.printf("%% java PercolationStats %1d %2d", n, t);
        StdOut.println();
        StdOut.printf("mean                    = %1f", stats.mean());
        StdOut.println();
        StdOut.printf("stddev                  = %1f", stats.stddev());
        StdOut.println();
        StdOut.printf("95%% confidence interval = %1f, %2f", stats.confidenceLo(), stats.confidenceHi());
    }
}
