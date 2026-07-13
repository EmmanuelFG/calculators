package org.emmfogo.calculators;

import org.emmfogo.solvers.ISolver;

import javax.swing.*;
import java.awt.*;

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
    private JButton returnHomeButton;
    private JButton btnEquals;

    public StandarCalculator(ISolver solver, Window parent) {
        setLocationRelativeTo(null);
        this.parent = parent;
        this.solver = solver;
        setContentPane(contentPane);
        pack();
    }


}
