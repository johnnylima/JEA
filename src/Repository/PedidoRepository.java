package Repository;

import java.util.ArrayList;
import java.util.Random;

import Dominio.Pedido;
import Dominio.Produto;
import Repository.Interfaces.IBaseInterface;

public class PedidoRepository {

	private ArrayList<Pedido> _pedidos = new ArrayList<Pedido>();
	
	public void Inserir(ArrayList<Produto> produto) {
		Pedido pedido = new Pedido();
		pedido.setCodigo(gerarCodigo());
		
		for	(Produto prod : produto) {
			pedido.setValorTotal(prod.getValor());
			pedido.setProdutos(prod);
		}
		
		pedido.setUsuario(LoginRepository.getSession().getLogin());
		_pedidos.add(pedido);
	}

	public void Excluir(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Pedido> GetAll() {
		return _pedidos;
	}
	
	public Pedido getPedido(String codigo) {
		for(Pedido ped : _pedidos) {
			if(ped.getCodigo().equals(codigo)) {
				return ped;
			}
		}
		return null;
	}
	
	private String gerarCodigo() {
		//instância um objeto da classe Random usando o construtor básico
        Random gerador = new Random();
        int max=999,
        	min=100;
         
//        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25
//        for (int i = 0; i < 20; i++) {
//            System.out.println((gerador.nextInt((max - min) + 1) + min));
//         }
        return "AJJ0"+(gerador.nextInt((max - min) + 1) + min);
	}
	
}
