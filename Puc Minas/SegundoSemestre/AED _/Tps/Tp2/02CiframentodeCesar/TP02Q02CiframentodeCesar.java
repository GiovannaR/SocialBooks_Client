/**
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 02
  *
  */

class TP02Q02CiframentodeCesar {

	//Funcao para iniciar o metodo de ciframento
	public static String Cifrar ( String teste ){
		return Cifrar ( teste, 0 );
	}

	// Funcao para cifrar uma mensagem de acordo com o Ciframento de Cesar
	public static String Cifrar ( String teste, int i ) {  
		String Nova = "";
		char Oficial;
	        if (i < teste.length( )){
			Oficial = (char)((int)teste.charAt(i) + 3);			
			Nova = Oficial + Cifrar( teste, i + 1 ); 
		}
		return (Nova);
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
