class TP01Q10Conversao {
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
  *Funcao para identificar letras maiusculas
  *@param analisada - caractere a ser analisado
  *
  */
	public static boolean EMaiuscula ( char analisada ) {
		boolean resposta = false;
		if ( ELetra(analisada) ){
			if ( analisada >= 'A' && analisada <= 'Z' ){
				resposta = true;
			}
		}
		return(resposta);
	}
   
   /**
   *Funcao para identificar letras minusculas
   *@param analisada - caractere a ser analisado
   *
   */
   public static boolean EMinuscula ( char analisada ) {
      boolean resposta = false;
      if ( ELetra(analisada) ){
         if ( analisada >= 'a' && analisada <= 'z' ){
            resposta = true;
         }
      }
      return(resposta);
   }
/**
  *Funcao para procurar um caractere especial que eh uma letra minuscula
  *@param procurado - caractere a ser procurado
  *
  */ 
	public static boolean ProcurarMI ( char procurado ) {
                boolean resposta = false;
                char [ ] EXMinusculas = {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø','ù','ú','û','ü','ý'};
                for ( int i = 0; i < 29; i++ ){
                        if ( EXMinusculas[i] == procurado ){
                                resposta = true;
                        }
		}
                return(resposta);
        }

/**
  *Funcao para procurar um caractere especial que eh uma letra maiuscula
  *@param procurado - caractere a ser procurado
  *
  */ 
	public static boolean ProcurarMA ( char procurado ) {
		boolean resposta = false;
		char [ ] EXMaiusculas = {'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø','Ù','Ú','Û','Ü','Ý'};
		for ( int i = 0; i < 29; i++ ){
                        if ( procurado == EXMaiusculas[i] ){
                                resposta = true;
                        }
		}
		return(resposta);
	}

   /**
   *Funcao para mudar as excecoes, como letras com acento, para maiusculas
   *@param procurado - char a ser mudado para maiuscula
   *
   */
	public static char ExcecoesparaMinusculas ( char procurado ) {
		char aux = '0';
		char [ ] EXMaiusculas = {'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø','Ù','Ú','Û','Ü','Ý'};
		char [ ] EXMinusculas = {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø','ù','ú','û','ü','ý'};
		for ( int i = 0; i < 29; i++ ){
			if ( procurado == EXMaiusculas[i] ){
				aux = EXMinusculas[i];
			}
		}
		return(aux);
	}
   
   /**
   *Funcao para mudar as excecoes, como letras com acento, para minusculas
   *@param procurado - char a ser mudado para minuscula
   *
   */
   public static char ExcecoesparaMaiusculas ( char procurado ) {
	char aux = '0';
	char [ ] EXMaiusculas = {'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø','Ù','Ú','Û','Ü','Ý'};
	char [ ] EXMinusculas = {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø','ù','ú','û','ü','ý'};
      for ( int i = 0; i < 29; i++ ){
         if ( procurado == EXMinusculas[i] ){
            aux = EXMaiusculas[i];
         }
      }
      return(aux);
   }
   
   /**
   *Funcao para retornar String so com letras maiusculas
   *@param analisada - String a ser analisada
   *
   */
	public static String SoMaiusculas ( String analisada ) {
		int i = 0;
		int tamanho = analisada.length( );
		int TabelaASCII;
		String Nova = "";
		char Oficial;
		char Excecao;
		while ( i < tamanho ) {
			if ( ProcurarMI (analisada.charAt(i)) ){
            	Excecao = ExcecoesparaMaiusculas ( analisada.charAt(i) );
                Nova += Excecao;
			}else if( EMinuscula(analisada.charAt(i)) ){
            	TabelaASCII = (int)analisada.charAt(i) - 32;
            	Oficial = (char)TabelaASCII;
				Nova += Oficial;	
            }else{
                Nova += analisada.charAt(i);
            }
         		i++;	
		}
		return(Nova);
	}
   
   /**
   *Funcao para retornar String so com letras minusculas
   *@param analisada - String a ser analisada
   *
   */
	public static String SoMinusculas ( String analisada ) {
		int i = 0;
		int tamanho = analisada.length( );
		int TabelaASCII;
        	String Nova = "";
      		char Oficial;
		char Excecao;

		while ( i < tamanho ) {
			if ( ProcurarMA (analisada.charAt(i)) ){
            			Excecao = ExcecoesparaMinusculas ( analisada.charAt(i) );
            			Nova += Excecao;
		}else if( EMaiuscula(analisada.charAt(i)) ){
        		TabelaASCII = (int)analisada.charAt(i) + 32;
        		Oficial = (char)TabelaASCII;
        		Nova += Oficial;
		}else{
			Nova += analisada.charAt(i);
		}
         	i++;
      }
      return(Nova);
   }

   /**
   *Funcao para tirar os espacos vazios da String
   *@param analisada - String a ter os espacos vazios tirados
   *
   */
	public static String SemEspacos ( String analisada ){
		int tamanho = analisada.length( );
		int i = 0;
		String Nova = "";
		while ( i < tamanho ) {
			if ( analisada.charAt(i) != ' ' ){
				Nova += analisada.charAt(i);
			}
			i++;
		}
		return(Nova);
	}

   /**
   *Funcao para remover um caracter aparece na String
   *@param analidade - String a ser analisada
   *@param removido - caractere a ser removido da String
   *
   */
	public static String Remover ( String analisada, char removido ){
		int tamanho = analisada.length( );
		int quantidade = 0;
		int i = 0;
		String Nova = "";
		while ( i < tamanho ){
			if( analisada.charAt(i) != removido ){
				Nova += analisada.charAt(i);
			}
			i++;
		}
		return(Nova);
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
