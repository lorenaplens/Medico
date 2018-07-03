package DAOs;

import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOPaciente extends DAOGenerico<Paciente> {

    public DAOPaciente() {
        super(Paciente.class);
    }

    public int autoIdPaciente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.cpfPaciente) FROM Paciente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Paciente> listByCpfPaciente(int cpfPaciente) {
        return em.createQuery("SELECT e FROM Paciente e WHERE e.cpfPaciente = :cpfPaciente").setParameter("cpfPaciente", cpfPaciente).getResultList();
    }

    public List<Paciente> listByNomePaciente(String nomePaciente) {
        return em.createQuery("SELECT e FROM Paciente e WHERE e.nomePaciente LIKE :nomePaciente").setParameter("nomePaciente", "%" + nomePaciente + "%").getResultList();
    }

    public List<Paciente> listInOrderCpfPaciente() {
        return em.createQuery("SELECT e FROM Paciente e ORDER BY e.cpfPaciente").getResultList();
    }

    public List<Paciente> listInOrderNomePaciente() {
        return em.createQuery("SELECT e FROM Paciente e ORDER BY e.nomePaciente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Paciente> lf;
        if (qualOrdem.equals("cpfPaciente")) {
            lf = listInOrderCpfPaciente();
        } else {
            lf = listInOrderNomePaciente();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCpfPaciente() + ";" + lf.get(i).getNomePaciente() + ";" + lf.get(i).getFiliacaoPaciente() + ";" + lf.get(i).getDoencaPaciente() + ";" + sdf.format(lf.get(i).getDataNascPaciente()) + ";" + lf.get(i).getGeneroPaciente() + ";");
        }
        return ls;
    }
}

