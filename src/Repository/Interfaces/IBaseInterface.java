package Repository.Interfaces;
import java.util.ArrayList;

import Exceptions.ProdutoCadastradoException;

public interface IBaseInterface<Tipo> {
		void Inserir(Tipo objeto);
		void Excluir(Tipo objeto);
		ArrayList<Tipo> GetAll();
}
