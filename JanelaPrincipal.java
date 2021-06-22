import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JanelaPrincipal extends JFrame {
	
	private Acao acao = new Acao();
	private Font arial = new Font("Arial", Font.BOLD, 20);
	private JLabel titulo = new JLabel();
	private JButton pilha = new JButton("Pilha");
	private JButton fila = new JButton("Fila");
	
	public JanelaPrincipal()
	{
		editarJanela();
	}
	public void editarJanela()
	{
		titulo.setFont(arial);
		titulo.setText("Escolha uma Estrutura de Dados:");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBounds(75, 10, 350, 30);
		add(titulo);
		
		pilha.setBounds(155, 100, 150, 30);
		pilha.addActionListener(acao);
		add(pilha);
		fila.setBounds(155, 180, 150, 30);
		fila.addActionListener(acao);
		add(fila);
		
		setLayout(null);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Estruturas de Dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main (String[] args)
	{
		new JanelaPrincipal();
	}
	
	private class Acao implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pilha)
			{
				new JanelaPilha();
			}
			if (e.getSource() == fila)
			{
				new JanelaFila();
			}
			
		}
		
	}

}
