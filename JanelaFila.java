import java.awt.Color;
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

public class JanelaFila extends JFrame {
	
	private Acao acao = new Acao();
	private Fila f = new Fila();
	
	private Color corFundo = new Color(0, 0, 0);
	private Color corTexto = new Color(255,255,255);
	private Font arial = new Font("Arial", Font.BOLD, 20);
	private JLabel[] posicoes = new JLabel[10];
	private JLabel primeiro = new JLabel();
	private JLabel ultimo = new JLabel();
	private JLabel titulo = new JLabel();
	private JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("fila.png")));
	
	private JButton inserir = new JButton("Inserir");
	private JButton remover = new JButton("Remover");
	
	
	
	public JanelaFila()
	{
		editarJanela();
	}
	public void editarJanela()
	{
		int posX = 50;
		int posY = 200;
		
		for(int i = 0; i < 10; i++)
		{
			posicoes[i] = new JLabel();
			posicoes[i].setBounds(posX, posY, 100, 40);
			posicoes[i].setHorizontalAlignment(SwingConstants.CENTER);
			posicoes[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			posicoes[i].setForeground(corTexto);
			posicoes[i].setText("");
			add(posicoes[i]);
			posX += 110;
		}
		titulo.setBounds(550, 50, 100, 30);
		titulo.setForeground(Color.RED);
		titulo.setFont(arial);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setText("Fila");
		add(titulo);
		
		primeiro.setSize(50, 20);
		primeiro.setHorizontalAlignment(SwingConstants.CENTER);
		primeiro.setText("Início");
		primeiro.setVisible(false);
		add(primeiro);
		
		ultimo.setSize(50, 20);
		ultimo.setHorizontalAlignment(SwingConstants.CENTER);
		ultimo.setText("Fim");
		ultimo.setVisible(false);
		add(ultimo);
		
		inserir.setBounds(200, 350, 150, 30);
		inserir.addActionListener(acao);
		add(inserir);
		remover.setBounds(400, 350, 150, 30);
		remover.addActionListener(acao);
		add(remover);
		
		
		setLayout(null);
		fundo.setBounds(0, 0, 1200, 600);
		add(fundo);
		setTitle("Fila");
		setSize(1200, 600);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class Acao implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== inserir)
			{
				if (f.filaCheia())
					JOptionPane.showMessageDialog( null, "Fila Cheia!", "Erro", JOptionPane.ERROR_MESSAGE);
				else
				{
					String nome = JOptionPane.showInputDialog(null, "Entre com a String a ser inserida:", "Inserir", JOptionPane.PLAIN_MESSAGE);
					if(nome != null)
					{
						if(f.insereFila(nome))
						{
							int fim = f.fimFila();
							int inicio = f.inicioFila();
							int posX = posicoes[fim].getX();
							int posY = 175;
							posicoes[fim].setOpaque(true);
							posicoes[fim].setBackground(corFundo);
							posicoes[fim].setText(nome);
							ultimo.setLocation(posX, posY);
							ultimo.setVisible(true);
							posX = posicoes[inicio].getX()+50;
							primeiro.setLocation(posX, posY);
							primeiro.setVisible(true);
						}
					}
					else
						JOptionPane.showMessageDialog(null, "A string não pôde ser inserida!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			if (e.getSource() == remover)
			{
				if(f.filaVazia())
					JOptionPane.showMessageDialog(null, "Fila Vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
				else
				{
					int inicio = f.inicioFila();
					posicoes[inicio].setBackground(null);
					posicoes[inicio].setOpaque(false);
					posicoes[inicio].setText("");
					f.retiraFila();
					inicio = f.inicioFila();
					int posX = posicoes[inicio].getX()+50;
					int posY = 175;
					primeiro.setLocation(posX, posY);
					if(f.filaVazia())
					{
						primeiro.setVisible(false);
						ultimo.setVisible(false);
					}
					else
					primeiro.setVisible(true);
					
				}
			}
			
		}
		
	}

}
