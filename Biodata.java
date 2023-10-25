/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Ericko Timur Apandi - 203040127
 */
public class Biodata extends JFrame {

    public Biodata() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);

                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        JLabel labelInputNama = new JLabel("Nama :");
        labelInputNama.setBounds(15, 40, 350, 15);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 65, 350, 30);

        JLabel labelInputNotelp = new JLabel("Nomor HP :");
        labelInputNotelp.setBounds(15, 100, 350, 15);
        JTextField textFieldNotelp = new JTextField();
        textFieldNotelp.setBounds(15, 125, 350, 30);

        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true);
        radioButtonL.setBounds(15, 205, 350, 30);

        JRadioButton radioButtonP = new JRadioButton("Perempuan");
        radioButtonP.setBounds(15, 230, 350, 30);
        
        JLabel labelInputAlamat = new JLabel("Alamat :");
        labelInputAlamat.setBounds(15, 150, 350, 30);
        JTextField textFieldAlamat = new JTextField();
        textFieldAlamat.setBounds(15, 175, 350, 30);        

        JButton button = new JButton("Simpan");
        button.setBounds(15, 270, 100, 40);
        
        JButton editButton = new JButton("Edit");
        editButton.setBounds(120,270,100,40);
        
        JButton deleteButton = new JButton("Hapus");
        deleteButton.setBounds(225, 270, 100, 40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 330, 500, 200);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);   
        bg.add(radioButtonP);

        BiodataTableModel tableModel = new BiodataTableModel();
        table.setModel(tableModel);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String alamat = textFieldAlamat.getText();
                String jenisKelamin = "";

                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }

                if (nama.trim().isEmpty() || noTelp.trim().isEmpty() || alamat.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Form tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                            "Masukan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, noTelp, alamat, jenisKelamin)));
                        textFieldNama.setText("");
                        textFieldNotelp.setText("");
                        textFieldAlamat.setText("");
                    } else {
                        JOptionPane.showMessageDialog(Biodata.this, "Anda tidak memasukan data");
                    }
                }
            }

        });
        
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                   String nama = textFieldNama.getText();
                   String noTelp = textFieldNotelp.getText();
                   String alamat = textFieldAlamat.getText();
                   String jenisKelamin = "";

            if (radioButtonL.isSelected()) {
                jenisKelamin = radioButtonL.getText();
            }
            if (radioButtonP.isSelected()) {
                jenisKelamin = radioButtonP.getText();

            if (nama.trim().isEmpty() || noTelp.trim().isEmpty() || alamat.trim().isEmpty()) {
                JOptionPane.showMessageDialog(Biodata.this, "Form tidak boleh ada yang kosong!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                        "Edit Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    tableModel.setValueAt(nama, selectedRow, 0);
                    tableModel.setValueAt(noTelp, selectedRow, 1);
                    tableModel.setValueAt(alamat, selectedRow, 2);
                    tableModel.setValueAt(jenisKelamin, selectedRow, 3);
                    textFieldNama.setText("");
                    textFieldNotelp.setText("");
                    textFieldAlamat.setText("");
                } else {
                    JOptionPane.showMessageDialog(Biodata.this, "Anda tidak mengedit data");
                }
                    }
                } else {
                JOptionPane.showMessageDialog(Biodata.this, "Pilih baris yang akan diedit");
                    
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                    "Hapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                    }
                } else {
                JOptionPane.showMessageDialog(Biodata.this, "Pilih baris yang akan dihapus");
                
                }
            }
        });


        this.add(button);
        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputNotelp);
        this.add(textFieldNotelp);
        this.add(radioButtonL);
        this.add(radioButtonP);
        this.add(editButton);
        this.add(deleteButton);
        this.add(labelInputAlamat);
        this.add(textFieldAlamat);
        this.add(scrollableTable);

        this.setSize(700, 700);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata b = new Biodata();
                b.setVisible(true);
            }
        });
    }
}
