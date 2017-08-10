class TP01Q02CiframentodeCesar{

/**
  *Funcao para cifrar uma mensagem de acordo com o Ciframento de Cesar
  *@param teste - mensagem a ser cifrada
  *
  */
	public static String Cifrar ( String teste ) {
		int tamanho = teste.length( );
		int TabelaASCII = 0; //Variavel para armazenar tres posicoes a frente de um caractere na tabela ASCII 
		int i = 0;
		String Nova = "";
		char Oficial;
	        while (i < tamanho){			
			
			TabelaASCII = (int)teste.charAt(i) + 3;
       	                Oficial = (char)TabelaASCII;
                        Nova = Nova + Oficial;
	
			i++;
		}
	return (Nova);
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
		String Nova;

		linha = MyIO.readLine( );
                Nova = Cifrar(linha);
                MyIO.println(Nova);
		while(igual(linha,"FIM") == false ){
			linha = MyIO.readLine( );
			Nova = Cifrar(linha);
			MyIO.println(Nova);
		}
	}	
}
