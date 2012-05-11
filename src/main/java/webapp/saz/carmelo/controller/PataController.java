package webapp.saz.carmelo.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import webapp.saz.carmelo.model.Pata;
import webapp.saz.carmelo.service.PataRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class PataController {

   @Inject
   private FacesContext facesContext;

   @Inject
   private PataRegistration pataRegistration;

   private Pata newPata;

   @Produces
   @Named
   public Pata getNewPata() {
      return newPata;
   }

   public void register() throws Exception {
      pataRegistration.register(newPata);
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      initNewPata();
   }

   @PostConstruct
   public void initNewPata() {
      newPata = new Pata();
   }
}
