
public class Fila {
	
	private String[] nomes;
	private int inicio;
	private int fim;
	private int tam;
	
	public Fila()
	{
		nomes = new String[10];
		inicio = 0;
		fim = -1;
		tam = 0;
	}
	public boolean filaVazia()
	{
		if (tam == 0)
			return true;
		return false;
	}
	public boolean filaCheia()
	{
		if (tam == 10)
			return true;
		return false;
	}
	public boolean insereFila(String nome)
	{
		if (filaCheia())
			return false;
		fim = (1+fim)%10;
		nomes[fim] = nome;
		tam++;
		return true;		
	}
	public boolean retiraFila()
	{
		if (filaVazia())
			return false;
		inicio = (1+inicio)%10;
		tam--;
		return true;
	}
	public String primeiroFila()
	{
		if (filaVazia())
			return ("");
		return nomes[inicio];
	}
	public String ultimoFila()
	{
		if (filaVazia())
			return ("");
		return nomes[fim];
	}
	public int tamanhoFila()
	{
		return tam;
	}
	public int inicioFila()
	{
		return inicio;
	}
	public int fimFila()
	{
		return fim;
	}
}
