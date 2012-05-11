package webapp.saz.carmelo.service;

import webapp.saz.carmelo.model.Criador;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class CriadorRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Criador> criadorEventSrc;

   public void register(Criador criador) throws Exception {
      log.info("Registering " + criador.getDescr());
      em.persist(criador);
      criadorEventSrc.fire(criador);
   }
}
