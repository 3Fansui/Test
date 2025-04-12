package lock;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int[] count = new int[1];
        count[0] = 1000;
        List<Thread> list = new ArrayList<>();
        MyLock lock = new MyLock();
        for (int i = 0; i < 5; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    lock.lock();
                    count[0]--;
                }
                for (int j = 0; j < 5; j++) {
                    lock.unlock();
                }
            }));
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println(count[0]);
    }
}
