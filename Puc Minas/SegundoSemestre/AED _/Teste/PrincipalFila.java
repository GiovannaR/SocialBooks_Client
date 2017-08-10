/**
 * Fila dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class PrincipalFila {

	public static Celula toPilha (Celula primeiro){
		Celula topo = null;
		Celula aux;
		Celula i = primeiro.prox;
		while ( i != null ){
			aux = new Celula (i.elemento);
			aux.prox = topo;
			topo = aux;
			i = i.prox;
		}
		aux = null;
		i = null;
		return topo;
	}

	public static void mostrarPilha (Celula topo){
		Celula i;
		System.out.print( "[" );
		for ( i = topo; i != null; i = i.prox ){
			System.out.print(i.elemento + " " );
		}
		System.out.print( "]" );
	}

   public static void main(String[] args) throws Exception {
      System.out.println("==== FILA DINAMICA ====");
      Fila fila = new Fila();
      int x1, x2, x3;

      fila.inserir(1);
      fila.inserir(2);
      fila.inserir(3);
      fila.inserir(4);

      
      mostrarPilha(toPilha(fila.primeiro));

   }
}
