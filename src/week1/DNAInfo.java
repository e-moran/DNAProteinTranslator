package week1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DNAInfo {
    private JTextField input;
    private JRadioButton DNAToMRNARadioButton;

    public DNAInfo() {
        JFrame frame = new JFrame("DNAInfo");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(DNAToMRNARadioButton.isSelected()) {
                    output.setText(new LukesProgram().dnaToMRNA(input.getText()));
                } else if(mRNAToTRNARadioButton.isSelected()) {
                    output.setText(new LukesProgram().mrnaToTRNA(input.getText()));
                } else if(mRNAToDNARadioButton.isSelected()) {
                    output.setText(new LukesProgram().mRNAToDNA(input.getText()));
                } else if(aminosRadioButton.isSelected()) {
                    output.setText(new LukesProgram().replaceAminos(input.getText()));
                }
            }
        });
    }

    private JRadioButton mRNAToTRNARadioButton;
    private JRadioButton mRNAToDNARadioButton;
    private JButton convertButton;
    private JPanel panel;
    private JTextField output;
    private JRadioButton aminosRadioButton;
}
