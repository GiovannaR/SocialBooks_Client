#include <stdio.h>
#include <omp.h>		
	int a[10] = {7,8,9,10,11,2,3,44,5,67};
        int b[10] = {1,2,3,4,5,6,7,8,9,10};
        int c[10] = {5,4,3,2,1,0,9,8,7,6};
	int i;
	int n;

	int main ( ){
		#pragma omp parallel
		{
			n = 10;
			#pragma omp for schedule(dynamic,2)
				for (i = 0; i < n; i++){
					c[i] = a[i]+b[i];
					printf("Thread %d executa a iteração %d do loop\n",omp_get_thread_num(),i);
				}
		}
	}
