#include <stdio.h>
#include <omp.h>
#include <time.h>
#include <stdlib.h>

void mergesort(int arr[], int size);
void Merge(int vec[], int vecSize);
void mergesortSerial(int arr[], int size);
void mergeSerial(int vec[], int vecSize); 
int IsSort(int *array, int size);

void inicializador(int vetor [ ], int max){
	int i;
	for ( i = 0; i < max; i ++ ){
		vetor[i] = rand( )%100;
	}
}

void mergesort(int arr[], int size){
	int mid;
	if(size > 1) {
		mid = size / 2;
		#pragma omp parallel sections
		{
			#pragma omp section
			{
				mergesort(arr, mid);
			}
			#pragma omp section
			{
				mergesort(arr + mid, size - mid);
			}
		}
		Merge(arr, size);
	}
}

void Merge(int vec[], int vecSize) {
	int mid;
	int i, j, k;
	int* tmp;
 
	tmp = (int*) malloc(vecSize * sizeof(int));
	if (!tmp) 
		exit(1);
 
	mid = vecSize / 2;
 
	i = 0;
	j = mid;
	k = 0;
	
	while (i < mid && j < vecSize) {
		if (vec[i] < vec[j]) 
			tmp[k] = vec[i++];
		else 
			tmp[k] = vec[j++];
		++k;
	}
	
	if (i == mid) 
		while (j < vecSize) 
			tmp[k++] = vec[j++];	
	else 
		while (i < mid) 
			tmp[k++] = vec[i++];
	
	for (i = 0; i < vecSize; ++i) 
		vec[i] = tmp[i];
	
	free(tmp);
}

void mergesortSerial(int arr[], int size) {
	int mid;
	if(size > 1) {
		mid = size / 2;
		mergesortSerial(arr, mid);
		mergesortSerial(arr + mid, size - mid);
		mergeSerial(arr, size);
	}
}

void mergeSerial(int vec[], int vecSize) {
	int mid;
	int i, j, k;
	int* tmp;
 
	tmp = (int*) malloc(vecSize * sizeof(int));
	if (!tmp) 
		exit(1);
 
	mid = vecSize / 2;
 
	i = 0;
	j = mid;
	k = 0;
	
	while (i < mid && j < vecSize) {
		if (vec[i] < vec[j]){ 
			tmp[k] = vec[i++];
		}else {
			tmp[k] = vec[j++];
		}
		++k;
	}
	
	if (i == mid){ 
		while (j < vecSize){ 
			tmp[k++] = vec[j++];	
		}
	}else{ 
		while (i < mid){ 
			tmp[k++] = vec[i++];
		}	
	}
	for (i = 0; i < vecSize; ++i){ 
		vec[i] = tmp[i];
	}
	free(tmp);
}


double processarSerial( double ti, double tf, int array[ ],int max ){
	ti = omp_get_wtime( );
        mergesortSerial(array, max );
        tf = omp_get_wtime( );
	double tempo = ((double)tf - ti);
	return tempo;
}

int IsSort(int *array, int size) {
	int i, value = 0;
	for(i = 1; i < size; i++) 
		if(array[i-1] > array[i])
			return 0;
	return 1;
}

int main(int argc, char** argv) {
	
	int max = 1000000;
	FILE *p = fopen("mergehs.txt", "w");

	char string[1000];
	int nthreads;	
	fputs("mergehs.c\nTAMANHO\t\tSerial\t\t1\t\t\t2\t\t\t4\t\t\t8\t\t\t16\t\t\t32\n", p);

	nthreads = 1;
	int vetor[max];
	int array[max];
	double ti;
	double tf;
	double time [6];
	double div [6];

	inicializador(array, max);

	sprintf(string,"%d\t\t",max);
        fputs(string, p);
	
	double tempoSerial = processarSerial( ti, tf, array, max );
	sprintf(string,"%6.4f\t\t", tempoSerial);
	fputs(string, p);

	int s = 0;
	while ( s < 6 ){
		omp_set_num_threads(nthreads);
		inicializador(vetor, max);
		double tempoI = omp_get_wtime( );
	      	mergesort( vetor, max);
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
}





