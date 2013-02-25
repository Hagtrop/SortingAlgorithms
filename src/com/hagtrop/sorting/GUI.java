package com.hagtrop.sorting;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton fileBtn, startBtn;
    private JTextField fileField, resultField;
    private File sourceFile;
    private String inputFileName, outputFileName;
    private JLabel inputLbl, outputLbl;
    private JRadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    public static void main(String args[]){
        new GUI();
    }
    GUI(){
        //Меняем тему оформления со стандартной на "Nimibus"
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Настраиваем форму
        setTitle("Алгоритмы сортировки");
        setSize(280,280);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        
        add(Box.createVerticalStrut(5));
        add(fileChooseBox());
        add(Box.createVerticalStrut(10));
        add(radioBtnBox());
        add(Box.createVerticalStrut(10));
        add(resultBox());
        add(Box.createHorizontalStrut(10));
        
        setVisible(true);
    }
    private Box fileChooseBox(){
        //Создаём горизонтальный Box с полем и кнопкой
        Box box = Box.createHorizontalBox();
        fileField = new JTextField("Выбор файла", 15);
        fileField.setMaximumSize(fileField.getPreferredSize());
        fileBtn = new JButton("File");
        fileBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fileBtnActionPerformed();
            }
        });
        box.add(fileField);
        box.add(fileBtn);
        box.add(Box.createHorizontalGlue());
        box.setAlignmentX(LEFT_ALIGNMENT);
        //Имена входного и выходного файлов
        inputLbl = new JLabel("Input:");
        outputLbl = new JLabel("Output:");
        //Создаём вертикальный Box для box и filePathLbl
        Box parentBox = Box.createVerticalBox();
        parentBox.add(box);
        parentBox.add(inputLbl);
        parentBox.add(outputLbl);
        parentBox.setAlignmentX(LEFT_ALIGNMENT);
        
        return parentBox;
    }
    private Box radioBtnBox(){
        Box box = Box.createVerticalBox();
        ButtonGroup group = new ButtonGroup();
        rb1 = new JRadioButton("Сортировка методом Пузырька");
        group.add(rb1);
        rb2 = new JRadioButton("Сортировка выборкой");
        group.add(rb2);
        rb3 = new JRadioButton("Сортировка вставками");
        group.add(rb3);
        rb4 = new JRadioButton("Сортировка слиянием");
        group.add(rb4);
        rb5 = new JRadioButton("Сортировка Шелла");
        group.add(rb5);
        rb6 = new JRadioButton("Быстрая сортировка");
        group.add(rb6);
        
        box.add(rb1);
        box.add(rb2);
        box.add(rb3);
        box.add(rb4);
        box.add(rb5);
        box.add(rb6);
        
        return box;
    }
    private Box resultBox(){
        Box box = Box.createHorizontalBox();
        box.setAlignmentX(LEFT_ALIGNMENT);
        startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startBtnActionPerformed();
            }
        });
        resultField = new JTextField(8);
        resultField.setMaximumSize(resultField.getPreferredSize());
        box.add(startBtn);
        box.add(resultField);
        return box;
    }
    private void fileBtnActionPerformed(){
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION){
            sourceFile = fileChooser.getSelectedFile();
            fileField.setText(sourceFile.getAbsolutePath());
            inputFileName = sourceFile.getName();
            inputLbl.setText("Input: " + inputFileName);
            int pos = inputFileName.lastIndexOf(".");
            if(pos>=0){
                StringBuilder sb = new StringBuilder(inputFileName);
                sb.insert(pos, "_sorted");
                outputFileName = sb.toString();
                //outputFileName = inputFileName.substring(0,pos) + "_sorted" + 
            }
            else{
                outputFileName = inputFileName + "_sorted";
            }
            outputLbl.setText("Output: " + outputFileName);
        }
    }
    private void startBtnActionPerformed(){
        try{
            ArrayList<Integer> array = MyFileReader.getArray(sourceFile);
            for(Integer n : array){
                System.out.print(n + " ");
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
    
}
