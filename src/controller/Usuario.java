package controller; 

import Enum.ETipoUsuario;

public class Usuario {
	
	private String Login;
	private String Senha;
	private ETipoUsuario TipoUsuario;
	
	public Usuario(String login, String senha, ETipoUsuario tipoUsuario) {
		Login = login;
		Senha = senha;
		TipoUsuario = tipoUsuario;
	}
	
	public String getLogin() {
		return Login;
	}
	
	public void setLogin(String login) {
		Login = login;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setTipoUsuario(ETipoUsuario tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	
	public ETipoUsuario getTipoUsuario() {
		return TipoUsuario;
	}
}
