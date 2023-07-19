package org.pahappa.systems.kimanyisacco.views.authentication;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.pahappa.systems.kimanyisacco.controllers.HyperLinks;
import org.pahappa.systems.kimanyisacco.models.User;

@ManagedBean(name = "loginForm")
@ViewScoped
public class LoginForm {
private User user;

    public void setUser(User user) {
    this.user = user;
}

    public LoginForm(){
        this.user=new User();
        
    }

    public User getUser(){
        return user;
    }

  public void doLogin() throws IOException{
    // System.out.println("mybaseurl:");
   String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+HyperLinks.dashboard);
  }
}
