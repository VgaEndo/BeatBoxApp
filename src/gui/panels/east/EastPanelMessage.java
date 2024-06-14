package gui.panels.east;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Vector;

public class EastPanelMessage  extends JPanel{

    private JTextArea textArea;
    private JTextField textField;
    private JButton send;
    private Vector<String> messageData;
    private JList<String> messages;

    public EastPanelMessage() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        textArea = new JTextArea(20,20);
        textField = new JTextField();
        messageData = new Vector<>();
        messages = new JList<>();
        messages.setListData(messageData);
        messages.setSize(200,200);
        textArea.add(messages);
        send = new JButton("Send");
        //messages.addListSelectionListener(e -> System.out.println("sdf"));


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

    public JList<String> getMessages() {
        return messages;
    }

    public Vector<String> getMessageData() {
        return messageData;
    }
}
