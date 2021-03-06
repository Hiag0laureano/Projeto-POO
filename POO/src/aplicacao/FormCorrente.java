package aplicacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import classes.ContaCorrente;
import classes.TransacoesCorrente;

public class FormCorrente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBanco;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtLimite;
	private JTextField txtValorTransacao;
	private JTextArea txtSaida;
	private ContaCorrente cc = null;
	private TransacoesCorrente tc = null;
	

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public FormCorrente() {
		
		cc = new ContaCorrente();
		tc = new TransacoesCorrente();
		
		setTitle("Conta Corrente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlDadosConta = new JPanel();
		pnlDadosConta.setBackground(Color.WHITE);
		pnlDadosConta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDadosConta.setBounds(10, 11, 433, 180);
		contentPane.add(pnlDadosConta);
		pnlDadosConta.setLayout(null);
		
		JLabel lblDadosConta = new JLabel("Dados da Conta");
		lblDadosConta.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblDadosConta.setBounds(10, 11, 143, 14);
		pnlDadosConta.add(lblDadosConta);
		
		JLabel lblNumeroBanco = new JLabel("Numero do Banco:");
		lblNumeroBanco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroBanco.setBounds(10, 62, 106, 14);
		pnlDadosConta.add(lblNumeroBanco);
		
		JLabel lblNumeroAgencia = new JLabel("Numero da Ag\u00EAncia:");
		lblNumeroAgencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroAgencia.setBounds(0, 93, 116, 14);
		pnlDadosConta.add(lblNumeroAgencia);
		
		JLabel lblNumeroConta = new JLabel("Numero da Conta:");
		lblNumeroConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroConta.setBounds(10, 118, 106, 14);
		pnlDadosConta.add(lblNumeroConta);
		
		JLabel lblTitulart = new JLabel("Titular:");
		lblTitulart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulart.setBounds(213, 59, 40, 14);
		pnlDadosConta.add(lblTitulart);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldo.setBounds(213, 90, 40, 14);
		pnlDadosConta.add(lblSaldo);
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimite.setBounds(213, 118, 40, 14);
		pnlDadosConta.add(lblLimite);
		
		txtBanco = new JTextField();
		txtBanco.setBounds(117, 59, 86, 20);
		pnlDadosConta.add(txtBanco);
		txtBanco.setColumns(10);
		
		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(117, 87, 86, 20);
		pnlDadosConta.add(txtAgencia);
		
		txtConta = new JTextField();
		txtConta.setColumns(10);
		txtConta.setBounds(117, 115, 86, 20);
		pnlDadosConta.add(txtConta);
		
		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		txtTitular.setBounds(255, 56, 168, 20);
		pnlDadosConta.add(txtTitular);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(255, 87, 67, 20);
		pnlDadosConta.add(txtSaldo);
		
		txtLimite = new JTextField();
		txtLimite.setColumns(10);
		txtLimite.setBounds(255, 115, 67, 20);
		pnlDadosConta.add(txtLimite);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cc.setNumeroBanco(Integer.parseInt(txtBanco.getText()));
				cc.setNumeroAgencia(Integer.parseInt(txtAgencia.getText()));
				cc.setNumeroConta(Integer.parseInt(txtConta.getText()));
				cc.setTitular(txtTitular.getText());
				cc.setSaldo(Double.parseDouble(txtSaldo.getText()));
				cc.setLimite(Double.parseDouble(txtLimite.getText()));
				
				txtSaida.setText(tc.abrirConta(cc));
				
				txtBanco.setEnabled(false);
				txtAgencia.setEnabled(false);
				txtConta.setEnabled(false);
				txtTitular.setEnabled(false);
				txtSaldo.setEnabled(false);
				txtLimite.setEnabled(false);
				btnAbrirConta.setEnabled(false);
			
			}
		});
		btnAbrirConta.setBounds(334, 86, 89, 46);
		pnlDadosConta.add(btnAbrirConta);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 364, 433, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tc.sacar(Double.parseDouble(txtValorTransacao.getText())));
				}
				
			}
		});
		btnSacar.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Website \u00BB Download.png")));
		btnSacar.setBounds(129, 9, 134, 35);
		panel.add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tc.depositar(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnDepositar.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Chest of Drawers \u00BB Open \u00BB Files.png")));
		btnDepositar.setBounds(129, 55, 134, 35);
		panel.add(btnDepositar);
		
		JButton btnTransferecnia = new JButton("Transferencia");
		btnTransferecnia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarValorTransacao()){
					txtSaida.append("\n"+tc.transferencia(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnTransferecnia.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Sign Post.png")));
		btnTransferecnia.setBounds(273, 9, 150, 35);
		panel.add(btnTransferecnia);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtSaida.append("\n"+tc.saldo());
				
			}
		});
		btnSaldo.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Hard Disk \u00BB Installation.png")));
		btnSaldo.setBounds(273, 55, 150, 35);
		panel.add(btnSaldo);
		
		JLabel lblValorTransacao = new JLabel("Valor Transa\u00E7\u00E3o:");
		lblValorTransacao.setBounds(10, 19, 122, 14);
		panel.add(lblValorTransacao);
		
		txtValorTransacao = new JTextField();
		txtValorTransacao.setBounds(10, 44, 109, 27);
		panel.add(txtValorTransacao);
		txtValorTransacao.setColumns(10);
		
		JPanel pnlSaida = new JPanel();
		pnlSaida.setBounds(10, 205, 433, 148);
		contentPane.add(pnlSaida);
		pnlSaida.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 413, 126);
		pnlSaida.add(scrollPane);
		
		txtSaida = new JTextArea();
		scrollPane.setViewportView(txtSaida);
	}
	
	
	private boolean validarValorTransacao(){
		boolean rs = true;
		if(txtValorTransacao.getText().equals("") || txtValorTransacao.getText()==null) {
			rs = false;
			JOptionPane.showMessageDialog(null, "O valor da transa??o deve ser preenchido");
		}
		return rs;
	}
	
}
