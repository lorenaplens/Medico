package DAOs;

import Entidades.Medico;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOMedico extends DAOGenerico<Medico> {

    public DAOMedico() {
        super(Medico.class);
    }

    public int autoIdMedico() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.cpfMedico) FROM Medico e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Medico> listByCpfMedico(int cpfMedico) {
        return em.createQuery("SELECT e FROM Medico e WHERE e.cpfMedico = :cpfMedico").setParameter("cpfMedico", cpfMedico).getResultList();
    }

    public List<Medico> listByNomeMedico(String nomeMedico) {
        return em.createQuery("SELECT e FROM Medico e WHERE e.nomeMedico LIKE :nomeMedico").setParameter("nomeMedico", "%" + nomeMedico + "%").getResultList();
    }

    public List<Medico> listInOrderCpfMedico() {
        return em.createQuery("SELECT e FROM Medico e ORDER BY e.cpfMedico").getResultList();
    }

    public List<Medico> listInOrderNomeMedico() {
        return em.createQuery("SELECT e FROM Medico e ORDER BY e.nomeMedico").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Medico> lf;
        if (qualOrdem.equals("cpfMedico")) {
            lf = listInOrderCpfMedico();
        } else {
            lf = listInOrderNomeMedico();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCpfMedico() + ";" + lf.get(i).getNomeMedico() + ";" + sdf.format(lf.get(i).getDataNascMedico()) + ";" + lf.get(i).getEnderecoMedico() + ";" + lf.get(i).getEspecialidadeMedico() + ";");
        }
        return ls;
    }
}

