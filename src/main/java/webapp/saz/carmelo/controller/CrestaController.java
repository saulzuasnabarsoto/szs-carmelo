package webapp.saz.carmelo.controller;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import webapp.saz.carmelo.model.Cresta;
import webapp.saz.carmelo.service.CrestaRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class CrestaController {

   @Inject
   private FacesContext facesContext;

   @Inject
   private CrestaRegistration crestaRegistration;

   private Cresta newCresta;

   @Produces
   @Named
   public Cresta getNewCresta() {
      return newCresta;
   }

   public void register() throws Exception {
      crestaRegistration.register(newCresta);
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      initNewCresta();
   }

   @PostConstruct
   public void initNewCresta() {
      newCresta = new Cresta();
   }
}
