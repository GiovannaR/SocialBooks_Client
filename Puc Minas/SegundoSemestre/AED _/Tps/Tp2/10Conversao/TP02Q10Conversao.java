/** 
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 10
  *
  */
class TP02Q10Conversao {

	//Metodo para testar se o caracter eh uma letra
	public static boolean ELetra ( char analisada ) {
                boolean resposta = false;
                if ( (analisada >= 'a' && analisada <= 'z') || (analisada >= 'A' && analisada <= 'Z') )
                {
                        resposta = true;
                }
        	return(resposta);
        }

	//Teste se o caractere eh uma letra maiuscula
	public static boolean EMaiuscula ( char analisada ) {
		boolean resposta = false;
		if ( ELetra(analisada) ){
			if ( analisada >= 'A' && analisada <= 'Z' ){
				resposta = true;
			}
		}
		return(resposta);
	}

	//Funcao para testar se o caractere corresponde a uma letra minuscula
	public static boolean EMinuscula ( char analisada ) {
        	boolean resposta = false;
        	if ( ELetra(analisada) ){
        		if ( analisada >= 'a' && analisada <= 'z' ){
            			resposta = true;
         		}
      		}
      		return(resposta);
  	}

	//Metodo para inicializar um  metodo recursivo que confere se um determinado caractere eh uma letra especial minuscula
	public static boolean ProcurarMI ( char procurado ){
		return ProcurarMI ( procurado, 0 );
	}

	//Metodo recursivo para ver se um determinado caractere eh uma letra minuscula especial, ou seja, eh uma letra, mas nao entra no conjunto de letras do programa
	public static boolean ProcurarMI ( char procurado, int i ) {
                boolean resposta = false;
                char [ ] EXMinusculas = {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø','ù','ú','û','ü','ý'};
                if ( i < 29 ){
                        if ( EXMinusculas[i] != procurado ){
                                resposta = ProcurarMI( procurado, i + 1);
                        }else{
				resposta = true;
			}
		}
                return(resposta);
        }

	//Metodo para inicializar um metodo recursivo para ver se um determinado caracter eh uma letra maiuscula especial
	public static boolean ProcurarMA ( char procurado ){
		return ProcurarMA ( procurado, 0 );
	}

	//Metodo recursivo para ver se um determinado caractere eh uma letra maiuscula especial, ou seja, eh uma letra, mas nao entra no conjunto de letras do programa
	public static boolean ProcurarMA ( char procurado, int i ) {
		boolean resposta = false;
		char [ ] EXMaiusculas = {'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø','Ù','Ú','Û','Ü','Ý'};
		if ( i < 29 ){
                        if ( procurado != EXMaiusculas[i] ){
                                resposta = ProcurarMA( procurado, i + 1 );
                        }else{
				resposta = true;
			}
		}
		return(resposta);
	}

	//Metodo para inicializar metodo recursivo que muda os caracteres especiais de minuscula para maiuscula
	public static char ExcecoesparaMinusculas ( char procurado ){
		return ExcecoesparaMinusculas ( procurado, 0 );
	}

	//Metodo recursivo para mudar os caracteres especiais de maiuscula para minuscula
	public static char ExcecoesparaMinusculas ( char procurado, int i ) {
		char aux = '0';
		char [ ] EXMaiusculas = {'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø','Ù','Ú','Û','Ü','Ý'};
		char [ ] EXMinusculas = {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø','ù','ú','û','ü','ý'};
		if ( i < 29 ){
			if ( procurado != EXMaiusculas[i] ){
				aux = ExcecoesparaMinusculas ( procurado, i + 1);
			}else{
				aux = EXMinusculas[i];
			}
		}
		return(aux);
	}

	//Metodo para inicializar metodo recursivo que muda as letras especiais minusculas para maiusculas
	public static char ExcecoesparaMaiusculas ( char procurado ){
		return ExcecoesparaMaiusculas ( procurado, 0 );
	}

	//Metodo recursivo para mudar as letras especiais minusculas para maiusculas
	public static char ExcecoesparaMaiusculas ( char procurado, int i ) {
		char aux = '0';
		char [ ] EXMaiusculas = {'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø','Ù','Ú','Û','Ü','Ý'};
		char [ ] EXMinusculas = {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø','ù','ú','û','ü','ý'};
      		if ( i < 29 ){
         		if ( procurado != EXMinusculas[i] ){
            			aux = ExcecoesparaMaiusculas( procurado , i + 1 );
         		}else{
				aux = EXMaiusculas[i];
			}
     		 }
      		return(aux);
   	}
	
	//Metodo para inicializar metodo recursivo que retorna uma String so com letras maiusculas
	public static String SoMaiusculas ( String analisada ){
		return SoMaiusculas ( analisada, 0 );
	}

	//Metodo recursivo para retornar uma String so com letras maiusculas
	public static String SoMaiusculas ( String analisada, int i ) {
		String Nova = "";
		char Oficial;
		char Excecao;
		if ( i < analisada.length( ) ) {
			if ( ProcurarMI( analisada.charAt(i) ) ){    		
				Excecao = ExcecoesparaMaiusculas ( analisada.charAt(i) );
                		Nova = Excecao + SoMaiusculas( analisada, i + 1 );
			}else if( EMinuscula(analisada.charAt(i)) ){
            			Oficial =(char)((int)analisada.charAt(i) - 32);
				Nova = Oficial + SoMaiusculas( analisada, i + 1 );	
            		}else{
                		Nova = analisada.charAt(i) + SoMaiusculas( analisada, i + 1 );
            		}
		}
		return(Nova);
	}

	//Metodo para inicializar metodo recursivo que retorna uma String com so letras minusculas
	public static String SoMinusculas ( String analisada ){
		return SoMinusculas ( analisada, 0 );
	}	

	//Metodo recursivo para retornar uma String so com letras minusculas
	public static String SoMinusculas ( String analisada, int i ) {
                String Nova = "";
                char Oficial;
                char Excecao;
                if ( i < analisada.length( ) ) {
                        if ( ProcurarMA( analisada.charAt(i) ) ){
                                Excecao = ExcecoesparaMinusculas ( analisada.charAt(i) );
                                Nova = Excecao + SoMinusculas( analisada, i + 1 );
                        }else if( EMaiuscula(analisada.charAt(i)) ){
                                Oficial =(char)((int)analisada.charAt(i) + 32);
                                Nova = Oficial +  SoMinusculas( analisada, i + 1 );
                        }else{
                                Nova = analisada.charAt(i) + SoMinusculas( analisada, i + 1 );
                        }
                }
                return(Nova);
        }

	//Metodo para inicializar metodo recursivo que retorna uma String sem espacos
	public static String Remover ( String analisada, char removido ){
		return Remover ( analisada, removido, 0 );
	}

	//Metodo recursivo que retorna uma String sem espacos
	public static String Remover ( String analisada, char removido, int i ){
		String Nova = "";
		if ( i < analisada.length( ) ){
			if( analisada.charAt(i) != removido ){
				Nova = analisada.charAt(i) + Remover ( analisada, removido, i + 1);
			}else{
				Nova = Remover ( analisada, removido, i + 1);
			}
		}
		return(Nova);
	}

//Metodo ṕara inicializar metodo recursivo que retorna uma Sting sem espacos
        public static String SemEspacos ( String analisada ){
                return SemEspacos ( analisada, 0 );
        }

        //Metodo recursivo para retornar uma String sem espacos vazios
        public static String SemEspacos ( String analisada, int i ){
                String Nova = "";
                if ( i < analisada.length( ) ) {
                        if ( analisada.charAt(i) != ' ' ){
                                Nova = analisada.charAt(i) + SemEspacos( analisada, i + 1);
                        }else{
                                Nova = SemEspacos ( analisada, i + 1);
                        }
                }
                return(Nova);
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
		String Maiusculas;
		String Minusculas;
		String SemEspacos;
		String Removido;

		linha = MyIO.readLine( );
		while ( igual(linha,"FIM") == false ){
			Maiusculas = SoMaiusculas(linha);
			MyIO.println(Maiusculas);
			Minusculas = SoMinusculas(linha);
			MyIO.println(Minusculas);
			SemEspacos = SemEspacos(linha);
			MyIO.println(SemEspacos);
			Removido = Remover(linha,linha.charAt(0));
			MyIO.println(Removido);
			linha = MyIO.readLine( );
      		}

	}

}
