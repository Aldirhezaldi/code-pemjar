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
public class runmultithread2 {
    public static void main(String[] args){
        multithread2a t1 = new multithread2a();
        multithread2b t2 = new multithread2b();
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Pesta berakhir............");
    }
}
