
public class Pilha {
	
	private String[] nomes;
	private int topo ;
	
	public Pilha()
	{
		nomes = new String[10];
		topo = -1;
	}
	
	public boolean pilhaVazia()
	{
		if (topo == -1)
			return true;
		return false;
	}
	
	public boolean pilhaCheia()
	{
		if (topo == 9)
			return true;
		return false;
	}
	public boolean empilha(String nome)
	{
		if (pilhaCheia())
			return false;
		nomes[++topo] = nome;
		return true;		
	}
	public boolean desempilha()
	{
		if (pilhaVazia())
			return false;
		topo--;
		return true;		
	}
	public int topoPilha()
	{
		return topo;
	}
	public String elementoTopo()
	{
		if(pilhaVazia())
			return ("");
		return nomes[topo];
	}
	public void mostraPilha()
	{
		if(pilhaVazia())
			System.out.println("Pilha Vazia!");
		for (int i = 0; i <= topo; i++)
			System.out.println(nomes[i]);
	}
}
