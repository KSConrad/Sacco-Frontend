package org.pahappa.systems.kimanyisacco.views.authentication;

import java.io.IOException;
import java.text.DecimalFormat;
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
import org.pahappa.systems.kimanyisacco.models.Transactions;
import org.pahappa.systems.kimanyisacco.services.MemberImpl;
import org.pahappa.systems.kimanyisacco.services.TransactionsImpl;

@ManagedBean(name = "loginForm")
@SessionScoped
public class LoginForm {
private Members member;
private Members memberResult;
private String formattedBalance;
private String formattedTransactionType;
private Transactions recentTransaction;
private int withdraws;
private int joins;
private int memberNumber;
public int getWithdraws() {
  return withdraws;
}

public void setWithdraws(int withdraws) {
  this.withdraws = withdraws;
}

public int getJoins() {
  return joins;
}

public void setJoins(int joins) {
  this.joins = joins;
}

public int getMemberNumber() {
  return memberNumber;
}

public void setMemberNumber(int memberNumber) {
  this.memberNumber = memberNumber;
}


MemberImpl memberImpl = new MemberImpl();
TransactionsImpl transImpl = new TransactionsImpl();

public String getFormattedBalance() {
  return formattedBalance;
}

public void setFormattedBalance(String formattedBalance) {
  this.formattedBalance = formattedBalance;
}

public String getFormattedTransactionType() {
  return formattedTransactionType;
}

public void setFormattedTransactionType(String formattedTransactionType) {
  this.formattedBalance = formattedTransactionType;
}

public Members getMemberResult() {
  return memberResult;
}

public void setMemberResult(Members memberResult) {
  this.memberResult = memberResult;
}

public Transactions getRecentTransaction() {
  return recentTransaction;
}

public void setRecentTransaction(Transactions recentTransaction) {
  this.recentTransaction = recentTransaction;
}


private double accountBalance;
public double getAccountBalance() {
  return accountBalance;
}

public void setAccountBalance(double accountBalance) {
  this.accountBalance = accountBalance;
}





public Members getMember(){
        return member;
    }

 public void  setMember(Members member){
      this.member=member;
    }   

    public LoginForm(){

     
      this.member=new Members();
       this.memberResult=new Members();
       this.recentTransaction= new Transactions();
        
    
    }

    public void init(){
      this.member= new Members();
    }


    

  public void doLogin() throws IOException{
   
    
    System.out.println(member.getUserName());
   memberResult=memberImpl.checkUserCredentials(member.getUserName(),member.getPassword());
   recentTransaction = transImpl.getRecent(member.getUserName());
   withdraws = transImpl.getWithdraws();
   joins = memberImpl.getJoins();
   memberNumber = memberImpl.getMembers();

   if(memberResult!=null){
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
       formattedBalance = decimalFormat.format(memberResult.getAccountBalance());
      formattedTransactionType =decimalFormat.format(recentTransaction.getAmount()) ;

      
       System.out.println(formattedBalance );



    FacesContext facesContext = FacesContext.getCurrentInstance();
     ExternalContext externalContext = facesContext.getExternalContext();
    HttpSession session = (HttpSession) externalContext.getSession(true);

    session.setAttribute("userName", member.getUserName());

    if(member.getUserName().equals("daniella.wwcd@gmail.com")){
String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
   System.out.println("mybaseurl:"+context);
   FacesContext.getCurrentInstance().getExternalContext().redirect(context+"/pages/admin/adminDashboard.xhtml");
    }

    else{

   String context= FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
   System.out.println("mybaseurl:"+context);
   FacesContext.getCurrentInstance().getExternalContext().redirect(context+HyperLinks.dashboard);}
   }

   else{
    FacesContext.getCurrentInstance().addMessage("growl",
    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed",
        "The username or password you entered is incorrect. Please try again"));
   }

   

  }
    

    

   public void display(){

    FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        
        // Retrieve the user's email from the session
        String userEmail = (String) session.getAttribute("userName");
    
        Members m = memberImpl.getMemberByUsername(userEmail);
 recentTransaction = transImpl.getRecent(member.getUserName());
  DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
       formattedBalance = decimalFormat.format(m.getAccountBalance());
      formattedTransactionType =decimalFormat.format(recentTransaction.getAmount()) ;
withdraws = transImpl.getWithdraws();
   joins = memberImpl.getJoins();
   memberNumber = memberImpl.getMembers();
  
   }


  
}
