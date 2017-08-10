/**
  * Trabalho IV - Seminarios
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

class Ponto {
   public:
   double x;
   double y;
   Ponto ( )
   { 
   }
   
};

Ponto inserir ( Ponto &p )
{
   int X, Y;
   cout << "Digite o X :" << endl; 
   cin >> X;
   p.x = X;
   cout << "Digite o Y :" << endl;
   cin >> Y;
   p.y = Y;
   return(p);
   
}

Ponto PontoMedio (Ponto a1, Ponto a2) {
   Ponto medio ;
   medio.x = ( (a1.x + a2.x)/2 );
   medio.y = ( (a1.y + a2.y)/2 );
   return(medio);
}

int main( ){

 Ponto a1;
 Ponto a2;
 Ponto pMedio;
 inserir(a1);
 inserir(a2);
 pMedio = PontoMedio( a1, a2 );
 cout << pMedio.x << endl ;
 cout << pMedio.y << endl ;
}


