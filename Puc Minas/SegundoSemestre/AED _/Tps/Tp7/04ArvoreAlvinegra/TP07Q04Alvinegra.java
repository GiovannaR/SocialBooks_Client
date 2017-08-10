/**
*Tp7
*Questao04 - Arvore Alvinegra
*@author Giovanna Avila Riqueti
*@version 1 15/11/2016
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
	public boolean cor;
	public Pessoa elemento;
	public No esq, dir;

/**
*Construtor alternativo
*@param elemento Pessoa - Pessoa que sera' o elemento
*/
	public No (Pessoa elemento){
		this(elemento.clonar( ), false, null, null);
	}

/**
*Construtor alternativo
*@param elemento Pessoa - Pessoa que sera' o elemento
*@param cor boolean - determina a cor do No(Branco ou preto)
*/
	public No (Pessoa elemento, boolean cor){
		this(elemento.clonar( ), cor, null, null);
	}

/**     
*Construtor alternativo
*@param elemento Pessoa - Pessoa que sera' o elemento
*@param cor boolean - determina a cor do No(Branco ou preto)
*@param esq No - No da esquerda
*@param dir No - No da direita
*/
	public No (Pessoa elemento, boolean cor, No esq, No dir){
		this.cor = cor;
		this.elemento = elemento.clonar( );
		this.esq = esq;
		this.dir = dir;
	}

}

class Alvinegra {

	private No raiz; // Raiz da arvore.
	public int compara = 0;

/**
*Construtor padrao
*/
	public Alvinegra() {
		raiz = null;
	}

/**
* Metodo publico iterativo para pesquisar elemento.
*@param id int - Id que sera procurado.
*@return boolean - se o id existe ou nao
*/
	public boolean pesquisar(int id) {
		MyIO.print("raiz dir ");
		return pesquisar(id, raiz);
	}

/**
*Metodo privado recursivo para pesquisar elemento.
*@param id int - id que sera procurado.
*@param i No - No a ser analisado.
*@return boolean - se o id existe ou nao
*/
	private boolean pesquisar(int id, No i) {
		boolean resp;
		if (i == null) {
			compara ++;
			resp = false;
			MyIO.println("NAO");
		} else if (id == i.elemento.getId( )) {
			compara += 2;
			resp = true;
			MyIO.println("SIM");
		} else if (id < i.elemento.getId( )) {
			compara += 3;
			MyIO.print("esq ");
			resp = pesquisar(id, i.esq);
		} else {
			compara += 3;
			MyIO.print("dir ");
			resp = pesquisar(id, i.dir);
		}
		return resp;
	}

/**
*Metodo publico iterativo para exibir elementos.
*/

	public void mostrarPre() {
		mostrarPre(raiz);
	}

/**
*Metodo privado recursivo para exibir elementos.
*@param i No - No a ser analisado
*/
	private void mostrarPre(No i) {
		compara ++;
		if (i != null) {
			mostrarPre(i.esq);
			MyIO.println(i.elemento.getId( ) + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no
			mostrarPre(i.dir); 
		}
	}

/**
*Metodo publico iterativo para inserir elemento.
*@param elemento Pessoa - Pessoa a ser inserida.
*@throws Exception Se o elemento existir.
*/
	public void inserir(Pessoa elemento) throws Exception {
		//Se a arvore tiver tres ou mais elementos
		if(raiz != null && raiz.esq != null && raiz.dir != null){
			compara ++;
			inserir(elemento, null, null, null, raiz);
		//Senao, se a arvore estiver vazia
		} else if(raiz == null){
			compara += 2;
			raiz = new No(elemento, false);
		//Senao, se a arvore tiver um elemento 
		} else if (raiz.esq == null && raiz.dir == null){
			compara += 4;//Conta tambem com o proximo if que compara o id
			if (raiz.elemento.getId( ) > elemento.getId( )){
				raiz.esq = new No(elemento, true);
			} else {
				raiz.dir = new No(elemento, true);
			}
		//Senao, se a arvore tiver dois elementos (raiz e dir)
		} else if (raiz.esq == null){
			compara += 4;
			if(raiz.elemento.getId( ) > elemento.getId( )){
				compara ++;
				raiz.esq = new No(elemento);
			} else if (raiz.dir.elemento.getId( ) > elemento.getId( )){
				compara += 2;
				raiz.esq = new No(raiz.elemento);
				raiz.elemento = elemento.clonar( );
			} else {
				compara += 2;
				raiz.esq = new No(raiz.elemento);
				raiz.elemento = raiz.dir.elemento.clonar( );
				raiz.dir.elemento = elemento.clonar( );
			}
			raiz.esq.cor = raiz.dir.cor = false;
		//Senao, se a arvore tiver dois elementos (raiz e esq)
		} else if (raiz.dir == null){
			compara += 5;
			if(raiz.elemento.getId( ) < elemento.getId( )){
				compara ++;
				raiz.dir = new No(elemento);
			} else if (raiz.esq.elemento.getId( ) < elemento.getId( )){
				compara += 2;
				raiz.dir = new No(raiz.elemento);
				raiz.elemento = elemento.clonar( );
			} else {
				compara += 2;
				raiz.dir = new No(raiz.elemento);
				raiz.elemento = raiz.esq.elemento.clonar( );
				raiz.esq.elemento = elemento.clonar( );
			}
			raiz.esq.cor = raiz.dir.cor = false;
		} else {
			compara += 5;
			throw new Exception("Erro ao inserir!");
		}
		raiz.cor = false;
	}

/**
*Metodo privado para balancear a arvore Alvinegra
*@param bisavo No - No a ser analisado
*@param avo No - No a ser analisado
*@param pai No - No a ser analisado
*@param i No - No a ser analisado
*/
	private void balancear(No bisavo, No avo, No pai, No i){
		//Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
		if(pai.cor == true){
			//4 tipos de reequilibrios e acoplamento
			if(pai.elemento.getId( ) > avo.elemento.getId( )){ // rotacao a esquerda ou direita-esquerda
				compara += 2;//Ja contando com o proximo if que compara ids
				if(i.elemento.getId( ) > pai.elemento.getId( )){
					avo = rotacaoEsq(avo);
				} else {
					avo = rotacaoDirEsq(avo);
				}
			} else { // rotacao a direita ou esquerda-direita
				compara += 2;//Ja contando com o proximo if que compara ids
				if(i.elemento.getId( ) < pai.elemento.getId( )){
					avo = rotacaoDir(avo);
				} else {
					avo = rotacaoEsqDir(avo);
				}
			}
			compara ++;
			if (bisavo == null){
				raiz = avo;
			} else {
				compara ++;
				if(avo.elemento.getId( ) < bisavo.elemento.getId( )){
					bisavo.esq = avo;
				} else {
					bisavo.dir = avo;
				}
			}
			//reestabelecer as cores apos a rotacao
			avo.cor = false;
			avo.esq.cor = avo.dir.cor = true;
		} //if(pai.cor == true)
	}



/**
*Metodo privado recursivo para inserir elemento.
*@param elemento Pessoa - Pessoa a ser inserida.
*@param avo No - No a ser analisado
*@param pai No - No a ser analisado
*@param i No - No a ser analisado.
*@throws Exception Se o elemento existir.
 */
	private void inserir(Pessoa elemento, No bisavo, No avo, No pai, No i) throws Exception {
		compara ++;
		if (i == null) {
			compara ++;
			if(elemento.getId( ) < pai.elemento.getId( )){
				i = pai.esq = new No(elemento, true);
			} else {
				i = pai.dir = new No(elemento, true);
			}
			if(pai.cor == true){
				balancear(bisavo, avo, pai, i);
			}
		} else {
			//Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
			compara ++;
			if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
				i.cor = true;
				i.esq.cor = i.dir.cor = false;
				compara ++;
				if(i == raiz){
					i.cor = false;
				}else if(pai.cor == true){
					balancear(bisavo, avo, pai, i);
				}
			}
			if (elemento.getId( ) < i.elemento.getId( )) {
				compara ++;
				inserir(elemento, avo, pai, i, i.esq);
			} else if (elemento.getId( ) > i.elemento.getId( )) {
				compara += 2;
				inserir(elemento, avo, pai, i, i.dir);
			} else {
				compara += 2;
				throw new Exception("Erro inserir (elemento repetido)!");
			}
		}
	}

/**
*Metodo privado para rotacionar determinado No para a direita
*@param no No - No a ser rotacionado
*@return noDir No - a nova "raiz" da parte rotacionada
*/
	private No rotacaoDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;
		noEsq.dir = no;
		no.esq = noEsqDir;
		return noEsq;
	}

/**
*Metodo privado para rotacionar determinado No para a esquerda
*@param no No - No a ser rotacionado
*@return noDir No - a nova "raiz" da parte rotacionada
*/
	private No rotacaoEsq(No no) {
		No noDir = no.dir;
		No noDirEsq = noDir.esq;
		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	}

/**
*Metodo provado para rotacionar primeiro para a direita e depois para a esquerda
*@param no No - no que sera' rotacionado para a esquerda 
*@return No - nova raiz da parte rotacionada
*/
	private No rotacaoDirEsq(No no) {
		no.dir = rotacaoDir(no.dir);
		return rotacaoEsq(no);
	}

/**
*Metodo provado para rotacionar primeiro para a esquerda e depois para a direita
*@param no No - no que sera' rotacionado para a direita 
*@return No - nova raiz da parte rotacionada
*/
	private No rotacaoEsqDir(No no) {
		no.esq = rotacaoEsq(no.esq);
		return rotacaoDir(no);
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

}

public class TP07Q04Alvinegra{

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
		Arq.openWrite("553285_alvinegra.txt");
		Arq.println("553285\t " + ((fim - inicio)/1000.0)  +  "s\t" + "\t" + comparacoes);
		Arq.close( );
	}

	public static void main (String [ ] args){
		
		try{
	
			long inicio = now ( );	
			
			Alvinegra arvore = new Alvinegra ( );			
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
				if ( !(arvore.isRemover(linha)) ){
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
	                fazerArquivo (inicio, fim, arvore.compara);

		}catch (Exception eo){

		}

	}

}
