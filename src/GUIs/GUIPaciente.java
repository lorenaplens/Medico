package GUIs;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import java.io.File;
import javax.swing.text.JTextComponent;
import Auxiliar.*;
import DAOs.*;
import Entidades.*;

public class GUIPaciente extends JFrame {
    public static void main(String[] args) {
        new GUIPaciente();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("CPF: ");
    private JLabel lbCpfPaciente = new JLabel("CPF");
    private JTextField fdCpfPaciente = new JTextField(15);

    private JLabel lbNomePaciente = new JLabel("Nome");
    private JTextField fdNomePaciente = new JTextField(45);

    private JLabel lbFiliacaoPaciente = new JLabel("Filiação");
    private JTextField fdFiliacaoPaciente = new JTextField(45);

    private JLabel lbDoencaPaciente = new JLabel("Doença");
    private JTextField fdDoencaPaciente = new JTextField(45);

    private JSpinner spinnerdataNascPaciente = new JSpinner(new SpinnerDateModel());
    private final JSpinner.DateEditor spinnerEditordataNascPaciente = new JSpinner.DateEditor(spinnerdataNascPaciente, "dd/MM/yyyy");
    private JLabel lbDataNascPaciente = new JLabel("Data Nascimento");
    JRadioButton rdfeminino = new JRadioButton("feminino");
    JRadioButton rdmasculino = new JRadioButton("masculino");
    JLabel lbgeneroPaciente = new JLabel("Genero");
    JPanel pnGeneroPaciente = new JPanel();
    ButtonGroup rdGroupGeneroPaciente = new ButtonGroup();

    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel();
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));

    DAOPaciente controle = new DAOPaciente();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Paciente paciente = new Paciente();

    public GUIPaciente(){
        setSize(725, 460);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Pacientes");

        painelCentral.setLayout(new GridLayout(6, 2));
        painelCentral.add(lbNomePaciente);
        painelCentral.add(fdNomePaciente);
        painelCentral.add(lbFiliacaoPaciente);
        painelCentral.add(fdFiliacaoPaciente);
        painelCentral.add(lbDoencaPaciente);
        painelCentral.add(fdDoencaPaciente);

        fdNomePaciente.setEnabled(false);
        fdFiliacaoPaciente.setEnabled(false);
        fdDoencaPaciente.setEnabled(false);

        painelCentral.add(lbgeneroPaciente);
        pnGeneroPaciente.add(rdfeminino);
        rdfeminino.setEnabled(false);
        pnGeneroPaciente.add(rdmasculino);
        rdmasculino.setEnabled(false);
        painelCentral.add(pnGeneroPaciente);
        painelCentral.add(lbDataNascPaciente);
        painelCentral.add(spinnerdataNascPaciente);
        spinnerdataNascPaciente.setEditor(spinnerEditordataNascPaciente);
        spinnerdataNascPaciente.setEnabled(false);
        List<String> combo = new ArrayList<>();


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdCpfPaciente);
        painelNorteBaixo.add(btBuscar);
        painelNorteBaixo.add(btInserir);
        painelNorteBaixo.add(btAtualizar);
        painelNorteBaixo.add(btRemover);
        painelNorteBaixo.add(btSalvar);
        painelNorteBaixo.add(btCancelar);
        painelNorteBaixo.add(btListar);
        painelNorteCima.setBackground(Color.white);
        painelNorteBaixo.setBackground(Color.white);
        painelCentralFora.setBackground(Color.white);
        painelCentral.setBackground(Color.white);
        painelSul.setBackground(Color.white);
        btInserir.setBackground(Color.WHITE);
        btSalvar.setBackground(Color.WHITE);
        btRemover.setBackground(Color.WHITE);
        btAtualizar.setBackground(Color.WHITE);
        btBuscar.setBackground(Color.WHITE);
        btCancelar.setBackground(Color.WHITE);
        btListar.setBackground(Color.WHITE);
        pnGeneroPaciente.setBackground(Color.WHITE);
        rdfeminino.setBackground(Color.WHITE);
        rdmasculino.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdCpfPaciente.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbCpfPaciente.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomePaciente.setFont(new Font("Courier New", Font.BOLD, 17));
        lbFiliacaoPaciente.setFont(new Font("Courier New", Font.BOLD, 17));
        lbDoencaPaciente.setFont(new Font("Courier New", Font.BOLD, 17));
        lbDataNascPaciente.setFont(new Font("Courier New", Font.BOLD, 17));
        lbgeneroPaciente.setFont(new Font("Courier New", Font.BOLD, 17));
        fdCpfPaciente.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomePaciente.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdFiliacaoPaciente.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdDoencaPaciente.setFont(new Font("Courier New", Font.PLAIN, 17));
        spinnerdataNascPaciente.setFont(new Font("Courier New", Font.PLAIN, 17));
        rdfeminino.setFont(new Font("Courier New", Font.PLAIN, 17));
        rdmasculino.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    paciente = new Paciente();
                    int cpfPaciente = Integer.valueOf(fdCpfPaciente.getText());
                    paciente.setCpfPaciente(Integer.valueOf(fdCpfPaciente.getText()));
                    paciente = controle.obter(paciente.getCpfPaciente());
                    labelAviso.setBackground(Color.green);
                    if (paciente != null) {
                        fdCpfPaciente.setText(paciente.getCpfPaciente() + "");
                        fdNomePaciente.setText(paciente.getNomePaciente() + "");
                        fdFiliacaoPaciente.setText(paciente.getFiliacaoPaciente() + "");
                        fdDoencaPaciente.setText(paciente.getDoencaPaciente() + "");
                        spinnerdataNascPaciente.setValue(paciente.getDataNascPaciente());
                        if (paciente.getGeneroPaciente()) {
                            rdfeminino.setSelected(true);
                            rdmasculino.setSelected(false);
                        } else {
                            rdmasculino.setSelected(true);
                            rdfeminino.setSelected(false);
                        }
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdNomePaciente.setEnabled(false);
                        fdNomePaciente.setText(null);
                        fdFiliacaoPaciente.setEnabled(false);
                        fdFiliacaoPaciente.setText(null);
                        fdDoencaPaciente.setEnabled(false);
                        fdDoencaPaciente.setText(null);
                        rdfeminino.setEnabled(false);
                        rdmasculino.setEnabled(false);
                        rdfeminino.setSelected(false);
                        rdmasculino.setSelected(false);
                        spinnerdataNascPaciente.setEnabled(false);
                        spinnerdataNascPaciente.setValue(new Date());
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
                    }
                } catch (Exception erro) {
                    labelAviso.setText("Preencha os campos corretamente!");
                    labelAviso.setBackground(Color.red);
                }
            }
        }
        );

        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = true;
                fdCpfPaciente.setEnabled(false);
                fdNomePaciente.setEnabled(true);
                fdFiliacaoPaciente.setEnabled(true);
                fdDoencaPaciente.setEnabled(true);
                spinnerdataNascPaciente.setEnabled(true);
                rdfeminino.setEnabled(true);
                rdmasculino.setEnabled(true);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btInserir.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acao){ //btInserir
                    try {
                    paciente = new Paciente();
                        paciente.setCpfPaciente(Integer.valueOf(fdCpfPaciente.getText()));
                        paciente.setNomePaciente(fdNomePaciente.getText());
                        paciente.setFiliacaoPaciente(fdFiliacaoPaciente.getText());
                        paciente.setDoencaPaciente(fdDoencaPaciente.getText());
                        paciente.setDataNascPaciente((Date) spinnerdataNascPaciente.getValue());
                        Boolean respGeneroPaciente = null;
                        if (rdfeminino.isSelected()) {
                            respGeneroPaciente = true;
                        } else if (rdmasculino.isSelected()) {
                            respGeneroPaciente = false;
                        } else {
                            int a = 1 / 0;
                        }
                        paciente.setGeneroPaciente(respGeneroPaciente);
                        controle.inserir(paciente);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdCpfPaciente.setEnabled(true);
                        fdCpfPaciente.requestFocus();
                        fdNomePaciente.setEnabled(false);
                        fdFiliacaoPaciente.setEnabled(false);
                        fdDoencaPaciente.setEnabled(false);
                        spinnerdataNascPaciente.setEnabled(false);
                        rdfeminino.setEnabled(false);
                        rdmasculino.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        paciente = new Paciente();
                        paciente.setCpfPaciente(Integer.valueOf(fdCpfPaciente.getText()));
                        paciente.setNomePaciente(fdNomePaciente.getText());
                        paciente.setFiliacaoPaciente(fdFiliacaoPaciente.getText());
                        paciente.setDoencaPaciente(fdDoencaPaciente.getText());
                        paciente.setDataNascPaciente((Date) spinnerdataNascPaciente.getValue());
                        Boolean respGeneroPaciente = null;
                        if(rdfeminino.isSelected()) {    respGeneroPaciente = true;} else {    respGeneroPaciente = false;}
                        paciente.setGeneroPaciente(respGeneroPaciente);
                        controle.atualizar(paciente);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdCpfPaciente.setEnabled(true);
                        fdCpfPaciente.requestFocus();
                        fdNomePaciente.setEnabled(false);
                        fdFiliacaoPaciente.setEnabled(false);
                        fdDoencaPaciente.setEnabled(false);
                        spinnerdataNascPaciente.setEnabled(false);
                        rdfeminino.setEnabled(false);
                        rdmasculino.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
            }
        }
    );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelAviso.setText("Cancelado!");
                fdCpfPaciente.setEnabled(false);
                fdCpfPaciente.setText("");
                fdNomePaciente.setEnabled(false);
                fdNomePaciente.setText("");
                fdFiliacaoPaciente.setEnabled(false);
                fdFiliacaoPaciente.setText("");
                fdDoencaPaciente.setEnabled(false);
                fdDoencaPaciente.setText("");
                spinnerdataNascPaciente.setEnabled(false);
                spinnerdataNascPaciente.setValue(new Date());
                rdfeminino.setEnabled(false);
                rdfeminino.setSelected(false);
                rdmasculino.setEnabled(false);
                rdmasculino.setSelected(false);
                fdCpfPaciente.setEnabled(true);
                fdCpfPaciente.requestFocus();
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
            }
        }
        );

        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = false;
                fdNomePaciente.setEnabled(true);
                fdFiliacaoPaciente.setEnabled(true);
                fdDoencaPaciente.setEnabled(true);
                spinnerdataNascPaciente.setEnabled(true);
                rdfeminino.setEnabled(true);
                rdmasculino.setEnabled(true);
                fdNomePaciente.requestFocus();
                fdCpfPaciente.setEnabled(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btRemover.setVisible(false);
                btAtualizar.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btRemover.setVisible(false);
                btListar.setVisible(false);
                btAtualizar.setVisible(false);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + paciente.getCpfPaciente() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(paciente);
                    labelAviso.setText("Removido!");
                    fdCpfPaciente.setText("");
                    fdNomePaciente.setText("");
                    fdNomePaciente.setEnabled(false);
                    fdFiliacaoPaciente.setText("");
                    fdFiliacaoPaciente.setEnabled(false);
                    fdDoencaPaciente.setText("");
                    fdDoencaPaciente.setEnabled(false);
                    spinnerdataNascPaciente.setEnabled(false);
                    spinnerdataNascPaciente.setValue(new Date());
                    rdfeminino.setEnabled(false);
                    rdfeminino.setSelected(false);
                    rdmasculino.setEnabled(false);
                    rdmasculino.setSelected(false);
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PacienteGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
