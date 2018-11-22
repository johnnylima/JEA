package Repository.Interfaces;
import java.util.ArrayList;

public interface IBaseInterface<Tipo> {
		void Inserir(Tipo objeto);
		void Excluir(Tipo objeto);
		ArrayList<Tipo> GetAll();
}
