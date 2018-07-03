/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Embeddable
public class ConsultaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "medico_cpf_medico")
    private int medicoCpfMedico;
    @Basic(optional = false)
    @Column(name = "data_consulta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataConsulta;
    @Basic(optional = false)
    @Column(name = "horarios_id_horario")
    private String horariosIdHorario;

    public ConsultaPK() {
    }

    public ConsultaPK(int medicoCpfMedico, Date dataConsulta, String horariosIdHorario) {
        this.medicoCpfMedico = medicoCpfMedico;
        this.dataConsulta = dataConsulta;
        this.horariosIdHorario = horariosIdHorario;
    }

    public int getMedicoCpfMedico() {
        return medicoCpfMedico;
    }

    public void setMedicoCpfMedico(int medicoCpfMedico) {
        this.medicoCpfMedico = medicoCpfMedico;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorariosIdHorario() {
        return horariosIdHorario;
    }

    public void setHorariosIdHorario(String horariosIdHorario) {
        this.horariosIdHorario = horariosIdHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) medicoCpfMedico;
        hash += (dataConsulta != null ? dataConsulta.hashCode() : 0);
        hash += (horariosIdHorario != null ? horariosIdHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaPK)) {
            return false;
        }
        ConsultaPK other = (ConsultaPK) object;
        if (this.medicoCpfMedico != other.medicoCpfMedico) {
            return false;
        }
        if ((this.dataConsulta == null && other.dataConsulta != null) || (this.dataConsulta != null && !this.dataConsulta.equals(other.dataConsulta))) {
            return false;
        }
        if ((this.horariosIdHorario == null && other.horariosIdHorario != null) || (this.horariosIdHorario != null && !this.horariosIdHorario.equals(other.horariosIdHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ConsultaPK[ medicoCpfMedico=" + medicoCpfMedico + ", dataConsulta=" + dataConsulta + ", horariosIdHorario=" + horariosIdHorario + " ]";
    }
    
}
