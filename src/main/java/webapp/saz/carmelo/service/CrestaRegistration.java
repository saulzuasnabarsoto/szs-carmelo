package webapp.saz.carmelo.service;

import webapp.saz.carmelo.model.Cresta;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class CrestaRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Cresta> crestaEventSrc;

   public void register(Cresta cresta) throws Exception {
      log.info("Registering " + cresta.getDescr());
      em.persist(cresta);
      crestaEventSrc.fire(cresta);
   }
}
