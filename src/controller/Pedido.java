package controller;

import java.util.ArrayList;
import java.util.Random;

public class Pedido extends ColecaoProdutos{
	private String Codigo;
	private int ValorTotal;
	private int Quantidade;
	
	public Pedido() {
		this.Codigo = "AJJ0"+(gerarCodigo());
	}
	
	
	public String getCodigo() {
		return Codigo;
	}
	
	public int getValorTotal() {
		return ValorTotal;
	}
	
	public void setValorTotal(int valorTotal) {
		ValorTotal = valorTotal;
	}
	
	public ArrayList<Produto> getProdutos() {
		return super.produtos;
	}
	
	public int qtdProduto() {
		return super.produtos.size(); 
	}
	
	private int gerarCodigo() {
		//instância um objeto da classe Random usando o construtor básico
        Random gerador = new Random();
        int max=999,
        	min=100;
         
//        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25
//        for (int i = 0; i < 20; i++) {
//            System.out.println((gerador.nextInt((max - min) + 1) + min));
//         }
        return (gerador.nextInt((max - min) + 1) + min);
	}
	
}
