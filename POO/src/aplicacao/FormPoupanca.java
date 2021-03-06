package aplicacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classes.ContaPoupanca;
import classes.TransacoesPoupanca;

public class FormPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtBanco;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtAniversario;
	private JTextField txtValorTransacao;
	private JTextArea txtSaida;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FormPoupanca() {
		
		ContaPoupanca cp = new ContaPoupanca();
		TransacoesPoupanca tp = new TransacoesPoupanca();
		
		setTitle("Conta Poupanca");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroBanco = new JLabel("N\u00FAmero do Banco:");
		lblNumeroBanco.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumeroBanco.setBounds(11, 11, 120, 14);
		contentPane.add(lblNumeroBanco);
		
		JTextPane txtBanco = new JTextPane();
		txtBanco.setBounds(11, 25, 120, 20);
		contentPane.add(txtBanco);
		
		JLabel lblAgencia = new JLabel("N\u00FAmero da Agencia:");
		lblAgencia.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblAgencia.setBounds(11, 65, 120, 14);
		contentPane.add(lblAgencia);
		
		JTextPane txtAgencia = new JTextPane();
		txtAgencia.setBounds(11, 78, 120, 20);
		contentPane.add(txtAgencia);
		
		JLabel lblNumeroConta = new JLabel("N\u00FAmero da Conta:");
		lblNumeroConta.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumeroConta.setBounds(11, 109, 120, 14);
		contentPane.add(lblNumeroConta);
		
		JTextPane txtConta = new JTextPane();
		txtConta.setBounds(11, 122, 120, 20);
		contentPane.add(txtConta);
		
		JLabel lblTransacoes = new JLabel("Transa\u00E7\u00F5es:");
		lblTransacoes.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTransacoes.setEnabled(true);
		lblTransacoes.setForeground(Color.BLACK);
		lblTransacoes.setBackground(Color.LIGHT_GRAY);
		lblTransacoes.setBounds(15, 153, 81, 14);
		contentPane.add(lblTransacoes);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(13, 170, 420, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblValorTransacao = new JLabel("Valor da Transa\u00E7\u00E3o:");
		lblValorTransacao.setBounds(10, 11, 116, 15);
		panel.add(lblValorTransacao);
		lblValorTransacao.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		 txtValorTransacao = new JTextField();
		txtValorTransacao.setForeground(Color.BLACK);
		txtValorTransacao.setBounds(10, 37, 147, 20);
		panel.add(txtValorTransacao);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tp.sacar(Double.parseDouble(txtValorTransacao.getText())));
				}
				
			}
		});
		btnSacar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnSacar.setBounds(182, 7, 95, 23);
		panel.add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tp.depositar(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnDepositar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnDepositar.setBounds(182, 48, 95, 23);
		panel.add(btnDepositar);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tp.transferencia(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnTransferir.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnTransferir.setBounds(305, 8, 105, 23);
		panel.add(btnTransferir);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSaida.append("\n"+tp.saldo());
			}
		});
		btnSaldo.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnSaldo.setBounds(305, 48, 105, 23);
		panel.add(btnSaldo);
		
		JLabel lblTItular = new JLabel("Titular da Conta:");
		lblTItular.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTItular.setBounds(159, 11, 112, 14);
		contentPane.add(lblTItular);
		
		JTextPane txtTitular = new JTextPane();
		txtTitular.setBounds(159, 25, 274, 20);
		contentPane.add(txtTitular);
		
		JLabel lblAniversario = new JLabel("Aniversario da Conta:");
		lblAniversario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblAniversario.setBounds(159, 65, 131, 14);
		contentPane.add(lblAniversario);
		
		JTextPane txtAniversario = new JTextPane();
		txtAniversario.setBounds(159, 78, 131, 20);
		contentPane.add(txtAniversario);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSaldo.setBounds(159, 109, 112, 14);
		contentPane.add(lblSaldo);
		
		JTextPane txtSaldo = new JTextPane();
		txtSaldo.setBounds(159, 122, 131, 20);
		contentPane.add(txtSaldo);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cp.setNumeroBanco(Integer.parseInt(txtBanco.getText()));
				cp.setNumeroAgencia(Integer.parseInt(txtAgencia.getText()));
				cp.setNumeroConta(Integer.parseInt(txtConta.getText()));
				cp.setTitular(txtTitular.getText());
				cp.setSaldo(Double.parseDouble(txtSaldo.getText()));
				cp.setAniversario(getName());
				txtSaida.setText(tp.abrirConta(cp));
				
				//Desabilitar as caixas e o bot?o abrirConta.
				txtBanco.setEnabled(false);
				txtAgencia.setEnabled(false);
				txtConta.setEnabled(false);
				txtTitular.setEnabled(false);
				txtAniversario.setEnabled(false);
				txtSaldo.setEnabled(false);
				btnAbrirConta.setEnabled(false);
			}
		});
		btnAbrirConta.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAbrirConta.setBounds(296, 65, 137, 85);
		contentPane.add(btnAbrirConta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 263, 420, 161);
		contentPane.add(scrollPane);
		
		txtSaida = new JTextArea();
		scrollPane.setViewportView(txtSaida);
	}
	
	//Criar uma fun??o para validar a txtValorTransacao.
	private boolean validarValorTransacao(){
		boolean rt = true;
		
		if(txtValorTransacao.getText().equals("") || txtValorTransacao.getText()==null) {
			rt = false;
			JOptionPane.showMessageDialog(null,"Preencha o valor da transa??o");
		}
		return rt;
	}
}
