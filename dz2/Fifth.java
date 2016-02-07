import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*
    TODO READ COMMENT
    1. Была ошибка с counter (56-59 строка), мы пытались считать элемент с ключом 0, в то время как в списке нумерация начиналась с 1.
    Исправил нумерацию, теперь она с 0.
    2. Опять таки возможно я неправильно понял задание, но ошибка ясна - при удалении работника с fio "f" остальные потоки видят это изменение и
    когда мы пробуем пройтись по final листу sFioList и вытащить бонус работника "f" у нас падает nullpointerexception т.к такого работника уже нет.
    Тут мы либо делаем try, catch и ловим null, либо при удалении работника меняем и список sFioList. Я выбрал первый вариант.
 */
public class Fifth extends Thread {

    private static final List<String> sFioList = Arrays.asList("a", "b", "c", "d", "e", "f", "j", "h", "i");
    private static final BonusForWorkers sBonusManager = new BonusForWorkers();

    public static void main(String[] args) throws InterruptedException {
        for (String item : sFioList) {
            sBonusManager.addBonusForWorker(item, new Bonus((int) (10000 * Math.random())));
        }

        Fifth[] allThreads = new Fifth[1000];
        for (int i = 0; i < allThreads.length; i++) {
            allThreads[i] = new Fifth();
        }

        for (int i = 0; i < allThreads.length; i++) {
            Fifth d = allThreads[i];
            d.start();

            if (i == 600) {
                sBonusManager.removeWorker(sFioList.get(5));
            }
        }

        for (Fifth d : allThreads) {
            d.join();
        }
    }

    @Override
    public void run() {
        for (String fio : sFioList) {
            System.out.println(fio + ": " + sBonusManager.getBonusForWorker(fio));
        }
    }

    public static class BonusForWorkers {
        private ConcurrentHashMap<String, String> mFioToId = new ConcurrentHashMap<>();
        private ConcurrentHashMap<String, Bonus> mIdToBonus = new ConcurrentHashMap<>();
        private final Object object = new Object();
        private int counter = 0;

        public void addBonusForWorker(String fio, Bonus bonus) {
            synchronized (object) {
                mFioToId.put(fio, String.valueOf(counter));
                mIdToBonus.put(String.valueOf(counter), bonus);
                counter++; // ERROR NUMBER 1.
            }
        }

        public void removeWorker(String fio) {
            String id = mFioToId.get(fio);
            mIdToBonus.remove(id);
            mFioToId.remove(fio);
        }

        public double getBonusForWorker(String fio) {
            // ERROR NUMBER 2.
            try {
                String serialNum = mFioToId.get(fio);
                Bonus bonus = mIdToBonus.get(serialNum);
                return bonus.getSum();
            } catch (NullPointerException e) {
                return -1;
            }
        }
    }

    static  class Bonus {
        private int mSum;

        public Bonus(int sum) {
            mSum = sum;
        }

        public int getSum() {
            return mSum;
        }
    }

}
