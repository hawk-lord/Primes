package ax.joint;

import java.util.Arrays;

/**
 * Algorithm P (Print table of 500 primes).
 * The Art of Computer Programming, section 1.3.2'
 *
 */
public class Main {

    static final int L = 500;
    static int n;
    static int q;
    static int r;
    static int jj;
    static int kk;
    static int pk;

    static int[] prime = new int[L];

    public static void main(String[] args) {

        prime[0] = 2;
        // P1
        n = 3;
        jj = 1;

        /*
         * Since there is no goto statement in Java, I use this variable to check if we
         * are coming from step P8 or not.
         */
        boolean fromP8 = false;

        createTable: do {
            do {
                if (!fromP8) {
                    // P2
                    prime[jj] = n;
                    jj++;
                    // P3
                    if (jj == 500) {
                        break createTable;
                    }
                }
                do {
                    if (!fromP8) {
                        // P4
                        n += 2;
                        // P5
                        kk = 2;
                    }
                    // P6
                    pk = prime[kk-1];
                    q = n / pk;
                    r = n % pk;
                    fromP8 = false;
                } while (r == 0);
                // P7 large if q <= pk
            } while (q <= pk);
            // P8 should go to P6
            fromP8 = true;
            kk++;
        } while (true);

        // P9 to P11
        System.out.println(Arrays.toString(prime));

    }
}
