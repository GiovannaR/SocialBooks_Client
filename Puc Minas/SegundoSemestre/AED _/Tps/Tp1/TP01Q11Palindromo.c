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
		do{
			quantidade ++;
			i++;
		}while ( teste[i] != '\0' );
		return quantidade;
	}

	int Palindromo ( char teste [ ] ){
		int resp = 1;
		int i = 0;
		int tamanho = tamanhodaString ( teste );
		int ultimo = tamanho - 1;
		while ( i < (double)tamanho/2 ){
			if ( teste[i] != teste[ultimo] ){
				resp = 0;
			}
			i++;
			ultimo--;
  		}	
		return resp;
	}

	char *Trim ( char suja [ ] ){
		int i = tamanhodaString ( suja )-1; 
		if(i>0 && suja[i] == '\n' ){
			suja[i] = '\0';
		}
		return suja;
	} 


	int Iguais ( char a1 [ ], char a2 [ ] ){
		int i = 0;
		int resp = 1;
		if ( tamanhodaString(a1) != tamanhodaString(a2) ){
			resp = 0;	
		}else{
			if ( a1[i] != a2[i] ){
				resp = 0; 
			}
		}
		return resp;
	}

	int main ( ){
		char Entrada [1000];
		char Fim [ ] = "FIM";
		fgets(Entrada, 1000, stdin);
		while ( Iguais( Trim(Entrada), Fim) == 0 ){
			if ( Palindromo (Entrada) == 1){
				printf( "SIM\n" );
			}else{
				printf( "NAO\n" );
			}
			fgets (Entrada, 1000, stdin);
		}
	}
 

