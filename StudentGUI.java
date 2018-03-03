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
        if (checkInt(idText.getText())) {
          int num = Integer.parseInt(idText.getText());
          String selection = cb.getItemAt(cb.getSelectedIndex());
          if (selection == "Insert") {
            if (hm.get(num) == null) {
              hm.put(num, new Student(nameText.getText(), majorText.getText()));
              String success = "Success! The following has been entered:\nId: " + num +
              "\nName: " + nameText.getText() +
              "\nMajor: " + majorText.getText();
              JOptionPane.showMessageDialog(new JFrame(), success);
            } else {
              JOptionPane.showMessageDialog(new JFrame(), "That Id is already taken!");
            }
          } else if (selection == "Delete") {
            Student stdnt = hm.get(num);
            if (stdnt == null) {
              JOptionPane.showMessageDialog(new JFrame(), "Student not found...");
            } else {
              hm.remove(num);
              JOptionPane.showMessageDialog(new JFrame(), "Student record has been removed!");
            }
          } else if (selection == "Find") {
            Student stdnt = hm.get(num);
            if (stdnt == null) {
              JOptionPane.showMessageDialog(new JFrame(), "Student not found...");
            } else {
              String found = "Student Found! Here is their information:\nId: " + num + "\n" +stdnt.toString();
              JOptionPane.showMessageDialog(new JFrame(), found);
            }
          } else if (selection == "Update") {
            System.out.println("the updater");
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
