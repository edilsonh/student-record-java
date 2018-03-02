import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    pack();
    setVisible(true);
    setSize(300,300);
  }

  public static void main(String[] args) {
    new StudentGUI();
  }
}
