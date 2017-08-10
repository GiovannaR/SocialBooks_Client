#include <stdio.h>
#include <omp.h>
#include <time.h>
#include <stdlib.h>


struct Compare { 
	int val; 
	int index; 
};

void inicializador(int vetor [ ], int max){
	for (int i = 0; i < max; i ++ ){
		vetor[i] = rand( )%100;
	}
}

/*
   Declara uma redução do OpenMP.
   Uma redução garante que a variável tem uma cópia em cada thread. Mas seus valores
   são reduzidos em uma variável global compartilhada.
   Esta redução garante que a variável usada como parâmetro, do tipo Compare,
   terá o maior valor ao final do processamento da thread.  
 */
#pragma omp declare reduction(maximum : struct Compare : omp_out = omp_in.val > omp_out.val ? omp_in : omp_out)

void selectionsort(int arr[], int size, int num_threads) {

	//     #pragma omp parallel 

	omp_set_num_threads(num_threads);
	for (int i = size - 1; i > 0; --i) {
		struct Compare max;
		max.val = arr[i];
		max.index = i;

		#pragma omp parallel for //reduction(maximum:max)
		for (int j = i - 1; j >= 0; j--) {
		#pragma omp critical
			{
				if (arr[j] > max.val) {
					max.val = arr[j];
					max.index = j;
				}
			}
			int tn = omp_get_thread_num();
		}

		int tmp = arr[i];
		arr[i] = max.val;
		arr[max.index] = tmp;
	}
}


void selecaoSerial(int arr[], int size ) {
        for (int i = size - 1; i > 0; --i) {
                struct Compare max;
                max.val = arr[i];
                max.index = i;
                for (int j = i - 1; j >= 0; j--) {
                     if (arr[j] > max.val) {
                               max.val = arr[j];
                               max.index = j;
                     }
        	}
                int tmp = arr[i];
                arr[i] = max.val;
                arr[max.index] = tmp;
        }
}

	double processarSerial( double ti, double tf, int array[ ],int max ){
		ti = omp_get_wtime( );
                selecaoSerial( array, max );
                tf = omp_get_wtime( );
		double tempo = ((double)tf - ti);
		return tempo;
	}

int main()
{
	int max = 100;
	FILE *p = fopen("psel1.txt", "w");

	char string[1000];
	int nthreads;	
	fputs("psel1.c\nTAMANHO\t\tSerial\t\t1\t\t2\t\t4\t\t8\t\t16\t\t32\n", p);

	for (int i = 0; i < 3; i++ ){
		nthreads = 1;
		int vetor[max];
		int array[max];
		double ti;
		double tf;
		double time [5];
		double div [5];

		inicializador( vetor, max );

		inicializador( array, max );
		processarSerial( ti, tf, array, max );

		sprintf(string,"%d\t\t",max);
                fputs(string, p);


		double tempoSerial = processarSerial( ti, tf, array, max );
		sprintf(string,"%6.4f\t\t", tempoSerial);
		fputs(string, p);

		int s = 0;
		while ( s < 6 ){
			double tempoI = omp_get_wtime( );
	                selectionsort( vetor, max, nthreads);
        	        double tempoF = omp_get_wtime( );	
			double procTime = ((double)tempoF - tempoI);
			time[s] = procTime;
			sprintf(string,"%6.4f\t\t", time[s]);
		        fputs(string, p);
			nthreads = nthreads*2;
			s ++;
		}

		fputs("\n\t\t\t\t", p);	             
		int f = 0;
		while ( f < 6 ){
			double divisao = tempoSerial/time[f];
			div [f] = divisao;
			sprintf(string,"%6.4f\t\t", div[f]);
                        fputs(string, p);
			f ++;
		}

		fputs("\n\t\t\t\t", p);
		
		int n = 0;
		while ( n < 6 ){
			int threads = 1;
			double eficiencia = div[n]/threads;
			sprintf(string,"%6.4f\t\t", eficiencia);
                        fputs(string, p);
			threads = threads*2;
			n ++;
		}
		fputs("\n", p);
			
		max *= 10;
	}
	fclose(p);
	return 0;

}
