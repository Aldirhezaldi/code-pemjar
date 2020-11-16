/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minggu3;

/**
 *
 * @author User
 */
import java.io.*;
public class Soal1Input {
    public static void main(String []args){
        if(args.length != 1) {
            System.err.println("Syntax - FileInputStreamDemo file");
            return;
        }
        try{
            //Membuat input stram yang membaca dari file
            InputStream fileInput = new FileInputStream(args[0]);
            int data = fileInput.read(); //Baca byte ke 1
            while (data != -1) //ulangi : hingga end of file (EOF) dicapai
            {
                data = fileInput.read(); // baca byte berikutnya
            }
            fileInput.close(); // Close the file
    }
        catch(IOException ioe){
            System.err.println("I/O error -" + ioe);
        }
}}
