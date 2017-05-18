package Array;

//Sistema de Fila 
//O primeiro a ser adicionado e o primeiro a sair 
//Terceira aula de Estrutura de dados 

public class fila<T> extends PersonalArrayListProf<T>
{
	public void adicionar(T nome)
	{
		super.adicionaNomeEm(nome, 0);
	}
	public T remover()
	{
		return removeElemento(retornaTamanhoLista()-1);
		
	}

}
