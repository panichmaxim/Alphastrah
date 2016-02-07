import java.lang.reflect.Field;

// Починить изменённое значение final в потоках
/*
    TODO READ COMMENT
    Не очень понял задание, если имеется ввиду, что необходимо отобразить в потоках изменения поля рефлексией, то
    1) final поле рефлексией не меняется ( http://www.quizful.net/post/java-reflection-api )
    => убираем final.
    2) Потоки успевают завершится быстрее чем поменялось значение поля, так что один из логичных вариантов переместить рефлекцию до запуска потоков
 */
public class Sixth {
    private /* final */ String test = "Tyger Tyger, burning bright";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final Sixth object = new Sixth();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(object.test);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(object.test);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(object.test);
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(object.test);
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(object.test);
            }
        });

        Field f = object.getClass().getDeclaredField("test");
        f.setAccessible(true);
        f.set(object, "In the forests of the night");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

//        Field f = object.getClass().getDeclaredField("test");
//        f.setAccessible(true);
//        f.set(object, "In the forests of the night");

    }
}
