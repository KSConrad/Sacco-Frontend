package org.pahappa.systems.kimanyisacco.views.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import javax.servlet.http.HttpSession;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.pahappa.systems.kimanyisacco.controllers.HyperLinks;
import org.pahappa.systems.kimanyisacco.daos.AddMember;
import org.pahappa.systems.kimanyisacco.models.Members;
import org.pahappa.systems.kimanyisacco.services.MemberImpl;

@ManagedBean(name = "loginForm")
@ViewScoped
public class LoginForm {
private Members member;
MemberImpl memberImpl = new MemberImpl();
public Members getMember(){
        return member;
    }

 public void  setMember(Members member){
      this.member=member;
    }   

    public LoginForm(){

     
      this.member=new Members();
      
        
    
    }

    public void init(){
      this.member= new Members();
    }

    

  public void doLogin() throws IOException{
    System.out.println(member.getUserName());
   boolean userExists=memberImpl.checkUserCredentials(member.getUserName(),member.getPassword());
   if(userExists){

    FacesContext facesContext = FacesContext.getCurrentInstance();
     ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(true);

    session.setAttribute("userName", member.getUserName());

   String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
   System.out.println("mybaseurl:"+context);
   FacesContext.getCurrentInstance().getExternalContext().redirect(context+HyperLinks.dashboard);
   }

    // System.out.println(member.getUserName());
    // boolean userExists = memberImpl.checkUserCredentials(member.getUserName(), member.getPassword());
    // if(userExists){
    //       // Set the logged-in user's email in the session for later use
    //       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggedInUserEmail", member.getEmail());
    //       return "Dashboard?faces-redirect=true";

    // }

    // else{
    //            // Show an error message if login fails
    //            FacesContext.getCurrentInstance().addMessage(null,
    //            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
    //    return null;
   
    // }

  }
    

    

    


  // public void doLog() throws IOException{
   
  //   System.out.println(user.getPassword());
  //  String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
  //   System.out.println("mybaseurl:"+context);
  //   FacesContext.getCurrentInstance().getExternalContext().redirect(context+HyperLinks.dashboard);
  //    userImpl.createUser(user) ; 
  //    List <User> result = new java.util.ArrayList<>();
  //   result =userImpl.getAllUsers();

  //   for(User users:result){
  //     System.out.println(users.getUserName());
  //   }
  // }
}
