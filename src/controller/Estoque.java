package controller;

public class Estoque{
	private int Quantidade;
	
//	public Estoque(int QuantidadeDisponivel) {
//		this.Quantidade = QuantidadeDisponivel;
//	}
		

	public void estoqueAdd(int qtd) {
		// TODO Auto-generated method stub
		Quantidade += qtd;
	}
	
	public void estoqueRemove(int qtd) {
		// TODO Auto-generated method stub
		Quantidade -= qtd;
	}
	
	public int estoqueQtd() {
		// TODO Auto-generated method stub
		return Quantidade;
	}
}
