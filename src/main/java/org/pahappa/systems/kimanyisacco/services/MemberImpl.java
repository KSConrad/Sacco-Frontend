package org.pahappa.systems.kimanyisacco.services;




import java.io.UnsupportedEncodingException;
import java.util.List;

import org.pahappa.systems.kimanyisacco.daos.AddMember;
import org.pahappa.systems.kimanyisacco.daos.AddUser;
import org.pahappa.systems.kimanyisacco.models.Members;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



public class MemberImpl  {
   
   AddMember memberDAO = new AddMember();
    
    public void createMember(Members member) {


        if (member.getPassword() == null || member.getPassword().trim().isEmpty()) {
            // If password is empty or null, set it to the generated ID
            member.setPassword(member.getEmail());
        }

        if (member.getUserName() == null || member.getUserName().trim().isEmpty()) {
            // If password is empty or null, set it to the generated ID
            member.setUserName(member.getEmail());
        }

        if (member.getStatus() == null || member.getStatus().trim().isEmpty()) {
            // If password is empty or null, set it to the generated ID
            member.setStatus("PENDING");
        }

        
        memberDAO.save(member);
      
    }

    public List<Members> getAllMembers(){
        return memberDAO.getAllMembers();
    }

public List<Members> getJoinRequests(){
        return memberDAO.getJoinRequests();
    }

    public void sendApprovalEmail(String recipientEmail,String firstName) {
        // Configure the email properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");


        // Set up the session with the authentication details
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("caden.wwdd@gmail.com", "tlipzljibdhzptke");
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("caden.wwdd@gmail.com","Kimwanyi SACCO"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Kimwanyi SACCO Membership Approval");
            message.setText( "Dear "+ firstName + ",\n\n" +
            "We are delighted to inform you that your membership application to Kimwanyi SACCO has been approved!\n\n" +
            "Here are your login credentials:\n\n" +
            "Username: " + recipientEmail + "\n" +
            "Temporary Password: " + recipientEmail + "\n\n" +
            "Please use the provided credentials to log in to your account. For security purposes, we recommend that you change your password after your first login.\n\n" +
            "Thank you for joining Kimwanyi SACCO. We look forward to serving you.\n\n" +
            "Best regards,\n" +
            "Kimwanyi SACCO Team");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle the exception if the email sending fails
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // Handle the exception if the email sending fails
        }
    }
    
public Members getMemberByUsername(String userName){
    return memberDAO.getMemberByUsername(userName);
}
 public void updateStatus(String userName){
    memberDAO.updateStatus(userName);
 }  

 public void updateMember(Members updatedDetails){
    memberDAO.updateMember(updatedDetails);
 }  
 
 public Members checkUserCredentials(String userName,String password){
    Members memberByCredentials = memberDAO.getMemberByCredentials(userName,password);
  
    


    return memberByCredentials;
   
 }
    
}
