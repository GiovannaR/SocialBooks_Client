#include <stdio.h>

int main ( ){
	int *x1;
	int x2;
	int *x3;

	x1 = (int*)malloc(sizeof(int));

	*x1 = 20;
	x2 = *x1;
	*x3 = x2**x1;
	printf("\nPrimeiros numeros : x1:%d, x2:%d, x3:%d \n",*x1,x2,*x3);
	x3 = &x2;
	x2 = 15;
	printf("\nSegundos numeros : x1:%d, x2:%d, x3:%d \n",*x1,x2,*x3);
}
