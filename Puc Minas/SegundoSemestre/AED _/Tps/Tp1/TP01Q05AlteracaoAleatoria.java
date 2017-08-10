import java.util.Random;

class TP01Q05AlteracaoAleatoria{
	
/**
  *Funcao para substituir um caractere aleatorio da String por outro caractere aleatorio
  *@param teste - String a ter os caracteres mudado 
  *
  */
	public static String Mudar ( String teste, Random gerador ) {
		int tamanho = teste.length( );
		int i = 0;
		String Nova = "";
		char substituida = (char)('a' + Math.abs(gerador.nextInt( ))  % 26 );	
		char substituta = (char)('a' + Math.abs(gerador.nextInt( ))  % 26 );	

           	while ( i < tamanho ){
			if( teste.charAt(i) == substituida ){
				Nova += substituta;
			}else{
				Nova += teste.charAt(i);
			}
			i ++;
		}
		return( Nova );
	}


/**
  *Funcao para comparar se duas Strings sao iguais
  *@param comparada - String a ser comparada
  *@param gemea - String a ser comparada
  *
  */
        public static boolean igual ( String comparada, String gemea ){
                boolean resposta = true;
                int tamanho = comparada.length( );
                if ( tamanho != gemea.length( ) ){
                        resposta = false;
                }else{
                        for ( int i = 0; i < tamanho; i++ ){
                                if( comparada.charAt(i) != gemea.charAt(i) ){
                                        resposta = false;
                                }
                        }
                }
        return (resposta);
        }
	
	public static void main ( String [ ] args ) {

		Random gerador = new Random ( );
		gerador.setSeed(4);	

		String linha;
		String Nova;

		linha = MyIO.readLine( );
		while ( igual(linha,"FIM") == false ){
			Nova = Mudar(linha,gerador);
			MyIO.println(Nova);
			linha = MyIO.readLine( );
		}
	} 
}
