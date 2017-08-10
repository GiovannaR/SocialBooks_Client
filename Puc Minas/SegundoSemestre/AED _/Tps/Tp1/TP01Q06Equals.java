class TP01Q06Equals {

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

	public static String SemMaiusculas ( String suja ){
		String limpa = "";
		char SoMinuscula;
		boolean resposta = false;
		int TabelaASCII;
		int tamanho = suja.length( );
		int i = 0;
		while ( i < tamanho ){
			if( suja.charAt(i) >= 'A' && suja.charAt(i) <= 'Z' ){
				TabelaASCII = (int)suja.charAt(i) + 32;
				SoMinuscula = (char)TabelaASCII;
				limpa += SoMinuscula;
			}else{
				limpa += suja.charAt(i);
			} 
			i++;
		}
	return( limpa );
	}

	public static boolean SemDistincao ( String comparada, String gemea ){
		boolean resposta = true;

	       //Strings que irao receber as Strings do argumento do metodo sem as letras maiusculas
		String Nova;
		String Oficial;

		int tamanho = comparada.length( );
		if ( tamanho != gemea.length( ) ){
			resposta = false;
		}else{
			Nova = SemMaiusculas ( gemea );
			Oficial = SemMaiusculas ( comparada );
			for( int i = 0; i < tamanho; i++ ){
					resposta = resposta && ( Nova.charAt(i) == Oficial.charAt(i) );
			}  	
		}
	return(resposta);
	}
	
	public static void main ( String [ ] args ){
		String[ ] analisada = new String[1000];
		
		int i = 0;
 		int posicao = 0;
		int proximo = 1;

      		do {
         		analisada[posicao] = MyIO.readLine( );
      		} while (igual(analisada[posicao++],"FIM") == false);
      		posicao --; //Para desconsiderar o fim
 
		while ( i < (posicao - 1)){
		        if ( igual(analisada[i],analisada[proximo]) ){
				MyIO.print( "SIM" );
			}else{
				MyIO.print( "NAO" );
			}	
			if( SemDistincao(analisada[i],analisada[proximo]) ){
				MyIO.println( " SIM" );
			}else{
				MyIO.println( " NAO" );
			}
			i += 2;
			proximo += 2;
			if ( i == (posicao - 1) ){
				if (igual(analisada[i++],analisada[i++])){
                	                MyIO.print( "SIM" );
  			        }else{
                               		MyIO.print( "NAO" );
                       		}

			}
		}
	}
}
