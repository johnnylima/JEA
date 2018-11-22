package Exceptions;

public class ProdutoCadastradoException extends Exception{
	public ProdutoCadastradoException() {
		super("Produto ja cadastrado");
	}
}
