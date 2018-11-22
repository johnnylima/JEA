package Repository;

import java.util.ArrayList;
import java.util.Random;

import Dominio.Pedido;
import Dominio.Produto;
import Exceptions.LimiteMaximoException;

public class PedidoRepository {

	private ArrayList<Pedido> _pedidos = new ArrayList<Pedido>();
	
	public void Inserir(ArrayList<Produto> produto) throws LimiteMaximoException {
		Pedido pedido = new Pedido();
		pedido.setCodigo(gerarCodigo());
		
		for	(Produto prod : produto) {
				if(prod.getQuantidadeVendida() <= 10) {
					pedido.setValorTotal(prod.getValor()*prod.getQuantidadeVendida());
					pedido.setProdutos(prod);
				} else {
					throw new LimiteMaximoException();
				}
		}
		
		pedido.setUsuario(LoginRepository.getSession().getLogin());
		_pedidos.add(pedido);
	}

	public void Excluir(Pedido pedido) {
		_pedidos.remove(pedido);
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
