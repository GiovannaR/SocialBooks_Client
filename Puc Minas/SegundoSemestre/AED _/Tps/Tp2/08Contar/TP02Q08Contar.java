/**  
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 08
  *
  */
class TP02Q08Contar {
	
	//Metodo para inicializar metodo recursivo que conta a ocorrencia de um caractere em uma String
	public static int Contar ( String analisada, char procurado ){
		return Contar ( analisada, procurado, 0 );
	}

	//Metodo recursivo para contar quantas vezes um determinado caractere aparece na String
	public static int Contar ( String analisada, char procurado, int i ){
		int quantidade = 0;
		if ( i < analisada.length( ) ){
			if( analisada.charAt(i) == procurado ){
				quantidade = Contar ( analisada, procurado, i + 1 ) + 1;
			} else{
				quantidade = Contar ( analisada, procurado, i + 1 ) + 0;
			}
		}
		return(quantidade);
	}	

	//Metodo para testar se o caracter eh uma letra
	public static boolean ELetra ( char analisada ) {
                boolean resposta = false;
                if ( (analisada >= 'a' && analisada <= 'z') || (analisada >= 'A' && analisada <= 'Z') )
                {
                        resposta = true;
                }
        	return(resposta);
        }

	//Metodo para identificar se um caractere eh um numero impar
	 public static boolean EImpar ( char analisada ) {
                boolean resposta = false;
                if ( (analisada >= '0' && analisada <= '9') && (int)analisada % 2 != 0 ){
                        resposta = true;
                }
        	return(resposta);
        }

	//Metodo para inicializar metodo recursivo que conta a quantidade de letras em uma String
	public static int QLetras ( String analisada ){
		return QLetras( analisada, 0 );
	}
	
	//Metodo recursivo para contar a quantidade de letras em uma String
	public static int QLetras ( String analisada, int i ){
                int quantidade = 0;
                if ( i < analisada.length( ) ){
                        if( ELetra (analisada.charAt(i)) ){
                                quantidade = QLetras( analisada, i + 1) + 1;
                        }else{
				quantidade = QLetras ( analisada, i + 1) + 0;
			}
                }
		return(quantidade);
	}

	//Metodo para inicializar metodo recursivo que conta os caracteres diferentes de letras
	public static int Diferentes ( String analisada ){
		return Diferentes ( analisada, 0 );
	}

	//Metodo recursivo para contar os caracteres diferentes de letras
	public static int Diferentes ( String analisada, int i ){
		int quantidade = 0;
		if ( i < analisada.length( ) ){
			if ( ELetra(analisada.charAt(i)) == false ){
				quantidade = Diferentes( analisada, i + 1) + 1 ;
			}else{
				quantidade = Diferentes ( analisada, i + 1) + 0;
			}
		}
		return(quantidade);
	}

	//Metodo para identificar uma vogal
	public static boolean EVogal( char analisada ) {
		boolean resposta = false;
		int TabelaASCII;
		if ( ELetra(analisada) ){
			if ( analisada >= 'A' && analisada <= 'Z' ){
				TabelaASCII = (int)analisada + 32;
				analisada = (char)TabelaASCII;
			}
			if ( analisada == 'a' || analisada == 'e' || analisada == 'i' || analisada == 'o' || analisada == 'u' ){
				resposta = true;
			}
		}
		return(resposta);
	}

	//Metodo para testar se o caractere eh uma consoante
	public static boolean EConsoante ( char analisada ) {
                boolean resposta = false;
		int TabelaASCII;
                if ( ELetra(analisada) ){
                	if( analisada >= 'A' && analisada <= 'Z' ){
                        	TabelaASCII = (int)analisada + 32;
                                analisada = (char)TabelaASCII;
                        }
                        if ( EVogal(analisada) == false ) {
	                        resposta = true;
         	        }
        	}
        	return(resposta);
        }

	//Funcao para identificar consoante doidona
	public static boolean ConsoanteDoida ( char analisada ) {
		boolean resposta = false;
		int TabelaASCII;
		if ( EConsoante(analisada) ){
			TabelaASCII = (int)analisada;
			if ( TabelaASCII % 5 == 0 && TabelaASCII % 2 != 0 ){
				resposta = true;
			}	
		}
		return(resposta);
	}

	//Funcao para identificar vogal doidona  
        public static boolean VogalDoida ( char analisada ) {
                boolean resposta = false;
                int TabelaASCII;
                if ( EVogal(analisada) ){
                        TabelaASCII = (int)analisada;
                        if ( TabelaASCII % 5 != 0 && TabelaASCII % 8 != 0 ){
                                resposta = true;
                        }
		}
                return(resposta);
        }

	public static int Doidoes ( String analisada ){
		return Doidoes ( analisada, 0 );
	}

	//Funcao ṕara contar caracteres doidoes (e' um digito impar ou consoante cujo codigo ASCII e' multiplo de cinco e nao multiplo de dois ou vogal cujo codigo ASCII nao e' multiplo de cinco e nem de oito).
	public static int Doidoes ( String analisada, int i ){
		int doido = 0;
		if ( i < analisada.length( ) ){
			if ( EDoido(analisada.charAt(i)) ){
				doido = Doidoes ( analisada, i + 1 ) + 1;
			}else {
				doido = Doidoes ( analisada, i + 1) + 0;
			}
		}
		return(doido);
	} 

//Funcao para afirmar se e' um caractere doidao
	public static boolean EDoido ( char analisada ){
		boolean resposta = false;
		int ASCIIconsoante;
		int ASCIIvogal;
		if ( EImpar(analisada) || VogalDoida(analisada) || ConsoanteDoida(analisada) ){
			resposta = true;
		}		 
		return(resposta);
	}

	//Metodo para inicializar metodo recursivo que compara duas Strings e diz se elas sao iguais
	public static boolean igual ( String p, String s ){
		return igual ( p, s, 0 );
	}
	
	//Metodo recursivo para comparar duas Strings e dizer se elas sao iguais
	public static boolean igual ( String comparada, String gemea, int i ){
		boolean resposta = true;
		if ( i < comparada.length( ) && i < gemea.length( ) ){
			if( comparada.length( ) != gemea.length( )){
				resposta = false;
			}else if ( comparada.charAt(i) != gemea.charAt(i) ){
				resposta = false; 
			}else{
				resposta = igual ( comparada, gemea, i + 1 );
			}		
		}
		return (resposta); 	
	}

	public static void main ( String [ ] args ){
		String linha;
		int primeiraLetra;
		int NLetras;
		int NOutros;
		int NDoidao;

		linha = MyIO.readLine( );
		while ( igual(linha,"FIM") == false ){
			primeiraLetra =	Contar(linha,linha.charAt(0));
			MyIO.print(primeiraLetra);
			NLetras = QLetras(linha);
			MyIO.print( " " + NLetras );
			NOutros = Diferentes(linha);
			MyIO.print(" " + NOutros);
			NDoidao = Doidoes(linha);
			MyIO.println( " " + NDoidao );
			linha = MyIO.readLine( );
		}

	}
}
