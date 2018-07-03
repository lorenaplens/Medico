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

public class GUIMedico extends JFrame {
    public static void main(String[] args) {
        new GUIMedico();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("CPF Medico: ");
    private JLabel lbCpfMedico = new JLabel("CPF Medico");
    private JTextField fdCpfMedico = new JTextField(15);

    private JLabel lbNomeMedico = new JLabel("Nome");
    private JTextField fdNomeMedico = new JTextField(45);

    private JSpinner spinnerdataNascMedico = new JSpinner(new SpinnerDateModel());
    private final JSpinner.DateEditor spinnerEditordataNascMedico = new JSpinner.DateEditor(spinnerdataNascMedico, "dd/MM/yyyy");
    private JLabel lbDataNascMedico = new JLabel("Data Nascimento:");
    private JLabel lbEnderecoMedico = new JLabel("Endereço");
    private JTextField fdEnderecoMedico = new JTextField(45);

    private JLabel lbEspecialidadeMedico = new JLabel("Especialidade");
    private JTextField fdEspecialidadeMedico = new JTextField(45);

    JPanel painelImagem = new JPanel(new GridLayout(1, 1));
    Image img;
    Image imagemAux;
    String origem;
    String destino = "src/fotos/";
    String semImagem = "src/fotos/0.png";
    String escolherImagem = "src/fotos/0a.png";
    JLabel labelFoto = new JLabel("");
    Boolean uploadFoto = false;

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

    DAOMedico controle = new DAOMedico();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Medico medico = new Medico();

    public GUIMedico(){
        setSize(725, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Medicos");

        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }

        painelCentral.setLayout(new GridLayout(5, 2));
        painelCentral.add(lbNomeMedico);
        painelCentral.add(fdNomeMedico);
        painelCentral.add(lbEnderecoMedico);
        painelCentral.add(fdEnderecoMedico);
        painelCentral.add(lbEspecialidadeMedico);
        painelCentral.add(fdEspecialidadeMedico);

        fdNomeMedico.setEnabled(false);
        fdEnderecoMedico.setEnabled(false);
        fdEspecialidadeMedico.setEnabled(false);

        painelCentral.add(lbDataNascMedico);
        painelCentral.add(spinnerdataNascMedico);
        spinnerdataNascMedico.setEditor(spinnerEditordataNascMedico);
        spinnerdataNascMedico.setEnabled(false);
        List<String> combo = new ArrayList<>();


cp.setBackground(Color.white);
        painelImagem.setBackground(Color.white);
        painelImagem.add(labelFoto);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.WEST);
        cp.add(painelImagem, BorderLayout.EAST);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdCpfMedico);
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

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdCpfMedico.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbCpfMedico.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeMedico.setFont(new Font("Courier New", Font.BOLD, 17));
        lbDataNascMedico.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEnderecoMedico.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEspecialidadeMedico.setFont(new Font("Courier New", Font.BOLD, 17));
        fdCpfMedico.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeMedico.setFont(new Font("Courier New", Font.PLAIN, 17));
        spinnerdataNascMedico.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEnderecoMedico.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEspecialidadeMedico.setFont(new Font("Courier New", Font.PLAIN, 17));
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
            uploadFoto = false;
                try{
                    medico = new Medico();
                    int cpfMedico = Integer.valueOf(fdCpfMedico.getText());
                    medico.setCpfMedico(Integer.valueOf(fdCpfMedico.getText()));
                    medico = controle.obter(medico.getCpfMedico());
                    labelAviso.setBackground(Color.green);
                    if (medico != null) {
                        fdCpfMedico.setText(medico.getCpfMedico() + "");
                        fdNomeMedico.setText(medico.getNomeMedico() + "");
                        spinnerdataNascMedico.setValue(medico.getDataNascMedico());
                        fdEnderecoMedico.setText(medico.getEnderecoMedico() + "");
                        fdEspecialidadeMedico.setText(medico.getEspecialidadeMedico() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                        try {
                            String aux = String.valueOf(medico.getCpfMedico()).trim();
                            origem = "/fotos/" + aux + ".png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));

                            labelFoto.setIcon(icone);

                        } catch (Exception erro) {
                            origem = "/fotos/0.png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);
                        }
                    } else {
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
                        fdNomeMedico.setEnabled(false);
                        fdNomeMedico.setText(null);
                        fdEnderecoMedico.setEnabled(false);
                        fdEnderecoMedico.setText(null);
                        fdEspecialidadeMedico.setEnabled(false);
                        fdEspecialidadeMedico.setText(null);
                        spinnerdataNascMedico.setEnabled(false);
                        spinnerdataNascMedico.setValue(new Date());
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
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
        try {
            origem = "/fotos/0a.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
                fdCpfMedico.setEnabled(false);
                fdNomeMedico.setEnabled(true);
                spinnerdataNascMedico.setEnabled(true);
                fdEnderecoMedico.setEnabled(true);
                fdEspecialidadeMedico.setEnabled(true);
            uploadFoto = true;
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
            uploadFoto = false;
                if(acao){ //btInserir
                    try {
                    medico = new Medico();
                        medico.setCpfMedico(Integer.valueOf(fdCpfMedico.getText()));
                        medico.setNomeMedico(fdNomeMedico.getText());
                        medico.setDataNascMedico((Date) spinnerdataNascMedico.getValue());
                        medico.setEnderecoMedico(fdEnderecoMedico.getText());
                        medico.setEspecialidadeMedico(fdEspecialidadeMedico.getText());
                        controle.inserir(medico);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdCpfMedico.setEnabled(true);
                        fdCpfMedico.requestFocus();
                        fdNomeMedico.setEnabled(false);
                        spinnerdataNascMedico.setEnabled(false);
                        fdEnderecoMedico.setEnabled(false);
                        fdEspecialidadeMedico.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        medico = new Medico();
                        medico.setCpfMedico(Integer.valueOf(fdCpfMedico.getText()));
                        medico.setNomeMedico(fdNomeMedico.getText());
                        medico.setDataNascMedico((Date) spinnerdataNascMedico.getValue());
                        medico.setEnderecoMedico(fdEnderecoMedico.getText());
                        medico.setEspecialidadeMedico(fdEspecialidadeMedico.getText());
                        controle.atualizar(medico);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdCpfMedico.setEnabled(true);
                        fdCpfMedico.requestFocus();
                        fdNomeMedico.setEnabled(false);
                        spinnerdataNascMedico.setEnabled(false);
                        fdEnderecoMedico.setEnabled(false);
                        fdEspecialidadeMedico.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
                destino = destino + medico.getCpfMedico() + ".png";
                CopiaImagem.copiar(origem, destino);
                destino = "src/fotos/";
            }
        }
    );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
                labelAviso.setText("Cancelado!");
                fdCpfMedico.setEnabled(false);
                fdCpfMedico.setText("");
                fdNomeMedico.setEnabled(false);
                fdNomeMedico.setText("");
                spinnerdataNascMedico.setEnabled(false);
                spinnerdataNascMedico.setValue(new Date());
                fdEnderecoMedico.setEnabled(false);
                fdEnderecoMedico.setText("");
                fdEspecialidadeMedico.setEnabled(false);
                fdEspecialidadeMedico.setText("");
                fdCpfMedico.setEnabled(true);
                fdCpfMedico.requestFocus();
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
            uploadFoto = false;
                acao = false;
                fdNomeMedico.setEnabled(true);
                spinnerdataNascMedico.setEnabled(true);
                fdEnderecoMedico.setEnabled(true);
                fdEspecialidadeMedico.setEnabled(true);
                fdNomeMedico.requestFocus();
                fdCpfMedico.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + medico.getCpfMedico() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(medico);
                    labelAviso.setText("Removido!");
                    fdCpfMedico.setText("");
                    fdNomeMedico.setText("");
                    fdNomeMedico.setEnabled(false);
                    spinnerdataNascMedico.setEnabled(false);
                    spinnerdataNascMedico.setValue(new Date());
                    fdEnderecoMedico.setText("");
                    fdEnderecoMedico.setEnabled(false);
                    fdEspecialidadeMedico.setText("");
                    fdEspecialidadeMedico.setEnabled(false);
String aux = String.valueOf(medico.getCpfMedico()).trim();
                    origem = "src/fotos/" + aux + ".png";
                    System.out.println(origem);
                    try {
                        File f = new File(origem);
                        if (f.exists()) {
                            f.delete();
                        }
                    } catch (Exception erro) {
                        System.out.println("Erro");
                    }
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );

 labelFoto.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (uploadFoto) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                        File img = fc.getSelectedFile();
                        origem = fc.getSelectedFile().getAbsolutePath();
                        try {
                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception ex) {
                            System.out.println("Erro: " + ex.getMessage());
                        }
                    }

                }

            }
        });

        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MedicoGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
