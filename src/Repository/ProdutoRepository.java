package Repository;
import java.util.ArrayList;

import Dominio.Produto;
import Enum.ETipoUsuario;
import Repository.Interfaces.IBaseInterface;

public class ProdutoRepository implements IBaseInterface<Produto> {
	
		private ArrayList<Produto> _produtos = new ArrayList<Produto>();
		
		public void Inserir(Produto novoProduto) {
			if(LoginRepository.getSession() != null) {
				if(LoginRepository.getSession().getTipoUsuario() == ETipoUsuario.Gerente) {
					_produtos.add(novoProduto);
				} else {
					System.out.println("Usuario nao permitido");
				}
			} else {
				System.out.println("Usuario nao logado");
			}
		}
		
		public ArrayList<Produto> GetAll(){
			return _produtos;
		}
		
		public void Excluir(Produto produto) {
			if(LoginRepository.getSession() != null) {
				if(LoginRepository.getSession().getTipoUsuario() == ETipoUsuario.Gerente) {
					_produtos.remove(produto);
				}
			}
		}
		
}
