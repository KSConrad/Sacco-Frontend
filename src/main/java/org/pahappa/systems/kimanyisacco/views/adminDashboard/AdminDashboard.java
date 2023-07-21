 package org.pahappa.systems.kimanyisacco.views.adminDashboard;

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

@ManagedBean(name = "admin")
@SessionScoped
public class AdminDashboard {
private Members member;
private Members memberResult; 
MemberImpl memberImpl = new MemberImpl();
public Members getMember(){
        return member;
    }

 public void  setMembers(Members member){
      this.member=member;
    }   
    // Add this field to hold the result
    private List<Members> result; // Add this property

    public List<Members> getResult() {
        return result;
    }

    public void setResult(List<Members> result) {
        this.result = result;
    }
   

    public Members getMemberResult() {
      return memberResult;
  }

  public void setMemberResult(Members MemberResult) {
      this.memberResult = memberResult;
  }

 
    public AdminDashboard(){
        this.member=new Members();
        this.memberResult=new Members();
        
    
    }

  public void viewJoin() throws IOException{
    
   
    result =memberImpl.getJoinRequests(); 
    
    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/joinRequests.xhtml");

for(Members member:result){
    System.out.println(member.getFirstName());
}   
  }

  
  public void doApprove(Members memberResult)throws IOException{
    this.memberResult = memberResult;
    
    System.out.println("Name"+ memberResult.getFirstName());
    System.out.println("Name"+ memberResult.getStatus());

    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/approve.xhtml");
  }

  public void Approve(long id) throws IOException{
    System.out.println(id);
    memberImpl.updateStatus(id);
    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/adminDashboard.xhtml");   

  }
 }






 