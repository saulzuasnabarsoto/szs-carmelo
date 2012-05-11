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

import webapp.saz.carmelo.model.Pata;

@RequestScoped
public class PataListProducer {
   @Inject
   private EntityManager em;

   private List<Pata> patas;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Pata> getPatas() {
      return patas;
   }

   public void onPataListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Pata pata) {
      retrieveAllPatasOrderedByName();
   }

   @PostConstruct
   public void retrieveAllPatasOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Pata> criteria = cb.createQuery(Pata.class);
      Root<Pata> pata = criteria.from(Pata.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(pata).orderBy(cb.asc(pata.get("descr")));
      patas = em.createQuery(criteria).getResultList();
   }
}
