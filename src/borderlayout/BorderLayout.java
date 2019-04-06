package borderlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class BorderLayout extends JFrame{
    
    JLabel labelMessage;
    JTextField fieldMessage;
    JButton buttonSubmit, buttonClean;
    JTextArea areaCenter;
    
    public BorderLayout(){
        createView();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 300));
        this.setTitle("Border Layout");
        this.setLocationRelativeTo(null);
    }
    
    public void createView(){
        JPanel panelMain = new JPanel(new java.awt.BorderLayout());
        this.getContentPane().add(panelMain);
        panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //North
        JPanel panelNorth = new JPanel(new java.awt.BorderLayout());
        panelMain.add(panelNorth, java.awt.BorderLayout.NORTH);
        
        labelMessage = new JLabel("Enter a message:");
        panelNorth.add(labelMessage, java.awt.BorderLayout.WEST);
        
        fieldMessage = new JTextField();
        panelNorth.add(fieldMessage, java.awt.BorderLayout.CENTER);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                areaCenter.append(fieldMessage.getText() + "\n");
            }      
        });
        panelNorth.add(buttonSubmit, java.awt.BorderLayout.EAST);
        //
        //Center
        JPanel panelCenter = new JPanel(new java.awt.BorderLayout());
        panelMain.add(panelCenter);
        
        areaCenter = new JTextArea();
        areaCenter.setEditable(false);
        areaCenter.setWrapStyleWord(true);
        areaCenter.setLineWrap(true);
        panelCenter.add(areaCenter);
        JScrollPane scroll = new JScrollPane(areaCenter);
        panelCenter.add(scroll);
        //
        //South
        JPanel panelSouth = new JPanel();
        panelMain.add(panelSouth, java.awt.BorderLayout.SOUTH);
        
        buttonClean = new JButton("Clean");
        buttonClean.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                areaCenter.setText("");
            }       
        });
        panelSouth.add(buttonClean);
        //
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new BorderLayout().setVisible(true);
            }
        });
    }
    
}
