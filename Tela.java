package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(5, 5, 469, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(5, 36, 91, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btnInserir = new JButton("inserir");
		btnInserir.setBounds(232, 35, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.setBounds(343, 36, 89, 23);
		contentPane.add(btnLimpar);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 84, 469, 166);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		ActionListener insert = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inserirDados();
			}
		};
		
		ActionListener limpa = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparTexto();	
			}
		};
		
		btnInserir.addActionListener(insert);
		tfIdade.addActionListener(insert);
		btnLimpar.addActionListener(limpa);
	}
	
	public void inserirDados(){
		if(!tfNome.getText().isEmpty()){
			String nome = tfNome.getText();
			String idade = tfIdade.getText();
			textArea.setText(textArea.getText()+nome+"\n" +idade +" anos" + "\n");
		}
		else{
			JOptionPane.showMessageDialog(null,"Digite um nome !!!" ," erro ", JOptionPane.ERROR_MESSAGE);
		}
	}
	
			public void limparTexto(){
				textArea.setText("");
			}
}
