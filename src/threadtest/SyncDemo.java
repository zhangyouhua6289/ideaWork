package threadtest;

/**
 * @author zyh
 * @date 2020/5/18
 */
public class SyncDemo {
    public static void main(String[] args) {
        Data d = new Data();
        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                d.increment();
            }, "A").start();
            new Thread(() -> {
                d.decrement();
            }, "B").start();
        }
    }
}

class Data {
    private int num = 0;

    public void increment() {
        if (num != 0) {

        }
        num++;
        System.out.println(Thread.currentThread().getName() + "--->" + num);
    }

    public void decrement() {
        if (num == 0) {

        }
        num--;
        System.out.println(Thread.currentThread().getName() + "--->" + num);
    }
}
