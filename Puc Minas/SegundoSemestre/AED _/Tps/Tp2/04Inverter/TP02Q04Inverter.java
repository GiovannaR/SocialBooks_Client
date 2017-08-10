/**  
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 04
  *
  */
class TP02Q04Inverter {

	//Metodo para iniciar o metodo recursivo para inverter uma String
	public static String Contrario ( String original ){
		return Contrario ( original, original.length( ) - 1 );
	}


	//Metodo recursivo para inverter uma String
	public static String Contrario ( String original, int i ){
        	String invertida = "";
		if ( i >= 0 ){
			invertida = original.charAt(i) + Contrario(original, i - 1);
		} 
		return( invertida );
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
		String invertida;
	
		linha = MyIO.readLine( );
		while (igual(linha,"FIM") == false){
			invertida = Contrario(linha);
			MyIO.println(invertida);
			linha = MyIO.readLine( );
		}
	}
}
