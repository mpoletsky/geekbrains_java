package ru.poletskiy.se.lesson24;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebChatWindow extends JFrame {
    JTextPane jtp = new JTextPane();
    JTextField newMessageField = new JTextField();

    public WebChatWindow() {
        setTitle("Web Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(400,100,600,500);

        setLayout(null);
        jtp.setEditable(false);
        JScrollPane jsp = new JScrollPane(jtp);
        jsp.setBounds(5, 5, 585, 400);
        add(jsp);

        newMessageField.setBounds(5, 410, 585, 20);
        JButton sendButton = new JButton("Отправить");
        sendButton.setBounds(5, 435, 585, 30);
        add(newMessageField);
        add(sendButton);

        setVisible(true);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        newMessageField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = newMessageField.getText();
        if (!"".equals(message) && message != null) {
            jtp.setEditable(true);
            appendToPane(jtp, "username\n", Color.RED);
            appendToPane(jtp, message + "\n\n", Color.BLACK);
            jtp.setEditable(false);
            newMessageField.setText("");
        }
    }

    private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
}
