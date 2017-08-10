/**
  * Trabalho IV - Seminarios
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

class Ponto {
   public:
   double x;
   double y;
   public :
   Ponto( )
   {
   }
   

void pontos ( double a, double b )
{
 x = a;
 y = b;
 }

Ponto PontoMedio (Ponto a1) {
   Ponto medio ;
   medio.pontos( (x + a1.x)/2 ,(y + a1.y)/2 );
   return(medio);
}

void inserir ( )
{
   int X, Y;
   cout << "Digite o X :" << endl; 
   cin >> X;
   x = X;
   cout << "Digite o Y :" << endl;
   cin >> Y;
   y = Y;
   
}

};

 void inserir ( );
 void pontos ( double , double );
 Ponto PontoMedio (Ponto );

int main( ){

 Ponto a1;
 Ponto a2;
 Ponto pMedio;
 a1.inserir( );
 a2.inserir( );
 pMedio = a1.PontoMedio( a2 );
 cout << pMedio.x << endl ;
 cout << pMedio.y << endl ;
}

