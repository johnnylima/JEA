package Dominio;

import Enum.ECategoriaProduto;

public class Produto{
	private String Descricao;
	private ECategoriaProduto Categoria;
	private int Valor;
	private Estoque Estoque;
	private String Figura;
	
	public Produto(String descricao, ECategoriaProduto Categoria, int Valor, int QuantidadeDisponivel, String Figura) {
		this.setDescricao(descricao);
		this.setCategoria(Categoria);
		this.setValor(Valor);
		this.Figura = Figura;
		this.Estoque = new Estoque(QuantidadeDisponivel);
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

	public void AdiconarEstoque(int quantidade) {
		this.Estoque.AdicionarQuantidadeDisponivel(quantidade);;
	}

	public void RemoveEstoque(int quantidade) {
		this.Estoque.removeQuantidadeDisponivel(quantidade);
	}
	
	public int getQuantidadeDisponivel() {
		return this.Estoque.getQuantidadeDisponivel();
	}

	public int getQuantidadeVendida() {
		return this.Estoque.getQuantidadeVendida();
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.Estoque.setQuantidadeVendida(quantidadeVendida);
	}
}
