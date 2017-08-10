class No{
	
	int elemento;
	No esq, dir;
	No2 raiz;

	public No (int elemento){
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
		this.raiz = null;
	}

}

class No2{

	int elemento;
	No2 esq, dir;

	public No2 (int elemento){
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
	}	
}

class ArvoredeArvore {

	No raiz;

	public No ( ){
		raiz = new No(6);
		Construir( );
	}

	public Construir ( ){
		try {	
			inicializar (2);
			inicializar (9);
			inicializar (4);
			inicializar (11);
			inicializar (0);
			inicializar (1);
			inicializar (3);
			inicializar (5);
			inicializar (7);
			inicializar (8);
			inicializar (10);
			inicializar (12);
		}catch ( Exception es ){
		}
	}

	public void inicializar (int x) throws Exception{
		raiz = inicializar (x,raiz);
	}

	private No inicializar (int x, No i) throws Exception{
		if ( i == null ){
			compara ++;
			i = new No(x);
		}else if ( x < i.elemento ){
			compara += 2;
			i.esq = inicializar (x,i.esq);
		}else if ( x > i.elemento ){
			compara += 3;
			i.dir = inicializar (x,i.dir);
		}else{
			compara += 3;
			throw new Exception ("Erro!");
		}
		return i;
	}
	
	public No BuscarNo (int mes)throws Exception{
		return BuscarNo(mes, raiz);
	}

	private No BuscarNo (int mes, No i) throws Exception{
		No resp = null;
		if ( i == null ){
			throw new Exception ("Nao encontrado");
		}else if ( mes == i.elemento ){
			resp = i;
		}else if ( mes < i.elemento ){
			resp = BuscarNo (mes, i.esq);
		}else if ( mes > i.elemento ){
			resp = BuscarNo (mes, i.dir);
		}
		return resp;
	}


	public void inserir2 (int n, int x){
		No r = buscarNo (n);
		n.raiz = inserir2 (x,n.raiz );

	}

	public No pesquisarNo (int x){
		return pesquisarNo(x, raiz);
	}

	private No pesquisarNo (int x, No i){
		resp = false;
		No r = null;
		if ( i != null ){
			resp = pesquisar( i.raiz );
			if ( resp == true ){
				r = i;
				i = null;
			}
			if ( r == null ){
				resp = pesquisarNo (x, i.esq);
			}
			if ( r == null ){
				resp = pesquisarNo (x, i.dir);
			}
		}
		return r;
	}

	public remover (int x){
		No r = pesquisarNo(x);
		if ( r != null ){
			r.raiz = remover(r.raiz);
		}
	}

	public No2 remover (int id, No2 j)throws Exception{
		if(j == null){
			compara ++;
			throw new Exception ("Erro");
    		}else if ( id < j.elemento ) {
			compara += 2;
        		j.esq = remover(id, j.esq);
      		}else if ( id > j.elemento ) {
			compara += 3;
        		j.dir = remover(id, j.dir);
      		}else if ( j.dir == null ) {
			compara += 4;
        		j = j.esq;
      		}else if ( j.esq == null ) {
			compara += 5;
        		j = j.dir;
      		}else{
			compara += 5;
        		j.esq = antecessor(j, j.esq);
        	}
        	return j;
    	}

	private No2 antecessor(No2 i, No2 j) {
		compara ++;
        	if (j.dir != null) {
            		j.dir = antecessor(i, j.dir);
        	} else {
            		i.elemento = j.elemento; 
            		j = j.esq; 
        	}
        	return j;
    	}
}
