package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimulationView extends JFrame{
    private JTextArea simArea;

    public SimulationView() {
        this.setBounds(100, 100, 820, 593);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel simLbl = new JLabel("SIMULATION");
        simLbl.setHorizontalAlignment(SwingConstants.CENTER);
        simLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        simLbl.setBounds(254, 35, 295, 38);
        this.getContentPane().add(simLbl);

        simArea = new JTextArea();
        simArea.setEnabled(false);
        simArea.setTabSize(4);
        simArea.setLineWrap(true);
        simArea.setBounds(51, 84, 721, 443);
        this.getContentPane().add(simArea);

        JScrollPane scrollPane = new JScrollPane(simArea);
        scrollPane.setBounds(51, 84, 721, 443);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.getContentPane().add(scrollPane);
    }

    public void setSimArea(String info) {
        this.simArea.setText(info);
    }

    public void refresh() {
        this.simArea.setText("");
    }
}
