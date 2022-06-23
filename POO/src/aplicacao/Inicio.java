package aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("Gerenciar Contas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);//Centraliza a janela no centro da tela
		
		JButton btnPoupanca = new JButton("Conta Poupanca");
		btnPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new FormPoupanca().setVisible(true);
			}
		});
		btnPoupanca.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPoupanca.setBounds(46, 93, 152, 71);
		contentPane.add(btnPoupanca);
		
		JButton btnCorrente = new JButton("Conta Corrente");
		btnCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new FormCorrente().setVisible(true);
			}
		});
		btnCorrente.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCorrente.setBounds(244, 93, 142, 71);
		contentPane.add(btnCorrente);
	}
}
