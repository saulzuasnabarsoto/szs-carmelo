package webapp.saz.carmelo.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import webapp.saz.carmelo.model.Credentials;
import webapp.saz.carmelo.model.User;

@SessionScoped
@Named
public class Login implements Serializable {

   private static final long serialVersionUID = 7965455427888195913L;

   @Inject
   private Credentials credentials;

   @Inject
   private UserManager userManager;

   private User currentUser;

   public String login() throws Exception {
	   String outcome = "login";
      User user = userManager.findUser(credentials.getUsername(), credentials.getPassword());
      if (user != null) {
         this.currentUser = user;
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome, " + currentUser.getName()));
         outcome = "home";
      }
      return outcome;
   }

   public void logout() {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Goodbye, " + currentUser.getName()));
      currentUser = null;
   }

   public boolean isLoggedIn() {
      return currentUser != null;
   }

   @Produces
   @LoggedIn
   public User getCurrentUser() {
      return currentUser;
   }

}