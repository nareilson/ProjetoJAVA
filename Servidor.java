package Visual;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controle.ServidorControle;

public class Servidor extends JFrame 
{
	JTextField nomeCliente = null;
	JComboBox<String> atendimentoTipo = null;
	JRadioButton preferenciaSim = null;
	JRadioButton preferenciaNao = null;
	ButtonGroup grupoRadioBu = null;
	JButton ok = null;
	JButton cancelar = null;
	JLabel avisoNome = null;
	JLabel avisoAtendimento = null;
	JLabel avisoPreferencial = null;
	String [] atendimento = {"Abrtura de conta","Pagamento","FGTS"};
	
	//Paineis para Layout
	JPanel painelNome = null;
	JPanel painelAtendimento = null;
	JPanel painelPreferencial = null;
	
	ServidorControle controle = null;
	
	public Servidor () 
	{
		setTitle("Cadastro Fila");
		setSize(300, 400);
		setLayout(new GridLayout(8,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		//Inicaiação do componentes visual
		nomeCliente = new JTextField("Nome: " );
		atendimentoTipo = new JComboBox<String>(atendimento);
		preferenciaSim = new JRadioButton("Sim");
		preferenciaNao = new JRadioButton("Não");
		grupoRadioBu = new ButtonGroup();
		grupoRadioBu.add(preferenciaSim);
		grupoRadioBu.add(preferenciaNao);
		ok = new JButton("ok");
		cancelar = new JButton("Cancelar");
		avisoNome = new JLabel("Nome: ");
		avisoAtendimento = new JLabel("Tipo de Atendimento: ");
		avisoPreferencial = new JLabel("Atendimento Preferecial? ");
		
		//Paineis com seus layout
		painelNome = new JPanel();
		painelNome.setLayout( new FlowLayout());
		painelAtendimento = new JPanel();
		painelAtendimento.setLayout(new FlowLayout());
		painelPreferencial =  new JPanel();
		painelPreferencial = new JPanel();
				
		painelNome.add(avisoNome);
		painelNome.add(nomeCliente);
		painelAtendimento.add(avisoAtendimento);
		painelAtendimento.add(atendimentoTipo);
		painelPreferencial.add(avisoPreferencial);
		painelPreferencial.add(preferenciaSim);
		painelPreferencial.add(preferenciaNao);
		
		add(painelNome);
		add(painelAtendimento);		
		add(painelPreferencial);
		add (ok);
		add(cancelar);
		
		controle = new ServidorControle(this);
		setVisible(true);
		ok.addActionListener(controle);
		cancelar.addActionListener(controle);
	}

}
