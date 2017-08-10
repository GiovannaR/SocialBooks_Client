/**  
  *Aluna: Giovanna Avila Riqueti   Matricula: 553285
  *Tp02
  *Questao 06
  *
  */

class TP02Q06Equals {

	//Metodo para inicializar um metodo recursivo para trocar as maiusculas por minusculas em uma String
	public static String SemMaiusculas ( String suja ){
		return SemMaiusculas ( suja, 0 );
	}

	//Metodo recursivo para trocar as letras maiusculas por minusculas em uma String
	public static String SemMaiusculas ( String suja, int i ){
		String limpa = "";
		char SoMinuscula;
		boolean resposta = false;
		if ( i < suja.length( ) ){
			if( suja.charAt(i) >= 'A' && suja.charAt(i) <= 'Z' ){
				SoMinuscula =(char)((int)suja.charAt(i) + 32);
				limpa = SoMinuscula + SemMaiusculas (suja, i + 1);
			}else{
				limpa = suja.charAt(i) + SemMaiusculas (suja, i + 1);
			} 
		}
	return( limpa );
	}


	//metodod para inicializar metodo recursivo para analisar se duas Strings sao iguais sem levar em consideracao maiuculas e minusculas
	public static boolean SemDistincao ( String comparada, String gemea ){
		return SemDistincao ( comparada, gemea, 0 );
	}

	//Metodo recursivo para analisar se duas Strings sao iguais sem levar em consideracao mauisuculas e minusculas
	public static boolean SemDistincao ( String comparada, String gemea, int i ){
		boolean resposta = true;
		String Nova;
		String Oficial;

		if ( i < comparada.length( ) && i < gemea.length( ) ){
			if ( comparada.length( ) != gemea.length( ) ){
				resposta = false;
			}else{
				Nova = SemMaiusculas ( gemea );
				Oficial = SemMaiusculas ( comparada );
				if ( Nova.charAt(i) != Oficial.charAt(i) ){
					resposta = false;
				}else{
					resposta = SemDistincao ( comparada, gemea, i + 1 );
				}
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
		String[ ] analisada = new String[1000];	
		int i = 0;
 		int posicao = 0;
		int proximo = 1;
      		do {
         		analisada[posicao] = MyIO.readLine( );
      		} while (igual(analisada[posicao++],"FIM") == false);
      		posicao --; //Para desconsiderar o fim

		if ( posicao % 2 == 0  ){ //Se o numero de palavras for par, nao sera necessario comparar a ultima com ela mesma  
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
			}
		}else if ( posicao % 2 != 0 ){ //Se for impar, a ultima deve ser testada com ela mesma
			i = 0; //Igual a zero para possibilitar nova repeticao
			proximo = 1;
			while ( i < (posicao - 2) ){
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
                                MyIO.println( );
                                i += 2;
				proximo += 2;
                        }
			if (igual(analisada[i++],analisada[i++])){
				MyIO.print( "SIM" );
			}else{
				MyIO.print( "NAO" );
			} 		
		}
	}
}
