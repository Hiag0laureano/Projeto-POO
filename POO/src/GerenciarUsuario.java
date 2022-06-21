
public class GerenciarUsuario {

	public static void main(String[] args) {
		Usuario us = new Usuario();
		us.nomeUsuario = "Admin";
		us.senha = "123";
		us.nivelAcesso = "Admin";
		us.criarUsuario();
		
	}

}
