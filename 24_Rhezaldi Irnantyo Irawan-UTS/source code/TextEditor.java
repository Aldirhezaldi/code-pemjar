/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Asus
 */
public class TextEditor {

    private FormTextEditor formtexteditor;
    private JFrame frame;

    FileReader fr = null;
    FileWriter fw = null;
    LineNumberReader lr = null;
    BufferedWriter bw = null;
    BufferedReader br = null;

    public TextEditor(FormTextEditor bacafiletext) {
        this.formtexteditor = bacafiletext;
        this.formtexteditor.getOpenFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenFile();
            }
        });
        this.formtexteditor.getSaveFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveFile();
            }
        });
        this.formtexteditor.getCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacafiletext.getTextPane().requestFocusInWindow();
                Action();
            }
        });
        this.formtexteditor.getPaste().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacafiletext.getTextPane().requestFocusInWindow();
                Action();
            }
        });
        this.formtexteditor.getCut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacafiletext.getTextPane().requestFocusInWindow();
                Action();
            }
        });
        this.formtexteditor.getBold().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacafiletext.getTextPane().requestFocusInWindow();
                Action();
            }
        });
        this.formtexteditor.getItalic().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacafiletext.getTextPane().requestFocusInWindow();
                Action();
            }
        });
        this.formtexteditor.getUnderline().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bacafiletext.getTextPane().requestFocusInWindow();
                Action();
            }
        });
        this.formtexteditor.getFontCl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FontColor();
            }
        });
        this.formtexteditor.getHighlight().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Highlight();
            }
        });
        this.formtexteditor.getSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search();
            }
        });
        this.formtexteditor.getLine().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LineNumber();
            }
        });
        this.formtexteditor.getAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAll();
            }
        });
        this.formtexteditor.getInfo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Information();
            }
        });
        this.formtexteditor.getScreenshoot().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screenshoot();
            }
        });

    }

    private void OpenFile() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        StyledDocument doc = formtexteditor.getTextPane().getStyledDocument();
        String contents = formtexteditor.getTextPane().getText();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(formtexteditor)) {
            try {
                int data;
                doc.insertString(0, "", null);
                fr = new FileReader(loadFile.getSelectedFile());
                lr = new LineNumberReader(fr);
                if (contents != null && !contents.isEmpty()) {
                    formtexteditor.getTextPane().setText("");
                }
                while ((data = lr.read()) != -1) {
                    doc.insertString(doc.getLength(), "" + (char) data, null);
                }
                formtexteditor.getNameFile().setText(loadFile.getSelectedFile().getName());
                lr.close();

            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void SaveFile() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        StyledDocument doc = formtexteditor.getTextPane().getStyledDocument();
        String contents = formtexteditor.getTextPane().getText();
        if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(formtexteditor)) {
            try {
                if (contents != null && !contents.isEmpty()) {
                    fw = new FileWriter(loadFile.getSelectedFile());
                    bw = new BufferedWriter(fw);
                    bw.write(contents);
                    JOptionPane.showMessageDialog(formtexteditor, "File berhasil ditulis.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FormTextEditor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FormTextEditor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (bw != null) {
                    try {
                        bw.flush();
                        bw.close();
                        formtexteditor.getNameFile().setText(loadFile.getSelectedFile().getName());
                    } catch (IOException ex) {
                        Logger.getLogger(FormTextEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    private void Action() {
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                formtexteditor.getTextPane().requestFocusInWindow();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                formtexteditor.getTextPane().requestFocusInWindow();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                formtexteditor.getTextPane().requestFocusInWindow();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                formtexteditor.getTextPane().requestFocusInWindow();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                formtexteditor.getTextPane().requestFocusInWindow();
            }
        };
    }

    private void FontColor() {
        Color newColor = JColorChooser.showDialog(frame, "Choose a color", Color.BLACK);
        if (newColor == null) {
            formtexteditor.getTextPane().requestFocusInWindow();
            return;
        }
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, newColor);
        formtexteditor.getTextPane().setCharacterAttributes(attr, false);
        formtexteditor.getTextPane().requestFocusInWindow();
    }

    private void Highlight() {
        Color newColor = JColorChooser.showDialog(frame, "Choose a color", Color.BLACK);
        if (newColor == null) {
            formtexteditor.getTextPane().requestFocusInWindow();
            return;
        }
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setBackground(attr, newColor);
        formtexteditor.getTextPane().setCharacterAttributes(attr, false);
        formtexteditor.getTextPane().requestFocusInWindow();
    }

    private void Search() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        String contents = formtexteditor.getInputSearch().getText();
        try {
            int banyak = 0;
            String data;
            int baris = 1;
            String[] kata = null;
            String infoBaris = "";
            String info = "";
            fr = new FileReader(loadFile.getSelectedFile());
            lr = new LineNumberReader(fr);
            while ((data = lr.readLine()) != null) {
                kata = data.split("\\s+");
                for (String getWord : kata) {
                    if (getWord.equalsIgnoreCase(contents)) {
                        banyak++;
                        info = "Pada Baris ke : " + lr.getLineNumber() + "\n";
                        infoBaris = infoBaris + info;
                    }
                }
            }
            formtexteditor.getInputSearch().setText("");
            JOptionPane.showMessageDialog(formtexteditor, "Pencarian Kata " + "'" + contents + "'" + "\n\n" + "Berada : \n\n"
                    + infoBaris
                    + "Banyak Kata yang Dicari : " + banyak, "Detail Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LineNumber() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        int contents = Integer.parseInt(formtexteditor.getInputLine().getText());
        try {
            int baris = 0;
            String data;
            fr = new FileReader(loadFile.getSelectedFile());
            lr = new LineNumberReader(fr);

            while ((data = lr.readLine()) != null) {
                if (contents == lr.getLineNumber()) {
                    formtexteditor.getTextPane().setText(data);
                }
            }
            lr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ShowAll() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        StyledDocument doc = formtexteditor.getTextPane().getStyledDocument();
        String contents = formtexteditor.getTextPane().getText();
        try {
            int a;
            fr = new FileReader(loadFile.getSelectedFile());
            lr = new LineNumberReader(fr);
            if (contents != null && !contents.isEmpty()) {
                formtexteditor.getTextPane().setText("");
            }
            while ((a = lr.read()) != -1) {
                doc.insertString(doc.getLength(), "" + (char) a, null);
                formtexteditor.getInputLine().setText("");
            }
            formtexteditor.getNameFile().setText(loadFile.getSelectedFile().getName());
            lr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | BadLocationException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Information() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        try {
            int banyakKata = 0, karakter = 0, baris = 0, banyakKalimat = 0;
            String data;
            fr = new FileReader(loadFile.getSelectedFile());
            lr = new LineNumberReader(fr);
            while ((data = lr.readLine()) != null) {
                String[] kata = data.split("\\s+");
                String[] kalimat = data.split("[.?!]+");
                banyakKata += kata.length;
                karakter += data.length();
                banyakKalimat += kalimat.length;
            }
            baris += lr.getLineNumber();
            JOptionPane.showMessageDialog(formtexteditor, "Detail Teks File\n"
                    + "Baris : " + (baris)
                    + "\nKata : " + (banyakKata)
                    + "\nKarakter : " + karakter
                    + "\nKalimat : " + banyakKalimat, "Detail Informasi", JOptionPane.INFORMATION_MESSAGE);
            lr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Screenshoot() {
        JFileChooser loadFile = formtexteditor.getLoadFile();
        try {
            Rectangle screenrect = this.formtexteditor.getBounds();
            BufferedImage capture = new Robot().createScreenCapture(screenrect);
            ImageIcon icon = new ImageIcon(capture);
            formtexteditor.setIconImage(capture);
            if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(formtexteditor)) {
                ImageIO.write(capture, "png", loadFile.getSelectedFile());
            }
            JOptionPane.showMessageDialog(formtexteditor, "Gambar berhasil disimpan.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | AWTException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
