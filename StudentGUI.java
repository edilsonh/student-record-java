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

    process.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String a = cb.getItemAt(cb.getSelectedIndex());
        if (a == "Insert") {
          System.out.println("the insert");
        } else if (a == "Delete") {
          System.out.println("the deleter");
        } else if (a == "Find") {
          System.out.println("the finder");
        } else if (a == "Update") {
          System.out.println("the updater");
        }
      }
    });

    pack();
    setVisible(true);
    setSize(300,300);
  }

  public static void main(String[] args) {
    new StudentGUI();
  }
}
