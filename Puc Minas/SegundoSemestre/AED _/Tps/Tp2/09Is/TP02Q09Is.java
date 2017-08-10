/** 
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 09
  *
  */
class TP02Q09Is {

	//Metodo para testar se o caracter eh uma letra
	public static boolean ELetra ( char analisada ) {
                boolean resposta = false;
                if ( (analisada >= 'a' && analisada <= 'z') || (analisada >= 'A' && analisada <= 'Z') )
                {
                        resposta = true;
                }
        	return(resposta);
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

	//Metodo para inicializar um metodo recursivo para identificar se a String possui so vogais
	public static boolean SoVogais ( String analisada ){
		return SoVogais ( analisada, 0 );
	} 	

	//Metodo recursivo para identificar se a String possui so vogais
	public static boolean SoVogais ( String analisada, int i ) {
		boolean resposta = true;
		if ( i < analisada.length( ) ){
			if ( EVogal( analisada.charAt(i)) == false ){
				resposta = false;
			}else{
				resposta = SoVogais( analisada, i + 1);
			}
		} 	
		return(resposta);
	}

	//Metodo para inicializar um metodo recursivo para identificar se a String possui so consoantes
        public static boolean SoConsoantes ( String analisada ){
                return SoConsoantes ( analisada, 0 );
        }

        //Metodo recursivo para identificar se a String possui so vogais
        public static boolean SoConsoantes ( String analisada, int i ) {
                boolean resposta = true;
                if ( i < analisada.length( ) ){
                        if ( EConsoante( analisada.charAt(i)) == false ){
                                resposta = false;
                        }else{
                                resposta = SoConsoantes( analisada, i + 1);
                        }
                }
                return(resposta);
        }

	//Funcao para identificar digitos em uma String
        public static boolean EDigito ( char analisada ) {
                boolean resposta = false;
                if ( analisada >= '0' && analisada <= '9' ){
                        resposta = true;
                }
        	return(resposta);
        }

	//Funcao para identificar pontos e virgulas em uma String
        public static boolean EVirgula ( char analisada ) {
                boolean resposta = false;
                if ( analisada == ',' || analisada == '.' ){
                        resposta = true;
                }
                return(resposta);
        }


	//Metodo para inicializar um metodo recursivo que testa se a String eh um inteiro
	public static boolean Inteiro ( String analisada ){
		return Inteiro ( analisada, 0 );
	}

	//Metodo recursivo para testar se a String corresponde a um inteiro
	public static boolean Inteiro ( String analisada, int i ) {
		boolean resposta = true;
		if ( i < analisada.length( ) ){
			if ( EDigito(analisada.charAt(i)) == false ) {
				resposta = false;
			}else{
				resposta = Inteiro(analisada, i + 1);
			}  
		}
		return(resposta);
	}
	
	//Metodo para inicializar metodo recursivo que conta quantas virgulas ou pontos existem na String
	public static int QVirgula ( String analisada ){
		return QVirgula( analisada, 0 );
	}

	//Metodo recursivo para contar quantas virgulas ou pontos existem na String
	public static int QVirgula ( String analisada, int i ){
		int quantidade = 0;
		if ( i < analisada.length( ) ){
			if ( EVirgula(analisada.charAt(i)) == false ){
				quantidade = QVirgula( analisada, i + 1);
			}else if ( EVirgula(analisada.charAt(i)) ){
				quantidade = QVirgula( analisada, i + 1) + 1;
			} 
		}
		return ( quantidade );
	}
	//Metodo para inicializar um metodo recursivo que testa se a String corresponde a um numero real
	public static boolean Real ( String analisada ){
		return Real ( analisada, 0 ); 
	}

	//Metodo recursivo para testar se a String corresponde a um numero real
	public static boolean Real ( String analisada, int i ) {
                boolean resposta = true;
		int quantidade;
                if ( i < analisada.length( ) ){
			if ( EDigito(analisada.charAt(i)) == false && EVirgula(analisada.charAt(i)) == false ){
				resposta = false;
			}else if ( EDigito(analisada.charAt(i)) ){
                        	resposta = Real ( analisada, i + 1 );
			}else if ( EVirgula(analisada.charAt(i)) ){
				quantidade = QVirgula(analisada);	
				if ( quantidade <= 1 ){
                                        resposta = Real( analisada, i + 1 );
                                }else if ( quantidade > 1 ){
					resposta = false;
                               	}
			}
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
