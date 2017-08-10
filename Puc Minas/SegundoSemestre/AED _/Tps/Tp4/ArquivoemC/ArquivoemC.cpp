/**
*Programa em C que escreve em um arquivo de modo padrao e le de tras para frente
*Autor: Giovanna Avila Riqueti
*Versao: 2 01/10/2016 
*/ 

#include <stdio.h>
#include <stdlib.h>

/* Metodo para ler de tras para frente no arquivo */
	void Leitura ( int posicao, int fim){
		FILE *p = fopen ("arquivo.txt", "r");
		int cordenada = 0;
		int ponteiro = -1;
		char parte1 [1000];

			if ( posicao > 0 && posicao < fim ){
				 while ( cordenada < posicao ){
	        	                char codigo = fgetc(p);
        	        	        char character = (char)codigo;
                          		if ( character == '\n' ){
                                  		ponteiro = ftell(p);
                          		}
                          		cordenada++;
                		}
				if ( ponteiro > 0 ){
					fseek(p, ponteiro, SEEK_SET);
					printf("%s",fgets(parte1,1000, p));
					fclose(p);
					Leitura ( ponteiro - 1, fim );
				}else{
					fseek(p, 0, SEEK_SET);
                               		printf("%s",fgets(parte1, 1000, p));
			       		fclose(p);
				}
			}
	}

/* Metodo para escrever na ordem padrao do arquivo */
	int escrever (int fim){
		FILE *a = fopen("arquivo.txt", "w");
		int i = 0;
		char parte1 [1000];
		char parte2 [1000];
		int ponteiro;	
		if ( a == NULL ){
			printf("Erro ao abrir o arquivo!");
			ponteiro = 0;
		}else{
			while ( i < fim ){
				float f = atof(fgets(parte1, 1000 , stdin));
				sprintf(parte2,"%g\n",f);
				fputs(parte2, a);
				i ++;
			}	
			ponteiro = ftell(a);
			fclose(a);
		}
		return ponteiro;
	}

	int main ( ){
		char inicio [1000];
		int quantidade = atoi(fgets( inicio, 1000, stdin ));
		int termino = escrever (quantidade);
		Leitura( termino - 1, termino );
	}










