package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExcutorPool {
    public static void main(String[] args) {
////        ExecutorService spool = Executors.newSingleThreadExecutor();
////        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService pool = Executors.newCachedThreadPool();
//
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        MyThread t3 = new MyThread();
//        MyThread t4 = new MyThread();
//        MyThread t5 = new MyThread();
//        //放入线程池中
//        pool.execute(t1);
//        pool.execute(t2);
//        pool.execute(t3);
//        pool.execute(t4);
//        pool.execute(t5);
//        //关闭线程池
//        pool.shutdown();
        Resource resource = new Resource();
        Thread t1 = new Thread(new Producer(resource));
        Thread t2 = new Thread(new Consumer(resource));
        t1.start();
        t2.start();
    }


}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行.....");
    }
}

class Resource{
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set (String name){
        //生产资源
        while (flag){
            try {
                Thread.sleep(1000);
                wait();//等待消费者消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name+"---"+count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void out(){
        //消费资源
        while (!flag){
            try {

                wait();//等待生产者生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
        flag = false;
        this.notifyAll();
    }

}
class Producer implements Runnable{
    private Resource res;
    public Producer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true)
        res.set("商品");
    }
}

class Consumer implements Runnable{
    private Resource res;
    public Consumer(Resource res) {
        this.res = res;
    }
    @Override
    public void run() {
        while (true)
        res.out();
    }
}