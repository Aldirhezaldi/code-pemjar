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
public class multithread2b extends Thread{
    public void run(){
        for(int i = 0; i <=10; i++){
            System.out.println("Minum : "+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
