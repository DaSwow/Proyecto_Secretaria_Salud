/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdsolicitud", query = "SELECT s FROM Solicitud s WHERE s.idsolicitud = :idsolicitud"),
    @NamedQuery(name = "Solicitud.findByIddoctor", query = "SELECT s FROM Solicitud s WHERE s.iddoctor = :iddoctor"),
    @NamedQuery(name = "Solicitud.findByIdpaciente", query = "SELECT s FROM Solicitud s WHERE s.idpaciente = :idpaciente"),
    @NamedQuery(name = "Solicitud.findByNsspaciente", query = "SELECT s FROM Solicitud s WHERE s.nsspaciente = :nsspaciente"),
    @NamedQuery(name = "Solicitud.findByAceptado", query = "SELECT s FROM Solicitud s WHERE s.aceptado = :aceptado"),
    @NamedQuery(name = "Solicitud.findBySolicitudcol", query = "SELECT s FROM Solicitud s WHERE s.solicitudcol = :solicitudcol")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsolicitud")
    private Integer idsolicitud;
    @Column(name = "iddoctor")
    private Integer iddoctor;
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Column(name = "nsspaciente")
    private String nsspaciente;
    @Column(name = "aceptado")
    private Short aceptado;
    @Column(name = "solicitudcol")
    private String solicitudcol;

    public Solicitud() {
    }

    public Solicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Integer getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNsspaciente() {
        return nsspaciente;
    }

    public void setNsspaciente(String nsspaciente) {
        this.nsspaciente = nsspaciente;
    }

    public Short getAceptado() {
        return aceptado;
    }

    public void setAceptado(Short aceptado) {
        this.aceptado = aceptado;
    }

    public String getSolicitudcol() {
        return solicitudcol;
    }

    public void setSolicitudcol(String solicitudcol) {
        this.solicitudcol = solicitudcol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Solicitud[ idsolicitud=" + idsolicitud + " ]";
    }
    
}
