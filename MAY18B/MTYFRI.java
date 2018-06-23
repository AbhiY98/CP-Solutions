import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;
�
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author abhiy13
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
�
    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            ArrayList<Long> a = new ArrayList<Long>();
            ArrayList<Long> b = new ArrayList<Long>();
            long s = 0, p = 0, x;
            long n = in.nextLong();
            long k = in.nextLong();
            for (int i = 0; i < n; i++) {
                x = in.nextLong();
                if (i % 2 == 1) {
                    p += x;
                    b.add(x);
                } else {
                    s += x;
                    a.add(x);
                }
            }
            if (p > s) {
                out.println("YES");
            } else {
                Collections.sort(a, Collections.reverseOrder());
                Collections.sort(b);
                boolean ok = false;
                long h = Math.min(k, b.size());
                for (int i = 0; i < h; i++) {
                    long dif = a.get(i) - b.get(i);
                    p += dif;
                    s -= dif;
                }
                if (p > s) {
                    ok = true;
                }
                if (ok) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
        }
�
    }
�
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
�
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
�
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
�
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
�
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
�
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
�
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
�
        public String next() {
            return nextString();
        }
�
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
�
        }
�
    }
}
�
 