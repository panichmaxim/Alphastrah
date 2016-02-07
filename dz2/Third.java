public class Third extends Thread {

    private static volatile int sCommon = 0;

    public void run() {
        // TODO READ COMMENT
        // sCommon = sCommon++; // весьма странная операция, если задача просто в подсчете с помощью sCommon количества потоков, то это явно ошибка.
        sCommon++;
        System.out.println(sCommon);
    }

    public static void main(String[] args) throws InterruptedException {
        Third[] allThreads = new Third[100000];

        for (int i = 0; i < allThreads.length; i++) {
            allThreads[i] = new Third();
        }

        new Third().start();
        for (Third d : allThreads) {
            d.start();
            new Third().start();
        }
        new Third().start();

    }
}
