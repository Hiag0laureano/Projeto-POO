package classes;

// T é a injeção de dependecia dentro da interface
public interface Operacoes<T> {
	
	public String abrirConta(T conta);
	public String depositar(double valor);
	public String sacar(double valor);
	public String saldo();
	public String transferencia(double valor);
}
