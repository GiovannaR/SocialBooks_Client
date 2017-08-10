/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Pilha {
	private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}


	/**
	 * Insere elemento na pilha (politica FILO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
      tmp = null;
	}


	/**
	 * Remove elemento da pilha (politica FILO).
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public int remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}

		int resp = topo.elemento;
      Celula tmp = topo;
		topo = topo.prox;
      tmp.prox = null;
      tmp = null;
		return resp;
	}
/*
	public void mostrarPilha ( ){
		System.out.print("[ ");
		mostrarPilha(topo);
		System.out.print( );
	}

	public void mostrarPilha ( Celula a ){
		if ( a != null ){
			mostrarPilha(a.prox);
			System.out.print( a.elemento + " " );
		}
	}
*/
	public void mostrarPilha2 ( ){
		MyIO.println( "[ " );
		Celula i = topo;
		Celula j = topo;

		Celula tmp = null;
		while ( tmp != topo ){
			for ( i = topo; i.prox != tmp; i = i.prox );
			for ( j = topo; j != i; j = j.prox );
			MyIO.print( j.elemento + " " );
			tmp = j;
		}		
		MyIO.println( " ]" );
	}

	public int soma ( ){
		int soma = 0;
		for(Celula i = topo; i != null; i = i.prox){
                        soma += i.elemento;
                }
		return soma;
	}

	public int soma2 ( ){
		soma2(topo);
	}

	 public void mostrarRecursivo ( Celula a ){
                if ( a != null ){
                        int soma += soma2(a.prox);
                }
		return soma;
        }

	 public int  ( ){
                int soma = 0;
                for(Celula i = topo; i != null; i = i.prox){
                        soma += i.elemento;
                }
                return soma;
        }


/*
	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 
	public void mostrar() {
		System.out.print("[ ");	
		for(Celula i = topo; i != null; i = i.prox){
			System.out.print(i.elemento + " ");
      		}
		System.out.println("] ");
	}

	public void mostrarRecursivo ( ){
		System.out.print("[ ");
		mostrarRecursivo(topo);
		System.out.print(" ]");
	}
*/
/*	public void mostrarRecursivo ( Celula a ){
		if ( a != null ){
			System.out.print( a.elemento );
			mostrarRecursivo(a.prox);
		}
	}
*/
}
