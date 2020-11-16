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
public class thread1angka extends Thread{
    public void run(){
        for(int i=10; i>=0; i--){
            System.out.println("Angka : "+i);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Thread Angka Berakhir......");
    }
}
