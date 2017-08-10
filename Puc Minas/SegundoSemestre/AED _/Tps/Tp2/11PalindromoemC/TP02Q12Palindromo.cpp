/**
*Giovanna Avila Riqueti
*24/09/2016
*Fazer um programa que identifica se uma palavra e' um palindromo
*/

#include <stdio.h>
#include <stdlib.h>
	int tamanhodaString ( char *teste ){
		int quantidade = 0;
		int i = 0;
		while ( teste[i] != '\0' ){
			quantidade ++;
			i++;
		}
		return quantidade;
	}

	int EPalindromo ( char teste [ ], int i ){
		int resp;
		int ultimo = tamanhodaString(teste) - 1;
		if ( i < (double)(tamanhodaString(teste))/2 ){
			if ( teste[i] != teste[(tamanhodaString(teste) - 1) - i] ){
				resp = 0;
			}else{
				resp = EPalindromo( teste, i + 1 );
			}
  		}else if ( i >= (double)(tamanhodaString(teste))/2 ){
			resp = 1;
		}
		return resp;
	}

	int IsPalindromo ( char teste [ ] ){
		return EPalindromo( teste, 0 );

	}

	char *Trim ( char suja [ ] ){
		int i = tamanhodaString ( suja )-1; 
		if(i>0 && suja[i] == '\n' ){
			suja[i] = '\0';
		}
		return suja;
	} 


	int EIgual ( char a1 [ ], char a2 [ ], int i ){
		int resp;
		if ( i < tamanhodaString(a1) ){
			if ( a1[i] != a2[i] ){
				resp = 0; 
			}else{
				resp = EIgual( a1, a2, i + 1 );
			}
		}else{
			resp = 1;
			//Quer dizer que todas as comparacoes ja' foram feitas e nao deu nenhum erro
		}
		return resp;
	}

	int IsIguais ( char a1 [ ], char a2 [ ] ){
		int resp;
		if ( tamanhodaString(a1) != tamanhodaString(a2) ){
                        resp = 0;
                }else{
			resp = EIgual( a1, a2, 0 );
		}
		return resp;
	}

	int main ( ){
		char Entrada [1000];
		char Fim [ ] = "FIM";
		fgets(Entrada, 1000, stdin);
		while ( IsIguais( Trim(Entrada), Fim) == 0 ){
			if ( IsPalindromo (Entrada) == 1){
				printf( "SIM\n" );
			}else{
				printf( "NAO\n" );
			}
			fgets (Entrada, 1000, stdin);
		}
	}
 


