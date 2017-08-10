class HashReserva{

	int [ ] tabela;
	int tamTabela;
	int NULO = -44;
	HashRehash T3;
	Lista TL;
	ArvoreBinaria TAB;

	public HashReserva( ){
		this(10);
	}

	public HashReserva(int n){
		this.tamTabela = n;
		tabela = new int [tamTabela];

		for (int i = 0; i < tamTabela; i++ ){
			tabela[i] = NULO;
		}

		T3 = new HashRehash ( );
		TL = new Lista ( );
		TAB = new ArvoreBinaria( );
	}

	public int hash (int x){
		return (x % tamTabela);
	}

	public int hashT2 (int x){
		return (x % 3);
	} 

	public void inserir (int x)throws Exception{
		int local = hash(x);
		int novo = hashT2(x);		

		if ( tabela[local] == NULO ){
			tabela[local] = x;
		}else if ( novo == 0 ){
			T3.inserir(x);
		}else if ( novo == 1 ){
			TL.inserirFim(x);
		}else if ( novo == 2 ){
			TAB.inserir(x);
		}
	}

	public boolean pesquisar (int x){
		boolean resp = false;
		int local = hash(x);
		int novo = hashT2(x);

		if ( tabela[local] == x ){
			resp = true;
		}else if ( novo == 0 ){
			resp = T3.pesquisar(x);
		}else if ( novo == 1 ){
			resp = TL.pesquisar(x);
		}else if ( novo == 2 ){
			resp = TAB.pesquisar(x);
		}
		
		return resp;
	}

	public void mostrar ( ){
		for(int i = 0; i < tamTabela; i++){
			MyIO.println( "Posicao : " + i + " Id: " + tabela[i] );
		}
		MyIO.println("T3 : ");
		T3.mostrar( );
		MyIO.println("Lista : ");
		TL.mostrar( );
		MyIO.println("Arvore: ");
		TAB.mostrarCentral( );
	}
}


class HashRehash {

	int [ ] tabela;
	int tamTabela;
	int NULO = -44;
	ArvoreBinaria arvore;

	public HashRehash( ){
		this(10);
	}

	public HashRehash (int n){
		this.tamTabela = n;
		tabela = new int [tamTabela + 1];
		for (int i = 0; i < tamTabela; i++ ){
			tabela[i] = NULO;
		}
		arvore = new ArvoreBinaria( );
	}

	public int hash (int x){
		return (x % 10);
	}

	public int rehash (int x){
		return (++x % 10);
	}

	public void inserir (int x)throws Exception{
		int local = hash(x);
		int novo = rehash(x);

		if ( tabela[local] == NULO ){
			tabela[local] = x;
		}else if ( tabela[novo] == NULO ){
			tabela[novo] = x;
		}else{
			arvore.inserir(x);
		}
	}
	
	public boolean pesquisar (int x){
		int local = hash(x);
		int novo = hash(x);
		boolean resp;

		if ( tabela[local] == x ){
			resp = true;
		}else if ( tabela[novo] == x ){
			resp = true;
		}else{
			resp = arvore.pesquisar(x);
		}
		
		return resp;
	}

	public void mostrar ( ){
		 for(int i = 0; i < tamTabela; i++){
                        MyIO.println( "Posicao : " + i + " Id: " + tabela[i] );
                }
		MyIO.println("Arvore do T3 ");
		arvore.mostrarCentral( );
	
	}

}


public class HashDoidona{

	public static void main ( String [ ] args )throws Exception{
		HashReserva array = new HashReserva( );
		int i = 0;
		while ( i < 35 ){
			int linha = MyIO.readInt( );
			array.inserir(linha);
			i++;
		}
		array.mostrar( );

		int j = 0;
		MyIO.println("\n Pequisas"); 
		while ( j < 3 ){
			int numero = MyIO.readInt( );
			if (array.pesquisar(numero)){
				MyIO.println("Numero: " + numero + " Resp: SIM" );
			}else{
				MyIO.println("Numero: " + numero + " Resp: NAO" );
			}
			j ++;
		}
	}

} 
