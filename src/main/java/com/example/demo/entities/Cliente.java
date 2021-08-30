package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLIENTE_ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clienteId;
	
	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;
	
	@Column(name="CONTRASENA")
	private String contrasena;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="CORREO_ELECTRONICO")
	private String correoElectronico;
	
	@Column(name="EDAD")
	private double edad;
	
	@Column(name="ESTATURA")
	private double estatura;
	
	@Column(name="PESO")
	private double peso;
	
	@Column(name="IMC")
	private double imc;
	
	@Column(name="GEB")
	private double geb;
	
	@Column(name="ETA")
	private double eta;
	
	@Column(name="FECHA_CREACION")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@Column(name="FECHA_ACTUALIZACION")
	@Temporal(TemporalType.DATE)
	
	private Date fechaActualizacion;

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getGeb() {
		return geb;
	}

	public void setGeb(double geb) {
		this.geb = geb;
	}

	public double getEta() {
		return eta;
	}

	public void setEta(double eta) {
		this.eta = eta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
}
