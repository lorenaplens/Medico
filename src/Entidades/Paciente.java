/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_paciente")
    private Integer cpfPaciente;
    @Basic(optional = false)
    @Column(name = "nome_paciente")
    private String nomePaciente;
    @Basic(optional = false)
    @Column(name = "filiacao_paciente")
    private String filiacaoPaciente;
    @Basic(optional = false)
    @Column(name = "doenca_paciente")
    private String doencaPaciente;
    @Basic(optional = false)
    @Column(name = "data_nasc_paciente")
    @Temporal(TemporalType.DATE)
    private Date dataNascPaciente;
    @Basic(optional = false)
    @Column(name = "genero_paciente")
    private boolean generoPaciente;
    @ManyToMany(mappedBy = "pacienteList")
    private List<Medico> medicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteCpfPaciente")
    private List<Consulta> consultaList;

    public Paciente() {
    }

    public Paciente(Integer cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public Paciente(Integer cpfPaciente, String nomePaciente, String filiacaoPaciente, String doencaPaciente, Date dataNascPaciente, boolean generoPaciente) {
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
        this.filiacaoPaciente = filiacaoPaciente;
        this.doencaPaciente = doencaPaciente;
        this.dataNascPaciente = dataNascPaciente;
        this.generoPaciente = generoPaciente;
    }

    public Integer getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(Integer cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getFiliacaoPaciente() {
        return filiacaoPaciente;
    }

    public void setFiliacaoPaciente(String filiacaoPaciente) {
        this.filiacaoPaciente = filiacaoPaciente;
    }

    public String getDoencaPaciente() {
        return doencaPaciente;
    }

    public void setDoencaPaciente(String doencaPaciente) {
        this.doencaPaciente = doencaPaciente;
    }

    public Date getDataNascPaciente() {
        return dataNascPaciente;
    }

    public void setDataNascPaciente(Date dataNascPaciente) {
        this.dataNascPaciente = dataNascPaciente;
    }

    public boolean getGeneroPaciente() {
        return generoPaciente;
    }

    public void setGeneroPaciente(boolean generoPaciente) {
        this.generoPaciente = generoPaciente;
    }

    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfPaciente != null ? cpfPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.cpfPaciente == null && other.cpfPaciente != null) || (this.cpfPaciente != null && !this.cpfPaciente.equals(other.cpfPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paciente[ cpfPaciente=" + cpfPaciente + " ]";
    }
    
}
