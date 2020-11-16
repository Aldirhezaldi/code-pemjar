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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
public class Soal2Controller {
    private Soal2 view;
    
    public Soal2Controller(Soal2 view){
        this.view = view;
        this.view.getBtBaca().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     proses();
                 } catch (BadLocationException ex) {
                     Logger.getLogger(Soal2Controller.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });
    }
    
    private void proses() throws BadLocationException {
         JFileChooser loadFile = view.getLoadFile();
         StyledDocument doc = view.getTxtPane().getStyledDocument();
         if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
             InputStream inputStream = null;
             try {
                 inputStream = new FileInputStream(loadFile.getSelectedFile());
                 int read = inputStream.read();
                 doc.insertString(0, "", null);
                 while (read != -1) {
                     doc.insertString(doc.getLength(), "" + (char)read, null);
                     System.out.print("" + (char)read);
                     read = inputStream.read();
                 }
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Soal2Controller.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException | BadLocationException ex) {
                 Logger.getLogger(Soal2Controller.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (inputStream != null) {
                     try {
                         inputStream.close();
                     } catch (IOException ex) {
                         Logger.getLogger(Soal2Controller.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
         }
     }
}
