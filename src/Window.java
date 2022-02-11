import java.awt.*;
import java.awt.event.*;


public class Window extends Frame{
    Window(String name) {
        setTitle(name);
        setLocation(400,400);
        setResizable(false);
        setSize(400, 400);
        setLayout(null);
        Label labelA = new Label("a");
        labelA.setSize(30, 20);
        labelA.setLocation(40, 50);

        Label labelB = new Label("b");
        labelB.setBounds(40 , 80,30,20);
        Label labelSum = new Label("sum");
        labelSum.setBounds(40, 110, 30,20);

        add(labelA);
        add(labelB);
        add(labelSum);

        TextField textFieldA = new TextField();
        textFieldA.setBounds(90, 50,80,20);
        TextField textFieldB = new TextField();
        textFieldB.setBounds(90, 80,80,20);
        TextField textFieldSum = new TextField();
        textFieldSum.setBounds(90,110,80,20);

        add(textFieldA);
        add(textFieldB);
        add(textFieldSum);

        Button calc = new Button("Calculate");
        calc.setBounds(90, 140, 80, 30);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt((textFieldA.getText()));
                    int b = Integer.parseInt((textFieldB.getText()));
                    int sum = a + b;
                    textFieldSum.setText(Integer.toString(sum));
                } catch (NumberFormatException ne) {
                    textFieldSum.setText("error");
                }
            }
        });

        Button clear = new Button("clear");
        clear.setBounds(90, 170, 80, 30);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldA.setText("");
                textFieldB.setText("");
                textFieldSum.setText("");
            }
        });
        add(calc);
        add(clear);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);}
        });
        setVisible(true);
    }

    public static void main (String[]args){
        new Window("Sum of two digits");
    }
}