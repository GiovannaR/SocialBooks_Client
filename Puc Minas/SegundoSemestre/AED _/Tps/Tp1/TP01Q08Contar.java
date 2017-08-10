class TP01Q08Contar {

/**
  *Funcao para contar quantas vezes um caracter aparece na String
  *@param analidade - String a ser analisada
  *@param procurado - caractere a ser encontrada na String
  *
  */
	public static int Contar ( String analisada, char procurado ){
		int tamanho = analisada.length( );
		int quantidade = 0;
		int i = 0;

		while ( i < tamanho ){
			if( analisada.charAt(i) == procurado ){
				quantidade += 1;
			}
		i++;
		}
	return(quantidade);
	}

/**
  *Funcao para identificar letras em uma String
  *@param analisada - String a ser analisada
  *
  */    
	public static boolean ELetra ( char analisada ) {
                boolean resposta = false;
                if ( (analisada >= 'a' && analisada <= 'z') || (analisada >= 'A' && analisada <= 'Z') )
                {
                        resposta = true;
                }
        return(resposta);
        }

/**
  *Funcao para identificar digitos em uma String
  *@param analisada - String a ser analisada
  *
  */
        public static boolean EImpar ( char analisada ) {
                boolean resposta = false;
                if ( (analisada >= '0' && analisada <= '9') && (int)analisada % 2 != 0 ){
                        resposta = true;
                }
        return(resposta);
        }


/**
  *Funcao para retornar quantas letras existem na String
  *@param analisada - String que vai ter as linhas contadas
  *
  */
	public static int QLetras ( String analisada ){
		int tamanho = analisada.length( );
                int quantidade = 0;
                int i = 0;

                while ( i < tamanho ){
                        if( ELetra (analisada.charAt(i)) ){
                                quantidade += 1;
                        }
                i++;
                }
		
	return(quantidade);
	}

/**
  *Funcao para contar quantos caracteres na String nao sao letras
  *@param analisada - String que vai ser analisada
  *
  */
	public static int Diferentes ( String analisada ){
		int tamanho = analisada.length( );
		int i = 0;
		int quantidade = 0;

		while ( i < tamanho ){
			if ( ELetra(analisada.charAt(i)) == false ){
				quantidade ++;
			}
			i++;
		}
		return(quantidade);
	}

/**
  *Funcao para identificar vogais
  *@param analisada - caratere a ser analisado
  *
  */
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

/**
  *Funcao para identificar consoantes
  *@param analisada - caractere a ser analisado
  *
  */
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

/**
  *Funcao para identificar consoante doidona
  *@param analisada - caractere a ser analisado
  *
  */
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

/**
  *Funcao para identificar vogal doidona
  *@param analisada - caractere a ser analisado
  *
  */
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


/**
  *Funcao ṕara contar caracteres doidoes (e' um digito impar ou consoante cujo codigo ASCII e' multiplo de cinco e nao multiplo de dois ou vogal cujo codigo ASCII nao e' multiplo de cinco e nem de oito).
  *@param analisada - String que tera ou nao os caracteres doidoes
  */
	public static int Doidoes ( String analisada ){
		int tamanho = analisada.length( );
		int i = 0;
		int doido = 0;
		while ( i < tamanho ){
			if ( EDoido(analisada.charAt(i)) ){
				doido ++;
			}
			i++;
		}
		return(doido);
	} 

/**
  *Funcao para afirmar se e' um caractere doidao
  *@param analisada - caractere a ser analisada
  *
  */
	public static boolean EDoido ( char analisada ){
		boolean resposta = false;
		int ASCIIconsoante;
		int ASCIIvogal;
		if ( EImpar(analisada) || VogalDoida(analisada) || ConsoanteDoida(analisada) ){
			resposta = true;
		}		 
	return(resposta);
	}

/**
  *Funcao para comparar se duas Strings sao iguais
  *@param comparada - String a ser comparada
  *@param gemea - String a ser comparada
  *
  */
        public static boolean igual ( String comparada, String gemea ){
                boolean resposta = true;
                int tamanho = comparada.length( );
                if ( tamanho != gemea.length( ) ){
                        resposta = false;
                }else{
                        for ( int i = 0; i < tamanho; i++ ){
                                if( comparada.charAt(i) != gemea.charAt(i) ){
                                        resposta = false;
                                }
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
