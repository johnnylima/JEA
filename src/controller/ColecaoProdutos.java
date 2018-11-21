package controller; 

import java.util.ArrayList;

public class ColecaoProdutos implements OperacoesProduto {
	
	protected ArrayList<Produto> produtos = new ArrayList<Produto>();

	@Override
	public boolean removeProduto(Produto o) {
		// TODO Auto-generated method stub
		if(produtos.remove(o)) return true;
		else return false;
	}

	@Override
	public void addProduto(Produto e) {
		// TODO Auto-generated method stub
		produtos.add(e);		
	}
	
	
	
	
	
}
