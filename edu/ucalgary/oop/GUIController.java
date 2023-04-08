package edu.ucalgary.oop;

import java.io.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GUIController {
   
    private final JFrame FRM = new JFrame();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(formatter);
    private RescueCenter rescueCenter;
    JTextArea scheduleArea = new JTextArea();

    
  
    public GUIController(){
        this.rescueCenter = new RescueCenter();
    }

    public void mainMenu(){
        JPanel mainMenu = new JPanel();

        JButton begin = new JButton( new AbstractAction("Get Schedule") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mainMenu.setVisible(false);
                generateSchedule();
            }
        });

        JButton about = new JButton( new AbstractAction("About") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mainMenu.setVisible(false);
                about();
            }
        });

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

    /* When the user clicks the "Generate Schedule" button, 
     * the program will attempt to generate a schedule based on the animal and medical task data
     * If the schedule cannot be generated, an error message will be displayed in the status bar.
     * needs to be able to modify the start hour of one or more of the treatments 
     * based on the error received?
     */
    public void generateSchedule(){
        // call modify start hour if the desired schedule does not genertae 
        // use get confirmation button so that if a volunteer was needed it can be confirmed
        // if save schedule is pressed when confirmation for backup is needed give error message
        // go to save schedule if backup volunteer is not needed

        FRM.setSize(600, 500);
        FRM.setResizable(true);
        FRM.setVisible(true);
        FRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menu = new JPanel(new BorderLayout());
        
        // this is just testing code: the schedule will be called here
        scheduleArea.setLineWrap(true);
        scheduleArea.setText("Schedule for " + formattedDate + "\n\n");

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
    
    
        for (int hour = 0; hour <= 23; hour++) {
            StringBuilder hourSchedule = new StringBuilder();
            hourSchedule.append(hour + ":00");
        
            boolean hasTasks = false;
            int duration = 0;
            for (Treatment treatment : rescueCenter.getTreatmentList()) {
                if (treatment.getStartHour() == hour) {
                    int taskID = treatment.getTaskID();
                    Task task = rescueCenter.getTaskByID(taskID);
                    duration += task.getDuration();
                }
            }

            if (duration > 60) {
                hourSchedule.append(" [ + backup volunteer]\n");
            }
            else {
                hourSchedule.append("\n");
            }

            for (Treatment treatment : rescueCenter.getTreatmentList()) {
                if (treatment.getStartHour() == hour) {
                    int taskID = treatment.getTaskID();
                    int animalID = treatment.getAnimalID();
                    Task task = rescueCenter.getTaskByID(taskID);
                    String taskDescription = task.getDescription();
                    Animal animal = rescueCenter.getAnimalByID(animalID);
                    String animalNickname = animal.getAnimalNickname();
                    //duration += task.getDuration();
                    hourSchedule.append("* " + taskDescription + " " + "(" + animalNickname + ")" + task.getDuration() + "\n");
                    hasTasks = true;
                }
            }

            for (Animal animal : rescueCenter.getAnimalList()) {
            
                if (animal.getActiveType() == "nocturnal") {
                    if (hour >= 0 && hour < 3) {
                        String animalNickname = animal.getAnimalNickname();
                        String animalSpecies = animal.getAnimalSpecies();
                        duration += animal.getFeedTime() + animal.getPrepTime();
                        hourSchedule.append("* " + "Feeding - " + animalSpecies + "es"+ " " + "(" + animalNickname + ")" + duration + "\n");
                        hasTasks = true;
                    }
                }
                if (animal.getActiveType() == "diurnal") {
                    if (hour >= 8 && hour < 11) {
                        String animalNickname = animal.getAnimalNickname();
                        String animalSpecies = animal.getAnimalSpecies();
                        duration += animal.getFeedTime() + animal.getPrepTime();
                        hourSchedule.append("* " + "Feeding - " + animalSpecies + "s"+ " " + "(" + animalNickname + ")" + duration + "\n");
                        hasTasks = true;
                    }
                }

                if (animal.getActiveType() == "crepuscular" ) {
                    if (hour >= 19 && hour < 22) {
                        String animalNickname = animal.getAnimalNickname();
                        String animalSpecies = animal.getAnimalSpecies();
                        duration += animal.getFeedTime() + animal.getPrepTime();
                        hourSchedule.append("* " + "Feeding - " + animalSpecies + "s"+ " " + "(" + animalNickname + ")" + duration +"\n");
                        hasTasks = true;
                    }
                }
            }
        
            if (hasTasks) {
                JTextArea hourTextArea = new JTextArea(hourSchedule.toString());
                hourTextArea.setEditable(false);
                scrollPanel.add(hourTextArea);
            }
        }
        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        menu.add(scrollPane, BorderLayout.CENTER);
        
        scheduleArea.append("\n\n" + "If a backup volunteer is needed, please get confirmation before saving schedule." + "\n\n");
        menu.add(scheduleArea, BorderLayout.SOUTH);

        // get schedule page buttons 
        JButton save = new JButton( new AbstractAction("Save") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                saveSchedule();
            }
        });

        JButton modify = new JButton( new AbstractAction("Modify Schedule") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                modifyStartHour();
            }
        });

        JButton confirm = new JButton( new AbstractAction("Get Confirmation") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                getConfirmation();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(save);
        buttonPanel.add(modify);
        buttonPanel.add(confirm);
        menu.add(buttonPanel, BorderLayout.SOUTH);
        FRM.add(menu);
    }

    public void modifyStartHour(){
        // modify start hours and call generate schedule for new schedule
        FRM.setSize(600, 500);
        FRM.setResizable(false);
        FRM.setVisible(true);
        FRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menu = new JPanel(new BorderLayout());

        // modify start hour page buttons 
        JButton begin = new JButton( new AbstractAction("Get Schedule") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                menu.setVisible(false);
                generateSchedule();
            }
        });

        JButton modify = new JButton( new AbstractAction("Modify Schedule") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                modifyStartHour();
            }
        });

        JButton confirm = new JButton( new AbstractAction("Get Confirmation") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                getConfirmation();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(begin);
        buttonPanel.add(modify);
        buttonPanel.add(confirm);
        menu.add(buttonPanel, BorderLayout.SOUTH);
        FRM.add(menu);
    }

    /* When the user clicks the "Get Confirmation" button, 
    * the program will confirm that a backup volunteer is needed. 
    * If the backup volunteer cannot be reached, 
    * an error message will be displayed in the status bar.
    */
    public void getConfirmation(){
        // add save schdeule button so that after confirming the schedule file can be generated
        FRM.setSize(600, 500);
        FRM.setResizable(false);
        FRM.setVisible(true);
        FRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menu = new JPanel(new BorderLayout());

        // modify start hour page buttons 
        JButton save = new JButton( new AbstractAction("Save") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                saveSchedule();
            }
        });

        JButton quit = new JButton( new AbstractAction("Quit") {
            @Override
            public void actionPerformed( ActionEvent e ){
                System.exit(0);
                
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(save);
        buttonPanel.add(quit);
        menu.add(buttonPanel, BorderLayout.SOUTH);
        FRM.add(menu);
    }

    /* When the user clicks the "Save Schedule" button, 
     * the program will save the current schedule to a file on disk. 
     * If an error occurs while saving the file, 
     * an error message will be displayed in the status bar.
     */
    public void saveSchedule(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(FRM);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(selectedFile);
                writer.write(scheduleArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(FRM, "Schedule saved successfully!", "Save Schedule", JOptionPane.INFORMATION_MESSAGE);
                FRM.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(FRM, "Error saving schedule. Please try again.", "Save Schedule", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main (String [] args){
        GUIController gui = new GUIController();
        gui.mainMenu();
    }
}
