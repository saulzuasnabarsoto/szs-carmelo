package webapp.saz.carmelo.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import webapp.saz.carmelo.model.Criador;
import webapp.saz.carmelo.service.CriadorRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class CriadorController {

   @Inject
   private FacesContext facesContext;

   @Inject
   private CriadorRegistration criadorRegistration;

   private Criador newCriador;

   @Produces
   @Named
   public Criador getNewCriador() {
      return newCriador;
   }

   public void register() throws Exception {
      criadorRegistration.register(newCriador);
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      initNewCriador();
   }

   @PostConstruct
   public void initNewCriador() {
      newCriador = new Criador();
   }
}