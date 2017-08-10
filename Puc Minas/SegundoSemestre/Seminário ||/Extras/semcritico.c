#include <stdio.h>
#include <omp.h>

	int main() {
  		int max = 0;
  		srand(time(NULL));
  		#pragma omp parallel 
  		{
   			int local = rand() % 100;  
   			printf("\n local: %i\n", local);
   			if (max < local){
     				max = local;
			}
  		}
  		printf("Maior: %i\n", max);
	}
