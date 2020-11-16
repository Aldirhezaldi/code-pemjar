/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcecode;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class waitingthread {

    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            
            public void run() {
                try {
                    processor.producre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class Processor{
    private List<Integer> list = new ArrayList<>();
    private int LIMIT =5;
    private int BOTTOM = 0;
    private int value = 0;
    private Object lock = new Object();

    public void producre() throws InterruptedException{
        synchronized (lock){
            while(true){

                if(list.size() == LIMIT){
                    System.out.println("waiting remove list..");
                    lock.wait();
                }else{
                    System.out.println("Adding :"+value);
                    list.add(value);
                    value++;
                    lock.notify(); // memberi sinyal pada threead yang sedang sleep/wait
                }
            }
        }
    }
    public void consumer() throws InterruptedException{
        synchronized (lock){
            while(true){

                if(list.size() == BOTTOM){
                    System.out.println("waiting add list..");
                    lock.wait();
                }else{
                    System.out.println("Removing :"+ list.remove(--value));
                    lock.notify(); // memberi sinyal pada threead yang sedang sleep/wait
                }
            }
        }
    }

}