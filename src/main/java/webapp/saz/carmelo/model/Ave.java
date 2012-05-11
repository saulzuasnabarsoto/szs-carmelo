package webapp.saz.carmelo.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ave", catalog = "carmelo_db")
public class Ave {
	
	private Integer id;
	private String  placa;
	private String  nombre;
	private String  pluma;
	private String  fecNac;
	private Sexo    sexo;
	private Raza    raza;
	private Cresta  cresta;
	private Pata    pata;
	private Criador criador;
	private Integer AveIdPadre;
	private Integer AveIdMadre;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "placa", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	@Length(max = 50)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "pluma", nullable = false, length = 30)
	@Length(max = 30)
	public String getPluma() {
		return pluma;
	}
	public void setPluma(String pluma) {
		this.pluma = pluma;
	}
	
	@Column(name = "fecNac", nullable = false, length = 8)
	@Length(max = 8)
	public String getFecNac() {
		return fecNac;
	}
	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}
	
	@Column(name = "aveIdPadre", nullable = false)
	public Integer getAveIdPadre() {
		return AveIdPadre;
	}
	public void setAveIdPadre(Integer aveIdPadre) {
		AveIdPadre = aveIdPadre;
	}
	
	@Column(name = "aveIdMadre", nullable = false)
	public Integer getAveIdMadre() {
		return AveIdMadre;
	}
	public void setAveIdMadre(Integer aveIdMadre) {
		AveIdMadre = aveIdMadre;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SexoId", nullable = false)
	@NotNull
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RazaId", nullable = false)
	@NotNull
	public Raza getRaza() {
		return raza;
	}
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CrestaId", nullable = false)
	@NotNull
	public Cresta getCresta() {
		return cresta;
	}
	public void setCresta(Cresta cresta) {
		this.cresta = cresta;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PataId", nullable = false)
	@NotNull
	public Pata getPata() {
		return pata;
	}
	public void setPata(Pata pata) {
		this.pata = pata;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CriadorId", nullable = false)
	@NotNull
	public Criador getCriador() {
		return criador;
	}
	public void setCriador(Criador criador) {
		this.criador = criador;
	}
	
}
