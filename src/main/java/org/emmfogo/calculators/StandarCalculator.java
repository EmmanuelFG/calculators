package org.emmfogo.calculators;

import org.emmfogo.solvers.ISolver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StandarCalculator extends JDialog implements ICalculator {
    private final ISolver solver;
    private final Window parent;
    private JPanel contentPane;
    private JTextField txtOperation;
    private JButton btnFour;
    private JButton btnFive;
    private JButton btnSix;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnNine;
    private JButton btnThree;
    private JButton btnTwo;
    private JButton btnOne;
    private JButton btnZero;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnAsterisk;
    private JButton btnSlash;
    private JButton btnColon;
    private JButton btnClear;
    private JButton btnReturn;
    private JButton btnEquals;
    private JLabel lblResult;
    private JButton btnDelete;

    public StandarCalculator(ISolver solver, Window parent) {
        setLocationRelativeTo(null);
        this.parent = parent;
        this.solver = solver;
        setContentPane(contentPane);
        configureNumberBtns();
        configureBtnRtrn();
        configureBtnClear();
        configureBtnDel();
        configureOperationBtns();
        configureBtnEquals();
        pack();
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
        numberButtons.add(btnColon);

        numberButtons.stream().forEach(e -> {
            e.addActionListener(f -> {
                String input = txtOperation.getText();
                input = input + e.getText();
                txtOperation.setText(input);
            });
        });
    }

    private void configureBtnRtrn() {
        btnReturn.addActionListener(e -> {
            parent.setVisible(true);
            this.dispose();
        });
    }

    private void configureBtnClear() {
        btnClear.addActionListener(e -> {
            txtOperation.setText("");
            lblResult.setText(" ");
        });
    }

    private void configureBtnDel() {
        btnDelete.addActionListener(e -> {
            String input = txtOperation.getText();
            input = input.substring(0, input.length() - 1);
            txtOperation.setText(input);
        });
    }

    private void configureOperationBtns() {
        List<JButton> operationButtons = new ArrayList<>();
        operationButtons.add(btnSlash);
        operationButtons.add(btnPlus);
        operationButtons.add(btnAsterisk);
        operationButtons.add(btnMinus);
        operationButtons.stream().forEach(e -> {
            e.addActionListener(f -> {
                String input = txtOperation.getText();
                input = input + e.getText();
                txtOperation.setText(input);
            });
        });
    }

    private void configureBtnEquals() {
        btnEquals.addActionListener(e -> {
            String input = txtOperation.getText();
            double solution = solver.solveMathemathicalExpression(input);
            lblResult.setText(solution + "");
        });
    }

}
