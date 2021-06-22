import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JanelaPilha extends JFrame {
	
	private Pilha p = new Pilha();
	private Acao acao = new Acao();
	
	private Font arial = new Font("Arial", Font.BOLD, 20);
	private Color corFundo = new Color(0, 0, 0);
	private Color corTexto = new Color (255, 255, 255);
	private JLabel[] posicoes = new JLabel[10];
	private JLabel titulo = new JLabel();
	private JLabel topo = new JLabel();
	private JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("fundo.png")));
	
	private JButton empilha = new JButton("Empilhar");
	private JButton desempilha = new JButton("Desempilhar");
	
	public JanelaPilha()
	{
		editarJanela();
	}
	
	public void editarJanela()
	{
		int posX = 100;
		int posY = 500;
		
		titulo.setBounds(350, 10, 100, 30);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(arial);
		titulo.setForeground(Color.RED);
		titulo.setText("PILHA");
		add(titulo);
		
		topo.setBounds(250, 50, 150, 30);
		topo.setFont(new Font("Arial", Font.BOLD, 15));
		topo.setHorizontalTextPosition(SwingConstants.CENTER);
		topo.setText("Topo: ");
		add(topo);
		
		for (int i = 0; i < 10; i++)
		{
			posicoes[i] = new JLabel();
			posicoes[i].setHorizontalAlignment(SwingConstants.CENTER);
			posicoes[i].setText("");
			posicoes[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			posicoes[i].setForeground(corTexto);
			posicoes[i].setBounds(posX, posY, 100, 40);
			add(posicoes[i]);
			posY -= 50;
		}
		
		//Container c = getContentPane();
		//c.setBackground(Color.LIGHT_GRAY);
		
		empilha.setBounds(500, 100, 150, 30);
		empilha.addActionListener(acao);
		desempilha.setBounds(500, 200, 150, 30);
		desempilha.addActionListener(acao);
		
		setLayout(null);
		add(empilha);
		add(desempilha);
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);
		setTitle("Pilha");
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class Acao implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== empilha)
			{
				if(p.pilhaCheia())
					JOptionPane.showMessageDialog(null, "Pilha Cheia!", "Erro!", JOptionPane.ERROR_MESSAGE);
				else
				{
					String nome = JOptionPane.showInputDialog(null, "Entre com a String a ser empilhada:", "Empilhar", JOptionPane.PLAIN_MESSAGE);
					if(nome != null && p.empilha(nome))
					{
						posicoes[p.topoPilha()].setOpaque(true);
						posicoes[p.topoPilha()].setBackground(corFundo);
						posicoes[p.topoPilha()].setText(nome);
						topo.setText("Topo: " + p.elementoTopo());
						//JOptionPane.showMessageDialog(null, "Empilhado!", "Sucesso!", 1);
					}
				else
					JOptionPane.showMessageDialog(null, "A String não pôde ser empilhada!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (e.getSource() == desempilha)
			{
				if (p.pilhaVazia())
					JOptionPane.showMessageDialog(null, "Pilha Vazia!", "Erro!", JOptionPane.ERROR_MESSAGE);
				else{
					//int resposta = JOptionPane.showConfirmDialog(null, "Deseja desempilhar?", "Desempilhar", 1 , JOptionPane.WARNING_MESSAGE);
					//if (resposta == 0)
					//{
						if(p.desempilha())
						{
							posicoes[p.topoPilha()+1].setOpaque(false);
							posicoes[p.topoPilha()+1].setBackground(null);
							posicoes[p.topoPilha()+1].setText("");
							topo.setText("Topo: " + p.elementoTopo());
							//JOptionPane.showMessageDialog(null, "Desempilhado!", "Sucesso!", 1);
						}
					//}
				}
			}
		}
	}
}