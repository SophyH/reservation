package reservation.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue = 100, allocationSize = 1)
@NamedQueries({
		@NamedQuery(name = "Reservation.findByKeyWithPassagers", query = "select r from Reservation r left join fetch r.passagers p "
				+ "where r.idReservation=:key"),
		@NamedQuery(name = "Reservation.findAllWithPassagers", query = "select r from Reservation r left join fetch r.passagers p "),
		@NamedQuery(name = "Reservation.findByKeyWithVols", query = "select r from Reservation r left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee "
				+ "left join fetch v.escales where r.idReservation=:key"),
		@NamedQuery(name = "Reservation.findAllWithVols", query = "select r from Reservation r left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee "
				+ "left join fetch v.escales "),
		@NamedQuery(name = "Reservation.findByKeyWithVolsAndPassagers", query = "select r from Reservation r left join fetch r.passagers p "
				+ "left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee left join fetch v.escales where r.idReservation=:key"),
		@NamedQuery(name = "Reservation.findAllWithVolsAndPassagers", query = "select r from Reservation r left join fetch r.passagers p "
				+ "left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee left join fetch v.escales"),
		@NamedQuery(name = "Reservation.findByKeyWithClient", query = "select r from Reservation r left join fetch r.client where r.idReservation = :key"),
		@NamedQuery(name = "Reservation.findAllWithClient", query = "select r from Reservation r left join fetch r.client") })
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "id_reservation")
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_reservation")
	private Date dateReservation;
	@Column(name = "numero_reservation")
	private Integer numeroReservation;
	@OneToMany(mappedBy = "reservation")
	private Set<Passager> passagers;
	@OneToMany(mappedBy = "")
	private Set<Vol> vols;
	@Transient
	private Client client;
	@Version
	private int version;

	public Reservation() {

	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Integer getNumeroReservation() {
		return numeroReservation;
	}

	public void setNumeroReservation(Integer numeroReservation) {
		this.numeroReservation = numeroReservation;
	}

	public Set<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(Set<Passager> passagers) {
		this.passagers = passagers;
	}

	public Set<Vol> getVols() {
		return vols;
	}

	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReservation == null) ? 0 : idReservation.hashCode());
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
		Reservation other = (Reservation) obj;
		if (idReservation == null) {
			if (other.idReservation != null)
				return false;
		} else if (!idReservation.equals(other.idReservation))
			return false;
		return true;
	}

}