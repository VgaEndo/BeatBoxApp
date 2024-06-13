package gui.panels.east;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class EastPanelMessage  extends JPanel{

    private JTextArea textArea;
    private JTextField textField;
    private JButton send;

    public EastPanelMessage() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        textArea = new JTextArea(20,20);
        textField = new JTextField();
        send = new JButton("Send");


        send.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.add(createScroll(textArea));
        this.add(textField);
        this.add(send);
        send.setEnabled(false);



        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                msgAvailable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                msgAvailable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                msgAvailable();
            }
        });


    }

    public void msgAvailable(){
        send.setEnabled(!textField.getText().isEmpty());

    }
    private JScrollPane createScroll(JTextArea area){
        JScrollPane pane = new JScrollPane(area);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        return pane;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getSend() {
        return send;
    }
}
