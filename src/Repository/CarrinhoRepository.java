package Repository;

import java.util.ArrayList;

import Dominio.Produto;
import Repository.Interfaces.IBaseInterface;

public class CarrinhoRepository implements IBaseInterface<Produto>{
	
	private ArrayList<Produto> _carrinho = new ArrayList<Produto>();
	private int ValorTotal=0;
	

	public void Inserir(Produto produto) {
		_carrinho.add(produto);
		
	}

	public void Excluir(Produto produto) {
		_carrinho.remove(produto);
		
	}
	
	public void ExcluirTodos() {
		_carrinho.clear();
	}

	public ArrayList<Produto> GetAll() {
		return _carrinho;
	}
	
	
	public int getValorTotal() {
		return ValorTotal;
	}
	
	public void setValorTotal(ArrayList<Produto> produto) {
		int valorTotal=0;
		for	(Produto prod : produto) {
					valorTotal += (prod.getValor()*prod.getQuantidadeVendida());
		}
		ValorTotal = valorTotal;
	}
	
	public void zerarValorTotal() {
		ValorTotal=0;
	}
	
}
