import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class First {

    private static List<Integer> sBalls = new ArrayList<>();
    private static boolean sRun = true;
    /*
        TODO READ COMMENT
        Не даем потокам одновременно доступ к редактированию/просмотру sBalls
     */
    private static final Object mLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(3);
        e.execute(new UpTask());
        e.execute(new ReadTask());
        e.execute(new UpTask());

        Thread.sleep(1000);
        sRun = false;
    }

    static class UpTask implements Runnable {

        @Override
        public void run() {
            while(sRun) {
                synchronized (mLock) {
                    sBalls.add((int) (10000 * Math.random()));
                }
            }
            System.out.println("UpTask: end");
        }
    }


    static class ReadTask implements Runnable {

        @Override
        public void run() {
            while (sRun) {
                synchronized (mLock) {
                System.out.println("Size : " + sBalls.size());
                    for (Integer i : sBalls) {
                        if (i % 500 == 0) {
                            System.out.println(i);
                        }
                    }
                }
            }
            System.out.println("ReadTask: end");
        }
    }

}
