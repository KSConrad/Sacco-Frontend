package org.pahappa.systems.kimanyisacco.navigation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Contains the links to the different pages with in the application.
 * It is to help us navigate between the pages in the application easily.
 */
@ManagedBean(name = "navigation")
@ApplicationScoped //There should be only one instance of the class created for the entire application
public class Navigation {
    

 private final String dashboard = "/pages/dashboard/Dashboard.xhtml";

private final String landing = "/pages/landing/Landing.xhtml";
 private final String home = "/pages/log-in/home.xhtml";
 private final String approve = "/pages/admin/approve.xhtml";
    public String getApprove() {
    return approve;
}

    public String getDashboard() {
        return dashboard;
    }

    public String getLanding() {
        return landing;
    }
     public String getHome() {
        return home;
    }

    private final int notificationsCount = 3;

    public int getNotificationsCount() {
        return notificationsCount;
    }


}
