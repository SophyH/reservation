package reservation.model;

import java.util.Date;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;



@Entity
@Table(name = "vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
public class Vol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "id_vol")
	private Long idVol;
	
	@Column(name = "date_depart")
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	
	
	@Column(name = "heure_depart")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	
	@Column(name = "date_arrivee")
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	
	@Column(name = "heure_arrivee")
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;
	
	
	@ManyToOne
	@JoinColumn(name = "aeroport_id_vol", foreignKey = @ForeignKey(name = "aeroport_id_vol_fk"))
	private Aeroport aeroportDepart;
	
	@ManyToOne
	@JoinColumn(name = "aeroport_id_vol", foreignKey = @ForeignKey(name = "aeroport_id_vol_fk"))
	private Aeroport aeroportArrivee;
	
	@OneToMany(mappedBy="key.vol")
	Set<Escale> escales;
	
	
	
	@Version
	private int version;

	public Vol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getIdVol() {
		return idVol;
	}



	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}



	public Date getDateDepart() {
		return dateDepart;
	}



	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}



	public Date getHeureDepart() {
		return heureDepart;
	}



	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}



	public Date getDateArrivee() {
		return dateArrivee;
	}



	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}



	public Date getHeureArrivee() {
		return heureArrivee;
	}



	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}



	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}



	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}



	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}



	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVol == null) ? 0 : idVol.hashCode());
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
		Vol other = (Vol) obj;
		if (idVol == null) {
			if (other.idVol != null)
				return false;
		} else if (!idVol.equals(other.idVol))
			return false;
		return true;
	}
	
	
	

}
