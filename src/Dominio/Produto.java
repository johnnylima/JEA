package Dominio;

import java.util.Random;

import Enum.ECategoriaProduto;

public class Produto{
	private String Descricao;
	private ECategoriaProduto Categoria;
	private int Valor;
	private Estoque Estoque;
	private String Figura;
	private String Codigo;
	
	public Produto(String descricao, ECategoriaProduto Categoria, int Valor, int QuantidadeDisponivel, String Figura) {
		this.setDescricao(descricao);
		this.setCategoria(Categoria);
		this.setValor(Valor);
		this.Figura = Figura;
		this.Estoque = new Estoque(QuantidadeDisponivel);
		this.setCodigo(gerarCodigo("C"));
	}
	
	public Produto(String descricao, ECategoriaProduto Categoria, int Valor, String Figura, int QuantidadeVendida, String prefix) {
		this.setDescricao(descricao);
		this.setCategoria(Categoria);
		this.setValor(Valor);
		this.Figura = Figura;
		this.Estoque = new Estoque();
		this.Estoque.setQuantidadeVendida(QuantidadeVendida);
		this.setCodigo(gerarCodigo(prefix));
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
	
	public void RemoveQuantidadeVendida(int quantidadeVendida) {
		this.Estoque.RemoveQuantidadeVendida(quantidadeVendida);
	}
	
	
	private String gerarCodigo(String prefix) {
		//instância um objeto da classe Random usando o construtor básico
        Random gerador = new Random();
        int max=999,
        	min=100;
         
//        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25
//        for (int i = 0; i < 20; i++) {
//            System.out.println((gerador.nextInt((max - min) + 1) + min));
//         }
        return prefix+(gerador.nextInt((max - min) + 1) + min);
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
}
