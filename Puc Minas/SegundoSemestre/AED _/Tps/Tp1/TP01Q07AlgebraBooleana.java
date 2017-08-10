class TP01Q07AlgebraBooleana{

	//Metodo para construir um array de caracteres com os valores das variaveis
	public static char [ ] QuantasEntradas ( String analisada ){
		String deChar = String.valueOf(analisada.charAt(0));
		int Entrada = Integer.parseInt(deChar);
		int i = 1;
		int a = 0;
		char [ ] binario = new char [Entrada];
		while( a < Entrada ){
			binario[a] = analisada.charAt(i);
			i++;
			a++;
		}
		return(binario);
	}

	//Metodo para substituir as variavaies por seus respectivos valores
	public static String SubstituirVariaveis ( String analisada, char [ ] numeros  ){
		String resp = "";
		int tamanho = analisada.length( );
		for ( int i = 0; i < tamanho; i++ ){
			if ( analisada.charAt(i) == 'A' ){
				resp += numeros[0];
			}else if ( analisada.charAt(i) == 'B' ){
				resp += numeros[1];
			}else if ( analisada.charAt(i) == 'C' ){
				resp += numeros[2];
			}else{
				resp += analisada.charAt(i);
			}
		}
		return(resp);
	}

 	//Funcao para tirar os espacos vazios da String
        public static String SemEspacos ( String analisada ){
                int tamanho = analisada.length( );
                int i = 0;
                String Nova = "";
                while ( i < tamanho ) {
                        if ( analisada.charAt(i) != ' ' ){
                                Nova += analisada.charAt(i);
                        }
                        i++;
                }
                return(Nova);
        }

	//Funcao para separar a parte com os valores das variaveis da parte das expressoes
	public static String Separar ( String analisada ){
		String Nova = "";
		String deChar = String.valueOf(analisada.charAt(0));
                int Entrada = Integer.parseInt(deChar);
		int i = Entrada + 1;
		while ( i < analisada.length( ) ){
			Nova += analisada.charAt(i);
			i ++;
		}
		return(Nova);
	}
	
	//Funcao para retornar o valor da expressao booleana
	public static String Processar ( String analisada ){
		int i = 0;
		//Alem de o contador ser menor do que o tamanho da String, o programa tambem deve continuar apenar se o tamanho da String nao corresponder a um, pois o objetivo do programa e retornar uma String contendo apenas 0 ou 1
		while ( i < analisada.length( ) && analisada.length( ) != 1 ){
			if (  analisada.charAt(i) == 'n' ){
				if ( analisada.charAt(i+4) == '0' || analisada.charAt(i+4) == '1' ){
					//Nessa parte, o programa ira substituir o NOT(0 ou 1), por apenas 0 ou 1 e retornara a String mudada
					analisada = NOT(analisada, analisada.charAt(i+4), i);
					//A parte de reiniciar o processo eh importante, pois depois da String ter sido mudada, outras expressoes no programa podem ter suas condicoes de execucao atendidas
					i = 0;
				}
			}else if ( analisada.charAt(i) == 'a' ){
				if ( analisada.charAt(i+4) == '0' || analisada.charAt(i+4) == '1' ){
					if ( analisada.charAt(i+6) == '0' || analisada.charAt(i+6) == '1' ){
						analisada = AND(analisada, i);
						i = 0;
					}
				} 
			}else if ( analisada.charAt(i) == 'o' ){
				if ( analisada.charAt(i+3) == '0' || analisada.charAt(i+3) == '1' ){
					if ( analisada.charAt(i+5) == '0' || analisada.charAt(i+5) == '1' ){
						analisada += OR(analisada, i);
						i = 0;
					}
				} 
			}
			i++;
		}
		return(analisada);
	}

	//Funcao que substitui a expressao not(0 ou 1) por 0 ou 1
	public static String NOT ( String analisada, char numero, int i ){
		String Nova = "";
		char Valor = '6'; //Caso der errado, esse numero vai caracterizar o erro
		int f = 0;
		if ( numero == '1' ){
			Valor = '0';
		}else if( numero == '0' ){
			Valor = '1';
		}
		while ( f < analisada.length( ) ){
			if ( f == i ){
				Nova += Valor;
			}
			//Pula a expressao como se ela nao existisse e no lugar dela estivesse o 0 ou o 1
			if ( f < i || f > (i + 5) ){
				Nova += analisada.charAt(f);
			}
			f++;
		}
		return(Nova);
	}

	//Funcao para substituir a expressao and(0 ou 1, 0 ou 1) por 0 ou 1
	public static String AND ( String analisada, int i ){
		String Nova = ""; 
		char Valor = '6'; //Caso der errado, esse numero vai caracterizar o erro
		int f = 0;
		if ( analisada.charAt( i + 4 ) == '0' ){
			Valor = '0';
		}else if ( analisada.charAt( i + 4 ) == '1' ){
			if ( analisada.charAt( i + 6 ) == '0' ){
				Valor = '0';
			}else if ( analisada.charAt( i + 6 ) == '1' ){
				Valor = '1';
			}
		}
		while ( f < analisada.length( ) ){
                       if ( f == i ){
                               Nova += Valor;
                       }
                       if ( f < i || f > (i + 7) ){
                               Nova += analisada.charAt(f);
                       }
                       f++;
                }
                return(Nova);
	}

	//Funcao para substituir a expressao and(0 ou 1, 0 ou 1) por 0 ou 1
	public static String OR ( String analisada, int i ){
		String Nova = "";
		char Valor = '6'; //Caso der errado, esse numero vai caracterizar o erro
		int f = 0;
		if ( analisada.charAt( i + 3 ) == '1' ){
			Valor = '1';
		}else if ( analisada.charAt( i + 3 ) == '0' ){
			if ( analisada.charAt( i + 5 ) == '0' ){
				Valor = '0';
			}else if ( analisada.charAt( i + 5 ) == '1' ){
				Valor = '1';
			}
		}
		while ( f < analisada.length( ) ){
			if ( f == i ){
				analisada += Valor;
			}else if ( f < i || f > (i + 6) ){
				Nova += analisada.charAt(f);
			} 
			f ++;
		}
		return(Nova);
	}
		
	//Funcao para comparar se duas Strings sao iguais
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
		String NoEspace;
		String Separada;
		String substituida;
		String Processada;
		char [ ] entradas;
		linha = MyIO.readLine( );
		while ( igual( linha, "0" ) == false ){
			NoEspace = SemEspacos (linha);
			entradas = QuantasEntradas ( NoEspace );
			Separada = Separar( NoEspace );
			substituida = SubstituirVariaveis ( Separada, entradas );
			Processada = Processar ( substituida );
			MyIO.println( Processada );	
			linha = MyIO.readLine( );
		}
	}

} 
