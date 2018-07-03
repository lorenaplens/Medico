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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "medico")
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_medico")
    private Integer cpfMedico;
    @Basic(optional = false)
    @Column(name = "nome_medico")
    private String nomeMedico;
    @Basic(optional = false)
    @Column(name = "data_nasc_medico")
    @Temporal(TemporalType.DATE)
    private Date dataNascMedico;
    @Basic(optional = false)
    @Column(name = "endereco_medico")
    private String enderecoMedico;
    @Basic(optional = false)
    @Column(name = "especialidade_medico")
    private String especialidadeMedico;
    @JoinTable(name = "medico_has_paciente", joinColumns = {
        @JoinColumn(name = "medico_cpf_medico", referencedColumnName = "cpf_medico")}, inverseJoinColumns = {
        @JoinColumn(name = "paciente_cpf_paciente", referencedColumnName = "cpf_paciente")})
    @ManyToMany
    private List<Paciente> pacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private List<Consulta> consultaList;

    public Medico() {
    }

    public Medico(Integer cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public Medico(Integer cpfMedico, String nomeMedico, Date dataNascMedico, String enderecoMedico, String especialidadeMedico) {
        this.cpfMedico = cpfMedico;
        this.nomeMedico = nomeMedico;
        this.dataNascMedico = dataNascMedico;
        this.enderecoMedico = enderecoMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public Integer getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(Integer cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public Date getDataNascMedico() {
        return dataNascMedico;
    }

    public void setDataNascMedico(Date dataNascMedico) {
        this.dataNascMedico = dataNascMedico;
    }

    public String getEnderecoMedico() {
        return enderecoMedico;
    }

    public void setEnderecoMedico(String enderecoMedico) {
        this.enderecoMedico = enderecoMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
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
        hash += (cpfMedico != null ? cpfMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.cpfMedico == null && other.cpfMedico != null) || (this.cpfMedico != null && !this.cpfMedico.equals(other.cpfMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Medico[ cpfMedico=" + cpfMedico + " ]";
    }
    
}
