package com.facturaproducto.app.infraestructura.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass // Indicar que es un componente de Spring
@EntityListeners(AuditingEntityListener.class) // Para escuchar los cambios de la entidad
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechacreacion;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = false, updatable = false) //NULLABLE-QUE NO PERMITA NULO,UPDATEABLE-NO PERMITA LA CREACIÓN DE NUEVAs FECHAs
	private Date fechaActualizacion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
