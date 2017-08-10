/**
  * Trabalho III - Seminarios
  *
  * Pontificia Universidade Catolica
  * Aluna: Giovanna Avila Riqueti
  * Matricula: 553285
  *
  *@Questao2
  *
  */


#include <iostream>
#include <stdio.h>

using namespace std;

int *cria_vetor(int n);
void mostrar_vetor(int *v, int n );
int *invertido ( int *v , int n);

int main()
{
   int n;
   printf("Escreva o tamanho do vetor");
   cin >> n;
   int *v = cria_vetor(n);
   mostrar_vetor( v , n );
   int *novo = invertido( v , n);
   mostrar_vetor( novo , n );
   delete v;
   delete novo;
   return 0;
}

int *cria_vetor(int n)
{
   int receber;
   int *v = new int [n];
   for(int i = 0; i < n; i ++ )
   {
      cin >> receber;
      v[i] = receber;
   }
   return v;
}

void mostrar_vetor(int *v, int n )
{
   for (int i = 0; i < n; i ++ )
   {
      cout << v[i] << "";
   }
   cout << endl;
} 
int *invertido ( int *v , int n)
{
   int *novo = new int[n];
   for (int i = 0; i < n; i++ )
   {
      novo[i] = v[n - (i + 1)];
   }
   return novo;
}