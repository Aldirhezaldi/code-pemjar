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
public class thread1 extends Thread{
    public void run(){
        System.out.println("Uji coba Thread sederhana");
    }
    public static void main(String args[]){
        thread1 obj = new thread1();
        obj.start();
    }
}
