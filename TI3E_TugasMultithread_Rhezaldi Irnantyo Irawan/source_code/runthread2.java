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
public class runthread2 {
    public static void main(String arga[]){
        thread2 cnt = new thread2();
        try{
            while(cnt.isAlive()){
                System.out.println("--------> Minum");
                Thread.sleep(1500);
            }
        }
        catch(InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Thread makan berakhir");
    }
}
