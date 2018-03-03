/*
* File: StudentGUI.java
* Author: Edilson Hernandez
* Date: March 4, 2018
* Purpose: The purpose of this program is create a database of student records.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentGUI extends JFrame {
  public StudentGUI() {
    setTitle("Project 4");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(5,2));

    JLabel idLabel = new JLabel("Id: ");
    JTextField idText = new JTextField("");
    add(idLabel);
    add(idText);

    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameText = new JTextField("");
    add(nameLabel);
    add(nameText);

    JLabel majorLabel = new JLabel("Major: ");
    JTextField majorText = new JTextField("");
    add(majorLabel);
    add(majorText);

    JLabel selectionLabel = new JLabel("Choose Selection: ");
    String selections[] = {"Insert","Delete","Find","Update"};
    JComboBox<String> cb = new JComboBox<>(selections);
    add(selectionLabel);
    add(cb);

    JButton process = new JButton("Process Request");
    add(process);

    HashMap<Integer,Student> hm = new HashMap<Integer,Student>();

    process.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // start with if statement to check if id entered is a integer
        if (checkInt(idText.getText())) {
          // store id number
          int num = Integer.parseInt(idText.getText());
          // get selected option
          String selection = cb.getItemAt(cb.getSelectedIndex());
          // determine next step with if statement depending on selection
          if (selection == "Insert") {
            // ensure that user fills all fields and id is available
            if ((nameText.getText().trim().equals("")) || (majorText.getText().trim().equals(""))) {
              JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields!");
            } else if (hm.get(num) == null) {
              // store student record in hashmap
              hm.put(num, new Student(nameText.getText(), majorText.getText()));
              String success = "Success! The following has been entered:\nId: " + num +
              "\nName: " + nameText.getText() +
              "\nMajor: " + majorText.getText();
              // display success message of student record stored
              JOptionPane.showMessageDialog(new JFrame(), success);
            } else {
              JOptionPane.showMessageDialog(new JFrame(), "That Id is already taken!");
            }
          } else if (selection == "Delete") {
            Student stdnt = hm.get(num);
            // ensure that student record exist
            if (stdnt == null) {
              JOptionPane.showMessageDialog(new JFrame(), "Student not found...");
            } else {
              hm.remove(num);
              JOptionPane.showMessageDialog(new JFrame(), "Student record has been removed!");
            }
          } else if (selection == "Find") {
            Student stdnt = hm.get(num);
            // ensure that student record exist
            if (stdnt == null) {
              JOptionPane.showMessageDialog(new JFrame(), "Student not found...");
            } else {
              String found = "Student Found! Here is their information:\nId: " + num + "\n" +stdnt.toString();
              JOptionPane.showMessageDialog(new JFrame(), found);
            }
          } else if (selection == "Update") {
            // ensure that student record exist
            if (hm.get(num) == null) {
              JOptionPane.showMessageDialog(new JFrame(), "Student not found...");
            } else {
              Student stdnt = hm.get(num);
              Integer credits[] = {1,2,3,4,5,6};
              Object grades[] = {'A','B','C','D','F'};
              Object c = JOptionPane.showInputDialog(new JFrame(), "How many credits was the class?", null, JOptionPane.QUESTION_MESSAGE, null, credits, credits[0]);
              Object g = JOptionPane.showInputDialog(new JFrame(), "What was the grade received?", null, JOptionPane.QUESTION_MESSAGE, null, grades, grades[0]);
              // based on entry, add grades appropiately to student record
              switch (g.toString()) {
                case "A": stdnt.courseCompleted(Integer.parseInt(c.toString()),4);
                          break;

                case "B": stdnt.courseCompleted(Integer.parseInt(c.toString()),3);
                          break;

                case "C": stdnt.courseCompleted(Integer.parseInt(c.toString()),2);
                          break;

                case "D": stdnt.courseCompleted(Integer.parseInt(c.toString()),1);
                          break;

                case "F": stdnt.courseCompleted(Integer.parseInt(c.toString()),0);
                          break;
              }
              JOptionPane.showMessageDialog(new JFrame(), "Grades have been added. Thank You!");
            }
          }
        } else {
          JOptionPane.showMessageDialog(new JFrame(),"Please enter a whole number for Id!");
        }
      }
    });

    pack();
    setVisible(true);
    setSize(300,300);
  }

  // method to determine if given string an integer
  public boolean checkInt(String s){
    try {
      Integer.parseInt(s);
      return true;
    } catch (Exception n) {
      return false;
    }
  }

  public static void main(String[] args) {
    new StudentGUI();
  }
}
