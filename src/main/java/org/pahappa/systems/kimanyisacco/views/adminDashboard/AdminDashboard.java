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
import org.pahappa.systems.kimanyisacco.models.Transactions;
import org.pahappa.systems.kimanyisacco.services.MemberImpl;
import org.pahappa.systems.kimanyisacco.services.TransactionsImpl;
import org.pahappa.systems.kimanyisacco.services.UserImpl;

@ManagedBean(name = "admin")
@SessionScoped
public class AdminDashboard {
private Members member;
private Members memberResult; 
private Transactions memberTransaction;
public Transactions getMemberTransaction() {
  return memberTransaction;
}

public void setMemberTransactions(Transactions memberTransactions) {
  this.memberTransaction = memberTransaction;
}
MemberImpl memberImpl = new MemberImpl();
TransactionsImpl transImpl = new TransactionsImpl();
public Members getMember(){
        return member;
    }

 public void  setMembers(Members member){
      this.member=member;
    }   
    // Add this field to hold the result
    private List<Members> result; 
    private List<Transactions> withdraws;// Add this property

    public List<Transactions> getWithdraws() {
      return withdraws;
    }

    public void setWithdraws(List<Transactions> withdrawResult) {
      this.withdraws = withdrawResult;
    }

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
        this.memberTransaction=new Transactions();
        
    
    }

  public List<Members> viewJoin() throws IOException{
    
    return memberImpl.getJoinRequests(); 
    
    
  }

  
  public void doApprove(Members memberResult)throws IOException{
    this.memberResult = memberResult;
    
    System.out.println("Name"+ memberResult.getFirstName());
    System.out.println("Name"+ memberResult.getStatus());

    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/approve.xhtml");
  }

  public void Approve(String userName,String firstName) throws IOException{
    System.out.println(userName);
    memberImpl.updateStatus(userName);
    memberImpl.sendApprovalEmail(userName,firstName);
    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/adminDashboard.xhtml");   

  }

  public List<Transactions> viewRequests() throws IOException{
    
   return transImpl.getWithdrawalRequests();
    
    
    // String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    // System.out.println("mybaseurl:"+context);
    // FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/withdrawalRequests.xhtml");

// for(Transactions t:withdraws){
//     System.out.println(t.getMember().getFirstName());
//      System.out.println(t.getCreatedOn());

// }   
  }

  public void viewWithdrawal(Transactions memberTransaction) throws IOException{
    this.memberTransaction = memberTransaction;
    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/approveWithdrawals.xhtml");

  }

  public void approveWithdrawal(String userName,int id,String decision) throws IOException{
    System.out.println(userName);
    transImpl.updateStatus(id,decision);
    String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    System.out.println("mybaseurl:"+context);
    FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/adminDashboard.xhtml");   

  }



 }






 