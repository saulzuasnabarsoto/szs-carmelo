package webapp.saz.carmelo.service;

import webapp.saz.carmelo.model.Pata;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class PataRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Pata> pataEventSrc;

   public void register(Pata pata) throws Exception {
      log.info("Registering " + pata.getDescr());
      em.persist(pata);
      pataEventSrc.fire(pata);
   }
}
