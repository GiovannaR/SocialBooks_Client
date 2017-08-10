/**
*Tp6
*Questao05 - Matriz Dinamica
*@author Giovanna Avila Riqueti
*@version 1 17/10/2016
*/

class Celula {

   	public int elemento;
   	public Celula inf, sup, esq, dir;

/**
*Construtor padrao
*/
   	public Celula(){
      		this(0, null, null, null, null);
   	}

/**
*Construtor alternativo
*@param elemento int - valor do elemento
*/
   	public Celula(int elemento){
      		this(elemento, null, null, null, null);
   	}

/**
*Construtor alternativo
*@param elemento int - valor do elemento
*@param inf Celula - Celula que o inf apontara'
*@param sup Celula - Celula que o sup apontara'
*@param esq Celula - Celula que o esq apontara'
*@param dir Celula - Celula que o dir apontara'
*/
	public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      		this.elemento = elemento;
      		this.inf = inf;
      		this.sup = sup;
      		this.esq = esq;
		this.dir = dir;
   	}

}

class Matriz {
   	private Celula inicio;
   	private int linha, coluna;

/**
*Construtor padrao
*/
   	public Matriz ( ){
      		inicio = new Celula ( );
		this.linha = this.coluna = 3;
		alocarMatriz( 3, 3 );
   	}

/**
*Construtor alternativo
*@param linha int - o numero de linhas da Matriz
*@param coluna int - o numero de colunas da Matriz
*/
   	public Matriz (int linha, int coluna){
      		inicio = new Celula ( );
		this.linha = linha;
      		this.coluna = coluna;
		alocarMatriz ( linha, coluna );
   	}

/**
*Metodo para alocar a Matriz
*@param int linha - o numero de linhas
*@param int coluna - o numero de colunas
*/
	public void alocarMatriz ( int linha, int coluna ){
		Celula i = inicio;
                Celula j = i;
                for( int n = 0; n < linha; n++ ){
                        for ( int s = 1; s < coluna; s++ ){
                                Celula tmp = new Celula( );
                                j.dir = tmp;
                                tmp.esq = j;
                                if ( tmp.esq != null && tmp.esq.sup != null && tmp.esq.sup.dir != null ){
                                        tmp.esq.sup.dir.inf = tmp;
                                        tmp.sup = tmp.esq.sup.dir;
                                }
				j = j.dir;
                                tmp = null;
                        }
				if( n < linha - 1 ){
                                	Celula tmp2 = new Celula ( );
                                	i.inf = tmp2;
                                	tmp2.sup = i;
                                	i = i.inf;
                                	j = i;
                                	tmp2 = null;
				}
                }
                j = null;
                i = null;

	}
	
/**
*Metodo para preencher determinada linha da Matriz
*@param array int [ ] - valores para preencher a linha
*@param int linha - o numero de linhas
*@param int coluna - o numero de colunas
*/
	public void preencherLinhas (int [ ] array, int Linha, int Coluna ){
		Celula n = inicio;
		if ( Linha != 0 ){
			for (int l = 0; l < Linha; l++, n = n.inf );
		}
		int i;
		for( i = 0; i < Coluna; i++ ) {
			n.elemento = array[i];
			n = n.dir;
		}
	}

/**
*Metodo para retornar uma String so com numeros
*@param suja String - String com numeros e outros caracteres
*@return Digito String - String so com numeros
*/
	public String SoDigito ( String suja ){
		String Digito = "";
		for ( int j = 0; j < suja.length( ); j ++ ){
			if ( suja.charAt(j) >= '0' && suja.charAt(j) <= '9' ){
				Digito += suja.charAt(j);
			}
		}
		return Digito;
	}

/**
*Metodo para quebrar a String de acordo com os seus espacos vazios e obter os inteiros
*@param suja String - String com os inteiros
*@param colunas int - numero de colunas da Matriz que define tamanho do array de retorno
*@return array int [ ] - array com os inteiros
*/ 
	public int [ ] quebrarInteiros (String suja, int coluna){
		int [ ] array = new int [coluna];
		String [ ] limpa = suja.split(" ");
		int i = 0;
		while ( i < array.length ){
			int inteiro = Integer.parseInt(SoDigito(limpa[i]));
			array[i] = inteiro;
			i ++;
		}
		return array;
	}

/**
*Metodo para mostrar os elementos da Matriz
*/
	public void mostrar( ){
		Celula i;
		Celula j;
		for ( i = inicio; i != null; i = i.inf ){
			for ( j = i; j != null; j = j.dir ){
				MyIO.print( j.elemento + " " );
			}
			MyIO.println("");
		} 
	}	

/**
*Metodo para somar Matrizes
*@param m Matriz - segunda Matriz a ser somada
*@return resp Matriz - Matriz que corresponde a soma de duas Matrizes
*/
   	public Matriz soma (Matriz m) {
      		Matriz resp = null;
		Celula ai = this.inicio;
		Celula aj = ai;
		Celula mi = m.inicio;
		Celula mj = mi;
		Celula ri; 
		Celula rj; 

      		if(this.linha == m.linha && this.coluna == m.coluna){
         		resp = new Matriz ( m.linha, m.coluna );
			ri = resp.inicio;
			rj = ri;
			
			for ( int n = 0; n < linha; n++ ){
				for ( int f = 0; f < coluna; f++ ){	
					rj.elemento = aj.elemento + mj.elemento;
					if ( rj.dir != null && aj.dir != null && mj.dir != null ){
						rj = rj.dir;
						aj = aj.dir;
						mj = mj.dir;
					}
				}
				ri = ri.inf;
				rj = ri;
				ai = ai.inf;
				aj = ai;
				mi = mi.inf;
				mj = mi;
			}
      		}
      		return resp;
   	}

	public Matriz transpor ( ){
		Matriz resp = new Matriz (this.coluna, this.linha);
		Celula i, j, f, n;
		f = resp.inicio;
		n = resp.inicio;
		for(i = inicio; i != null; i = i.inf ){
			for ( j = i; j != null; j = j.dir ){
				f.elemento = j.elemento;
				f = f.inf;
			}
			n = n.dir;
			f = n;
		}
		f = null; 
		n = null;
		i = null;
		j = null;
		return resp;
	}


/**
*Funcao que retorna uma Matriz que e' a multiplicacao de outras duas
*@param m Matriz - Matriz a ser multiplicada
*@return r Matriz - Matriz que e' o resultado da multiplicacao de duas matrizes
*/
   	public Matriz multiplicacao (Matriz m) {
      		Matriz r = null;

      		if( this.coluna == m.linha ){
			r = new Matriz (this.linha, m.coluna );
			

			Celula ai = this.inicio;
			Celula aj = this.inicio;
			Celula mi = m.inicio;
			Celula mj = m.inicio;

			for ( Celula ir = r.inicio; ir != null; ir = ir.inf ){
				for ( Celula jr = ir; jr != null; jr = jr.dir ){
					int resp = 0;
					for ( aj = ai, mi = mj; mi != null ; mi = mi.inf, aj = aj.dir ){
						resp += (aj.elemento * mi.elemento);
					}
					jr.elemento = resp; 
					mj = mj.dir;
				}
				ai = ai.inf;
				mj = m.inicio;
			}
		}
      		return r;
   	}

/**
*Metodo para identificar se uma Matriz e' quadrada
*@return boolean - se e' quadrada ou nao
*/
   	public boolean isQuadrada ( ){
      		return (this.linha == this.coluna);
   	}

/**
*Metodo para mostrar apenas a Diagonal Principal de uma Matriz
*/
   	public void mostrarDiagonalPrincipal ( ){
      		if(isQuadrada() == true){
			int i;
			int j;
			Celula n = inicio;
			Celula f = n;
			for ( i = 0; i < this.linha; i ++ ){
				for ( j = 0; j < this.coluna; j++ ){
					if ( i == j ){
						MyIO.print( f.elemento + " " );
					}
						if ( f.dir != null ){
							f = f.dir;
						}
					}
				
				n = n.inf;
				f = n;				
			}
      		}
   	}

/**
*Metodo para mostrar apenas a Diagonal Secundaria de uma Matriz
*/
   	public void mostrarDiagonalSecundaria (){
      		if(isQuadrada() == true){
			int i;
                        int j;
                        Celula n = inicio;
                        Celula f = n;
                        for ( i = 0; i < this.linha; i ++ ){
                                for ( j = 0; j < this.coluna; j++ ){
                                        if ( i == (coluna - 1) - j ){
                                                MyIO.print( f.elemento + " " );
                                        }
                                                if ( f.dir != null ){
                                                        f = f.dir;
                                                }
                                        }
                                n = n.inf;
                                f = n;
                        }			
      		}
   	}

}

class TP0605Matriz {

	public static void main (String [ ] args){
      		Matriz m1, m2, soma, multiplicacao;

		int [ ] array;
		String linha;

		int Linhas, Colunas, i;
		int Casos;
		int contador = 0;

	//	Casos = MyIO.readInt( );
	//	while ( contador < Casos ){

			Linhas = MyIO.readInt( );
			Colunas = MyIO.readInt( );

			m1 = new Matriz ( Linhas, Colunas );
			for ( i = 0; i < Linhas; i++ ){
				linha = MyIO.readLine( );
				array = m1.quebrarInteiros(linha, Colunas);
				m1.preencherLinhas(array, i, Colunas); 	
			}		

	/*		Linhas = MyIO.readInt( );
         	      	Colunas = MyIO.readInt( );

                	m2 = new Matriz ( Linhas, Colunas );
                        
                	for ( i = 0; i < Linhas; i++ ){
                	linha = MyIO.readLine( );
                        array = m2.quebrarInteiros(linha, Colunas);
                        m2.preencherLinhas(array, i, Colunas);
                	}
                	
			m1.mostrarDiagonalPrincipal( );
			MyIO.println(" ");
			m1.mostrarDiagonalSecundaria( );
			MyIO.println(" ");
			soma = m1.soma(m2);
			soma.mostrar( );      
			multiplicacao = m1.multiplicacao(m2);
			multiplicacao.mostrar( );
			contador ++;
   		}
	*/
		m2 = m1.transpor( );
		m2.mostrar( );
	}
}
