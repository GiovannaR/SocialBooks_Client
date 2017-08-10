class TP01Q01Palindromo {

/**
  *Funcao para identificar se a String eh um palindromo
  *@param teste - String a ser testada
  *
  */	
	public static boolean Palindromo ( String teste ) {
		boolean resposta = true;
		int tamanho = teste.length( );  
		int i = 0;   
		int ultimo = tamanho - 1;
		int metade = tamanho/2;
		while ( i < (double)metade ){
			if ( teste.charAt(i) != teste.charAt(ultimo)){
				resposta = false;
			}
			i++;
			ultimo--;
  		}
		return (resposta);
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
		while(igual(linha,"FIM") == false){
			if (Palindromo(linha)){
                                MyIO.println("SIM");
                        }
                        else{
                                MyIO.println("NAO");
                        }
			linha = MyIO.readLine( );
		}
	}

}
