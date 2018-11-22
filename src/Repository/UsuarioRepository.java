package Repository;
import java.util.ArrayList;
import Dominio.Usuario;

public class UsuarioRepository {
		protected static ArrayList<Usuario> _usuarios = new ArrayList<Usuario>();
		
		public void Inserir(Usuario novoUsuario) {
			_usuarios.add(novoUsuario);
		}
		
		public void Excluir(Usuario usuario) {
			_usuarios.remove(usuario);
		}
		
		//Retorna todo mundo
		public ArrayList<Usuario> GetAll(){
			return _usuarios;
		}
}
