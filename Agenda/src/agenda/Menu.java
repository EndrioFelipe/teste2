package agenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea area;
    JScrollPane painel;
    JMenuBar barraDeMenu;
    JMenu menuArquivo;
    JMenu menuAjuda;
    JMenuItem menuArquivoNovo;
    JMenuItem menuArquivoAbrir;
    JMenuItem menuArquivoSalvar;
    JMenuItem menuArquivoSair;
    JMenuItem menuAjudaSobre;
    
    public Menu() {
        super("Contatos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        area = new JTextArea();
        painel = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(painel);
        barraDeMenu = new JMenuBar();
        setJMenuBar(barraDeMenu);
        menuArquivo = new JMenu("Arquivo");
        barraDeMenu.add(menuArquivo);
        menuAjuda = new JMenu("Ajuda");
        barraDeMenu.add(menuAjuda);
        menuArquivoNovo = new JMenuItem("Novo");
        menuArquivo.add(menuArquivoNovo);
        menuArquivoAbrir = new JMenuItem("Abrir");
        menuArquivo.add(menuArquivoAbrir);
        menuArquivoSalvar = new JMenuItem("Salvar");
        menuArquivo.add(menuArquivoSalvar);
        menuArquivoSair = new JMenuItem("Sair");
        menuArquivo.add(menuArquivoSair);
        menuAjudaSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuAjudaSobre);
        menuArquivoNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                novo();
            }
        });
        menuArquivoAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrir();
            }
        });
        menuArquivoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
        menuArquivoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        menuAjudaSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sobre();
            }
        });
    }
    
    public void novo () {
        area.setText("");
    }
    
    public void abrir() {
        JFileChooser chooser = new JFileChooser();
        int opcao = chooser.showOpenDialog(this);
        if(opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = chooser.getSelectedFile();
    //        File arquivo = new File("arquivo.txt");
            try {
                FileInputStream fis = new FileInputStream(arquivo);
                byte[] arrayDeBytes = new byte[(int)arquivo.length()];
                fis.read(arrayDeBytes);
                String s = new String(arrayDeBytes);
                area.setText(s);
                fis.close();
            } catch(FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(this, "Arquivo não encontrado!");
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this, "Erro durante a leitura do arquivo!");
            } 
        }
    }
    public void salvar() {
        JFileChooser chooser = new JFileChooser();
        int opcao = chooser.showSaveDialog(this);
        if(opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = chooser.getSelectedFile();
    //        File arquivo = new File("arquivo.txt");
            try{
                FileOutputStream fos = new FileOutputStream(arquivo);
                String s = area.getText();
                byte[] arrayDeBytes = s.getBytes();
                fos.write(arrayDeBytes);
                fos.close();
            } catch(FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(this, "Arquivo não encontrado!");
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this, "Erro durante a escrita do arquivo!");
            }
        }
    }
    public void sair() {
        dispose();
//        System.exit(0);
    }
    public void sobre() {
        JOptionPane.showMessageDialog(this, "Programa NotePad--\n\nDesenvolvido pela turma de Lógica de Programação II\n\n2019\n\nNenhum Direito Reservado.");
    }
    
    public static void main(String[] args) {
        Menu janela = new Menu();
        janela.setSize(500, 600);
        janela.setVisible(true);
    }
}
