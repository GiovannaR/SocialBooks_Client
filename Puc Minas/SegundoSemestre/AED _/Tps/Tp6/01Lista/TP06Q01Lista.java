/**
*Tp6
*Questao01 - Lista com alocacao flexivel
*@author Giovanna Avila Riqueti
*@version 1 09/10/2016
*/
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
	public Pessoa clone ( ){
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
	public String SoDigito ( String suja ){
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

class Celula{

	public Pessoa elemento;
	public Celula prox;

/**
*Construtor padrao
*/
	public Celula( ){
		this(new Pessoa( ));
	}

/**
*Construtor alternativo
*@param x Pessoa - valor do elemento
*/
	public Celula(Pessoa x){
		this.elemento = x.clone( );
		this.prox = null;
	}
}

class Lista{

	private Celula primeiro, ultimo;
	
/**
*Construtor padrao
*/
	public Lista ( ){
		primeiro = new Celula ( );
		ultimo = primeiro;
	}

/**
*Metodo para inserir Pessoa no inicio da lista
*@param x Pessoa - Pessoa a ser inserida
*/
	public void inserirInicio (Pessoa x){
		Celula tmp = new Celula (x);
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if ( primeiro == ultimo ){
			ultimo = tmp;
		}
		tmp = null;
	}

/**
*Inserir uma Pessoa em ua determinada posicao da lista
*@param x Pessoa - Pessoa a ser inserida
*@param pos int - posicao para inserir a Pessoa
*@throws Exception quando pos corresponder a uma posicao inexistente da Lista
*/
	public void inserir (Pessoa x, int pos) throws Exception {
                int tamanho = tamanho( );
                if ( pos < 0 || pos > tamanho ){
			MyIO.println("Inseir");
                        throw new Exception("Erro!");
                }else if ( pos == 0 ){
                        inserirInicio(x);
                }else if ( pos == tamanho ){
                        inserirFim(x);
                }else{
                        Celula i = primeiro;
                        for ( int j = 0; j < pos; j++, i = i.prox );
                        Celula tmp = new Celula (x);
                        tmp.prox = i.prox;
                        i.prox = tmp;
                        tmp = i = null;
                }
        }

/**
*Metodo para inserir uma Pessoa no final da lista
*@param x Pessoa - pessoa a ser inserida
*/	
	public void inserirFim (Pessoa x){
                ultimo.prox = new Celula (x);
                ultimo = ultimo.prox;
        }

/*
*Metodo para remover uma Pessoa da lista em determinada posicao
*@param pos int - posicao da qual a Pessoa deve ser removida
*@throws Exception quando o tamanho a se remover nao existe na lista
*@return elemento Pessoa - Pessoa removida
*/ 
	public Pessoa remover (int pos) throws Exception {
		Pessoa elemento;	
		int tamanho = tamanho( );
		if ( pos < 0 || pos > tamanho ){
                        MyIO.println("Remover");
			throw new Exception("Erro!");
                }else if ( pos == 0 ){
                        elemento = removerInicio( );
                }else if ( pos == tamanho ){
			elemento = removerFim( );
		}else{
			Celula i = primeiro;
			for ( int j = 0; j < pos; j ++, i = i.prox );
			Celula tmp = i.prox;
			elemento = tmp.elemento.clone( );	
			i.prox = tmp.prox;
			tmp.prox = null;;
			i = tmp = null;
		}
		return elemento;
	}
	
/**
*Metodod para remover uma Pessoa no inicio da Lista
*@throws Exception quando nao ha' nada para remover
*@return elemento Pessoa - Pessoa removida
*/
	public Pessoa removerInicio ( ) throws Exception{
		if ( primeiro == ultimo ){
			MyIO.println("RemoverInicio");
			throw new Exception ("Erro");
		}
		Celula tmp = primeiro;	
		primeiro = primeiro.prox;
		Pessoa elemento = primeiro.elemento.clone( );
		tmp.prox = null;
		tmp = null;
		return elemento;
	}

/**
*Metodo para remover uma Pessoa no final da Lista
*@throws Exception quando nao ha' nada para remover
*@return elemento Pessoa - Pessoa removida
*/
	public Pessoa removerFim ( ) throws Exception {
                if ( primeiro == ultimo ){
                        MyIO.println("Remover fim");
			throw new Exception("Erro");
                }
                Celula i;
                for (i = primeiro; i.prox != ultimo; i = i.prox);
                Pessoa elemento = ultimo.elemento.clone( );
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
*Identificar o metodo de remocao e retornar: (R) "nome da Pessoa removida"
*@param analisada String - Possui as informacoes de qual metodo de remover se deve usar
*@return resposta String - (R) "nome da pessoa removida"
*/
	public String Removidos (String analisada) throws Exception {
		String resposta = "(R) ";
		Pessoa semposicao = new Pessoa ( );
		if (analisada.contains("RI")){
			semposicao = removerInicio ( );
		}else if(analisada.contains("R*")){
			String [ ] parte1 = analisada.split(" ");
			int inteiro = Integer.parseInt(parte1[1]);
			semposicao = remover (inteiro);
		}else if(analisada.contains("RF")){
			semposicao = removerFim ( );
		}
		resposta += semposicao.getNome( );
		return resposta;
	}

/**
*Identificar qual o metodo de inserir e executa-lo
*@param pessoa Pessoa - Pessoa a ser inserida
*@param analisada String - Contem a pessoa e as informacoes do metodo a ser utilizado
*/
	public void qualMetodo ( Pessoa pessoa, String analisada ) throws Exception{
		if ( analisada.contains("II")){
			inserirInicio (pessoa); 
		}else if ( analisada.contains("I*")){
			String [ ] parte1 = analisada.split(" ");
			int posicao = Integer.parseInt(parte1[1]);
			inserir (pessoa, posicao);
		}else if ( analisada.contains("IF")){
			inserirFim (pessoa);
		}
	}

/**
*Imprimir pessoas contidas no ponteiro
*/
	public void imprimir( ){
		for ( Celula i = primeiro.prox; i != null ; i = i.prox ){
			String id = String.valueOf(i.elemento.getId( ));
			String idade = String.valueOf(i.elemento.getIdade( ));
			MyIO.println ( id + " ## " + i.elemento.getNome( ).toString( ) + " ## " + i.elemento.getNacionalidades( ).toString( ) + " ## " + i.elemento.getDataN( ).toString( ) + " ## " + i.elemento.getLocalN( ).toString( ) + " ## " + i.elemento.getDataM( ).toString( ) + " ## " + i.elemento.getLocalM( ).toString( ) + " ## " + idade );
		
		}
	}


}

class TP06Q01Lista {

		public static void main ( String [ ] args ) throws Exception{
			try{
				MyIO.setCharset("UTF8");
				int quantidade;
				int i = 0;
				String linha;
				Lista lista = new Lista( );
				Pessoa inserida = new Pessoa ( );	
				Pessoa doarray = new Pessoa ( );	

				linha = MyIO.readLine( );
				while ( !linha.equals("FIM")){
					inserida.ler( linha );
					lista.inserirFim(inserida);
					linha = MyIO.readLine( );
				}

				linha = MyIO.readLine( );
				quantidade = Integer.parseInt(linha);
				while ( i < quantidade ){
					linha = MyIO.readLine( );
					if ( lista.isRemover(linha) ){
						String imprimida = lista.Removidos(linha);
						MyIO.println(imprimida);
					}else{
						Pessoa certa = doarray.Outros(linha);
						lista.qualMetodo (certa,linha);
					}
					i++;
				}
				lista.imprimir( );
			}catch ( Exception es ){
				MyIO.println("Erro: " + es.getMessage());
			}
	}

}
