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
public class thread2huruf extends Thread{
    public void run(){
        for(char i='A'; i<='Z'; i++){
            System.out.println("Abjad : "+i);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Thread Abjad Berakhir......");
    }
}
