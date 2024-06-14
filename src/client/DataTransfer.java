package client;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class DataTransfer {

    private JTextField textField;
    private JTextArea area;
    private JButton button;
    private String username;
    private List<JCheckBox> boxes;

    private JList<String> messages;

    private Vector<String> messageData;

    private int []array;


    public DataTransfer(JTextField textField, JTextArea area, JButton button,String username
            , List<JCheckBox> boxes,JList<String> messages
            , Vector<String> messageData) {
        this.textField = textField;
        this.area = area;
        this.button = button;
        this.username = username;
        this.boxes = boxes;
        this.messages = messages;
        this.messageData = messageData;
        messages.addListSelectionListener(e -> setCheckBoxes());

    }

    public String boxesToString(){
        StringBuilder boxString = new StringBuilder("1xz");

        for(JCheckBox el : boxes){
            if(el.isSelected()){
                boxString.append(" ").append(boxes.indexOf(el));
            }
        }
        return boxString.toString();
    }

    public void setArray(int []array){
        this.array = array;
    }

    public void setAction(ActionListener listener){
        button.addActionListener(listener);
    }

    public String getMessage() {
        String msg = textField.getText();
        clear();
        return msg;
    }

    public void  clear(){
        textField.setText("");
        textField.requestFocus();
    }

    public void sendToGui(String msg){


        messageData.add(msg);
        messages.updateUI();
    }

    public String getUsername() {
        return username;
    }

    public void setCheckBoxes(){
        boxes.forEach(e -> e.setSelected(false));
        for(Integer el : array){
            boxes.get(el).setSelected(true);
        }
    }
}
