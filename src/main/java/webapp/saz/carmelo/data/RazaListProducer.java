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

import webapp.saz.carmelo.model.Raza;

@RequestScoped
public class RazaListProducer {
   @Inject
   private EntityManager em;

   private List<Raza> razas;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Raza> getRazas() {
      return razas;
   }

   public void onRazaListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Raza raza) {
      retrieveAllRazasOrderedByName();
   }

   @PostConstruct
   public void retrieveAllRazasOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Raza> criteria = cb.createQuery(Raza.class);
      Root<Raza> raza = criteria.from(Raza.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(raza).orderBy(cb.asc(raza.get("descr")));
      razas = em.createQuery(criteria).getResultList();
   }
}
