/**
*Ler e escrever reais em um arquivo
*@author Giovanna Avila Riqueti
*@version 2 25/09/2016
*/

import java.lang.Double;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;

class ArquivoemJava {

/**
*Metodo para inicializar o metodo Leitura, sendo a posicao a comecar, a ultima posicao do arquivo
*/
	public static void Leitura ( ) throws Exception{
		RandomAccessFile arquivo2 = new RandomAccessFile( "arquivo.txt", "r" );
		Leitura (arquivo2.length( ) - 1);
	}

/**
*Metodo para pegar a ultima posicao do arquivo(ultima linha), ler o que esta' nela e printar 
*@param posicao long - posicao que indica a posicao na qual se deve terminar de analisar
*/
	public static void Leitura ( long posicao ) throws Exception{
		RandomAccessFile arquivo2 = new RandomAccessFile( "arquivo.txt", "r" ); 
		long ponteiro = -1;
		long cordenada = 0;
		if ( posicao > 0 ){
			while ( cordenada < posicao ){
				int codigo = Integer.parseInt(String.valueOf(arquivo2.readByte( )));
				int character = (char)codigo;
				//Como ira' ler toda a linha, o ponteiro deve estar no final da linha e nao no meio dela
				if ( character == '\n' ){
					ponteiro = arquivo2.getFilePointer( );
				}
				cordenada ++;
			}
			if ( ponteiro > 0 ){
				arquivo2.seek(ponteiro);
                        	String lido = arquivo2.readLine( );
                        	MyIO.println( lido );
				arquivo2.close( );
				//Como ja' pegou a ultima linha, deve-se fazer o metodo novamente para pegar a linha anterior
                        	Leitura( ponteiro - 1 );
			}else{
				//Como o arquivo chegou ao fim, nao e' necessario chamar a funcao novamente
				arquivo2.seek(0);
                                String lido = arquivo2.readLine( );
                                MyIO.println( lido );
                                arquivo2.close( );
			}
		}		
	}
/**
*Metodo para pegar da entrada padrao e escrever no arquivo
*@param fim long - indica o termino de ler do arquivo
*/
	public static void Escrita ( long fim ) throws Exception {
		RandomAccessFile arquivo1 = new RandomAccessFile ( "arquivo.txt", "rw" );
		//O getDefault( ) para pegar a localidade correspondente
		DecimalFormatSymbols novod = new DecimalFormatSymbols (Locale.getDefault( ));
		novod.setDecimalSeparator('.');
		//Para definir o formato dos decimais e qual simbolo se deve colocar
		DecimalFormat correta = new DecimalFormat ("###.###", novod );
		for ( long j = 0; j < fim ; j ++ ){
			double d = MyIO.readDouble( );
			arquivo1.writeBytes ( correta.format(d) + "\n" );
		}
		arquivo1.close( );
	}

	public static void main ( String [ ] args ){
		try{
			long param = Long.parseLong(MyIO.readLine( ));
			Escrita ( param );
			Leitura ( );
		}catch( Exception ex ){
			MyIO.println("Erro");
		}
	}

}
