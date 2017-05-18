package Array;
public class PersonalArrayListProf<T> 
{
	//Atributos da classe
	private final int MEM_EXTRA = 10;
	private T[] lista = (T[]) new Object[MEM_EXTRA];
	private int finalLista = 0;
	
	//METODO QUE RETORNA A ATUAL POSICAO DE INSERCAO
	public int retornaTamanhoLista()
	{
		return finalLista;
	}
	
	//METODO RESPONSAVEL PELA INSERCAO
	public void adicionaNome(T novoNome)
	{
		//VERIFICA SE AINDA HA MEMORIA DISPONIVEL
		if (finalLista == lista.length)
		{
			realocaLista();
		}
		lista[finalLista] = novoNome;
		finalLista++;
	}
	
	//METODO UTILIZADO PARA REMOVER UM ELEMENTO
	public T removeElemento(int posicao)
	{
		T excluido = null;
			
		//VERIFICAR SE A POSICAO DE REMOCAO EXISTE
		if (posicao < 0 || posicao >= finalLista)
		{
			throw new RuntimeException();
			//return excluido;
		}
			
		//Guarda o elemento a ser excluido
		excluido = lista[posicao];
			
		//EXCLUI E REPOSICIONA OS DEMAIS ELEMENTOS
		for (int inicio = posicao; inicio < finalLista - 1; inicio++)
		{
			lista[inicio] = lista[inicio+1];
 		}
		finalLista--;
				
		return excluido;
	}
	
	//INSERE UM NOVO ELEMENTO NA POSICAO DESEJADA
	public void adicionaNomeEm(T novo, int posicao)
	{
		//O QUE SERA QUE EU TENHO QUE CODIFICAR AQUI????
		if (posicao >=0 && posicao <= finalLista)
		{
			//Verifica se existe memoria suficiente
			if (finalLista == lista.length)
			{
				realocaLista();
			}
			
			//Se insercao na primeira posicao, desloca todos para a direita e insere
			if (posicao == finalLista)
			{
				lista[finalLista] = novo;
			}
			else 
			{
				for (int pos = finalLista; pos > posicao; pos--)
				{
					lista[pos] = lista[pos - 1];
				}
				lista[posicao] = novo;
			}
			
			//Atualiza a variavel de insercao
			finalLista++;
		}
	}
	
	//BUSCA UM ELEMENTO DA LISTA
	public T buscaElementoLista(int posicao)
	{
		if (posicao >= 0 && posicao < finalLista)
		{
			return lista[posicao];
		}
		return null;
	}
	
	//METODO IMPLEMENTADO PARA IIMPRIMIR A LISTA
	public void imprimeLista()
	{
		for (int pos=0; pos < finalLista; pos++)
		{
			System.out.print(lista[pos] +  " ");
		}
		System.out.println();
	}
	
	//METODO UTLIZADO PARA AUMENTAR A MEMORIA DA LISTA
	private void realocaLista()
	{
		//ALOCA UM NOVO VETOR COM MAIS MEMORIA QUE O ANTERIOR
		T[] temporario = 
				(T[]) new String[lista.length + MEM_EXTRA];
		
		//REALIZA A COPIA ELEMENTO POR ELEMENTO
		//DO VETOR ANTIGO PARA O NOVO
		for (int posicao=0; posicao < lista.length; posicao++)
		{
			temporario[posicao] = lista[posicao];
		}
		
		//REVALIDA A VARIAVEL DE REFERENCIA PARA A NOVA LISTA
		lista = temporario;
	}
}