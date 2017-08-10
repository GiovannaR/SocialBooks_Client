/**
 *Tp7
 *Questao02 - Arvore Binaria de Arvore Binaria
 *@author Giovanna Avila Riqueti
 *@version 1 17/10/2016
 */

import java.util.*;

class Pessoa
{
	public int id;
	public int idade;
	public String nome;
	public String nacionalidade;
	public String nascimento;
	public String localNascimento;
	public String morte;
	public String localMorte;

/**
*Metodo para imprimir na saida correspondente as variaveis globais
*/
	public void imprimir(){
		MyIO.println(this.id + " ## " + 
				this.nome + " ## " + 
				this.nacionalidade + " ## " +
				this.nascimento + " ## " +
				this.localNascimento + " ## " +
				this.morte + " ## " +
				this.localMorte + " ## " +
				this.idade + //" " + 
				"");
	}

/**
*Metodo para clonar uma instancia da classe
*/
	public Pessoa clone (){
		Pessoa resp = new Pessoa();
		resp.id = this.id;
		resp.idade = this.idade;
		resp.nome = this.nome;
		resp.nacionalidade = this.nacionalidade;
		resp.nascimento = this.nascimento;
		resp.localNascimento = this.localNascimento;
		resp.morte = this.morte;
		resp.localMorte = this.localMorte;
		return resp;
	}

/**
*Metodo para retornar o numero do mes correspondente
*@param data String - data de nascimento ou morte
*@return resp int - numero do mes
*/
	public int getMes(String data){
		int resp = 0;
		if(data.contains("janeiro") == true){
			resp = 1;
		} else if(data.contains("fevereiro") == true){
			resp = 2;
		} else if(data.contains("março") == true){
			resp = 3;
		} else if(data.contains("abril") == true){
			resp = 4;
		} else if(data.contains("maio") == true){
			resp = 5;
		} else if(data.contains("junho") == true){
			resp = 6;
		} else if(data.contains("julho") == true){
			resp = 7;
		} else if(data.contains("agosto") == true){
			resp = 8;
		} else if(data.contains("setembro") == true){
			resp = 9;
		} else if(data.contains("outubro") == true){
			resp = 10;
		} else if(data.contains("novembro") == true){
			resp = 11;
		} else if(data.contains("dezembro") == true){
			resp = 12;
		}
		return resp;
	}
	
/**
*Divide a linha por meio do ## de modo a conseguir uma Pessoa
*@param inteira String - String a ser separada
*/
	public void parsePessoa(String s){
		String array[] = s.split(" ## ");
		this.id = Integer.parseInt(ArvoreBinaria.SoDigito(array[0]));
		this.nome = array[1];
		this.nacionalidade = array[2];
		this.nascimento = array[3];
		this.localNascimento = array[4];
		this.morte = array[5];
		this.localMorte = array[6];
		this.idade = Integer.parseInt(ArvoreBinaria.SoDigito(array[7]));
	}

/**
*Metodo para pegar o que esta' entre duas Strings
*@param s String - String principal
*@param antes String - String que marca inicio
*@param depois String - String que marca fim
*@return resp String - o que esta' entre duas Strings 
*/
	public String getSubstringEntre(String s, String antes, String depois){
		String resp = "";
		int posInicio , posFim;

		posInicio = s.indexOf(antes) + antes.length();

		if(antes.compareTo(depois) != 0){
			posFim = s.indexOf(depois);
		} else {
			posFim = s.indexOf(depois, posInicio);
		}

		if(0 <= posInicio && posInicio < posFim && posFim < s.length()){
			resp = s.substring(posInicio, posFim);
		}

		return resp;
	}

/**
*Metodo para pegar o int que esta' entre duas String
*@param s String - String principal
*@param antes String - String que marca inicio
*@param depois String - String que marca fim
*@return int - o inteiro que esta' entre as Strings
*/
	public int getIntEntre(String s, String antes, String depois){
		return (new Integer(getSubstringEntre(s, antes, depois).replace(".","").trim())).intValue();
	}

/**
*Metodo para pegar o double que esta' entre duas String
*@param s String - String principal
*@param antes String - String que marca inicio
*@param depois String - String que marca fim
*@return int - o double que esta' entre as Strings
*/
	public double getDoubleEntre(String s, String antes, String depois){
		return (new Double(getSubstringEntre(s, antes, depois).replace(",",".").trim())).doubleValue();
	}

/**
*Funcao que retorna uma String sem as tags
*@param s String - String que tera' as tags colocadas
*@return resp String - String sem as tags
*/
	public String removeTags(String s){
		String resp = "";
		for (int i = 0; i < s.length(); i++){

			//Perguntas: (1) Pq o while abaixo? (2) Pq as clausulas do while abaixo nao podem ser invertidas?
			while(i < s.length() && s.charAt(i) == '<'){
				for (i++; s.charAt(i) != '>'; i++);
				i++;

				//Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
				while(i < s.length() && s.charAt(i) == '&'){
					for (i++; s.charAt(i) != ';'; i++);
					i++;
				}
			}

			//Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
			while(i < s.length() && s.charAt(i) == '&'){
				for (i++; s.charAt(i) != ';'; i++);
				i++;
				resp += ' ';
			}

			//Perqunta: Pq nao colocamos apenas resp += s.charAt(i)?
			if(i < s.length()){
				resp += s.charAt(i);
			}
		}

		while(resp.length() > 0 && resp.charAt(0) == ' '){
			resp = resp.substring(1);
		}

		return resp;
	}

/**
*Metodo para ler de um arquivo e a partir desse atribuir valor as variaveis globais
*@param arquivo String - Nome do arquivo
*/
	public void ler(String nomeArquivo){
		String linha;

		//Abrir o arquivo para leitura
		Arq.openRead(nomeArquivo, "UTF8");//ISO-8859-1");

		//Definir atributo id
		this.id = (nomeArquivo.charAt(nomeArquivo.length() - 8) - 48) * 100;
		this.id += (nomeArquivo.charAt(nomeArquivo.length() - 7) - 48) * 10;
		this.id += (nomeArquivo.charAt(nomeArquivo.length() - 6) - 48);

		//Definir atributo nome
		for(linha = Arq.readLine(); linha.contains("<h1") == false; linha = Arq.readLine());
		this.nome = getSubstringEntre(linha, "lang=\"pt\">", "</h1>");

		//Definir atributo nacionalidade
		for(linha = Arq.readLine(); linha.contains("Nacionalidade") == false; linha = Arq.readLine());
		this.nacionalidade = removeTags(Arq.readLine());

		//Definir atributo nascimento
		for(linha = Arq.readLine(); linha.contains("Nascimento") == false; linha = Arq.readLine());
		this.nascimento = removeTags(Arq.readLine());

		//Se vivo
		if(this.nascimento.charAt(this.nascimento.length()-1) == ')'){
			String tmp = this.nascimento.substring(this.nascimento.indexOf('(') + 1);
			tmp = tmp.substring(0, tmp.indexOf(' '));
			this.idade = (new Integer(tmp)).intValue();
			this.nascimento = this.nascimento.substring(0, this.nascimento.indexOf('('));
			this.morte = "vivo";
			this.localMorte = "vivo";
		} else {
			this.morte = "";
			this.localMorte = "";
		}

		//Definir atributo local de nascimento
		for(linha = Arq.readLine(); linha.contains("Local") == false; linha = Arq.readLine());
		this.localNascimento = removeTags(Arq.readLine());

		//Definir atributos morte e local de morte
		if (this.morte.length() == 0){
			for(linha = Arq.readLine(); linha.contains("Morte") == false; linha = Arq.readLine());
			this.morte = removeTags(Arq.readLine());

			if(this.morte.contains("(") == true){
				String tmp = this.morte.substring(this.morte.indexOf('(') + 1);
				tmp = tmp.substring(0, tmp.indexOf(' '));
				this.idade = (new Integer(tmp)).intValue();
				this.morte = this.morte.substring(0, this.morte.indexOf('('));
			}

			for(linha = Arq.readLine(); linha.contains("Local") == false; linha = Arq.readLine());
			this.localMorte = removeTags(Arq.readLine());
		}

		//Fechar o arquivo para a leitura
		Arq.close();
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
	public int compara = 0;

/**
*Construtor padrao
*/
	public ArvoreBinaria( ){
		raiz = new No(6);
		Construir ( );
	}

//---------------------------------------------------METODOS PARA A PRIMEIRA ARVORE-----------------------------------------------------
/**
*Metodo para construir a primeira arvore
*/
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
*@throws Exception caso o int a ser inserido ja' existe
*/
	private No inicializar (int x, No i) throws Exception{
		if ( i == null ){
			compara ++;
			i = new No(x);
		}else if ( x < i.elemento ){
			compara += 2;
			i.esq = inicializar (x,i.esq);
		}else if ( x > i.elemento ){
			compara += 3;
			i.dir = inicializar (x,i.dir);
		}else{
			compara += 3;
			throw new Exception ("Erro!");
		}
		return i;
	}

/**
*Metodo para encontrar o No correspondente a um determinado mes
*@param mes int - mes a ser procurado
*@throws Exception caso encontre um no que e' null
*/
	public No BuscarNo (int mes)throws Exception{
		return BuscarNo(mes, raiz);
	}

/**
*Metodo privado para encontrar o No correspondente a um determinado mes
*@param mes int - mes a ser procurado
*@throws Exception caso encontre um no que e' null
*/
	private No BuscarNo (int mes, No i) throws Exception{
		No resp = null;
		if ( i == null ){
			compara ++;
			throw new Exception ("Nao encontrado");
		}else if ( mes == i.elemento ){
			compara += 2;
			resp = i;
		}else if ( mes < i.elemento ){
			compara += 3;
			resp = BuscarNo (mes, i.esq);
		}else if ( mes > i.elemento ){
			compara += 4;
			resp = BuscarNo (mes, i.dir);
		}
		return resp;
	}

/**
*Metodo para inicializar metodo que insere um determinado id na segunda arvore
*@param mes int - mes no qual a Pessoa que tem determinado id nasceu
*@param id int - id a ser inserido
*@throws Exception caso o No seja null
*/ 
	public void inserir ( int mes, int id )throws Exception{
		No i = BuscarNo (mes);
		i.arvore = inserir ( id, i.arvore );
	}

/**
*Metodo para inserir um determinado id na segunda arvore
*@param mes int - mes no qual a Pessoa que tem determinado id nasceu
*@param id int - id a ser inserido
*@throws Exception caso o No seja null
*/
	private No2 inserir (int id, No2 j) throws Exception{
                if ( j == null ){
			compara ++;
                        j = new No2(id);
        	}else if ( id < j.elemento ){
			compara += 2;
                        j.esq = inserir (id, j.esq);
                }else if ( id > j.elemento ){
			compara += 3;
                        j.dir = inserir (id, j.dir);
                }else{
			compara += 3;
                        throw new Exception ("Erro!");
                }
                return j;
        }

/**
*Metodo inicializar metodo para remover determinado id na segunda arvore
*@param id int - id a ser removido
*@throws Exception caso j seja null
*/
	public void remover (int id) throws Exception{
		No i = pesquisarNo(id);
		compara ++;
		if ( i != null ){
			i.arvore = remover (id, i.arvore);
		}
	}

/**
*Metodo para remover determinado id na segunda arvore
*@param id int - id a ser removido
*@param j No2 - No2 a ser analisado
*@return j No2 - dar continuidade a recursividade
*@throws Exception caso j seja null
*/
	public No2 remover (int id, No2 j)throws Exception{
		if(j == null){
			compara ++;
			throw new Exception ("Erro");
    		}else if ( id < j.elemento ) {
			compara += 2;
        		j.esq = remover(id, j.esq);
      		}else if ( id > j.elemento ) {
			compara += 3;
        		j.dir = remover(id, j.dir);
      		}else if ( j.dir == null ) {
			compara += 4;
        		j = j.esq;
      		}else if ( j.esq == null ) {
			compara += 5;
        		j = j.dir;
      		}else{
			compara += 5;
        		j.esq = antecessor(j, j.esq);
        	}
        	return j;
    	}

/**
*Metodo para trocar No removido pelo maior numero a esquerda
*@param i No2 - No2 cujo elemento foi removido
*@param j No2 - i.esq
*@return No2 - alterado ou nao
*/
	private No2 antecessor(No2 i, No2 j) {
		compara ++;
        	if (j.dir != null) {
            		j.dir = antecessor(i, j.dir);
        	} else {
            		i.elemento = j.elemento; 
            		j = j.esq; 
        	}
        	return j;
    	}

/**
*Metodo para inicializar metodo que descobre o No na primeira arvore cuja arvore (a segunda) possui o id correspondente
*@param id int - id a ser procurado
*@return No - No que possui o id ou null
*/
	public No pesquisarNo (int id) {
		return pesquisarNo (id, raiz);
	}

/**
*Metodo que descobre o No na primeira arvore cuja arvore (a segunda) possui o id correspondente
*@param id int - id a ser procurado
*@param i No - No a ser analisado
*@return No - No que possui o id ou null
*/
	public No pesquisarNo (int id, No i){
		boolean resp;
		No r = null;
		compara ++;
		if ( i != null ){
			resp = pesquisarNo (id, i.arvore);
			if ( resp == true ){
                                r = i;
                        }
			compara ++;
			if ( r == null ){
				r = pesquisarNo (id, i.esq);
			} 
			compara ++;
			if ( r == null ){
				r = pesquisarNo (id, i.dir);
			}
		}
		return r;
	}

/**
*Metodo descobrir se existe determinado id na arvore
*@param id int - id a ser procurado
*@param i No2 - No2 a ser analisado
*@return resp boolean - se achou ou nao o Id
*/
	private boolean pesquisarNo (int x, No2 i){
                boolean resp;
                if ( i == null ){
			compara ++;
                        resp = false;
                }else if ( x == i.elemento ){
			compara += 2;
                        resp = true;
                }else if ( x < i.elemento ){
			compara += 3;
                        resp = pesquisarNo (x, i.esq);
                }else{
			compara += 3;
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

/**
*Metodo recursivo de pesquisar
*@param x int - id a ser pesquisado
*@param i No - No a ser analisado
*@return resp boolean - Se o id existe ou nao na arvore
*/
	public boolean pesquisar ( int x, No i ){
		boolean resp = false;
		compara ++;
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
			compara ++;	
			resp = false;
		}else if ( x == j.elemento ){
			compara += 2;
			resp = true;
		}else if ( x < j.elemento ){
			compara += 3;
			MyIO.print("esq ");
			resp = pesquisar (x, j.esq);
		}else if(x > j.elemento){
			compara += 4;
			MyIO.print("dir ");
			resp = pesquisar (x, j.dir);
		}
		return resp;
	}

//-----------------------------------------------------LIGADOS A MAIN-------------------------------------------------------------

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
*@param completa String - String que contem o int que sera' removido
*/
	public void paraRemover ( String completa ) throws Exception{
		int id = Integer.parseInt(SoDigito(completa));
		remover(id);
	}

}


public class TP07Q02ArvoredeArvore{

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
		Arq.openWrite("553285_arvoreArvore.txt");
		Arq.println("553285\t " + ((fim - inicio)/1000.0)  +  "s\t" + "\t" + comparacoes);
		Arq.close( );
	}


	public static void main ( String [ ] args )throws Exception {
		try {

			long inicio = now ( );	

			ArvoreBinaria arvore = new ArvoreBinaria ( );
			int mes;
			Pessoa inserida;
			String linha; 
			Pessoa doarray;

			linha = MyIO.readLine( );
			while ( !(linha.equals("FIM")) ){
				inserida = new Pessoa ( );
				inserida.ler( linha );
				mes = inserida.getMes (inserida.nascimento );
				arvore.inserir(mes, inserida.id);
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
					String aux = linha.substring(2);
					doarray = new Pessoa ( );
					doarray.parsePessoa(aux);
					arvore.inserir(doarray.getMes(doarray.nascimento), doarray.id);
				}
				i ++;
			}

			linha = MyIO.readLine( );
			while ( !(linha.equals("FIM")) ){
				int id = Integer.parseInt(arvore.SoDigito(linha));
				arvore.pesquisar(id); 
				linha = MyIO.readLine( );
			}

			long fim = now ( );
			fazerArquivo (inicio, fim, arvore.compara);

		}catch ( Exception eo ){

		}
	}
} 
