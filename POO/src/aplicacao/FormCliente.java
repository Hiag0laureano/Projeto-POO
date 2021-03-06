package aplicacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import classes.PrjCliente;
import classes.PrjEndereco;
import classes.PrjUsuario;
import repositorio.RepoSistema;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
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
	public FormCliente() {
		setResizable(false);
		setTitle("Gerenciar Clientes");
		setBackground(new Color(102, 51, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdCliente = new JLabel("ID do Cliente:");
		lblIdCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdCliente.setBounds(20, 11, 92, 14);
		contentPane.add(lblIdCliente);
		
		JTextPane txtIdCliente = new JTextPane();
		txtIdCliente.setBounds(20, 26, 92, 20);
		contentPane.add(txtIdCliente);
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		lblNomeCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNomeCliente.setBounds(122, 11, 119, 14);
		contentPane.add(lblNomeCliente);
		
		JTextPane txtNomeCliente = new JTextPane();
		txtNomeCliente.setBounds(122, 26, 332, 20);
		contentPane.add(txtNomeCliente);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEmail.setBounds(20, 67, 119, 14);
		contentPane.add(lblEmail);
		
		JTextPane txtEmail = new JTextPane();
		txtEmail.setBounds(20, 81, 434, 20);
		contentPane.add(txtEmail);
		
		JLabel lblIdUsuario = new JLabel("ID do Usuario:");
		lblIdUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdUsuario.setBounds(20, 131, 92, 14);
		contentPane.add(lblIdUsuario);
		
		JTextPane txtIdUsuario = new JTextPane();
		txtIdUsuario.setBounds(20, 146, 92, 20);
		contentPane.add(txtIdUsuario);
		
		JLabel lblNomeUsuario = new JLabel("Nome do Usuario:");
		lblNomeUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNomeUsuario.setBounds(122, 131, 119, 14);
		contentPane.add(lblNomeUsuario);
		
		JTextPane txtNomeUsuario = new JTextPane();
		txtNomeUsuario.setBounds(122, 146, 204, 20);
		contentPane.add(txtNomeUsuario);
		
		JLabel lblSenhaUsuario = new JLabel("Senha:");
		lblSenhaUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSenhaUsuario.setBounds(336, 131, 119, 14);
		contentPane.add(lblSenhaUsuario);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(336, 146, 118, 20);
		contentPane.add(txtSenha);
		
		JLabel lblIdEndereco = new JLabel("ID do Endere\u00E7o:");
		lblIdEndereco.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdEndereco.setBounds(20, 200, 101, 14);
		contentPane.add(lblIdEndereco);
		
		JTextPane txtIdEndereco = new JTextPane();
		txtIdEndereco.setBounds(20, 215, 92, 20);
		contentPane.add(txtIdEndereco);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblLogradouro.setBounds(122, 200, 132, 14);
		contentPane.add(lblLogradouro);
		
		JTextPane txtLogradouro = new JTextPane();
		txtLogradouro.setBounds(122, 215, 332, 20);
		contentPane.add(txtLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumero.setBounds(20, 261, 101, 14);
		contentPane.add(lblNumero);
		
		JTextPane txtNumero = new JTextPane();
		txtNumero.setBounds(20, 276, 92, 20);
		contentPane.add(txtNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblBairro.setBounds(122, 261, 132, 14);
		contentPane.add(lblBairro);
		
		JTextPane txtBairro = new JTextPane();
		txtBairro.setBounds(122, 276, 332, 20);
		contentPane.add(txtBairro);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				//Instancia da Classe PrjUsuario
				PrjUsuario usuario = new PrjUsuario();
				//Instancia da Classe PrjEndereco
				PrjEndereco endereco = new PrjEndereco();
				//Instancia da Classe PrjCliente
				PrjCliente cliente = new PrjCliente();
				//Vamos Adicionar os clientes na memoria com o RepoSistema
				RepoSistema rs = new RepoSistema();
				
				//O ID do usuario so recebe numeros inteiros porem a caixa que ? digitada o id recebe o tipo text. Portanto se faz uma convers?o de texto para inteiro
				// Com o comando Integer.ParseInt
				usuario.idUsuario = Integer.parseInt(txtIdUsuario.getText());
				usuario.nomeUsuario = txtNomeUsuario.getText();
				usuario.senha = txtSenha.getText();
				
				endereco.idEndereco = Integer.parseInt(txtIdEndereco.getText());
				endereco.logradouro = txtLogradouro.getText();
				endereco.numero = txtNumero.getText();
				endereco.bairro = txtBairro.getText();
				
				cliente.idCliente = Integer.parseInt(txtIdCliente.getText());
				cliente.nomeCliente = txtNomeCliente.getText();
				cliente.email = txtEmail.getText();
				cliente.usuario = usuario;
				cliente.endereco = endereco;
				
				
				JOptionPane.showMessageDialog(null, rs.cadUsuario(usuario)+"\n"+rs.cadEndereco(endereco)+"\n"+rs.cadCliente(cliente));
			}
		});
		btnCadastrar.setBounds(20, 316, 92, 23);
		contentPane.add(btnCadastrar);
	}
}
