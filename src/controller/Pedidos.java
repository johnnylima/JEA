package controller;

import java.util.ArrayList;

public class Pedidos {
	
	protected ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public Pedido getPedido(String codigo) {
		for(Pedido p: this.pedidos) {
			if(p.getCodigo().equals(codigo)) return p;
		}
		return null;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void addPedido(Pedido e) {
		pedidos.add(e);		
	}
	public int qtdPedidos() {
		return pedidos.size();
	}

}
