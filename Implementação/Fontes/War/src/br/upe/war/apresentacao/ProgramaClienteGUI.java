package br.upe.war.apresentacao;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProgramaClienteGUI {

	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="347,40"
	private JPanel CriarSalaDialog = null;
	private JButton entrarSala = null;
	private JTextField nomeJogador = null;
	private JTextField nomeSala = null;
	private JList numeroMaxJogadores = null;
	private JRadioButton protegida = null;
	private JRadioButton naoProtegida = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JList corJogador = null;
	private JLabel jLabel31 = null;
	private JLabel jLabel311 = null;
	private JLabel jLabel312 = null;
	/**
	 * This method initializes jDialog	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog() {
		if (jDialog == null) {
			jDialog = new JDialog();
			jDialog.setSize(new Dimension(315, 280));
			jDialog.setContentPane(getCriarSalaDialog());
		}
		return jDialog;
	}

	/**
	 * This method initializes CriarSalaDialog	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCriarSalaDialog() {
		if (CriarSalaDialog == null) {
			jLabel312 = new JLabel();
			jLabel312.setBounds(new Rectangle(245, 172, 35, 16));
			jLabel312.setText("não");
			jLabel311 = new JLabel();
			jLabel311.setBounds(new Rectangle(186, 170, 28, 17));
			jLabel311.setText("sim");
			jLabel31 = new JLabel();
			jLabel31.setBounds(new Rectangle(13, 169, 77, 19));
			jLabel31.setText("Com senha");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(13, 130, 171, 21));
			jLabel3.setText("Número max de jogadores");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(13, 94, 87, 17));
			jLabel2.setText("Nome da Sala");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(13, 55, 53, 21));
			jLabel1.setText("Cor");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 18, 64, 20));
			jLabel.setText("Login");
			CriarSalaDialog = new JPanel();
			CriarSalaDialog.setLayout(null);
			CriarSalaDialog.add(getEntrarSala(), null);
			CriarSalaDialog.add(getNomeJogador(), null);
			CriarSalaDialog.add(getNomeSala(), null);
			CriarSalaDialog.add(getNumeroMaxJogadores(), null);
			CriarSalaDialog.add(getProtegida(), null);
			CriarSalaDialog.add(getNaoProtegida(), null);
			CriarSalaDialog.add(jLabel, null);
			CriarSalaDialog.add(jLabel1, null);
			CriarSalaDialog.add(jLabel2, null);
			CriarSalaDialog.add(jLabel3, null);
			CriarSalaDialog.add(getCorJogador(), null);
			CriarSalaDialog.add(jLabel31, null);
			CriarSalaDialog.add(jLabel311, null);
			CriarSalaDialog.add(jLabel312, null);
		}
		return CriarSalaDialog;
	}

	/**
	 * This method initializes entrarSala	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEntrarSala() {
		if (entrarSala == null) {
			entrarSala = new JButton();
			entrarSala.setBounds(new Rectangle(89, 207, 125, 22));
			entrarSala.setText("Criar Sala");
		}
		return entrarSala;
	}

	/**
	 * This method initializes nomeJogador	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNomeJogador() {
		if (nomeJogador == null) {
			nomeJogador = new JTextField();
			nomeJogador.setBounds(new Rectangle(152, 19, 108, 18));
		}
		return nomeJogador;
	}

	/**
	 * This method initializes nomeSala	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNomeSala() {
		if (nomeSala == null) {
			nomeSala = new JTextField();
			nomeSala.setBounds(new Rectangle(158, 92, 102, 20));
		}
		return nomeSala;
	}

	/**
	 * This method initializes numeroMaxJogadores	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getNumeroMaxJogadores() {
		if (numeroMaxJogadores == null) {
			numeroMaxJogadores = new JList();
			numeroMaxJogadores.setBounds(new Rectangle(214, 134, 46, 21));
		}
		return numeroMaxJogadores;
	}

	/**
	 * This method initializes protegida	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getProtegida() {
		if (protegida == null) {
			protegida = new JRadioButton();
			protegida.setBounds(new Rectangle(166, 169, 21, 21));
		}
		return protegida;
	}

	/**
	 * This method initializes naoProtegida	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getNaoProtegida() {
		if (naoProtegida == null) {
			naoProtegida = new JRadioButton();
			naoProtegida.setBounds(new Rectangle(223, 169, 21, 21));
		}
		return naoProtegida;
	}

	/**
	 * This method initializes corJogador	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getCorJogador() {
		if (corJogador == null) {
			corJogador = new JList();
			corJogador.setBounds(new Rectangle(183, 63, 77, 15));
			String[] cores = {"Azul", "Vermelho", "Verde", "Amarelo", "Preto", "Branco"};
			corJogador.setListData(cores);
		}
		return corJogador;
	}

}
