/**
*Tp7
*Questao02 - Arvore Binaria de Arvore Binaria
*@author Giovanna Avila Riqueti
*@version 1 17/10/2016
*/

import java.util.*;
 
class Pessoa{

        private int ID;
        private String nome;
        private String nacionalidade;
        private String DatadeNascimento;
	private String LocaldeNascimento;
        private String DatadeMorte;
        private String LocaldeMorte;
        private int Idade;

/**
*Metodo padrao de construtor
*/
        public Pessoa ( ){
        }

/**
*Construtor alternativo
*@param ID int - O ID do arquivo a ser aberto
*@param nome String - Nome da pessoa da qual o arquivo contem informacoes
*@param nacionalidade String - Nacionalidade da pessoa em questao
*@param DatadeNascimento String - Data de nascimento da pessoa em questao
*@param DatadeMorte String - Data de morte da pessoa em questao
*@param LocaldeMorte String - Local onde a pessoa morreu
*@param Idade int - Idade da pessoa
*/
	public Pessoa ( int ID, String nome, String nacionalidade, String DatadeNascimento, String LocaldeNascimento, String DatadeMorte, String LocaldeMorte, int Idade ){ 
                setID (ID);
                setNome (nome);
                setNacionalidade (nacionalidade);
                setDataN (DatadeNascimento);
		setLocalN (LocaldeNascimento);
                setDataM (DatadeMorte);
                setLocalM (LocaldeMorte);
                setIdade (Idade);
        }

/**
*Metodo para atribuir valor a variavel ID
*@param ID int - int a ser atribuido a variavel
*/
        public void setID ( int ID ){
                this.ID = ID;
        }

/**
*Metodo para atribuir valor a variavel nome
*@param nome String - String a ser atribuida a variavel
*/
        public void setNome ( String nome ){
                this.nome = nome;
        }

/**
*Metodo para atribuir valor a variavel nacionalidade
*@param nacionalidade String- String a ser atribuida a variavel
*/
        public void setNacionalidade ( String nacionalidade ){
                this.nacionalidade = nacionalidade;
        }

/**
*Metodo para atribuir valor a variavel DatadeNscimento;
*@param DatadeNascimento String- String a ser atribuida a variavel
*/
        public void setDataN ( String DatadeNascimento ){
                this.DatadeNascimento = DatadeNascimento;
        }

/**
*Metodo para atribuir valor a variavel LocaldeNascimento
*@param LocaldeNascimento String - String a ser atribuida a variavel
*/
	public void setLocalN ( String LocaldeNascimento ){
		this.LocaldeNascimento = LocaldeNascimento;
	}

/**
*Metodo para atribuir valor a variavel DatadeMorte
*@param DatadeMorte String - String a ser atribuida a variavel
*/
        public void setDataM ( String DatadeMorte ){
                this.DatadeMorte = DatadeMorte;
        }

/**
*Metodo para atribuir valor a variavel LocaldeMorte
*@param LocaldeMorte String - String a ser atribuida a variavel
*/
        public void setLocalM ( String LocaldeMorte ){
                this.LocaldeMorte = LocaldeMorte;
        }


/**
*Metodo para atribuir valor a variavel Idade
*@param Idade int - int a ser atribuido a variavel
*/
        public void setIdade ( int Idade ){
                this.Idade = Idade;
        }

/**
*Metodo para retornar valor do ID
*@return int - Valor do ID
*/
        public int getId ( ){
                return this.ID;
        }

/**
*Metodo para retornar valor do nome
*@return String - Valor do nome
*/
        public String getNome ( ){
                return this.nome;
        }

/**
*Metodo para retornar valor da nacionalidade
*@return String - Valor da nacionalidade
*/
        public String getNacionalidades ( ){
                return this.nacionalidade;
        }

/**
*Metodo para retornar valor da DatadeNascimento;
*@return String - Valor da DatadeNascimento
*/
        public String getDataN ( ){
                return this.DatadeNascimento;
        }

/**
*Metodo para retornar valor do LocaldeNascimento
*@return String - Valor do LocaldeNascimento
*/
	public String getLocalN ( ){
		return this.LocaldeNascimento;
	}
/**
*Metodo para retornar valor da DatadeMorte
*@return String - Valor da DatadeMorte
*/
        public String getDataM ( ){
                return this.DatadeMorte;
        }

/**
*Metodo para retornar valor do LocaldeMorte
*@return String - Valor do LocaldeMorte
*/
        public String getLocalM ( ){
                return this.LocaldeMorte;
        }

/**
*Metodo para retornar valor da Idade
*@return int - Valor da Idade
*/
        public int getIdade ( ){
                return this.Idade;
        }

/**
*Metodo para clonar uma instancia da classe
*/
	public Pessoa clonar ( ){
                return new Pessoa ( getId( ), getNome( ), getNacionalidades( ), getDataN( ), getLocalN( ), getDataM( ), getLocalM( ), getIdade( ) );
        }

/**
*Metodo para imprimir na saida correspondente as variaveis globais
*/
        public void imprimir ( ){
                MyIO.println( getId( ) + " " +  getNome( ) + " " + getNacionalidades( ) + " " + getDataN( ) + " " + getLocalN( ) + " " + getDataM( ) + " " + getLocalM( ) + " " +  getIdade( ) );
        }

/**
*Metodo para ler de um arquivo e a partir desse atribuir valor as variaveis globais
*@param arquivo String - Nome do arquivo
*/
        public void ler ( String arquivo ){
		Arq.openRead(arquivo);
		String linha;
		String reunida = "";
		linha = Arq.readLine( );
		while ( !linha.equals("</html>") ){
			reunida += linha;
			linha = Arq.readLine();
		}
			setID( Integer.parseInt(arquivo.substring(5,8)) );
			setNome( ReceberNome(reunida) );
			setNacionalidade ( ReceberNacionalidade(reunida) );
			setDataN ( ReceberDataN(reunida) );
			setLocalN ( ReceberLocalN(reunida) );
			setDataM ( ReceberDataM(reunida) );
			setLocalM ( ReceberLocalM(reunida) );
			setIdade ( ReceberIdade(reunida) );
			Arq.close( );
	}

/**
*Metodo para encontrar no arquivo determinada String que sera' o valor da variavel nome
*@param reunida String - String correspondente a todo o arquivo
*@return Nome String - O valor da variavel nome
*/
	public String ReceberNome (String reunida){
		String Nome = "";
		String SegundaParte [ ] = new String [2];
		String PrimeiraParte [ ] = new String [2];
		PrimeiraParte = reunida.split("<title>");
		SegundaParte = PrimeiraParte[1].split(" – Wikipédia,");
		Nome = SegundaParte[0];
		return Nome;     		
	}

/**
*Metodo para encontrar no arquivo determinada String que sera' o valor da variavel nacionalidade
*@param reunida String - String correspondente a todo o arquivo
*@return nacionalidade String - O valor da variavel nacionalidade
*/
	public String ReceberNacionalidade ( String reunida ){
		String nacionalidade = "";
		String semparentese;
		String resposta = "";
		nacionalidade = QuebrarLinha( reunida, "Nacionalidade" );
		return nacionalidade;
	}

/**
*Metodo para encontrar no arquivo determinada String que sera' o valor da variavel DatadeNascimento
*@param reunida String - String correspondente a todo o arquivo
*@return resposta String - O valor da variavel DatadeNascimento
*/
	public String ReceberDataN ( String reunida ){
		String datadenascimento = "";
		String semparenteses;
		String resposta = "";
		datadenascimento = QuebrarLinha ( reunida, "Nascimento" );
		semparenteses = TirarEntre(datadenascimento, '(', ')');
		resposta = TirarEntre (semparenteses, '&', ';');
		return resposta;
	}

/**
*Metodo para encontrar no arquivo determinada String que sera' o valor da variavel LocaldeNascimento
*@param reunida String - String correspondente a todo o arquivo
*@return resposta String - O valor da variavel LocaldeNascimento
*/
	public String ReceberLocalN ( String reunida ){
		String localdenascimento = "";
		String resposta = "";
		localdenascimento = QuebrarLinha ( reunida, "Local" );
		resposta = TirarEntre(localdenascimento, '&', ';');
		return resposta;
	}

/**
*Metodo para encontrar no arquivo determinada String que sera' o valor da variavel DatadeMorte
*@param reunida String - String correspondente a todo o arquivo
*@return resposta String - O valor da variavel DatadeMorte
*/
	public String ReceberDataM ( String reunida ){
		String datademorte = "";
		String semparenteses;
		String resposta = "";
		datademorte = QuebrarLinha( reunida,"Morte" );
		if ( datademorte.isEmpty( )){
			resposta = "vivo";
		}else{
			semparenteses = TirarEntre(datademorte, '(', ')');
			resposta = TirarEntre(semparenteses, '&', ';');
		}
		return resposta;
	}

/**
*Metodo para encontrar no arquivo determinada String que sera' o valor da variavel LocaldeMorte
*@param reunida String - String correspondente a todo o arquivo
*@return resposta String - O valor da variavel LocaldeMorte
*/
	public String ReceberLocalM ( String reunida ){
		String teste = "";
		String localdemorte = "";
		String [ ] PrimeiraParte;
		String resposta = "";
		teste = QuebrarLinha( reunida,"Morte" );
		if ( teste.isEmpty( ) ){
			resposta = "vivo";
		}else{
			PrimeiraParte = reunida.split("Morte</td>");
			localdemorte = QuebrarLinha(PrimeiraParte[1],"Local");
			resposta = TirarEntre (localdemorte, '&', ';');
		}
		return resposta;
	}
	
/**
*Metodo para encontrar no arquivo determinado int que sera' o valor da variavel Idade levando em connsideracao de a pessoa morreu ou nao
*@param reunida String - String correspondente a todo o arquivo
*@return resposta int - O valor da variavel Idade
*/
	public int ReceberIdade ( String reunida ){
		int resposta = 0;
		String teste = "";
		String IdadeTeste = "";

		teste = QuebrarLinha( reunida, "Morte" );
		if ( teste.isEmpty( ) ){
			IdadeTeste = QuebrarLinha( reunida, "Nascimento" );
                        resposta = RetirarIdade (IdadeTeste);
		}else{
			resposta = RetirarIdade( teste );
		}
		return resposta;
	}

/**
*Metodo para retornar uma String so com numeros
*@param suja String - String com numeros e outros caracteres
*@return Digito String - String so com numeros
*/
	public static String SoDigito ( String suja ){
		String Digito = "";
		for ( int j = 0; j < suja.length( ); j ++ ){
			if ( suja.charAt(j) >= '0' && suja.charAt(j) <= '9' ){
				Digito += suja.charAt(j);
			}
		}
		return Digito;
	}

/**
*Metodo para retirar o valor da Idade do arquivo de modo a ignorar caracteres que nao correspondem a Idade pretendida
*@param suja String - String com caracteres inuteis
*@return resp int - int que sera' o valor da Idade
*/
	public int RetirarIdade ( String suja ){
		int resp = 0;
		String resposta = "";
		String [ ] PrimeiraParte = suja.split("&#160;");
		if ( PrimeiraParte.length >= 2 ){
			resposta = SoDigito(PrimeiraParte[1]);
			
		}else{
			String entreparenteses = PegarEntre( suja, '(', ')' );
			resposta = SoDigito( entreparenteses );
		}
		resp = Integer.parseInt(resposta);
		return resp;		
	}
	
/**
*Metodo para retornar uma String desejada que esta' no arquivo HTML
*@param reunida String - String que corresponde ao arquivo todo
*@param procurada String - String que define como o arquivo sera' dividido para encontrar uma String desejada
*@return resposta String - String desejada
*/
	public String QuebrarLinha ( String reunida, String procurada ){
		String resposta = "";
		try{
			String [ ] PrimeiraParte = reunida.split(procurada + "</td>");
			String [ ] SegundaParte = PrimeiraParte[1].split("<br />");
                	String [ ] TerceiraParte = SegundaParte[0].split("</td>");
                	String [ ] QuartaParte = TerceiraParte[0].split(">");
			String [ ] QuintaParte;

			for ( int i = 0; i < QuartaParte.length; i ++ ){
				QuintaParte = QuartaParte[i].split("<");
				resposta += QuintaParte[0];
			}

		}catch ( ArrayIndexOutOfBoundsException problema ){
			resposta = "";
		}
		return resposta;
	}

/**
*Metodo que retorna uma String sem o que esta' dentro dos parenteses
*@param suja String - String com os parenteses
*@return limpa String - String sem o que esta'entre os parenteses
*/
	public String TirarEntre ( String suja, char antes, char depois ){
		String limpa = "";
		int inicio = suja.indexOf(antes);
		int fim;
		
		if ( antes == depois ){
			fim = suja.indexOf(depois);			
		}else{
			fim = suja.indexOf(depois, inicio);
		}
		
		for ( int i = 0; i < suja.length( ); i++ ){
			if ( i < inicio || i > fim ){
				limpa += suja.charAt(i);
			}
		}
		return limpa;
	}

/**
*Metodo que retorna uma String com o que esta' dentro dos parenteses
*@param suja String - String com os parenteses
*@return limpa String - String sem o que esta'entre os parenteses
*/
	public String PegarEntre ( String suja, char antes, char depois ){
		String limpa = "";
		int inicio = suja.indexOf(antes);
		int fim;

		if ( antes == depois ){
			fim = suja.indexOf(depois);
		}else{
			fim = suja.indexOf(depois, inicio);
		}
		for ( int i = 0; i < suja.length( ); i ++ ){
			if ( i > inicio && i < fim ){
				limpa += suja.charAt(i);
			}
		}
		return limpa;
	}

/**
*Metodo que retorna uma String que esta invertida em relacao a original
*@param original String - String a ser invertida
*@return invertida String - String invertida em relacao a original
*/
	public String Contrario ( String original ){
        	String invertida = "";
		int tamanho = original.length( );
		int ultimo = tamanho - 1;
		int metade = tamanho/2;
		while ( ultimo >= 0 ){
			invertida = invertida + original.charAt(ultimo);
			ultimo--; 
		} 
		return invertida;
	}

/**
*Divide a linha por meio do ## de modo a conseguir uma Pessoa
*@param inteira String - String a ser separada
*@return doarray Pessoa - Pessoa formada
*/
	public Pessoa Outros (String inteira){
                Pessoa doarray = new Pessoa ( );
		String partida = "";
                String id = "";
                String [ ] parte1 = inteira.split("##");
                String [ ] parte2 = parte1[0].split(" ");
                if ( parte2.length >= 3 ){
                        id = parte2[2];
                }else{
                        id = parte2[1];
                }
                doarray.setID(Integer.parseInt(id));
                doarray.setNome(parte1[1]);
                doarray.setNacionalidade(parte1[2]);
                doarray.setDataN(parte1[3]);
                doarray.setLocalN(parte1[4]);
                doarray.setDataM(parte1[5]);
                doarray.setLocalM(parte1[6]);
                int idade = Integer.parseInt(parte1[7].trim( ));
                doarray.setIdade(idade);
		return doarray;
        }

	public int getMes ( ){
		String a = getDataN( );
		int resp = 0;
		if ( a.contains("janeiro") ){
			resp = 1;
		}else if ( a.contains("fevereiro") ){
			resp = 2;
		}else if ( a.contains("março") ){
			resp = 3;
		}else if ( a.contains("abril") ){
			resp = 4;
		}else if ( a.contains("maio") ){
			resp = 5;
		}else if ( a.contains("junho") ){
			resp = 6;
		}else if ( a.contains("julho") ){
			resp = 7;
		}else if ( a.contains("agosto") ){
			resp = 8;
                }else if ( a.contains("setembro") ){
			resp = 9;
                }else if ( a.contains("outubro") ){
			resp = 10;
                }else if ( a.contains("novembro") ){
			resp = 11;
                }else if ( a.contains("dezembro") ){
			resp = 12;
		}
		return resp;
	}
}


class No{


	public int elemento;
        public No esq;
        public No dir;
	public No2 arvore;
	

/**
*Construtor alternativo
*@param elemento int -  Inteiro que dara' valor ao elemento
*/
        public No (int elemento){
                this(elemento, null, null, null);
        }

/**
*Construtor alternativo
*@param elemento int - Inteiro que dara' valor ao elemento
*@param esq No - No que esq apontara'
*@param dir No - No que dir apontara'
*@param arvore No2 - No2 que arvore apontara'
*/
        public No (int elemento, No esq, No dir, No2 arvore){
                this.elemento = elemento;
                this.esq = esq;
                this.dir = dir;
		this.arvore = arvore;
        }

}

class No2{

	public int elemento;
	public No2 esq;
	public No2 dir;

/**
*Construtor alternativo
*@param elemento int - Inteiro que dara' valor ao elemento
*/
	public No2 (int elemento){
		this(elemento, null, null);
	}

/**
*Construtor alternativo
*@param elemento int - Inteiro que dara' valor ao elemento
*@param esq No - No que esq apontara'
*@param dir No - No que dir apontara'
*/
	public No2 (int elemento, No2 esq, No2 dir){
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}

}

class ArvoreBinaria {

	public No raiz;

/**
*Construtor padrao
*/
	public ArvoreBinaria( ){
		raiz = new No(6);
		Construir ( );
	}

//---------------------------------------------------METODOS PARA A PRIMEIRA ARVORE-----------------------------------------------------
	public void Construir ( ) {
		try {	
			inicializar (2);
			inicializar (9);
			inicializar (4);
			inicializar (11);
			inicializar (0);
			inicializar (1);
			inicializar (3);
			inicializar (5);
			inicializar (7);
			inicializar (8);
			inicializar (10);
			inicializar (12);
		}catch ( Exception es ){
		}
	}

/**
*Metodo para inicializar o metodo recursivo de inserir
*@param x int - Inteiro a ser inserido
*/
	public void inicializar (int x) throws Exception{
		raiz = inicializar (x,raiz);
	}

/**
*Metodo recursivo para inserir determinado inteiro na Arvore Binaria
*@param x int - Inteiro a ser inserido
*@param i No - No que tem a manter recursividade
*/
	private No inicializar (int x, No i) throws Exception{
		if ( i == null ){
			i = new No(x);
		}else if ( x < i.elemento ){
			i.esq = inicializar (x,i.esq);
		}else if ( x > i.elemento ){
			i.dir = inicializar (x,i.dir);
		}else{
			throw new Exception ("Erro!");
		}
		return i;
	}

//-----------------------------------------NORMAIS-------------------------------------------------------------------

	public No BuscarNo (int mes)throws Exception{
		return BuscarNo(mes, raiz);
	}

	private No BuscarNo (int mes, No i) throws Exception{
		No resp = null;
		if ( i == null ){
			throw new Exception ("Nao encontrado");
		}else if ( mes == i.elemento ){
			resp = i;
		}else if ( mes < i.elemento ){
			resp = BuscarNo (mes, i.esq);
		}else if ( mes > i.elemento ){
			resp = BuscarNo (mes, i.dir);
		}
		return resp;
	}

	public void inserir ( int mes, int id )throws Exception{
		No i = BuscarNo (mes);
		i.arvore = inserir ( id, i.arvore );
	}

	private No2 inserir (int id, No2 j) throws Exception{
                if ( j == null ){
                        j = new No2(id);
        	}else if ( id < j.elemento ){
                        j.esq = inserir (id, j.esq);
                }else if ( id > j.elemento ){
                        j.dir = inserir (id, j.dir);
                }else{
                        throw new Exception ("Erro!");
                }
                return j;
        }

	public void remover (int id) throws Exception{
		No i = pesquisarNo(id);
		if ( i != null ){
			i.arvore = remover (id, i.arvore);
		}
	}

	public No2 remover (int id, No2 j)throws Exception{
		if(j == null){
			throw new Exception ("Erro");
    		}else if ( id < j.elemento ) {
        		j.esq = remover(id, j.esq);
      		}else if ( id > j.elemento ) {
        		j.dir = remover(id, j.dir);
      		}else if ( j.dir == null ) {
        		j = j.esq;
      		}else if ( j.esq == null ) {
        		j = j.dir;
      		}else{
        		j.esq = antecessor(j, j.esq);
        	}
        	return j;
    	}

	private No2 antecessor(No2 i, No2 j) {
        	if (j.dir != null) {
            		j.dir = antecessor(i, j.dir);
        	} else {
            		i.elemento = j.elemento; 
            		j = j.esq; 
        	}
        	return j;
    	}

	public No pesquisarNo (int id) {
		return pesquisarNo (id, raiz);
	}

	public No pesquisarNo (int id, No i){
		boolean resp;
		No r = null;
		if ( i != null ){
			resp = pesquisarNo (id, i.arvore);
			if ( resp == true ){
                                r = i;
                        }
			if ( r == null ){
				r = pesquisarNo (id, i.esq);
			} 
			if ( r == null ){
				r = pesquisarNo (id, i.dir);
			}
		}
		return r;
	}

	private boolean pesquisarNo (int x, No2 i){
                boolean resp;
                if ( i == null ){
                        resp = false;
                }else if ( x == i.elemento ){
                        resp = true;
                }else if ( x < i.elemento ){
                        resp = pesquisarNo (x, i.esq);
                }else{
                        resp = pesquisarNo (x, i.dir);
                }
                return resp;
        }


/**
*Metodo para inicializar metodo recursivo de pesquisar
*@param x int - Id a ser pesquisado
*/
	public void pesquisar (int x){
		MyIO.print("raiz ");
		if ( pesquisar(x, raiz) ){
			MyIO.println("SIM");
		}else{
			MyIO.println("NAO");
		}
	}

	public boolean pesquisar ( int x, No i ){
		boolean resp = false;
		if ( i != null ){
			if ( resp == false ){
				MyIO.print("esq ");
				resp = pesquisar ( x, i.esq );
			}
			if( resp == false){
				MyIO.print("raiz ");
				resp = pesquisar ( x, i.arvore );
			}
			if ( resp == false ){
				MyIO.print("dir ");
				resp = pesquisar ( x, i.dir );
			}
		}
		return resp;
	}

/**
*Metodo recursivo de pesquisar o Id
*@param x int - Id a ser pesquisado
*@return resp boolean - se achou ou nao o Id
*/
	private boolean pesquisar (int x, No2 j){
		boolean resp = false;
		if ( j == null ){	
			resp = false;
		}else if ( x == j.elemento ){
			resp = true;
		}else if ( x < j.elemento ){
			MyIO.print("esq ");
			resp = pesquisar (x, j.esq);
		}else if(x > j.elemento){
			MyIO.print("dir ");
			resp = pesquisar (x, j.dir);
		}
		return resp;
	}


/**
*Metodo para inicializar o metodo recursivo para mostrar os elementos da Arvore Binaria
*/
	public void mostrar ( ){
		mostrar (raiz);
	}

/**
*Metodo recursivo para mostrar os elementos da Arvore Binaria
*@param i No - mantem a recursividade
*/
	public void mostrar (No i){
		if ( i != null ){
			mostrar (i.esq);
			MyIO.println( i.elemento );;
			mostrar (i.dir);
		}
	}
      

	public void mostrar2 ( ){
		mostrar2 (raiz);
	}

/**
*Metodo recursivo para mostrar os elementos da Arvore Binaria
*@param i No - mantem a recursividade
*/
        public void mostrar2 (No i){
                if ( i != null ){
			mostrar2 ( i.esq );
			mostrar2 ( i.arvore );
			mostrar2 ( i.dir );
		}
        }

	public void mostrar2 (No2 j){
		if ( j != null ){
			mostrar2 (j.esq);
			MyIO.println ( j.elemento + "" );
			mostrar2 (j.dir);
		}
	}

//-----------------------------------------------------LIGADOS A MAIN-------------------------------------------------------------

/**
*De acordo com as informacoes da linha, ver se deve inserir ou remover
*@param analisada String - Possui as informacoes se deve inserir ou nao
*@return resposta boolean - Se deve remover ou nao
*/
	public boolean isRemover (String analisada){
		boolean resposta = true;
		if ( analisada.contains("##") ){
			resposta = false;
		}
		return resposta;
	}
	
	public void paraRemover ( String completa ) throws Exception{
		int id = Integer.parseInt(Pessoa.SoDigito(completa));
		remover(id);
	}

}


public class TP07Q02ArvoredeArvore{

	public static void main ( String [ ] args )throws Exception {
		MyIO.setCharset("UTF8");
		ArvoreBinaria arvore = new ArvoreBinaria ( );
		int mes;
		Pessoa inserida = new Pessoa ( );
		String linha; 
		Pessoa doarray = new Pessoa ( );

		linha = MyIO.readLine( );
		while ( !(linha.equals("FIM")) ){
			inserida.ler( linha );
			mes = inserida.getMes ( );
			arvore.inserir(mes, inserida.getId( ));
			linha = MyIO.readLine( );
		}

		int i = 0;
		int quantidade;
		quantidade = MyIO.readInt( );
		
		while ( i < quantidade ){
			linha = MyIO.readLine( );
			if ( arvore.isRemover(linha) ){			
				arvore.paraRemover(linha);
			}else{
				Pessoa certa = doarray.Outros(linha);
				arvore.inserir(certa.getMes( ), certa.getId( ));
			}
			i ++;
		}
	
		linha = MyIO.readLine( );
		while ( !(linha.equals("FIM")) ){
			int id = Integer.parseInt(Pessoa.SoDigito(linha));
			arvore.pesquisar(id); 
			linha = MyIO.readLine( );
		}
	}

} 
