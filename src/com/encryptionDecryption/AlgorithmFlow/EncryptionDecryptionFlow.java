package com.encryptionDecryption.AlgorithmFlow;

import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Logger;

public class EncryptionDecryptionFlow extends JFrame {

//    SOLVE FIELDS
    private JButton copyDecrypt;
    private JButton copyEncrypt;
    private JButton decrypt;
    private JButton encrypt;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;

    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;

    private JLabel mainSection;
    private JLabel message1;
    private JTextField messageTextField1;
    private JLabel message2;
    private JTextField messageTextField2;

    private JTextArea text1;
    private JTextArea text2;
    private JTextArea text3;
    private JTextArea text4;



    private static SecretKeySpec secretKeySpec;
    private static byte[] keyByte;

    public static void setKey(@NotNull String userKeyCode) {
        try {
            MessageDigest messageDigest = null;

            messageDigest = MessageDigest.getInstance("SHA-1");
            keyByte = messageDigest.digest(userKeyCode.getBytes("UTF-8"));
            keyByte = Arrays.copyOf(keyByte, 16);
            secretKeySpec = new SecretKeySpec(keyByte, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
        }
    }


    /**
     *  Used to initialize the Default Frame-UI
     * {@DefaultConstructor}
     */
    public EncryptionDecryptionFlow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        renderFrame();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cryptography");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        text1.setBackground(new Color(255, 255, 255));
        text1.setColumns(20);
        text1.setFont(new Font("Dialog", 0, 14));
        text1.setForeground(new Color(0, 0, 0));
        text1.setRows(5);
        text1.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 2));
        jScrollPane1.setViewportView(text1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 80, 300, 120);

        text2.setBackground(new Color(255, 255, 255));
        text2.setColumns(20);
        text2.setFont(new Font("Dialog", 0, 14));
        text2.setForeground(new Color(0, 0, 0));
        text2.setRows(5);
        text2.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 2));
        jScrollPane2.setViewportView(text2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(80, 322, 300, 120);

        text3.setBackground(new Color(255, 255, 255));
        text3.setColumns(20);
        text3.setFont(new Font("Dialog", 0, 14));
        text3.setForeground(new Color(0, 0, 0));
        text3.setRows(5);
        text3.setToolTipText("");
        text3.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 2));
        jScrollPane3.setViewportView(text3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(470, 80, 320, 120);

        text4.setBackground(new Color(255, 255, 255));
        text4.setColumns(20);
        text4.setFont(new Font("Dialog", 0, 14));
        text4.setForeground(new Color(0, 0, 0));
        text4.setRows(5);
        text4.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 2));
        jScrollPane4.setViewportView(text4);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(470, 320, 320, 120);


        messageTextField1.setBackground(new Color(255, 255, 255));
        messageTextField1.setForeground(new Color(0, 0, 0));
        messageTextField1.setHorizontalAlignment(JTextField.CENTER);
        getContentPane().add(messageTextField1);
        messageTextField1.setBounds(200, 220, 180, 30);

        messageTextField2.setBackground(new Color(255, 255, 255));
        messageTextField2.setForeground(new Color(0, 0, 0));
        messageTextField2.setHorizontalAlignment(JTextField.CENTER);
        getContentPane().add(messageTextField2);
        messageTextField2.setBounds(595, 220, 190, 30);


        encrypt.setBackground(new Color(0, 51, 51));
        encrypt.setFont(new Font("Dialog", 1, 14));
        encrypt.setForeground(new Color(255, 255, 255));
        encrypt.setText("Encrypt");
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptActionPerformed(e);
            }
        });
        getContentPane().add(encrypt);
        encrypt.setBounds(80, 275, 90, 30);

        decrypt.setBackground(new Color(0, 51, 51));
        decrypt.setFont(new Font("Dialog", 1, 14));
        decrypt.setForeground(new Color(255, 255, 255));
        decrypt.setText("Decrypt");
        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decryptActionPerformed(e);
            }
        });
        getContentPane().add(decrypt);
        decrypt.setBounds(470, 275, 90, 30);

        copyEncrypt.setBackground(new Color(102, 0, 0));
        copyEncrypt.setFont(new Font("Dialog", 1, 12));
        copyEncrypt.setForeground(new Color(255, 255, 255));
        copyEncrypt.setText("Copy Encryption");
        copyEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyEncryptActionPerformed(e);
            }
        });
        getContentPane().add(copyEncrypt);
        copyEncrypt.setBounds(240, 275, 140, 30);

        copyDecrypt.setBackground(new Color(102, 0, 0));
        copyDecrypt.setFont(new Font("Dialog", 1, 12));
        copyDecrypt.setForeground(new Color(255, 255, 255));
        copyDecrypt.setText("Copy Decryption");
        copyDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyDecryptActionPerformed(e);
            }
        });
        getContentPane().add(copyDecrypt);
        copyDecrypt.setBounds(633, 275, 150, 30);



        jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lLabel2MousePressed(e);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(810, 5, 30, 20);

        jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lLabel3MousePressed(e);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(780, 5, 30, 20);

        jLabel1.setFont(new Font("Dialog", 1, 14));
        jLabel1.setForeground(new Color(204, 51, 0));
        jLabel1.setText("Encrypted Key");
        jLabel1.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 220, 110, 30);

        jLabel4.setFont(new Font("Dialog", 1, 14));
        jLabel4.setForeground(new Color(204, 51, 0));
        jLabel4.setText("Decrypted Key");
        jLabel4.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 220, 110, 30);

        jLabel5.setFont(new Font("Dialog", 1, 18));
        jLabel5.setForeground(new Color(0, 0, 51));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Message to Decrypt");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(470, 50, 300, 30);

        jLabel6.setFont(new Font("Dialog", 1, 18));
        jLabel6.setForeground(new Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Message to Encrypt");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 50, 300, 30);


        message1.setForeground(new Color(204, 0, 0));
        message1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(message1);
        message1.setBounds(80, 450, 300, 20);

        message2.setForeground(new Color(204, 0, 0));
        message2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(message2);
        message2.setBounds(470, 450, 320, 20);

        mainSection.setForeground(new Color(153, 0, 0));
        mainSection.setIcon(new ImageIcon(getClass().getResource("/assets/edcrypt.png")));
        mainSection.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        getContentPane().add(mainSection);
        mainSection.setBounds(0, 0, 850, 500);

        setSize(new Dimension(850, 499));
        setLocationRelativeTo(null);
    }

    private void lLabel3MousePressed(MouseEvent e) {
        this.setState(Frame.ICONIFIED);
    }

    private void lLabel2MousePressed(MouseEvent e) {
        System.exit(0);
    }

    private void copyDecryptActionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text4.getText()), null);
        message2.setText("Your Decrypted Message has Been Copied!");
        message1.setText("");
    }

    private void copyEncryptActionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text2.getText()), null);
        message1.setText("Your Encrypted Message has Been Copied!");
        message2.setText("");
    }

    private void decryptActionPerformed(ActionEvent e) {
        String userMessage;
        String secretKey;
        try {
            userMessage = text3.getText();
            secretKey = messageTextField2.getText();
            setKey(secretKey);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            text4.setText(new String(cipher.doFinal(Base64.getDecoder().decode(userMessage))));
        } catch (Exception exception) {
            text2.setText("[EncryptionDecryptionFlow] Please Fill Up the Right SecretKey");
            exception.printStackTrace();
        }
    }

    private void encryptActionPerformed(ActionEvent e) {
        String userMessage;
        String secretKey;
        try {
            userMessage = text1.getText();
            secretKey = messageTextField1.getText();
            setKey(secretKey);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            text2.setText(Base64.getEncoder().encodeToString(cipher.doFinal(userMessage.getBytes("UTF-8"))));
        } catch (Exception exception) {
            text2.setText("[EncryptionDecryptionFlow] Please Fill Up the Right SecretKey");
            exception.printStackTrace();
        }
    }

    private void renderFrame() {
        jScrollPane1 = new JScrollPane();
        text1 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        text2 = new JTextArea();
        jScrollPane3 = new JScrollPane();
        text3 = new JTextArea();
        jScrollPane4 = new JScrollPane();
        text4 = new JTextArea();
        messageTextField1 = new JTextField();
        messageTextField2 = new JTextField();

        encrypt = new JButton();
        decrypt  = new JButton();
        copyDecrypt = new JButton();
        copyEncrypt = new JButton();

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        message1 = new JLabel();
        message2 = new JLabel();

        mainSection = new JLabel();
    }
}
