package org.emmfogo;

import org.emmfogo.access.IAccess;
import org.emmfogo.calculators.AverageCalculator;
import org.emmfogo.calculators.ICalculator;
import org.emmfogo.calculators.StandarCalculator;
import org.emmfogo.solvers.MeanSolver;
import org.emmfogo.solvers.StandarSolver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private final IAccess accessValidator;
    private JPanel myPanel;
    private JComboBox cmbCalculator;
    private JButton btnSelect;
    private JRadioButton rbtStudent;
    private JRadioButton rbtTeacher;
    private JLabel lblSelect;
    private JLabel lblRole;
    private JLabel lblMain;
    private ButtonGroup roleButtons;
    private ICalculator calculator;

    public Principal(IAccess accessValidator) {
        this.accessValidator = accessValidator;
        configureCmb();
        configureRbt();
        configSelect();
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    private void configureCmb() {
        List<String> calculators = new ArrayList<>();
        calculators.add("Standar calculator");
        calculators.add("Average calculator");
        calculators.stream().forEach(e -> cmbCalculator.addItem(e));
    }

    private void configureRbt() {
        roleButtons = new ButtonGroup();
        rbtStudent.setActionCommand("student");
        rbtTeacher.setActionCommand("teacher");
        roleButtons.add(rbtStudent);
        roleButtons.add(rbtTeacher);
    }

    private void configSelect() {
        btnSelect.addActionListener(e -> {
            String role = roleButtons.getSelection().getActionCommand();
            String calculatorType = cmbCalculator.getSelectedItem().toString();
            boolean isAble = accessValidator.validate(calculatorType, role);
            if (isAble) {
                Window original = SwingUtilities.getWindowAncestor(myPanel);
                if (role.equals("student")) {
                    StandarSolver solver = new StandarSolver();
                    calculator = new StandarCalculator(solver, original);
                    StandarCalculator standar = (StandarCalculator) calculator;
                    standar.setVisible(true);
                } else {
                    MeanSolver solver = new MeanSolver();
                    calculator = new AverageCalculator(solver, original);
                    AverageCalculator standar = (AverageCalculator) calculator;
                    standar.setVisible(true);
                }
                original.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Your access has been denied");
            }

        });
    }
}
