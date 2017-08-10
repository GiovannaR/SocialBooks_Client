/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 2 01/2015
 */

class Insercao extends Geracao {

	/**
	 * Construtor.
	 */
   public Insercao(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Insercao(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao por insercao.
	 */
	public static void insercao() {
		for (int i = 1; i < n; i++) {
		int tmp = array[i];
        	int j = i - 1;
		
         	while ((j >= 0) && (array[j] > tmp)) {
            		array[j + 1] = array[j];
            		j--;
         	}
         	array[j + 1] = tmp;
      		}
	}

/**
  * Algoritmo de ordenacao por insercao parcial, so' os k menores elementos
  */
        public static void insercao ( int k ) {
                for (int i = 1; i < n; i++) {
                int tmp = array[i];
                int j = i - 1;
		if ( j > k ){
			j = k;
		}
                while ((j >= 0) && (array[j] > tmp)) {
                        array[j + 1] = array[j];
                        j--;
                }
                array[j + 1] = tmp;
                }
        }



	public static void main(String[] args) {
      		Insercao insercao = new Insercao(20);
		insercao.aleatorio();
		
		long comeco = now();
		insercao.insercao();
		long fim = now();
		insercao.mostrar( );
		System.out.println("Tempo para ordenar: " + (fim-comeco)/1000.0 + " s.");
		insercao = new Insercao(20);
		insercao.aleatorio( );
		 insercao.mostrar( );
		MyIO.println("Separa" );	
		long inicio = now( );
		insercao.insercao(5);
		long finall = now( );
		insercao.mostrar();
		System.out.println("Tempo para ordenar: " + (finall-inicio)/1000.0 + " s.");
	}
}
