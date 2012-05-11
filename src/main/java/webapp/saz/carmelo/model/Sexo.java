package webapp.saz.carmelo.model;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "sexo", catalog = "carmelo_db")
public class Sexo  {
	
	private String id;
	private String descr;
	private Set<Ave> aves = new HashSet<Ave>(0);
	
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 45)
	@Length(max = 1)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sexo")
	public Set<Ave> getAves() {
		return aves;
	}
	public void setAves(Set<Ave> aves) {
		this.aves = aves;
	}
	
	
}
