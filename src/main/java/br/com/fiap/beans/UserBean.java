package br.com.fiap.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {
	
	private User user = new User();
	
	public void save() {
		new UserDao().save(this.user);
		this.user = new User();
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
	}
	
	public List<User> getUsers(){
		return new UserDao().getAll();
	}

	
	public void executar() {
		System.out.println("acionando o bean");
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	
}


