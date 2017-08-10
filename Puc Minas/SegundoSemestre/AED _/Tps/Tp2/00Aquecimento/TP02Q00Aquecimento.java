/**
  *Aluna: Giovanna Avila Riqueti   Matricula:553285
  *Tp2
  *Questao 00
  *
  */
class TP02Q00Aquecimento{
	
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

	//Metodo para inicializar metodo recursivo que conta a quantidade de letras maiusculas
	public static int ContarMaiusculas ( String analisada ){
		return ContarMaiusculas ( analisada, 0 );
	}

	//Metodo recursivo para contar as letras maiusculas dentro de uma String
	public static int ContarMaiusculas ( String analisada, int i ){
		int quantidade = 0;
		if ( i < analisada.length( ) ){
			if ( EMaiuscula(analisada.charAt(i)) == false ){
				quantidade = ContarMaiusculas ( analisada, i + 1);
			}else{
				quantidade = ContarMaiusculas ( analisada, i + 1) + 1;
			}
		}
		return (quantidade);
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
		int Maiusculas;
		linha = MyIO.readLine( );
		while ( igual(linha,"FIM") == false ) {
			Maiusculas = ContarMaiusculas( linha );
			MyIO.println( Maiusculas );
			linha = MyIO.readLine( );
		}
	}

}
