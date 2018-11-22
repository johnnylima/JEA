package Repository;

import java.util.ArrayList;

import Dominio.Produto;
import Repository.Interfaces.IBaseInterface;

public class CarrinhoRepository implements IBaseInterface<Produto>{
	
	private ArrayList<Produto> _carrinho = new ArrayList<Produto>();

	public void Inserir(Produto produto) {
		_carrinho.add(produto);
		
	}

	public void Excluir(Produto produto) {
		_carrinho.remove(produto);
		
	}

	public ArrayList<Produto> GetAll() {
		return _carrinho;
	}
	
}
