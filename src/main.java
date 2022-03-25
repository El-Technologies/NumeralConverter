import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main extends process {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                main window = new main();
                window.frmNumeralConverterBy.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmNumeralConverterBy = new JFrame();
        frmNumeralConverterBy.setTitle("Numeral Converter by Sommy");
        frmNumeralConverterBy.getContentPane().setBackground(Color.WHITE);
        frmNumeralConverterBy.getContentPane().setLayout(null);

        input_1 = new JTextField();
        input_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                info.setText("Enter number to convert");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                info.setText(null);
            }
        });
        input_1.setFocusTraversalPolicyProvider(true);
        input_1.setHorizontalAlignment(SwingConstants.CENTER);
        input_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        input_1.setBounds(216, 99, 81, 38);
        frmNumeralConverterBy.getContentPane().add(input_1);
        input_1.setColumns(10);

        input_2 = new JTextField();
        input_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                info.setText("Enter number to convert");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                info.setText(null);
            }
        });
        input_2.setHorizontalAlignment(SwingConstants.CENTER);
        input_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        input_2.setColumns(10);
        input_2.setBounds(216, 176, 81, 38);
        frmNumeralConverterBy.getContentPane().add(input_2);

        convertBtn = new JButton("CONVERT");
        convertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });
        convertBtn.setForeground(Color.WHITE);
        convertBtn.setBackground(Color.GREEN);
        convertBtn.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
        convertBtn.setBounds(188, 245, 109, 38);
        frmNumeralConverterBy.getContentPane().add(convertBtn);

        clearBtn = new JButton("CLEAR");
        clearBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (clear == 1) info.setText("Click once to clear inputs");
                else info.setText("Click again to clear bases");

                if ((input_1.getText().isEmpty()) & (input_2.getText().isEmpty()) & ((choice_1.getSelectedIndex() != 0)) | choice_1.getSelectedIndex() != 0)
                    info.setText("Click once to clear bases");

                if ((!input_1.getText().isEmpty()) | (!input_2.getText().isEmpty()))
                    info.setText("Click once to clear inputs");

                if ((input_1.getText().isEmpty()) & (input_2.getText().isEmpty()) & (choice_1.getSelectedIndex() == 0) & (choice_2.getSelectedIndex() == 0))
                    info.setText("There's nothing to clear");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                info.setText(null);
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if ((!input_1.getText().isEmpty()) | (!input_2.getText().isEmpty())) clear = 1;
                else if ((input_1.getText().isEmpty()) | (input_2.getText().isEmpty())) {
                    info.setText("Click again to clear bases");
                    clear = 2;
                }

                clear();
            }
        });
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
        clearBtn.setBackground(Color.RED);
        clearBtn.setBounds(34, 245, 87, 38);
        frmNumeralConverterBy.getContentPane().add(clearBtn);

        info = new JLabel();
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        info.setBounds(10, 28, 316, 38);
        frmNumeralConverterBy.getContentPane().add(info);

        choice_1 = new Choice();
        choice_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                info.setText("Choose base to convert from");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                info.setText(null);
            }
        });
        choice_1.add("Base");
        choice_1.add("Binary");
        choice_1.add("Octal");
        choice_1.add("Decimal");
        choice_1.add("Hexadecimal");
        choice_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
        choice_1.setFocusTraversalKeysEnabled(false);
        choice_1.setBounds(34, 109, 81, 38);
        frmNumeralConverterBy.getContentPane().add(choice_1);

        choice_2 = new Choice();
        choice_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                info.setText("Choose base to convert to");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                info.setText(null);
            }
        });
        choice_2.add("Base");
        choice_2.add("Binary");
        choice_2.add("Octal");
        choice_2.add("Decimal");
        choice_2.add("Hexadecimal");
        choice_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
        choice_2.setFocusTraversalKeysEnabled(false);
        choice_2.setBounds(34, 185, 81, 22);
        frmNumeralConverterBy.getContentPane().add(choice_2);
        frmNumeralConverterBy.setBounds(100, 100, 352, 345);
        frmNumeralConverterBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}