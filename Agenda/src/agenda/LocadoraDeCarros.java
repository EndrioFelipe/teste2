/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 *
 * @author yoda
 */
public class LocadoraDeCarros extends JFrame {
    JPanel barraDeFerramentas;
    JButton botaoCadastrar;
    JButton botaoAtualizar;
    JButton botaoAbrir;
    JButton botaoSalvar;
    JLabel label;
    JTextArea area;
    Veiculo[] lista;
    int quantidade;
    //87
    
    public LocadoraDeCarros() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        barraDeFerramentas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(barraDeFerramentas, BorderLayout.NORTH);
        area = new JTextArea();
        //area = new JTextArea();
        //add(area, BorderLayout.CENTER);
        label = new JLabel("adf");
        add(label);
        botaoCadastrar = new JButton("Cadastrar");
        barraDeFerramentas.add(botaoCadastrar);
        botaoAtualizar = new JButton("Atualizar");
        barraDeFerramentas.add(botaoAtualizar);
        botaoAbrir = new JButton("Abrir");
        barraDeFerramentas.add(botaoAbrir);
        botaoSalvar = new JButton("Salvar");
        barraDeFerramentas.add(botaoSalvar);
        lista = new Veiculo[10];
        quantidade = 0;
        
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Veiculo veiculo = new Veiculo();
                lista[quantidade++] = veiculo;
                JanelaCadastro janela = new JanelaCadastro(veiculo);
                janela.setSize(200, 100);
                janela.setVisible(true);
            }
        });
        
        botaoAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				/*
				 * area.setText("Modelo \t Placa \t Diária\n"); for(int i = 0; i < quantidade;
				 * i++) { area.append(lista[i].toString()+"\n"); }
				 * 
				 */
            	
                //add(area, BorderLayout.CENTER);
            }
        });
        
        botaoAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                le();
            }
        });
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                escreve();
            }
        });
    }
    
    void escreve() {
        File arquivo = new File("arquivo.bin");
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i = 0; i < quantidade; i++) {
                dos.writeUTF(lista[i].modelo);
                dos.writeUTF(lista[i].placa);
                dos.writeDouble(lista[i].diaria);
            }
            fos.close();
        }catch(FileNotFoundException fnfe) {
            
        } catch(IOException ioe) {
            
        }
    }
    
    void le() {
        File arquivo = new File("arquivo.bin");
        quantidade = 0;
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            DataInputStream dis = new DataInputStream(fis);
            while(true) {
                lista[quantidade] = new Veiculo();
                lista[quantidade].modelo = dis.readUTF();
                lista[quantidade].placa = dis.readUTF();
                lista[quantidade].diaria = dis.readDouble();
                quantidade++;
            }
        }catch(FileNotFoundException fnfe) {
            
        } catch(IOException ioe) {
            
        }
    }
    
    public static void main(String[] args) {
        LocadoraDeCarros locadora = new LocadoraDeCarros();
        locadora.setSize(400, 500);
        locadora.setVisible(true);
    }
}

class JanelaCadastro extends JFrame {
    JLabel rotuloModelo;
    JTextField campoModelo;
    JLabel rotuloPlaca;
    JTextField campoPlaca;
    JLabel rotuloDiaria;
    JTextField campoDiaria;
    JButton botaoOK;
    JButton botaoCancel;
    Veiculo veiculo;
    
    public JanelaCadastro(Veiculo v) {
        veiculo = v;
        setLayout(new GridLayout(4, 2, 4, 4));
        rotuloModelo = new JLabel("Modelo:");
        add(rotuloModelo);
        campoModelo = new JTextField();
        add(campoModelo);
        rotuloPlaca = new JLabel("Placa:");
        add(rotuloPlaca);
        campoPlaca = new JTextField();
        add(campoPlaca);
        rotuloDiaria = new JLabel("Diaria:");
        add(rotuloDiaria);
        campoDiaria = new JTextField();
        add(campoDiaria);
        botaoOK = new JButton("OK");
        add(botaoOK);
        botaoCancel = new JButton("Cancel");
        add(botaoCancel);
        botaoOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				
				 veiculo.modelo = campoModelo.getText(); 
				 veiculo.placa = campoPlaca.getText();
				 veiculo.diaria = Double.parseDouble(campoDiaria.getText());
				 
            	//new JPanel(new FlowLayout(FlowLayout.LEFT));
                dispose();
            }
        });
    }
}

class Veiculo {
    String modelo;
    String placa;
    double diaria;
    
    public Veiculo() {
    }
    public Veiculo(String modelo, String placa, double diaria) {
        this.modelo = modelo;
        this.placa = placa;
        this.diaria = diaria;
    }
    public String toString() {
        DecimalFormat df = new DecimalFormat("R$ #.00");
        return modelo+" \t "+placa+" \t "+df.format(diaria);
    }
}