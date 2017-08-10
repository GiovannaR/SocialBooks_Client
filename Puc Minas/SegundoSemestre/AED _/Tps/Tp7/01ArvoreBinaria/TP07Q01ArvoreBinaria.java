/**
*Tp7
*Questao01 - Arvore Binaria
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

}

class No{

	public Pessoa elemento;
	public No esq;
	public No dir;

/**
*Construtor alternativo
*@param elemento Pessoa - Pessoa que dara' valor ao elemento
*/
	public No (Pessoa elemento){
		this(elemento.clonar( ), null, null);
	}

/**
*Construtor alternativo
*@param elemento Pessoa - Pessoa que dara' valor ao elemento
*@param esq No - No que esq apontara'
*@param dir No - No que dir apontara'
*/
	public No (Pessoa elemento, No esq, No dir){
		this.elemento = elemento.clonar( );
		this.esq = esq;
		this.dir = dir;
	}

}

class ArvoreBinaria {

	public No raiz;
	public int compara = 0;

/**
*Construtor padrao
*/
	public ArvoreBinaria( ){
		raiz = null;
	}

/**
*Metodo para inicializar o metodo recursivo de inserir
*@param x Pessoa - Pessoa a ser inserida
*/
	public void inserir (Pessoa x) throws Exception{
		raiz = inserir (x,raiz);
	}

/**
*Metodo recursivo para inserir determinada Pessoa na Arvore Binaria
*@param x Pessoa - Pessoa a ser inserida
*@param i No - No que tem a manter recursividade
*/
	private No inserir (Pessoa x, No i) throws Exception{
		if ( i == null ){
			compara ++;			
			i = new No(x);
		}else if ( x.getId( ) < i.elemento.getId( ) ){
			compara += 2;
			i.esq = inserir (x,i.esq);
		}else if ( x.getId( ) > i.elemento.getId( ) ){
			compara += 3;
			i.dir = inserir (x,i.dir);
		}else{
			compara += 3;
			throw new Exception ("Erro!");
		}
		return i;
	}

/**
*Metodo para inicializar metodo recursivo de pesquisar
*@param x int - Id a ser pesquisado
*/
	public boolean pesquisar (int x){
		MyIO.print("raiz ");
		return pesquisar(x, raiz);
	}

/**
*Metodo recursivo de pesquisar o Id
*@param x int - Id a ser pesquisado
*@return resp boolean - se achou ou nao o Id
*/
	private boolean pesquisar (int x, No i){
		boolean resp = false;
		if ( i == null ){
			compara ++;
			MyIO.println("NAO");
			resp = false;
		}else if ( x == i.elemento.getId( ) ){
			compara += 2;
			resp = true;
			MyIO.println("SIM");
		}else if ( x < i.elemento.getId( ) ){
			compara += 3;
			MyIO.print("esq ");
			resp = pesquisar (x, i.esq);
		}else if ( x > i.elemento.getId( ) ){
			compara += 4;
			MyIO.print("dir ");
			resp = pesquisar (x, i.dir);
		}
		return resp;
	}

/**
*Metodo para inicializar o metodo recursivo de pesquisar o Id
*/
	public Pessoa pesquisarId (int x){
                return pesquisarId(x, raiz);
        }

/**
*Metodo privado para pesquisar se um Id esta' presente em uma das Pessoas da Arvore Binaria e retornar a Pessoa
*@param x int - Id a ser pesquisado
*@param i No - Manter recursividade
*@resturn resp Pessoa - Pessoa que possui o determinado Id
*/ 
	private Pessoa pesquisarId (int x, No i){
		Pessoa resp = new Pessoa ( );
                if ( i == null ){
			compara ++;
			resp = null;
		}else{                     
                	if ( x == i.elemento.getId( ) ){
				compara += 2;
                	        resp = i.elemento.clonar( );                        
                	}else if ( x < i.elemento.getId( ) ){
				compara += 3;
                        	resp = pesquisarId (x, i.esq);
                	}else if ( x > i.elemento.getId( ) ){
				compara += 4;
                        	resp = pesquisarId (x, i.dir);
                	}
		}
                return resp;
        } 

/**
*Metodo que inicializa o metodo recursivo remover
*@param x Pessoa - Pessoa a ser removida
*@throws Exception caso nao encontre o elemento
*/
	public void remover(Pessoa x) throws Exception {
        	raiz = remover(x, raiz);
    	}
 
/**
*Metodo recursivo para remover elemento
*@param x Pessoa - Pessoa a ser removida
*@param i No - alimenta a recursividade
*@return No - alterado ou nao
*@throws Exception caso nao encontre o elemento
*/
	private No remover(Pessoa x, No i) throws Exception {
    		if (x == null) {
    		} else if(i == null){
			compara ++;
			throw new Exception("Erro ao remover");
    		}else if (x.getId( ) < i.elemento.getId( )) {
			compara += 2;
        		i.esq = remover(x, i.esq);
      		}else if (x.getId( ) > i.elemento.getId( )) {
			compara += 3;
        		i.dir = remover(x, i.dir);
      		}else if (i.dir == null) {
			compara += 4;
        		i = i.esq;
      		}else if (i.esq == null) {
			compara += 5;
        		i = i.dir;
      		}else{
			compara += 5;
        		i.esq = antecessor(i, i.esq);
        	}
        	return i;
    	}
 
/**
*Metodo para trocar No removido pelo maior numero a esquerda
*@param i No - No cujo elemento foi removido
*@param j No - i.esq
*@return No - alterado ou nao
*/
	private No antecessor(No i, No j) {
		compara ++;
        	if (j.dir != null) {
            		j.dir = antecessor(i, j.dir);
        	} else {
            		i.elemento = j.elemento.clonar( ); 
            		j = j.esq; 
        	}
        	return j;
    	}		


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

/**
*Metodo que auxilia na remocao
*@param completa String - String que contem o id da Pessoa a ser removida
*/
	public void paraRemover ( String completa ) throws Exception{
		Pessoa removida = new Pessoa ( );
		int id = Integer.parseInt(Pessoa.SoDigito(completa));
		removida = pesquisarId(id);
		remover(removida);
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
		compara ++;
		if ( i != null ){
			mostrar (i.esq);
			MyIO.println( i.elemento.getId( ) );;
			mostrar (i.dir);
		}
	}

/**
*Funcao que retorna o numero de comparacoes feitas
*@return int - numero de comparacoes
*/
	public int getComparacoes ( ) {
		return this.compara;
	}


}

public class TP07Q01ArvoreBinaria{

/**
*Retorna o timestamp atual
*@return timestamp atual
*/
	public static long now(){
		return new Date().getTime();
	}

/**
*Metodo para fazer arquivo
*@param inicio long - tempo inicial do programa
*@param fim long - tempo final do programa
*/
	public static void fazerArquivo ( long inicio, long fim, int comparacoes){
		Arq.openWrite("553285_arvoreBinaria.txt");
		Arq.println("553285\t " + ((fim - inicio)/1000.0)  +  "s\t" + "\t" + comparacoes);
		Arq.close( );
	}

	public static void main ( String [ ] args )throws Exception {

		long inicio = now ( );

		try{
			ArvoreBinaria arvore = new ArvoreBinaria ( );			
			String linha;	
			Pessoa inserida = new Pessoa ( );
			Pessoa doarray = new Pessoa ( );
	
			linha = MyIO.readLine( );
			while ( linha.equals("FIM") == false ){
				inserida.ler( linha );
				arvore.inserir(inserida);
				linha = MyIO.readLine( );
			}

			linha = MyIO.readLine( );
			int quantidade = Integer.parseInt(linha);
			int i = 0;
			while ( i < quantidade ){
				linha = MyIO.readLine( );
				if ( arvore.isRemover(linha) ){
					arvore.paraRemover(linha);
				}else{
					Pessoa certa = doarray.Outros(linha);
					arvore.inserir(certa);
				}
				i ++;
			}
			int id;
			linha = MyIO.readLine( );
			while ( linha.equals("FIM") == false ){
				id = Integer.parseInt(Pessoa.SoDigito(linha));
				arvore.pesquisar(id);
				MyIO.println( );
				linha = MyIO.readLine( );
			}

			long fim = now ( );
	                fazerArquivo (inicio, fim, arvore.getComparacoes( ));

		}catch ( Exception es ){
			MyIO.println("Erro");
 		}

	}

} 
