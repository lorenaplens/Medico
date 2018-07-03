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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "consulta")
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultaPK consultaPK;
    @Basic(optional = false)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "horarios_id_horario", referencedColumnName = "id_horario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horarios horarios;
    @JoinColumn(name = "paciente_cpf_paciente", referencedColumnName = "cpf_paciente")
    @ManyToOne(optional = false)
    private Paciente pacienteCpfPaciente;
    @JoinColumn(name = "medico_cpf_medico", referencedColumnName = "cpf_medico", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medico medico;

    public Consulta() {
    }

    public Consulta(ConsultaPK consultaPK) {
        this.consultaPK = consultaPK;
    }

    public Consulta(ConsultaPK consultaPK, String observacao) {
        this.consultaPK = consultaPK;
        this.observacao = observacao;
    }

    public Consulta(int medicoCpfMedico, Date dataConsulta, String horariosIdHorario) {
        this.consultaPK = new ConsultaPK(medicoCpfMedico, dataConsulta, horariosIdHorario);
    }

    public ConsultaPK getConsultaPK() {
        return consultaPK;
    }

    public void setConsultaPK(ConsultaPK consultaPK) {
        this.consultaPK = consultaPK;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Horarios getHorarios() {
        return horarios;
    }

    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }

    public Paciente getPacienteCpfPaciente() {
        return pacienteCpfPaciente;
    }

    public void setPacienteCpfPaciente(Paciente pacienteCpfPaciente) {
        this.pacienteCpfPaciente = pacienteCpfPaciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaPK != null ? consultaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.consultaPK == null && other.consultaPK != null) || (this.consultaPK != null && !this.consultaPK.equals(other.consultaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Consulta[ consultaPK=" + consultaPK + " ]";
    }
    
}
