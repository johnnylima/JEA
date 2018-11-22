package Repository;
import java.util.ArrayList;

import Dominio.Pedido;
import Dominio.Produto;
import Enum.ETipoUsuario;
import Exceptions.ProdutoCadastradoException;
import Repository.Interfaces.IBaseInterface;

public class ProdutoRepository implements IBaseInterface<Produto> {
	
		private ArrayList<Produto> _produtos = new ArrayList<Produto>();
		
		public void Inserir(Produto novoProduto){
			if(LoginRepository.getSession() != null) {
				if(LoginRepository.getSession().getTipoUsuario() == ETipoUsuario.Gerente) {
					
					for(Produto ped : _produtos) {
							if((ped.getDescricao().equals(novoProduto.getDescricao()) && 
									ped.getCategoria().equals(novoProduto.getCategoria()) && 
									ped.getValor() == novoProduto.getValor() && 
									ped.getQuantidadeDisponivel() == novoProduto.getQuantidadeDisponivel())) {
								System.out.println("ka cadas");
								return;
							}

					}
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
