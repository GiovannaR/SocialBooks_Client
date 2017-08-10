class PilhaNo{

	private Celula topo;
	
	public PilhaNo ( ){
		topo = new Celula ( );
	}

	public void inserir(int x){
		Celula tmp = new Celula (x);
		tmp.prox = topo.prox;
		topo.prox = tmp;
		tmp = null;
	}

	public int remover ( ) throws Exception{
		if ( topo.prox == null ){
			throw new Exception("Erro");
		}
		int elemento = topo.prox.elemento;
		Celula tmp = topo.prox.prox;
		topo.prox = tmp;
		topo.prox.prox = null;
		tmp = null;
		return elemento;
	}









}
