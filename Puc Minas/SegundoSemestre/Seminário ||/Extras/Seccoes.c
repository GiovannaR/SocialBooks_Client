#include <stdio.h>
#include <omp.h>

	int main( )
	{
  		#pragma omp parallel
  		{
    			printf ( "All threads run this\n" );
    			#pragma omp sections
    			{
      			#pragma omp section
      			{
        			printf ( "This executes in parallel\n" );
      			}
      			#pragma omp section
      			{
				printf( "Sequential statement 1\n" );
        			printf( "This always executes after statement 1\n" );
      			}
      			#pragma omp section
			{
        			printf( "This also executes in parallel\n" );
      			}
    			}	
  		}
	}
