package edu.ucalgary.oop;

import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.*;

public class GUIController implements ScheduleFormatter{
   
    private final JFrame FRM = new JFrame();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(formatter);
    private RescueCenter rescueCenter;
    JTextArea scheduleArea = new JTextArea();
    JTextArea hourTextArea = new JTextArea();
    private boolean backup; 
    JPanel scrollPanel = new JPanel();
  
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
        scrollPanel.removeAll();
        scheduleArea.setText("");
        hourTextArea.setText("");
        // this is just testing code: the schedule will be called here
        scheduleArea.setLineWrap(true);
        scheduleArea.setText("Schedule for " + formattedDate);

        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));

        scrollPanel.add(scheduleArea, BorderLayout.NORTH);

        scheduleFormatter();

        JPanel messagePanel = new JPanel();
        messagePanel.add(new JLabel("If backup volunteer(s) is needed, please get confirmation before saving schedule."));
        scrollPanel.add(messagePanel, BorderLayout.SOUTH);
 
        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        menu.add(scrollPane, BorderLayout.CENTER);

        // get schedule page buttons 
        JButton save = new JButton( new AbstractAction("Save") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                if (backup) {
                    JOptionPane.showMessageDialog(FRM, "Please confirm that the backup(s) have been called before saving the schedule.");
                } else {
                    saveSchedule();
                }
            }
        });

        JButton modify = new JButton( new AbstractAction("Modify Schedule") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                modifyStartHour();
            }
        });

        JButton confirm = new JButton( new AbstractAction("Confirm Backup(s)") {
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

    @Override
    public void scheduleFormatter(){
        for (int hour = 0; hour <= 23; hour++) {
            StringBuilder hourSchedule = new StringBuilder();
            hourSchedule.append("\n" + hour + ":00" + "\n");
       
            boolean hasTasks = false;
            int duration = 0;
            int remainingTime = 60;
           
            for (Treatment treatment : rescueCenter.getTreatmentList()) {
                if (treatment.getStartHour() == hour) {
                    int taskID = treatment.getTaskID();
                    int animalID = treatment.getAnimalID();
                    Task task = rescueCenter.getTaskByID(taskID);
                    String taskDescription = task.getDescription();
                    Animal animal = rescueCenter.getAnimalByID(animalID);
                    String animalNickname = animal.getAnimalNickname();
                    duration += task.getDuration();
                    remainingTime -= duration;
                    hourSchedule.append("* " + taskDescription + " " + "(" + animalNickname + ")" + duration + "\n");
                    hasTasks = true;
                }
            }
 
            ArrayList<String> foxesFed = new ArrayList<>();
            ArrayList<String> raccoonsFed = new ArrayList<>();
            ArrayList<String> beaversFed = new ArrayList<>();
            ArrayList<String> porcupinesFed = new ArrayList<>();
            ArrayList<String> coyotesFed = new ArrayList<>();
            for (Animal animal : rescueCenter.getAnimalList()) {
                boolean printed = animal.isFeedingPrinted();
                if (animal.getActiveType() == "nocturnal") {
                    if (hour >= 0 && hour < 3) {
                        if (!printed){
                            String animalNickname = animal.getAnimalNickname();
                            String animalSpecies = animal.getAnimalSpecies();
                            duration += animal.getFeedTime() + animal.getPrepTime();
                            remainingTime -= duration;
                            if (animalSpecies.equals("fox")){
                                foxesFed.add(animalNickname);
                            }
                            if (animalSpecies.equals("raccoon")){
                                raccoonsFed.add(animalNickname);
                            }
                            animal.setFeedingPrinted(true);
                        }
                        /* 
                        if(!printed){
                            String animalNickname = animal.getAnimalNickname();
                            String animalSpecies = animal.getAnimalSpecies();
                            duration += animal.getFeedTime() + animal.getPrepTime();
                            hourSchedule.append("* " + "Feeding - " + animalSpecies + "es"+ " " + "(" + animalNickname + ")" + duration + "\n");
                            animal.setFeedingPrinted(true);
                        }*/
                        hasTasks = true;
                    }
                }
                if (animal.getActiveType() == "diurnal") {
                    if (hour >= 8 && hour < 11) {
                        if (!printed){
                            String animalNickname = animal.getAnimalNickname();
                            String animalSpecies = animal.getAnimalSpecies();
                            duration += animal.getFeedTime() + animal.getPrepTime();
                            remainingTime -= duration;
                            if (animalSpecies.equals("beaver")){
                                beaversFed.add(animalNickname);
                            }
                            animal.setFeedingPrinted(true);
                        }
                        /* 
                        if(!printed){
                            String animalNickname = animal.getAnimalNickname();
                            String animalSpecies = animal.getAnimalSpecies();
                            duration += animal.getFeedTime() + animal.getPrepTime();
                            hourSchedule.append("* " + "Feeding - " + animalSpecies + "s"+ " " + "(" + animalNickname + ")" + duration + "\n");
                            animal.setFeedingPrinted(true);
                        }
                    */
                        hasTasks = true;
                    }
                }
 
 
                if (animal.getActiveType() == "crepuscular" ) {
                    if (hour >= 19 && hour < 22) {
                        if (!printed){
                            String animalNickname = animal.getAnimalNickname();
                            String animalSpecies = animal.getAnimalSpecies();
                            duration += animal.getFeedTime() + animal.getPrepTime();
                            remainingTime -= duration;
                            if (animalSpecies.equals("coyote")){
                                coyotesFed.add(animalNickname);
                            }
                            if (animalSpecies.equals("porcupine")){
                                porcupinesFed.add(animalNickname);
                            }
                            animal.setFeedingPrinted(true);
                        }
                        /* 
                        if(!printed){
                            String animalNickname = animal.getAnimalNickname();
                            String animalSpecies = animal.getAnimalSpecies();
                            duration += animal.getFeedTime() + animal.getPrepTime();
                            hourSchedule.append("* " + "Feeding - " + animalSpecies + "s"+ " " + "(" + animalNickname + ")" + duration +"\n");
                            animal.setFeedingPrinted(true);
                        }*/
                        hasTasks = true;
                    }
                }
            }
 
            if (foxesFed.size() > 0) {
                hourSchedule.append("* Feeding - foxes (" + foxesFed.size() + ": " + String.join(", ", foxesFed) + ") " + duration + "\n");
            }
            if (raccoonsFed.size() > 0) {
                hourSchedule.append("* Feeding - raccoons (" + raccoonsFed.size() + ": " + String.join(", ", raccoonsFed) + ") " + duration + "\n");
            }
            if (beaversFed.size() > 0) {
                hourSchedule.append("* Feeding - beavers (" + beaversFed.size() + ": " + String.join(", ", beaversFed) + ") " + duration + "\n");
            }
            if (coyotesFed.size() > 0) {
                hourSchedule.append("* Feeding - coyotes (" + coyotesFed.size() + ": " + String.join(", ", coyotesFed) + ") " + duration + "\n");
            }
            if (porcupinesFed.size() > 0) {
                hourSchedule.append("* Feeding - porcupines (" + porcupinesFed.size() + ": " + String.join(", ", porcupinesFed) + ") " + duration + "\n");
            }
   
            if (duration > 60) {
                backup = true; 
                hourSchedule.append(" [ + backup volunteer]\n");
            }
       
            if (hasTasks) {
                hourTextArea.append(hourSchedule.toString());
                hourTextArea.setEditable(false);
                scrollPanel.add(hourTextArea);
            }
        }
    }

    public void modifyStartHour() {
        
        // create new JPanel menu for modifying start hour
        JPanel menu = new JPanel(new BorderLayout());
    
        // create table to display treatments with option to modify start hour
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Treatment ID");
        model.addColumn("Animal ID");
        model.addColumn("Task");
        model.addColumn("Start Hour");
    
        // fetch treatments data from SQL database
        try {
            Statement stmt = rescueCenter.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TREATMENTS JOIN ANIMALS ON TREATMENTS.AnimalID = ANIMALS.AnimalID JOIN TASKS ON TREATMENTS.TaskID = TASKS.TaskID");
            while (rs.next()) {
                int treatmentID = rs.getInt("TreatmentID");
                int animalID = rs.getInt("AnimalID");
                String animalNickname = rs.getString("AnimalNickname");
                String taskDescription = rs.getString("Description");
                int startHour = rs.getInt("StartHour");
                model.addRow(new Object[] {treatmentID, animalID + " (" + animalNickname + ")", taskDescription, startHour});
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching treatments data: " + ex.getMessage());
        }
    
        // create JTable to display treatments data
        JTable table = new JTable(model);
    
        // allow user to edit start hour by double-clicking on a cell
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    int treatmentID = (int) model.getValueAt(table.getSelectedRow(), 0);
                    int currentStartHour = (int) model.getValueAt(table.getSelectedRow(), 3);
                    int newStartHour = Integer.parseInt(JOptionPane.showInputDialog(FRM, "Enter new start hour for Treatment " + treatmentID + ":", currentStartHour));
                    try {
                        String sql = "UPDATE TREATMENTS SET StartHour = ? WHERE TreatmentID = ?";
                        PreparedStatement pstmt = rescueCenter.getConnection().prepareStatement(sql);
                        pstmt.setInt(1, newStartHour);
                        pstmt.setInt(2, treatmentID);
                        pstmt.executeUpdate();
                        // update model with new start hour value
                        model.setValueAt(newStartHour, table.getSelectedRow(), 3);
                    } catch (SQLException ex) {
                        System.out.println("Error updating start hour for Treatment " + treatmentID + ": " + ex.getMessage());
                    }            
                }
            }
        });
    
        // add table to menu
        menu.add(new JScrollPane(table), BorderLayout.CENTER);
    
        // add buttons to menu
        JButton generateButton = new JButton("Generate Schedule");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FRM.getContentPane().removeAll();
                FRM.repaint();
                generateSchedule();
            }
        });
        JButton goBack = new JButton( new AbstractAction("Go Back") {
            @Override
            public void actionPerformed( ActionEvent e ){
                menu.setVisible(false);
                generateSchedule();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(generateButton);
        buttonPanel.add(goBack);
        menu.add(buttonPanel, BorderLayout.SOUTH);
    
        // add menu to JFrame
        FRM.getContentPane().add(menu);
        FRM.pack();
        FRM.setLocationRelativeTo(null);
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

        JPanel confirmationPanel = new JPanel(new BorderLayout());
        confirmationPanel.setPreferredSize(new Dimension(600, 500));

        // Add a label at the top of the screen
        JPanel messagePanel = new JPanel();
        messagePanel.add(new JLabel("Backup volunteer(s) confirmed!"));

        // Create scrollPane to display the schedule
        JScrollPane scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        confirmationPanel.add(messagePanel, BorderLayout.NORTH);
        confirmationPanel.add(scrollPane, BorderLayout.CENTER);

        // Remove the previous messagePanel from scrollPanel and add the new one
        scrollPanel.remove(scrollPanel.getComponentCount() - 1);
        
        menu.add(confirmationPanel);
    
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
                writer.write("\n");
                writer.write(hourTextArea.getText());
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
