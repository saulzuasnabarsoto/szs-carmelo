package webapp.saz.carmelo.controller;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import webapp.saz.carmelo.model.Raza;
import webapp.saz.carmelo.service.RazaRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class RazaController {

   @Inject
   private FacesContext facesContext;

   @Inject
   private RazaRegistration razaRegistration;

   private Raza newRaza;

   @Produces
   @Named
   public Raza getNewRaza() {
      return newRaza;
   }

   public void register() throws Exception {
      razaRegistration.register(newRaza);
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      initNewRaza();
   }

   @PostConstruct
   public void initNewRaza() {
      newRaza = new Raza();
   }
}
