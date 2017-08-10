/**
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 01
  *
  */

class TP02Q01Palindromo {

      //Metodo para inicializar outro metodo recursivo  
	public static boolean EPalindromo ( String s ){
		return EPalindromo(s,0);
	}

	//Metodo recursivo para percorrer uma String e falar se ela corresponde a um Palindromo
	public static boolean EPalindromo ( String analisada, int i ){
		boolean resposta = true;
		if ( i < (double)(analisada.length( )/2) ){
			if ( analisada.charAt(i) != analisada.charAt((analisada.length( ) - 1) - i) ){
				resposta = false;
			}else{
				resposta = EPalindromo ( analisada, i + 1 );
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
		while(igual(linha,"FIM") == false){
			if (EPalindromo(linha)){
                                MyIO.println("SIM");
                        }
                        else{
                                MyIO.println("NAO");
                        }
			linha = MyIO.readLine( );
		}
	}

}
