package com.myFuzzyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversionInformation {

    private JFrame frame;
    private JLabel lblTitle;
    private JLabel lblAmountOfAssertion;
    private JLabel lblQLevelOfAssertion;
    private JLabel lblQLevelOfDesire;
    private JLabel lblQLevelOfTalent;
    private JTextField txtLevelOfAssertion;
    private JTextField txtLevelOfInterest;
    private JTextField txtLevelOfConfidence;
    private JButton btnSubmit;
    private JLabel lblProbabilityAnswer;
    private JButton btnClear;
    private JButton btnQuit;

    // public ConversionClass cc = new ConversionClass();

    /**
     * Create the application.
     */
    public ConversionInformation() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 721, 503);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblTitle = new JLabel("Potential CS/CIS Major Candidate Calculator");
        lblTitle.setBounds(0, 2, 705, 52);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 29));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setVerticalAlignment(SwingConstants.TOP);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblTitle);

        lblAmountOfAssertion = new JLabel(
                "Please answer the following questions ");
        lblAmountOfAssertion.setBounds(0, 65, 705, 52);
        lblAmountOfAssertion.setFont(new Font("Tahoma",
                Font.BOLD | Font.ITALIC, 15));
        frame.getContentPane().add(lblAmountOfAssertion);

        lblQLevelOfAssertion = new JLabel(
                "<html>How assertive was Professer Buchan in convincing the student? 0-100, (0 = worst, 100 = best)");
        lblQLevelOfAssertion.setBounds(0, 140, 503, 77);
        lblQLevelOfAssertion.setHorizontalAlignment(SwingConstants.LEFT);
        lblQLevelOfAssertion.setFont(new Font("Tahoma", Font.BOLD, 11));
        frame.getContentPane().add(lblQLevelOfAssertion);

        txtLevelOfAssertion = new JTextField();
        txtLevelOfAssertion
                .addKeyListener(new TxtLevelOfAssertionKeyListener());
        txtLevelOfAssertion.setBounds(527, 157, 71, 23);
        frame.getContentPane().add(txtLevelOfAssertion);
        txtLevelOfAssertion.setColumns(10);

        lblQLevelOfDesire = new JLabel(
                "<html>Prior to talking with professor Buchan, how interested was the student in a CS/CIS major? (0 = worst, 10 = best)");
        lblQLevelOfDesire.setBounds(0, 228, 517, 77);
        lblQLevelOfDesire.setFont(new Font("Tahoma", Font.BOLD, 11));
        frame.getContentPane().add(lblQLevelOfDesire);

        txtLevelOfInterest = new JTextField();
        txtLevelOfInterest.addKeyListener(new TxtLevelOfInterestKeyListener());
        txtLevelOfInterest.setBounds(527, 245, 71, 23);
        frame.getContentPane().add(txtLevelOfInterest);
        txtLevelOfInterest.setColumns(10);

        lblQLevelOfTalent = new JLabel(
                "<html>How confident is the student that he/she can complete a CS/CIS major? (0 = worst, 10 = best)");
        lblQLevelOfTalent.setBounds(0, 303, 417, 64);
        lblQLevelOfTalent.setFont(new Font("Tahoma", Font.BOLD, 11));
        frame.getContentPane().add(lblQLevelOfTalent);

        txtLevelOfConfidence = new JTextField();
        txtLevelOfConfidence
                .addKeyListener(new TxtLevelOfConfidenceKeyListener());
        txtLevelOfConfidence.setBounds(527, 324, 71, 23);
        txtLevelOfConfidence.setText("");
        frame.getContentPane().add(txtLevelOfConfidence);
        txtLevelOfConfidence.setColumns(10);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(61, 428, 89, 23);
        btnSubmit.addMouseListener(new BtnSubmitMouseListener());
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
        frame.getContentPane().add(btnSubmit);

        JLabel lblProbabilityStudentIsChangingMajor = new JLabel(
                "The probability that the student will change his/her major is: ");
        lblProbabilityStudentIsChangingMajor.setFont(new Font("Tahoma",
                Font.BOLD, 11));
        lblProbabilityStudentIsChangingMajor.setBounds(10, 361, 407, 50);
        frame.getContentPane().add(lblProbabilityStudentIsChangingMajor);

        lblProbabilityAnswer = new JLabel("");
        lblProbabilityAnswer.setBounds(394, 378, 285, 52);
        frame.getContentPane().add(lblProbabilityAnswer);

        btnClear = new JButton("Clear");
        btnClear.addMouseListener(new BtnClearMouseListener());
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnClear.setBounds(180, 428, 89, 23);
        frame.getContentPane().add(btnClear);

        btnQuit = new JButton("Quit");
        btnQuit.addMouseListener(new BtnQuitMouseListener());
        btnQuit.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnQuit.setBounds(295, 428, 89, 23);
        frame.getContentPane().add(btnQuit);
    }

    private class BtnSubmitMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent arg0) {

            if (txtLevelOfAssertion.getText().equals("")
                    || txtLevelOfConfidence.getText().equals("")
                    || txtLevelOfInterest.getText().equals("")) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Please enter all values to properly calculate the probablility of a new convert");
            } else if (Double.parseDouble(txtLevelOfAssertion.getText()) > 100
                    || Double.parseDouble(txtLevelOfAssertion.getText()) < 0) {
                JOptionPane
                        .showMessageDialog(null,
                                "Please enter a proper value (0 - 100) for Buchan's level of assertion");
            } else if (Double.parseDouble(txtLevelOfConfidence.getText()) > 10
                    || Double.parseDouble(txtLevelOfConfidence.getText()) < 0) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Please enter a proper value (0 - 10) for the student's level of confidence of completing the CS/CIS major");
            } else if (Double.parseDouble(txtLevelOfInterest.getText()) > 10
                    || Double.parseDouble(txtLevelOfInterest.getText()) < 0) {
                JOptionPane
                        .showMessageDialog(null,
                                "Please enter a proper value (0 - 10) for the student's level of interest");
            } else {

                // Set inputs
                ConversionClass.setLevelOfAssertionExhibitedByBuchan(Double
                        .parseDouble(txtLevelOfAssertion.getText()));
                ConversionClass.setLevelOfPerceivedAbilityByStudent(Double
                        .parseDouble(txtLevelOfConfidence.getText()));
                ConversionClass.setLevelOfDesireToCompleteDegree(Double
                        .parseDouble(txtLevelOfInterest.getText()));
                ConversionClass.evaluate();
                lblProbabilityAnswer
                        .setText(Double
                                .toString(ConversionClass.probabiltyStudentWillConvert));
            }
        }
    }

    private class BtnClearMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent arg0) {
            txtLevelOfAssertion.setText("");
            txtLevelOfConfidence.setText("");
            txtLevelOfInterest.setText("");
            lblProbabilityAnswer.setText("");
        }
    }

    private class BtnQuitMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent arg0) {
            System.exit(0);
        }
    }

    private class TxtLevelOfAssertionKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

            // Allot only numbers, no characters!
            char c = e.getKeyChar();

            if (!(Character.isDigit(c))) {
                e.consume();
            }
        }
    }

    private class TxtLevelOfInterestKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            // Allot only numbers, no characters!
            char c = e.getKeyChar();

            if (!(Character.isDigit(c))) {
                e.consume();
            }
        }
    }

    private class TxtLevelOfConfidenceKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            // Allot only numbers, no characters!
            char c = e.getKeyChar();

            if (!(Character.isDigit(c))) {
                e.consume();
            }
        }
    }

    public void setVisible() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConversionInformation window = new ConversionInformation();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String filename = "conversionPossibility.fcl";
                FIS fis = FIS.load(filename, true);

                if (fis == null) {
                    System.err.println("Can't load file: '" + filename + "'");
                    System.exit(1);
                }

            }
        });

    }
}
