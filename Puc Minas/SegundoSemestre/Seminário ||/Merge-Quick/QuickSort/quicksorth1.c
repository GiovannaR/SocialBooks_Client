#include <stdio.h>
#include <omp.h>
#include <time.h>
#include <stdlib.h>

void quicksort(int *a, int left, int right, int thread);
void quickSerial(int *a, int left, int right);
void swap(int *a, int i, int j);
int partition(int *a, int left,int right,int pivot);
int IsSort(int *array, int size);

void inicializador(int vetor [ ], int max){
	int i;
	for ( i = 0; i < max; i ++ ){
		vetor[i] = rand( )%100;
	}
}

void quickSerial(int *a, int left, int right){
	if (left < right){
		int pivot = (left + right) / 2;
		int pos = partition(a,left,right,pivot);
		quickSerial(a, left, pos - 1);
		quickSerial(a, pos + 1, right);
	}
}

void quicksort(int *a, int left, int right, int thread){
	if (left < right){
		int pivot = (left + right) / 2;
		int pos = partition(a,left,right,pivot);
		if ( thread > 1 ){
			#pragma omp parallel sections
			{
				#pragma omp section
				{
					quicksort(a, left, pos - 1, thread - 1);
				}
				#pragma omp section
				{
					quicksort(a, pos + 1, right, thread - 1);
				}
			}
		}else{
			quicksort(a, left, pos - 1, 1);
			quicksort(a, pos + 1, right, 1);
		}
	}
}


void swap(int *a, int i, int j){
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
}

int partition(int *a, int left,int right,int pivot)
{
	int pos, i;
	swap(a, pivot, right);
	pos = left;
	for(i = left; i < right; i++){
		if (a[i] < a[right]){
			swap(a, i, pos);
			pos++;
		}
	}
	swap(a, right, pos);
	return pos;
}



int IsSort(int *array, int size) {
	int i, value = 0;
	for(i = 1; i < size; i++){ 
		if(array[i-1] > array[i]){
			return 0;
		}
	}
	return 1;
}

double processarSerial( int array[ ],int max ){
	double ti = omp_get_wtime( );
        quickSerial(array, 0, max - 1);
        double tf = omp_get_wtime( );
	double tempo = ((double)tf - ti);
	return tempo;
}

int main (int argc, char** argv) {

	int max = 100000;
	FILE *p = fopen("quickh1.txt", "w");

	char string[1000];
	int nthreads;	
	fputs("quickh1.c\nTAMANHO\t\tSerial\t\t1\t\t\t2\t\t\t4\t\t\t8\t\t\t16\t\t\t32\n", p);

	nthreads = 1;
	int vetor[max];
	int array[max];
	double time [6];
	double div [6];

	inicializador(array, max);

	sprintf(string,"%d\t\t",max);
	fputs(string, p);

	double tempoSerial = processarSerial( array, max );
	sprintf(string,"%6.4f\t\t", tempoSerial);
	fputs(string, p);

	int s = 0;
	while ( s < 6 ){
		omp_set_num_threads(nthreads);
		inicializador(vetor, max);
		double tempoI = omp_get_wtime( );
		quicksort( vetor, 0, max - 1, nthreads);
		double tempoF = omp_get_wtime( );	
		double procTime = ((double)tempoF - tempoI);
		time[s] = procTime;
		sprintf(string,"%6.4f\t\t", time[s]);
		fputs(string, p);
		nthreads*= 2;
		s ++;
	}


	fputs("\n\t\t\t\t\t\t", p);	             
	int f = 0;
	while ( f < 6 ){
		double divisao = tempoSerial/time[f];
		div [f] = divisao;
		sprintf(string,"%6.4f\t\t", div[f]);
		fputs(string, p);
		f ++;
	}

	fputs("\n\t\t\t\t\t\t", p);

	int n = 0;
	int threads = 1;
	while ( n < 6 ){
		double eficiencia = div[n]/threads;
		sprintf(string,"%6.4f\t\t", eficiencia);
		fputs(string, p);
		threads *= 2;
		n ++;
	}
	fputs("\n", p);			
	fclose(p);
	return 0;
}

