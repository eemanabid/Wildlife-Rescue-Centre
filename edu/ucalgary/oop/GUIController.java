package edu.ucalgary.oop;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    /*
     * When the user clicks the "Generate Schedule" button, 
     * the program will attempt to generate a schedule based on the animal and medical task data
     * If the schedule cannot be generated, an error message will be displayed in the status bar.
     * needs to be able to modify the start hour of one or more of the treatments 
     * based on the error received?
     * 
     * When the user clicks the "Save Schedule" button, 
     * the program will save the current schedule to a file on disk. 
     * If an error occurs while saving the file, 
     * an error message will be displayed in the status bar.
     * 
     * When the user clicks the "Get Confirmation" button, 
     * the program will confirm that a backup volunteer is needed. 
     * If the backup volunteer cannot be reached, 
     * an error message will be displayed in the status bar.
     */


    private final JFrame FRM = new JFrame();

    //empty constructor atm: 
    public GUIController(){
    }

    public void mainMenu(){
        JPanel mainMenu = new JPanel();

        JButton begin = new JButton( new AbstractAction("Begin") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mainMenu.setVisible(false);
                
            }
        });

        JButton about = new JButton( new AbstractAction("About") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mainMenu.setVisible(false);
                about();
            }
        });

        /*
         * update this function so that user cannot quit until 
         * user has confirmed that a backup volunteer has been called
         * if a backup volunteer was needed
         */
        JButton quit = new JButton( new AbstractAction("Quit") {
            @Override
            public void actionPerformed( ActionEvent e ){
                System.exit(0);
                
            }
        });

        mainMenu.add(begin);
        mainMenu.add(about);
        mainMenu.add(quit);
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
        
        JButton back = new JButton( new AbstractAction("Go Back") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                mainMenu();
            }
        });

        JButton quit = new JButton( new AbstractAction("Quit") {
            @Override
            public void actionPerformed( ActionEvent e ){
                System.exit(0);
            }
        });

        menu.add(label1);
        menu.add(back);
        menu.add(quit);

        FRM.add(menu);
    }

    public static void main (String [] args){
        GUIController gui = new GUIController();
        gui.mainMenu();
    }
}
