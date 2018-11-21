package controller;

import java.util.ArrayList;

public class Carrinho extends ColecaoProdutos{
	
	public ArrayList<Produto> getProdutos() {
		return super.produtos;
	}
	
	public int qtdProduto() {
		return super.produtos.size();
	}
	
}
