import edu.columbia.cs.psl.phosphor.runtime.Tainter;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by max on 25/6/2017.
 */




public class Selective {

    static class RunMe implements Runnable {

        public int add(int a, int b) {
            return a + b;
        }

        @Override
        public void run() {
            add(1, 2);
        }
    }

    static class TestClass {
        int _1, _2;
        int[] arr = new int[10];
        TestClass(int a, int b) {
            _1 = a;
            _2 = b;
        }
        int add() {
            return _1 + _2 + arr[0];
        }

    }

    public static void main(String[] args) {
        int aa[][] = new int[3][3];
        System.out.println(aa);
        aa[0] = new int[4];
        TestClass c = new TestClass(Tainter.taintedInt(1, 2), Tainter.taintedInt(1, 4));
        int r = c.add();
        Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread();
            }
        }).execute(new RunMe());
        new RunMe().run();
        System.out.println(r);
        String a = "hello";
        char[] cr = a.toCharArray();
    }

}
