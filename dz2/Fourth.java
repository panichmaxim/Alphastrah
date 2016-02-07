import java.util.Arrays;
import java.util.List;

public class Fourth extends Thread {
    private static Manager sManager = new Manager("Juan Mario Laserna");

    public static void main(String[] args) throws InterruptedException {
        Fourth[] allThreads = new Fourth[1000];
        for (int i = 0; i < allThreads.length; i++) {
            allThreads[i] = new Fourth();
        }

        for (Fourth d : allThreads) {
            d.start();
        }

        for (Fourth d : allThreads) {
            d.join();
        }

        System.out.println(sManager.getManagerName() + ": " + sManager.getGeneration() + " " + sManager.getTotalAmount());
    }

    @Override
    public void run() {
        sManager.workOn(Arrays.asList(new Work(), new Work(), new Work(), new Work(), new Work()));
    }


    class Work {
        private float mAmount = 1.55f;

        public float getAmount() {
            return mAmount;
        }
    }

    static class Manager {
        private int mGeneration;
        private float mTotalAmount;
        private final String mManagerName;
        private final Object mLock = new Object();

        public Manager(String manager) {
            mManagerName = manager;
        }

        /*
            TODO READ COMMENT
            Закомментил странные куски кода, не очень понятно их назначение.
         */

        public void workOn(List<Work> workList) {
            synchronized (mLock) {
                // int curGeneration = mGeneration;
                float amountForThisWork = 0;

                for (Work o : workList) {
                    // mGeneration = curGeneration;
                    amountForThisWork += o.getAmount();
                }

                mTotalAmount += amountForThisWork;
                mGeneration++;
            }
        }

        public int getGeneration() {
            return mGeneration;
        }

        public float getTotalAmount() {
            return mTotalAmount;
        }

        public String getManagerName() {
            return mManagerName;
        }

    }
}
