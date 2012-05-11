package webapp.saz.carmelo.data;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import webapp.saz.carmelo.model.Criador;

@RequestScoped
public class CriadorListProducer {
   @Inject
   private EntityManager em;

   private List<Criador> criadores;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Criador> getCriadores() {
      return criadores;
   }

   public void onCriadorListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Criador criador) {
      retrieveAllCriadoresOrderedByName();
   }

   @PostConstruct
   public void retrieveAllCriadoresOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Criador> criteria = cb.createQuery(Criador.class);
      Root<Criador> criador = criteria.from(Criador.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(criador).orderBy(cb.asc(criador.get("descr")));
      criadores = em.createQuery(criteria).getResultList();
   }
}
