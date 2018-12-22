package ru.poletskiy.se.lesson181;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
final class ExampleSimpleWindow extends JFrame
{

    private ExampleSimpleWindow() throws HeadlessException {
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        final ExampleSimpleWindow window = new ExampleSimpleWindow();
        window.setVisible(true);
    }

}