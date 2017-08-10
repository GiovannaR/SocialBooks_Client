/**
*Tp7
*Questao07 - Hash Indireta com Lista Simples
*@author Giovanna Avila Riqueti
*@version 1 18/11/2016
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

class Celula {
	Pessoa elemento;
	Celula prox;

	public Celula( ){
		this(new Pessoa( ));
	}

	public Celula (Pessoa elemento){
		this.elemento = elemento.clonar( );
		this.prox = null;
	}

}

class Lista {
	private Celula primeiro, ultimo;
	public static int compara = 0;

/**
*Construtor padrao
*/
	public Lista ( ){
		this.primeiro = new Celula ( );
		ultimo = primeiro;
	}

/**
*Metodo que retorna o ponteiro primeiro.prox
*@return Celula - ponteiro primeiro.prox
*/
	public Celula getPrimeiro( ){
		return this.primeiro.prox;
	}	

/**
*Metodo para inserir uma Pessoa no final da lista
*@param x Pessoa - pessoa a ser inserida
*/	
	public void inserir (Pessoa x){
		ultimo.prox = new Celula (x.clonar( ));
		ultimo = ultimo.prox;
	}

/**
*Metodod para remover uma Pessoa no inicio da Lista
*@throws Exception quando nao ha' nada para remover
*@return elemento Pessoa - Pessoa removida
*/
	public Pessoa removerInicio ( )throws Exception{
		compara ++;
		if ( primeiro == ultimo ){
			throw new Exception ("Erro!");
		}	
		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Pessoa elemento = primeiro.elemento.clonar( );
		tmp.prox = null;
		tmp = null;
		return elemento;
	}

/**
*Metodo para remover uma Pessoa da lista em determinada posicao
*@param pos int - posicao da qual a Pessoa deve ser removida
*@throws Exception quando o tamanho a se remover nao existe na lista
*@return elemento Pessoa - Pessoa removida
*/ 
	public Pessoa remover (int pos) throws Exception{
		Pessoa resp;
		int tamanho = tamanho ( );
		compara ++;
		if ( pos < 0 || pos > tamanho( ) || primeiro == ultimo ){
			throw new Exception ("Erro!");
		}else if ( pos == 0 ){
			resp = removerInicio( );
		}else if ( pos == (tamanho - 1) ){
			resp = removerFim( );
		}else{
			Celula i = primeiro;
			for (int j = 0; j < pos ; j++, i = i.prox );
			Celula tmp = i.prox;
			resp = tmp.elemento.clonar( );	
			i.prox = tmp.prox;
			tmp.prox = null;;
			i = tmp = null;
		}
		return resp;
	}

/**
*Metodo para remover uma Pessoa no final da Lista
*@throws Exception quando nao ha' nada para remover
*@return elemento Pessoa - Pessoa removida
*/
	public Pessoa removerFim ( ) throws Exception{
		compara ++;
		if ( primeiro == ultimo ){
                        throw new Exception ("Erro!");
                }
		Celula i;
		for( i = primeiro; i.prox != ultimo; i = i.prox );
		Pessoa elemento = ultimo.elemento.clonar( );
                ultimo = i;
                i = ultimo.prox = null;
		return elemento;
	}

/**
*Funcao que retorna o tamanho da lista
*@return quantidade int - tamanho da lista
*/
	public int tamanho ( ){
                int quantidade = 0;
                try{
                        for ( Celula i = primeiro.prox; i != null; i = i.prox ){
                                quantidade ++;
                        }
                }catch( Exception es ){
                }
                return quantidade;
        }

/**
*Metodo para pesquisar se determinada Pessoa com determinado id existe na lista
*@param id int - id a ser procurado
*@return resp boolean - se existe ou nao
*/
	public boolean pesquisar (int id){
		boolean resp = false;
		Celula i = primeiro.prox;
		compara ++;
		while ( i != null ){
			compara += 2; //Para o "while " e para o "if"
			if ( i.elemento.getId( ) == id ){	
				resp = true;
				i = null;
			}else{
				i = i.prox;
			}
		}
		return resp;
	}

/**
*Metodo que retorna a posicao que a Pessoa com determinado id se encontra na Lista
*@param id int - id a ser procuradp
*@return resp - posicao da Pessoa com determinado id
*/
	public int posicao (int id){
		int resp = 0;
		Celula i = primeiro.prox;
		compara ++;		
		while( i.elemento.getId( ) != id ){
			compara ++;
			resp ++;
			i = i.prox;
		}
		return resp;
	}


}

class HashLSimples{

	Lista [ ] tabela;
	int tamTabela;

/**
*Construtor padrao
*/
	public HashLSimples( ){
		this(21);
	}

/**
*Construtor alternativo
*@param n int - tamanho da tabela Hash
*/
	public HashLSimples (int n){
		tamTabela = n;
		tabela = new Lista [tamTabela];
		
		for (int i = 0; i < tamTabela; i++){
			tabela[i] = new Lista ( );
		}
	}

/**
*Metodo de transformacao
*@param id int - id da Pessoa 
*@return int - posicao na tabela correspondente a uma Pessoa com determinado id
*/
	public int hash (int id){
		return (id % tamTabela);
	}
/**
*Metodo para inserir na Lista da tabela Hash
*@param x Pessoa - Pessoa a ser inserida
*/
	public void inserir (Pessoa x){
		int local = hash(x.getId( ));
		tabela[local].inserir(x);
	}
/**
*Metodo para pesquisar na Lista da tabela Hash
*@param id int - id a ser pesquisado
*@return boolean - se o id existe em uma das Listas da tabela Hash ou nao
*/
	public boolean pesquisar (int id){
		int local = hash(id);
		return tabela[local].pesquisar(id);
	}	
/**
*Metodo para remover uma Pessoa das Listas da tabela Hash
*@param id int - id da Pessoa a ser removida
*@throws Exception - Caso nao tenha nada para remover
*/
	public void remover (int id) throws Exception{
		if ( pesquisar(id) ){
			int local = hash(id);
			int remocao = tabela[local].posicao(id);
			Pessoa removida = tabela[local].remover(remocao);
		}
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
*@throws Exception - caso nao tenha elemento para remover
*/
	public void paraRemover ( String completa ) throws Exception{
		Pessoa removida = new Pessoa ( );
		int id = Integer.parseInt(Pessoa.SoDigito(completa));
		remover(id);
	}

}

public class TP07Q07HashLSimples{

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
		Arq.openWrite("553285_HashIndireta.txt");
		Arq.println("553285\t " + ((fim - inicio)/1000.0)  +  "s\t" + "\t" + comparacoes);
		Arq.close( );
	}

	public static void main ( String [ ] args )throws Exception{
		try{

			long inicio = now ( );
			
			HashLSimples array = new HashLSimples ( );		
			String linha;
			Pessoa inserida;
			Pessoa doarray = new Pessoa ( );

			linha = MyIO.readLine( );
			while ( linha.equals("FIM") == false ){
				inserida = new Pessoa ( );
				inserida.ler( linha );
				array.inserir(inserida);
				linha = MyIO.readLine( );
			}

			linha = MyIO.readLine( );
			int quantidade = Integer.parseInt(linha);	
			int i = 0;
			while ( i < quantidade ){
				linha = MyIO.readLine( );
				if ( array.isRemover(linha) ){
					array.paraRemover(linha);
				}else{
					Pessoa certa = doarray.Outros(linha);
					array.inserir(certa);
				}
				i ++;
			}

			int id;
			linha = MyIO.readLine( );
			while ( linha.equals("FIM") == false ){
				id = Integer.parseInt(Pessoa.SoDigito(linha));
				if ( array.pesquisar(id) ){
					MyIO.println("SIM");
				}else{
					MyIO.println("NAO");
				}
				linha = MyIO.readLine( );
			}

			long fim = now ( );
			fazerArquivo (inicio, fim, Lista.compara);

		}catch( Exception eo ){
		}
	}

}

