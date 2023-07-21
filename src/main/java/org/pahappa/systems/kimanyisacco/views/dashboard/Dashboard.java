package org.pahappa.systems.kimanyisacco.views.dashboard;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ViewScoped
@ManagedBean(name = "dashboard")
public class Dashboard {
    private Date systemTime;


    public Dashboard() {
        this.systemTime = new Date();
    }

    public Date getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }


    public void showSession(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
ExternalContext externalContext = facesContext.getExternalContext();
HttpSession session = (HttpSession) externalContext.getSession(false);

// Retrieve the user's email from the session
String userEmail = (String) session.getAttribute("userName");
System.out.println(userEmail);
    }

}
