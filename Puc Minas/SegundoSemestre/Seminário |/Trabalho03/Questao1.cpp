/**
  * Trabalho III - Seminarios
  *
  * Pontificia Universidade Catolica
  * Aluna: Giovanna Avila Riqueti
  * Matricula: 553285
  *
  *@Questao1
  *
  */

#include <iostream>
#include <stdio.h>


using namespace std;

int *cria_vetor(int n);
void mostra_vetor(int *v, int n);
int buscar(int x, int n, int *v);

int main()
{
   int n;
   printf("Digite o tamanho do vetor");
   scanf("%d", &n);
   cout << n << endl;
   
   int *v = cria_vetor(n);
   mostra_vetor( v,  n);
   int x;
   printf("Qual numero sera' buscado");
   cin >> x;
   int b = buscar( x, n, v ) ;
   cout << b << endl;
   delete v;
   return 0;
}


int *cria_vetor(int n)
{
   int r;
   int *v = new int[n];
   for( int i = 0; i < n; i ++ )
   {
      printf("Digite os elementos do vetor");
      cin >> r;
      v[i] = r;
   }
   return v;
}

void mostra_vetor(int *v, int n)
{
   for(int i = 0; i<n; i++)
   {
      cout << v[i] ;
   }
   cout << endl;
}

int buscar(int x, int n, int *v)
{
   int achou = -1;
   for( int i = 0; i < n; i ++ )
   {
      if ( v[i] == x )
      {
         achou = i;
      }
   }
   return achou;
}
