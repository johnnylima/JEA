package Dominio;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {
		private String Codigo;
		private int ValorTotal;
		private ArrayList<Produto> Produtos;
		private String Usuario;
		
		public String getCodigo() {
			return Codigo;
		}
		public void setCodigo(String codigo) {
			Codigo = codigo;
		}
		public int getValorTotal() {
			return ValorTotal;
		}
		public void setValorTotal(int valor) {
			ValorTotal += valor;
		}
		public ArrayList<Produto> getProdutos() {
			return Produtos;
		}
		public void setProdutos(Produto produto) {
			if(Produtos == null) {
				Produtos = new ArrayList<Produto>();
				Produto p = new Produto(produto.getDescricao(), produto.getCategoria(), produto.getValor(), produto.getFigura(), produto.getQuantidadeVendida(), "V");
				Produtos.add(p);
//				System.out.println(p.getCodigo());
//				System.out.println(produto.getCodigo());
			} else {
				Produtos.add(produto);
			}
		}
		public String getUsuario() {
			return Usuario;
		}
		public void setUsuario(String usuario) {
			Usuario = usuario;
		}
		
		private String gerarCodigo() {
			//instância um objeto da classe Random usando o construtor básico
	        Random gerador = new Random();
	        int max=999,
	        	min=100;
	         
//	        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25
//	        for (int i = 0; i < 20; i++) {
//	            System.out.println((gerador.nextInt((max - min) + 1) + min));
//	         }
	        return "V"+(gerador.nextInt((max - min) + 1) + min);
		}
}