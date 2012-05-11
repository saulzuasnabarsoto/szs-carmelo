package webapp.saz.carmelo.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cresta", catalog = "carmelo_db")
public class Cresta {

	private Integer id;
	private String descr;
	private Set<Ave> aves = new HashSet<Ave>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "descr", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	// mappeBy = "cresta" tiene que ser igual al nombre del
	// objeto declarado en Ave.java
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cresta")
	public Set<Ave> getAves() {
		return aves;
	}
	public void setAves(Set<Ave> aves) {
		this.aves = aves;
	}
	
	
}
