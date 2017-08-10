class No{
	public int elemento;
	public No esq;
	public No dir;
	public int nivel;

/**
*Construtor padrao
*/
	No (int elemento){
		this(elemento, null, null, 1);
	}

/**
*Construtor alternativo
*/
	No(int elemento, No esq, No dir, int nivel){
		this.elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}

	public No setNivel ( ){
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
		return this;
	}	

	public static int getNivel (No no){
		return (no == null) ? 0 : no.nivel;
	}

}

public class AVL {
	private No raiz;

/**
*Construtor padrao
*/
	public AVL( ){
		raiz = null;
	}
	
/**
*Funcao para obter a altura da arvore
*@return int - a altura da arvore (nivel - 1)
*/
	public int getAltura( ){
		return nivel(raiz) - 1;
	}

/**
*Funcao para obter o nivel do No
*@param no No - No a ser analisado
*@return int - o nivel do no
*/
	private int nivel (No no){
		return (no == null) ? 0 : (1 + Math.max(nivel(no.esq), nivel(no.dir)));
	}

/**
*Metodo publico que chama o pesquisar privado
*@param elemento int - elemento a ser pesquisado
*@return boolean - resposta se o elemento foi encontrado ou nao
*/
	public boolean pesquisar(int elemento) {
		return pesquisar(raiz, elemento);
	}

/**
*Metodo recursivo para pesquisar determinado elemento
*@param elemento int - elemento a ser pesquisado
*@return boolean - resposta se o elemento foi encontrado ou nao
*/
	private boolean pesquisar(No no, int x) {
		boolean resp;
		if (no == null) {
			resp = false;
		} else if (x == no.elemento) {
			resp = true;
		} else if (x < no.elemento) {
			resp = pesquisar(no.esq, x);
		} else {
			resp = pesquisar(no.dir, x);
		}
		return resp;
	}
   
	public void inserir(int x) throws Exception {
		raiz = inserir(raiz, x);
	}

	private No inserir(No no, int x) throws Exception {
		if (no == null) {
			no = new No(x);
		} else if (x < no.elemento) {
			no.esq = inserir(no.esq, x);
        	} else if (x > no.elemento) {
			no.dir = inserir(no.dir, x);
        	} else {
			throw new Exception("Erro ao inserir elemento (" + x + ")! ");
        	}
		no = balancear(no);
		return no;
    	}

	private No balancear (No no) throws Exception{
		if ( no != null ){
			int fator = No.getNivel(no.dir) - No.getNivel(no.esq);
			if ( Math.abs(fator) <= 1 ){
				no = no.setNivel( );
			}else if ( fator == 2 ){
				int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
				if ( fatorFilhoDir == -1 ){
					no.dir = rotacionarDir(no.dir);
				} 
				no = rotacionarEsq(no);
			}else if ( fator == -2 ){
				int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
				if ( fatorFilhoEsq == 1 ){
					no.esq = rotacionarEsq(no.esq);
				}
				no = rotacionarDir(no);
			}
		}else{
				throw new Exception("Erro ao balancear");
		}
		return no;
	}

	private No rotacionarEsq (No no){
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;
		noEsq.dir = no;
		no.esq = noEsqDir;
		
		no.setNivel( );
		noEsq.setNivel( );

		return noEsq;
	}

	private No rotacionarDir(No no){
		No noDir = no.dir;
		No noDirEsq = noDir.esq;
		noDir.esq = no.dir;
		no.dir = noDirEsq;

		no.serNivel( );
		noDir.setNivel( );

		return noDir;
	}

	public void remover(int x) throws Exception {
		raiz = remover(raiz, x);
	}

	private No remover(No no, int x) throws Exception {
		if (no == null) {
			throw new Exception("Erro ao remover!");
		}else if (x < no.elemento) {
			no.esq = remover(no.esq, x);
		}else if (x > no.elemento) {
			no.dir = remover(no.dir, x);
		}else if (no.dir == null) {
			no = no.esq;
		}else if (no.esq == null) {
            		no = no.dir;
		}else {
		no.esq = antecessor(no, no.esq);
		}
		
		no = balancear(no);
		return no;
	}

	private No antecessor(No n1, No n2) {
        	if (n2.dir != null) {
            // Caminha para direita.
            n2.dir = antecessor(n1, n2.dir);
 
            // Encontrou o maximo da subarvore esquerda.
        } else {
            n1.elemento = n2.elemento; // Substitui N1 por N2.
            n2 = n2.esq; // Substitui N2 por N2.ESQ.
        }
        return n2;
    }
































