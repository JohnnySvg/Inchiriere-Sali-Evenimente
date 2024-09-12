package net.javaguides.springboot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nume")
	private String nume;
	
	@Column(name="nr_pers")
	private String nrPers;
	
	@Column(name="sala")
	private String sala;

	@Column(name="checkin")
	private String checkin;
	
	@Override
	public String toString() {
		return "Request [id=" + id + ", nume=" + nume + ", nrPers=" + nrPers + ", sala=" + sala + ", checkin="
				+ checkin + ", checkout=" + checkout + "]";
	}

	@Column(name="checkout")
	private String checkout;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getNrPers() {
		return nrPers;
	}

	public void setNrPers(String nrPers) {
		this.nrPers = nrPers;
	}
	
	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}
