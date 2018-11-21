package controller; 

import Enum.ECategoriaProduto;

public class Produto extends Estoque{
	private String Descricao;
	private ECategoriaProduto Categoria;
	private double Valor;
	private Estoque Estoque;
	private String Figura;
	
	public Produto(String Descricao, ECategoriaProduto Categoria, double Valor, int qtd, String Figura) {
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

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public String getFigura() {
		return Figura;
	}
	
}
