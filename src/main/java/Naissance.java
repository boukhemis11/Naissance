import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 
 */

/**
 * @author boukh
 *
 */
public class Naissance {
	private long annee;
	private Date eventeDate;
	private long nombre;
	
	public Naissance(long annee, Date eventeDate, long nombre) {
		super();
		this.annee = annee;
		this.eventeDate = eventeDate;
		this.nombre = nombre;
	}
	
	
	public long getAnnee() {
		return annee;
	}

	public void setAnnee(long annee) {
		this.annee = annee;
	}

	public Date getEventeDate() {
		return eventeDate;
	}

	public void setEventeDate(Date eventeDate) {
		this.eventeDate = eventeDate;
	}

	public long getNombre() {
		return nombre;
	}

	public void setNombre(long nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Naissance [annee=" + annee + ", eventeDate=" + eventeDate + ", nombre=" + nombre + "]";
	}


	
	
}