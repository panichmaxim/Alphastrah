public class Second extends Thread {

    private static volatile int sCounter = 0;
    private final String mName;
    /*
        TODO READ COMMENT
        Аналогично первому примеру не даем потокам одновременно доступ к sCounter
     */
    private static final Object mLock = new Object();

    public Second(String name) {
        mName = name;
    }

    public void run() {
        synchronized (mLock) {
            System.out.println(mName + " start:" + sCounter);
            int c = sCounter;
            sCounter = c + 1;
            System.out.println(mName + " end:" + sCounter);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Second("A").start();
        new Second("B").start();
        new Second("C").start();
        new Second("D").start();
        new Second("E").start();
        new Second("F").start();
        new Second("G").start();
    }

}
