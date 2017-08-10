public class TestePilha{

	public static void main ( String [ ] args ){
		try {
			PilhaNo pilha = new PilhaNo ( );
			pilha.inserir(1);
			pilha.inserir(2);
			pilha.inserir(3);
                	pilha.inserir(4);
			pilha.inserir(5);

			int x = pilha.remover( );
			int y = pilha.remover( );

			System.out.println( "Removidos : x: " + x + ", y: " + y );
		}catch( Exception es ){
			System.out.println("Erro");
		}
	}
}
