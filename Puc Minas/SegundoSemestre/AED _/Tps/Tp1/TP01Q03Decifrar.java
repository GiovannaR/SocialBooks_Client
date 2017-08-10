class TP01Q03Decifrar{

/**
  *Funcao para decifrar a mensagem de Cesar (trocar a letra por outra tres posicoes atras
  *@param teste - String a ser decodificada
  *
  */
	public static String Decodificar ( String teste ) {
		int tamanho = teste.length( );
		int TabelaASCII; //Variavel para armazenar valor inteiro de um caractere
		char Oficial;
		String Nova = "";

		for( int i = 0; i < tamanho; i++ ){
			if ( teste.charAt(i) == 'A' || teste.charAt(i) == 'a' ){
				TabelaASCII = (int)teste.charAt(i) + 25;
				Oficial = (char)TabelaASCII;
				Nova = Nova + Oficial;
			}else{
				TabelaASCII = (int)teste.charAt(i) - 3;
                                Oficial = (char)TabelaASCII;
                                Nova = Nova + Oficial;

			}
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
		String Oficial;

		linha = MyIO.readLine( );
                Oficial =  Decodificar(linha);
                MyIO.println(Oficial);
		while(igual(linha,"FIM") == false) {
			linha = MyIO.readLine( );
			Oficial = Decodificar(linha);
			MyIO.println(Oficial);
		}
	}
}
