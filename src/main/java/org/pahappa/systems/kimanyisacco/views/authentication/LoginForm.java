package org.pahappa.systems.kimanyisacco.views.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.pahappa.systems.kimanyisacco.controllers.HyperLinks;
import org.pahappa.systems.kimanyisacco.models.User;
import org.pahappa.systems.kimanyisacco.services.UserImpl;

@ManagedBean(name = "loginForm")
@ViewScoped
public class LoginForm {
private User user;
UserImpl userImpl = new UserImpl();
public User getUser(){
        return user;
    }

 public void  setUser(User user){
      this.user=user;
    }   

    public LoginForm(){
        this.user=new User();
        
    
    }

    public void init(){
      this.user= new User();
    }

    

     
    

    

    


  public void doLogin() throws IOException{
   
    System.out.println(user.getPassword());
   String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+HyperLinks.dashboard);
     userImpl.createUser(user) ; 
     List <User> result = new java.util.ArrayList<>();
    result =userImpl.getAllUsers();

    for(User users:result){
      System.out.println(users.getUserName());
    }
  }
}
