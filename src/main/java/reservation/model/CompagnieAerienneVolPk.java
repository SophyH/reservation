package reservation.model;

import javax.persistence.Embeddable;

@Embeddable
public class CompagnieAerienneVolPk {

	private Vol vol;
	private CompagnieAerienne compagnieAerienne;

	public CompagnieAerienneVolPk() {

	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

}
