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

import webapp.saz.carmelo.model.Cresta;

@RequestScoped
public class CrestaListProducer {
   @Inject
   private EntityManager em;

   private List<Cresta> crestas;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Cresta> getCrestas() {
      return crestas;
   }

   public void onCrestaListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Cresta cresta) {
      retrieveAllCrestasOrderedByName();
   }

   @PostConstruct
   public void retrieveAllCrestasOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Cresta> criteria = cb.createQuery(Cresta.class);
      Root<Cresta> cresta = criteria.from(Cresta.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(cresta).orderBy(cb.asc(cresta.get("descr")));
      crestas = em.createQuery(criteria).getResultList();
   }
}
