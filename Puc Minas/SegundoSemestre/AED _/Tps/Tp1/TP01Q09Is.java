class TP01Q09Is {

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
  *Funcao para identificar se a String possui so vogais
  *@param analisada - String a ser analisada
  *
  */
	public static boolean SoVogais ( String analisada ) {
		boolean resposta = true;
		int i = 0;
		int tamanho = analisada.length( );
		while ( i < tamanho ){
			resposta = resposta && EVogal(analisada.charAt(i));
			i++;
		} 	
		return(resposta);
	}

/**
  *Funcao para identificar se a String possui so consoantes
  *@param analisada - String a ser analisada
  *
  */
        public static boolean SoConsoantes ( String analisada ) {
                boolean resposta = true; 
                int i = 0;
		int tamanho = analisada.length( );
                while ( i < tamanho ){
                        resposta = resposta && EConsoante(analisada.charAt(i));
                        i++;
                }
                return(resposta);
        }

/**
  *Funcao para identificar digitos em uma String
  *@param analisada - String a ser analisada
  *
  */
        public static boolean EDigito ( char analisada ) {
                boolean resposta = false;
                if ( analisada >= '0' && analisada <= '9' ){
                        resposta = true;
                }
        	return(resposta);
        }

/**
  *Funcao para identificar pontos e virgulas em uma String
  *@param analisada - String a ser analisada
  *
  */
        public static boolean EVirgula ( char analisada ) {
                boolean resposta = false;
                if ( analisada == ',' || analisada == '.' ){
                        resposta = true;
                }
                return(resposta);
        }


/**
  *Funcao para identificar se String corresponde a um numero inteiro
  *@param analisada - String a ser analisada
  *
  */
	public static boolean Inteiro ( String analisada ) {
		int tamanho = analisada.length( );
		int i = 0;
		boolean resposta = true;
		while ( i < tamanho ){
			if ( EDigito(analisada.charAt(i)) == false ) {
				resposta = false;
			}
			i++;  
		}
		return(resposta);
	}

/**
  *Funcao para identificar se String corresponde a um numero real
  *@param analisada - String a ser analisada
  *
  */
        public static boolean Real ( String analisada ) {
                int tamanho = analisada.length( );
                int i = 0;
		int quantidade = 0;
                boolean resposta = true;
                while ( i < tamanho ){
                        resposta = resposta && ( EDigito(analisada.charAt(i)) || EVirgula(analisada.charAt(i)) );
                        if ( EVirgula(analisada.charAt(i)) ){
				quantidade ++;
			}
			 i++;
                }
		if ( quantidade > 1 ){
			resposta = false;
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
		linha = MyIO.readLine( );
		while ( igual(linha,"FIM") == false ){
			if ( SoVogais(linha) ){
				MyIO.print ("SIM");
			}else{
				MyIO.print("NAO");
			}
			if ( SoConsoantes(linha) ){
                                MyIO.print (" SIM");
                        }else{
                                MyIO.print(" NAO");
                        }
			if ( Inteiro(linha) ){
                                MyIO.print (" SIM ");
                        }else{
                                MyIO.print(" NAO ");
                        }
			if ( Real(linha) ){
				MyIO.println("SIM");
			}else{
				MyIO.println("NAO");
			}
			linha = MyIO.readLine( );
		}

	}

}
