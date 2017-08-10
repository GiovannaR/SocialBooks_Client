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


	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
	public void mostrar() {
		System.out.print("[ ");
		
		for(Celula i = topo; i != null; i = i.prox){
			System.out.print(i.elemento + " ");
      		}

		System.out.println("] ");
	}

	public void mostrarRR ( ){
		System.out.print("[ ");
		mostrarRR(topo);
		System.out.println(" ]");
	}

	public void mostrarRR (Celula i){
		if ( i != null ){
			mostrarRR(i.prox);
			System.out.print( i.elemento + " " );
		}
	}

	public int somar() {
                int soma = 0;

                for(Celula i = topo; i != null; i = i.prox){
                        soma += i.elemento;
                }
		return soma;
        }

	public int somarR( ){
		return somarR(topo);
	}

	public int somarR ( Celula i){
		int soma = 0;
		if ( i != null ){
			soma = i.elemento + somarR(i.prox);
		}
		return soma;
	}

	public int maior ( ) throws Exception{
		if ( topo == null ){
			throw new Exception ("Erro");
		}
		int maior = topo.elemento;
		for ( Celula i = topo; i != null; i = i.prox ){
			if ( i.elemento > maior ){
				maior = i.elemento;
			}
		}
		return maior;
	}





}
