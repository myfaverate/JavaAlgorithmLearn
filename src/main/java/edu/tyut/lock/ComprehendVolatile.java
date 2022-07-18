package edu.tyut.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComprehendVolatile {
    // volatile 轻量级锁、指令重排
    private static int num = 10_0000;
    private static final List<Integer> arr=new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
//        synchronized (arr) {
//            new Thread(() -> {
//                while (num-- > 0) arr.add(num);;
//            }).start();
//            new Thread(() -> {
//                while (num-- > 0) arr.add(num);;
//            }).start();
//            new Thread(() -> {
//                while (num-- > 0) arr.add(num);;
//            }).start();
//            new Thread(() -> {
//                while (num-- > 0) arr.add(num);;
//            }).start();
//            new Thread(() -> {
//                while (num-- > 0) arr.add(num);;
//            }).start();
//        }
        synchronized (arr) {
            Thread thread = new Thread(() -> {
                while (num > 0) {
                    subNum();
                    arr.add(num);
                }
            });
            thread.start();
            thread.join();
            Thread thread1 = new Thread(() -> {
                while (num > 0) {
                    subNum();
                    arr.add(num);
                }
            });
            thread1.start();
            thread1.join();
            Thread thread2 = new Thread(() -> {
                while (num > 0) {
                    subNum();
                    arr.add(num);
                }
            });
            thread2.start();
            thread2.join();
            Thread thread3 = new Thread(() -> {
                while (num > 0) {
                    subNum();
                    arr.add(num);
                }
            });
            thread3.start();
            thread3.join();
            Thread thread4 = new Thread(() -> {
                while (num > 0) {
                    subNum();
                    arr.add(num);
                }
            });
            thread4.start();
            thread4.join();
        }
        arr.sort(Comparator.comparingInt(n -> n)); // 0, 0
        System.out.println(arr);
    }
    private static void subNum(){
        num--;
    }
}
