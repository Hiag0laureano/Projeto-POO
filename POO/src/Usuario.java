
public class Usuario {
	public String nomeUsuario;
	public String senha;
	public String nivelAcesso;
	
	
	public void criarUsuario() {
		System.out.println("USuario criado com sucesso");
	}
	public void logar(String nomeUsuario, String senha) {
		if(this.nomeUsuario != nomeUsuario) {
			System.out.println("Usuario não encontrado");
		}
		else {
			System.out.println("Bem Vindo!");
		}
	}
}
