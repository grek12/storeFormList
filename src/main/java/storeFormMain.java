import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class storeFormMain  extends JFrame {
    private JPanel panelMain;
    private JTextArea textArea1;
    private JTextField textName;
    private JButton addBuyBut;
    private JButton delBuyBut;
    private JButton newFrameBut;
    private JButton srCheckBut;
    private JButton exitBut;
    private JButton clearBut;
    private JButton printAllBut;
    Store store = new Store("nameStore");

    public storeFormMain(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        setSize(600, 500);
        panelMain.setPreferredSize(new Dimension(800, 600));
        textArea1.setFont(new Font("Raster Fonts",Font.BOLD,11));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        addBuyBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            store.addBuy(textName.getText());
            }
        });
        delBuyBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store.delBuy();
            }
        });
        srCheckBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);
                textArea1.append("Средний чек покупателей: ");
                textArea1.append(   String.valueOf(store.srCena()));
            }
        });
        printAllBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);
                textArea1.append(store.getAllData()) ;
                textArea1.append("Средний чек покупателей: ");
                textArea1.append(   String.valueOf(store.srCena()));
            }
        });
        clearBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);
            }
        });
        exitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        textName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            textName.setText("");
            }
        });
        newFrameBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            buyForm form = new buyForm(store);
                form.pack();
                form.setVisible(true);

            }
        });
    }
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new storeFormMain ("Store");
        frame.setVisible(true);


    }
}
