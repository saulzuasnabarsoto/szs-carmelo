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

import webapp.saz.carmelo.model.Sexo;

@RequestScoped
public class SexoListProducer {
   @Inject
   private EntityManager em;

   private List<Sexo> sexos;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Sexo> getSexos() {
      return sexos;
   }

   public void onRazaListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Sexo sexo) {
      retrieveAllSexosOrderedByName();
   }

   @PostConstruct
   public void retrieveAllSexosOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Sexo> criteria = cb.createQuery(Sexo.class);
      Root<Sexo> sexo = criteria.from(Sexo.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(sexo).orderBy(cb.asc(sexo.get("descr")));
      sexos = em.createQuery(criteria).getResultList();
   }
}
