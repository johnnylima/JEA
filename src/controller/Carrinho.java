package controller; 

import java.util.ArrayList;

public class Carrinho extends ColecaoProdutos{
	
	public ArrayList<Produto> getProdutos() {
		return super.produtos;
	}
	
	public int qtdProdutos() {
		return super.produtos.size(); 
	}
	
	
	
}
