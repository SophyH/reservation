package reservation.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "aeroport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_aeroport", initialValue = 100, allocationSize = 1)
public class Aeroport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	@Column(name = "id_aeroport")
	private Long idAeroport;
	
	@Column(name = "nom_aeroport", length = 150, nullable = false)
	private String nomAeroport;
	
	
	@OneToMany(mappedBy="aeroport")
	private Set<Vol> volArrivee;
	
	@OneToMany(mappedBy="aeroport")
	private Set<Vol> volDepart;
	
	@OneToMany(mappedBy="key.aeroport")
	Set<Escale> escales;

	public Aeroport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(Long idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNomAeroport() {
		return nomAeroport;
	}

	public void setNomAeroport(String nomAeroport) {
		this.nomAeroport = nomAeroport;
	}

	public Set<Vol> getVolArrivee() {
		return volArrivee;
	}

	public void setVolArrivee(Set<Vol> volArrivee) {
		this.volArrivee = volArrivee;
	}

	public Set<Vol> getVolDepart() {
		return volDepart;
	}

	public void setVolDepart(Set<Vol> volDepart) {
		this.volDepart = volDepart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAeroport == null) ? 0 : idAeroport.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroport other = (Aeroport) obj;
		if (idAeroport == null) {
			if (other.idAeroport != null)
				return false;
		} else if (!idAeroport.equals(other.idAeroport))
			return false;
		return true;
	}
	
	
	

}
