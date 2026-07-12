package org.emmfogo;


import org.emmfogo.access.AccessValidator;
import org.emmfogo.access.IAccess;

import javax.swing.*;

public class Main {
    static void main() {
        IAccess validator = new AccessValidator();
        JFrame frame = new JFrame();
        frame.setContentPane(new Principal(validator).getMyPanel());
        frame.setVisible(true);
        frame.setSize(2000, 2000);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
