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
public class thread2 extends Thread{
    thread2(){
        super("Tes Thread");
        System.out.println("my thread created"+this);
        start();
    }
    public void run(){
        try{
            for(int i=0; i<10; i++){
                System.out.println("makan yang ke "+i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Thread interrupted");
        }
        System.out.println("Pesta makan berakhir");
    }
}
