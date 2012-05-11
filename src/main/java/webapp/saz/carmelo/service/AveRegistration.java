package webapp.saz.carmelo.service;

import webapp.saz.carmelo.model.Ave;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class AveRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Ave> aveEventSrc;

   public void register(Ave ave) throws Exception {
      log.info("Registrando " + ave.getPlaca());
      em.persist(ave);
      aveEventSrc.fire(ave);
   }
}
