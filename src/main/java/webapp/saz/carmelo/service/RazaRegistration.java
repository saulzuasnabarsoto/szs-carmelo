package webapp.saz.carmelo.service;

import webapp.saz.carmelo.model.Raza;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class RazaRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Raza> razaEventSrc;

   public void register(Raza raza) throws Exception {
      log.info("Registering " + raza.getDescr());
      em.persist(raza);
      razaEventSrc.fire(raza);
   }
}
