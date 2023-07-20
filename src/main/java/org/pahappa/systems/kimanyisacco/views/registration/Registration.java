package org.pahappa.systems.kimanyisacco.views.registration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.pahappa.systems.kimanyisacco.controllers.HyperLinks;
import org.pahappa.systems.kimanyisacco.models.Members;
import org.pahappa.systems.kimanyisacco.services.MemberImpl;
import org.pahappa.systems.kimanyisacco.services.UserImpl;

@ManagedBean(name = "registration")
@ViewScoped
public class Registration {
private Members member;
MemberImpl memberImpl = new MemberImpl();
public Members getMember(){
        return member;
    }

 public void  setMembers(Members member){
      this.member=member;
    }   


 
    public Registration(){
        this.member=new Members();
        
    
    }

  public void doRegistration() throws IOException{
   
    System.out.println(member.getLastName());
   String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/log-in/home.xhtml");
     memberImpl.createMember(member) ; 
     List <Members> result = new java.util.ArrayList<>();
    result =memberImpl.getAllMembers();

    for(Members member:result){
      System.out.println(member.getFirstName());
    }
  }
}
