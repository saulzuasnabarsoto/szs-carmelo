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

import webapp.saz.carmelo.model.Ave;

@RequestScoped
public class AveListProducer {
   @Inject
   private EntityManager em;

   private List<Ave> aves;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Ave> getAves() {
      return aves;
   }

   public void onAveListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Ave ave) {
      retrieveAllAvesOrderedByName();
   }

   @PostConstruct
   public void retrieveAllAvesOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Ave> criteria = cb.createQuery(Ave.class);
      Root<Ave> ave = criteria.from(Ave.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(ave).orderBy(cb.asc(ave.get("placa")));
      aves = em.createQuery(criteria).getResultList();
   }
}
