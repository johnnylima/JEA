package controller; 

import Enum.ECategoriaProduto;

public class Produto extends Estoque{
	private String Descricao;
	private ECategoriaProduto Categoria;
	private int Valor;
	private String Figura;
	
	public Produto(String Descricao, ECategoriaProduto Categoria, int Valor, int qtd, String Figura) {
		this.setDescricao(Descricao);
		this.setCategoria(Categoria);
		this.setValor(Valor);
		this.Figura = Figura;
		estoqueAdd(qtd);
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public ECategoriaProduto getCategoria() {
		return Categoria;
	}

	public void setCategoria(ECategoriaProduto categoria) {
		Categoria = categoria;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

	public String getFigura() {
		return Figura;
	}
	
}
