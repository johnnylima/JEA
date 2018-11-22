package Dominio;
import java.util.ArrayList;

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
				Produtos.add(produto);
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
}