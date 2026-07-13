package org.emmfogo.calculators;

import org.emmfogo.solvers.ISolver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AverageCalculator extends JDialog implements ICalculator {
    private final ISolver solver;
    private final Window parent;
    private JPanel contentPane;
    private JTextField txtInteractive;
    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnFour;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnFive;
    private JButton btnNine;
    private JButton btnSix;
    private JButton btnThree;
    private JButton btnZero;
    private JButton btnComma;
    private JButton btnClear;
    private JButton btnSpace;
    private JButton btnEquals;
    private JButton btnReturn;
    private JLabel lblName;
    private JButton btnDelete;
    private JLabel lblResult;

    public AverageCalculator(ISolver solver, Window parent) {
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
        this.parent = parent;
        this.solver = solver;
        setContentPane(contentPane);
        configureNumberBtns();
        configBtnSpace();
        configBtnClear();
        configBtnEquals();
        configBtnRtrn();
        configBtnDel();

    }


    private void configureNumberBtns() {
        List<JButton> numberButtons = new ArrayList<>();
        numberButtons.add(btnZero);
        numberButtons.add(btnOne);
        numberButtons.add(btnTwo);
        numberButtons.add(btnThree);
        numberButtons.add(btnFour);
        numberButtons.add(btnFive);
        numberButtons.add(btnSix);
        numberButtons.add(btnSeven);
        numberButtons.add(btnEight);
        numberButtons.add(btnNine);
        numberButtons.add(btnComma);
        numberButtons.stream().forEach(e -> {
            e.addActionListener(f -> {
                String input = txtInteractive.getText();
                input = input + e.getText();
                txtInteractive.setText(input);
            });
        });
    }

    private void configBtnSpace() {
        btnSpace.addActionListener(e -> {
            String input = txtInteractive.getText();
            input = input + " ";
            txtInteractive.setText(input);
        });
    }

    private void configBtnClear() {
        btnClear.addActionListener(e -> {
            txtInteractive.setText("");
            lblResult.setText(" ");
        });
    }

    private void configBtnEquals() {
        btnEquals.addActionListener(e -> {
            String txt = txtInteractive.getText();
            float solution = solver.solveMathemathicalExpression(txt);
            lblResult.setText(solution + "");
        });
    }

    private void configBtnDel() {
        btnDelete.addActionListener(e -> {
            String txt = txtInteractive.getText();
            txt = txt.substring(0, txt.length() - 1);
            txtInteractive.setText(txt);
        });
    }

    private void configBtnRtrn() {
        btnReturn.addActionListener(e -> {
            parent.setVisible(true);
            this.dispose();
        });
    }


}
