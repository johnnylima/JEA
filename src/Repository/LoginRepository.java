package Repository;
import java.util.ArrayList;
import Dominio.Usuario;

public class LoginRepository extends UsuarioRepository{
    private static Usuario Session = null;
	
	public static boolean Logar(String login, String senha) {
		for(int i = 0; i < _usuarios.size(); i++) {
		Usuario user = _usuarios.get(i);
			if(user.getLogin().equals(login) && user.getSenha().equals(senha)) {
				Session = user;
				return true;
			}
		}
		return false;
	}
	
	public static Usuario getSession() {
		return Session;
	}

}
