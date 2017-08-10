/**  
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 05
  *
  */

import java.util.Random;
class TP02Q05AlteracaoBooleana {

	//Metodo para gerar uma char de forma aleatoria
	public static char Gerador ( Random gerador ){
		char s = (char)('a' + Math.abs(gerador.nextInt( ))  % 26 );
		return s;
	} 
	
	//Metodo para iniciar o metodo recursivo que troca uma letra aleatoria da String por outra letra aleatoria
	public static String Mudar ( String teste, char substituida, char substituta ){
		return Mudar ( teste, substituida, substituta, 0 );
	}

	//Metodo recursivo para trocar uma letra aleatoria da String por outra aleatoria
	public static String Mudar ( String teste, char substituida, char substituta, int i ) {
		String Nova = "";

        if ( i < teste.length( ) ){
			if( teste.charAt(i) == substituida ){
				Nova = substituta + Mudar( teste, substituida, substituta, i + 1);
			}else{
				Nova = teste.charAt(i) + Mudar( teste, substituida, substituta, i + 1);
			}
		}
		return( Nova );
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

	public static void main ( String [ ] args ) {

		Random gerador = new Random ( );
		gerador.setSeed(4);	
		String linha;
		String Nova;

		linha = MyIO.readLine( );
		while ( igual(linha,"FIM") == false ){
			char substituida = Gerador ( gerador );
			char substituta = Gerador ( gerador );
			Nova = Mudar(linha,substituida, substituta);
			MyIO.println(Nova);
			linha = MyIO.readLine( );
		}
	}

}
