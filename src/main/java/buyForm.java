import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class buyForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton numBut;
    private JButton setPocBut;
    private JButton addPocBut;
    private JButton renameBut;
    private JTextField numText;
    private JTextField setNameText;
    private JTextField addPocText;
    private JTextField numPocText;
    private JTextField newPocText;
    private JTextArea textArea1;
    private JButton printSumBut;
    private JButton prinAllBut;
    private JButton cleanBut;

    public buyForm(Store store) {
        setContentPane(contentPane);

        getRootPane().setDefaultButton(buttonOK);
       textArea1.setFont(new Font("Raster Fonts",Font.BOLD,11));
        setSize(550, 350);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        numBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        renameBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = numText.getText();
                store.findBuy(text).setFam(setNameText.getText());
                numText.setText(setNameText.getText());
            }
        });
        addPocBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = numText.getText();
                String textCen = addPocText.getText();
                int cena = Integer.parseInt(textCen);
                if( store.findBuy(text).addPocupka(cena)){
                    String PokupkiString = Arrays.toString(store.findBuy(text).Pokupki);
                    JOptionPane.showMessageDialog(null, "Новая покупка успешно добавлена " + "\n" + "Покупки : " + PokupkiString);
                } else {
                    JOptionPane.showMessageDialog(null, "Ошибка!Проверьте введенные данные!");
                }
            }
        });
        setPocBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = numText.getText();
                String text1 = numPocText.getText();
                int number = Integer.parseInt(text1);
                String text2 = newPocText.getText();
                int number2 = Integer.parseInt(text2);
                if(store.findBuy(text).setPocupka(number,number2)){
                    String PokupkiString = Arrays.toString(store.findBuy(text).Pokupki);
                    JOptionPane.showMessageDialog(null,"Покупка успешно исправлена "+"\n" + "Покупки Студента: " + PokupkiString);
                }
            }
        });
        printSumBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String text = numText.getText();
                textArea1.append("Cумма покупок покупателя: ");
                textArea1.append(String.valueOf(store.findBuy(text).sumPoc()));
            }
        });
        prinAllBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String text = numText.getText();
                textArea1.append(store.findBuy(text).getData());

            }
        });
        numText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                numText.setText("");
            }
        });
        setNameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                setNameText.setText("");
            }
        });
        addPocText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                addPocText.setText("");
            }
        });
        numPocText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                numPocText.setText("");
            }
        });
        newPocText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                newPocText.setText("");
            }
        });
        cleanBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            textArea1.setText("");
            }
        });
    }

    public buyForm() {


    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        buyForm dialog = new buyForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
