/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasjs8;

/**
 *
 * @author User
 */
public class runMultithreadTugas {
    public static void main(String[] args){
        thread1angka t1 = new thread1angka();
        thread2huruf t2 = new thread2huruf();
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Berakhir");
    }
}
