class TP01Q04Inverter{

/**
  *Funcao para inverter uma String
  *@param original - String a ser invertida
  *
  */
	public static String Contrario ( String original ){
        	String invertida = "";
		int tamanho = original.length( );
		int ultimo = tamanho - 1;
		int metade = tamanho/2;
		while ( ultimo >= 0 ){
			invertida = invertida + original.charAt(ultimo);
			ultimo--; 
		} 
	return( invertida );
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
		String invertida;
	
		linha = MyIO.readLine( );
		while (igual(linha,"FIM") == false){
			invertida = Contrario(linha);
			MyIO.println(invertida);
			linha = MyIO.readLine( );
		}
	}
}
