package edu.ucalgary.oop;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    private final JFrame FRM = new JFrame();

    //empty constructor atm: 
    public GUIController(){
    }

    public void mainMenu(){
        JPanel mainMenu = new JPanel();

        JButton start = new JButton( new AbstractAction("Begin") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mainMenu.setVisible(false);
                //menuForCategory();
            }
        });

        JButton about = new JButton( new AbstractAction("About") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mainMenu.setVisible(false);
                //about();
            }
        });

        JButton exit = new JButton( new AbstractAction("Quit") {
            @Override
            public void actionPerformed( ActionEvent e ){
                System.exit(0);
            }
        });

        mainMenu.add(start);
        mainMenu.add(about);
        mainMenu.add(exit);
        FRM.add(mainMenu);
        FRM.setTitle("WildLife Rescue Centre");
        FRM.setVisible(true);
        FRM.setSize(500, 100);
        FRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
