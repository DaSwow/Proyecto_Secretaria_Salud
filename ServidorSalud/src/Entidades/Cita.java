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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdcita", query = "SELECT c FROM Cita c WHERE c.idcita = :idcita"),
    @NamedQuery(name = "Cita.findByIddoctor", query = "SELECT c FROM Cita c WHERE c.iddoctor = :iddoctor"),
    @NamedQuery(name = "Cita.findByNsspaciente", query = "SELECT c FROM Cita c WHERE c.nsspaciente = :nsspaciente")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcita;
    @Column(name = "iddoctor")
    private Integer iddoctor;
    @Column(name = "nsspaciente")
    private String nsspaciente;

    public Cita() {
    }

    public Cita(Integer iddoctor, String nsspaciente) {
        this.iddoctor = iddoctor;
        this.nsspaciente = nsspaciente;
    }


    public Integer getIdcita() {
        return idcita;
    }


    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getNsspaciente() {
        return nsspaciente;
    }

    public void setNsspaciente(String nsspaciente) {
        this.nsspaciente = nsspaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idcita == null && other.idcita != null) || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cita[ idcita=" + idcita + " ]";
    }
    
}
