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

        convertButton.addActionListener(actionEvent -> {
            if(DNAToMRNARadioButton.isSelected()) {
                output.setText(new LukesProgram().dnaToMRNA(input.getText()));
            } else if(mRNAToTRNARadioButton.isSelected()) {
                output.setText(new LukesProgram().mrnaToTRNA(input.getText()));
            } else if(mRNAToDNARadioButton.isSelected()) {
                output.setText(new LukesProgram().mRNAToDNA(input.getText()));
            } else if(aminosRadioButton.isSelected()) {
                if(input.getText().length() % 3 == 0) {
                    output.setText(new LukesProgram().replaceAminos(input.getText()));
                } else {
                    output.setText("Input invalid length");
                }
            } else {
                output.setText("No conversion selected");
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
