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

    public void about(){
        FRM.setSize(500, 125);
        FRM.setResizable(false);
        FRM.setVisible(true);
        FRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menu = new JPanel();

        JLabel label1 = new JLabel("Made by: Eeman Abid, Hareem Khan, Hooriya Amjad, Sahiti Akella");
        //JLabel label2 = new JLabel("Instructions for use: Follow the menus and enter the data which is required");

        JButton goBack = new JButton( new AbstractAction("Go Back") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                mainMenu();
            }
        });

        JButton exit = new JButton( new AbstractAction("Quit") {
            @Override
            public void actionPerformed( ActionEvent e ){
                System.exit(0);
            }
        });

        menu.add(label1);
        //menu.add(label2);
        menu.add(goBack);
        menu.add(exit);

        FRM.add(menu);
    }

    public static void main (String [] args){
        GUIController gui = new GUIController();
        gui.mainMenu();
    }
}
