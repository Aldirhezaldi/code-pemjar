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
public class multithread1 implements Runnable{
    public void run(){
        System.out.println("Ujicoba multithread");
    }
    public static void main(String args[]){
        multithread1 obj = new multithread1();
        Thread tobj = new Thread(obj);
        tobj.start();
    }
}
