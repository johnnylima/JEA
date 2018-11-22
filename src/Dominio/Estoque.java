package Dominio;

public class Estoque {
	private int QuantidadeDisponivel;
	private int QuantidadeVendida;
	
	public Estoque(int QuantidadeDisponivel) {
		this.QuantidadeDisponivel = QuantidadeDisponivel;
	}
	
	public void AdicionarQuantidadeDisponivel(int quantidade) {
		QuantidadeDisponivel =+ quantidade;
	}
	
	public void removeQuantidadeDisponivel(int quantidade) {
		QuantidadeDisponivel =- quantidade;
	}
	
	public int getQuantidadeDisponivel() {
		return QuantidadeDisponivel;
	}

	public int getQuantidadeVendida() {
		return QuantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		QuantidadeVendida =+ quantidadeVendida;
	}
	
	public void RemoveQuantidadeVendida(int quantidadeVendida) {
		QuantidadeVendida =- quantidadeVendida;
	}
	

}
