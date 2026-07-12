package org.emmfogo;


import org.emmfogo.validators.IValidator;
import org.emmfogo.validators.InputValidator;

import javax.swing.*;

public class Main {
    static void main() {
        IValidator validator = new InputValidator();
        JFrame frame = new JFrame();
        frame.setContentPane(new Principal(validator).getMyPanel());
        frame.setVisible(true);
        frame.setSize(2000, 2000);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
