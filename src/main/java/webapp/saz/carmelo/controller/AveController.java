package webapp.saz.carmelo.controller;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import webapp.saz.carmelo.model.Ave;
import webapp.saz.carmelo.model.Cresta;
import webapp.saz.carmelo.model.Criador;
import webapp.saz.carmelo.model.Pata;
import webapp.saz.carmelo.model.Raza;
import webapp.saz.carmelo.model.Sexo;
import webapp.saz.carmelo.service.AveRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class AveController {

   @Inject
   private FacesContext facesContext;

   @Inject
   private AveRegistration aveRegistration;

   private Ave newAve;

   private Sexo newSexo1;
   private Raza newRaza1;
   private Pata newPata1;
   private Cresta newCresta1;
   private Criador newCriador1;
   
   @Produces
   @Named
   public Ave getNewAve() {
      return newAve;
   }

   @Produces
   @Named
   public Sexo getNewSexo1() {
      return newSexo1;
   }

   @Produces
   @Named
   public Raza getNewRaza1() {
      return newRaza1;
   }
   
   @Produces
   @Named
   public Pata getNewPata1() {
      return newPata1;
   }
   
   @Produces
   @Named
   public Cresta getNewCresta1() {
      return newCresta1;
   }
   
   @Produces
   @Named
   public Criador getNewCriador1() {
      return newCriador1;
   }

   public void register() throws Exception {
	  newAve.setSexo(newSexo1);
	  newAve.setRaza(newRaza1);
	  newAve.setPata(newPata1);
	  newAve.setCresta(newCresta1);
	  newAve.setCriador(newCriador1);
	  
      aveRegistration.register(newAve);
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      initNewAve();
   }

   @PostConstruct
   public void initNewAve() {
      newAve = new Ave();
      newSexo1 = new Sexo();
      newRaza1 = new Raza();
      newPata1 = new Pata();
      newCresta1 = new Cresta();
      newCriador1 = new Criador();
      newAve.setAveIdPadre(0);
      newAve.setAveIdMadre(0);
   }
}
