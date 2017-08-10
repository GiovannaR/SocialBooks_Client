/**
*Tp5
*Questao12 - Radixsort
*
*Aluna: Giovanna Avila Riqueti
*Matricula:553285
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


}


class Lista{

	Pessoa [ ] array;
	int n;
	int compara = 0;
	int movimenta = 0;

/**
*Construtor padrao
*/
	public Lista( ){
	}

/**
*Construtor alternativo
*@param tamanho int - tamanho do array 
*/
	public Lista (int tamanho){
		array = new Pessoa[tamanho];
		n = 0;
	}


/**
*Inserir uma Pessoa no fim
*@param pessoa Pessoa - Pessoa a ser inserida
*/ 
	public void inserirFim (Pessoa pessoa){
		if ( n <= array.length ){
			array[n] = pessoa.clonar( );
			n ++;
		}else{
			MyIO.println("Erro: n maior que o array.length");
		}
	}

/**
*Metodo para ordenar que compara todos os algarismos do numero e possui um array de 0 a 10 que ajuda em sua ordenacao
*/
	public void radixsort ( ){
		Pessoa [ ] ordenado = new Pessoa [n];
		int max = getMaior( );
		int min = getMenor( );
		int novomin = Math.abs(min);
		int regulador = max + novomin;
		int elevadoa10 = 1;

		while ( regulador/elevadoa10 > 0 ){
			int [ ] count = new int [10];
			for ( int i = 0; i < n; count[((doidao(array[i]) + novomin)/elevadoa10) % 10]++, i++ );

			for ( int i = 1; i < 10; count[i] += count[i - 1], i ++ );

			for ( int i = n - 1; i >= 0; movimenta++, i-- ){
				ordenado[ count[((doidao(array[i]) + novomin)/elevadoa10) % 10] - 1] = array[i].clonar( );
				count[((doidao(array[i]) + novomin)/elevadoa10) % 10]--; 
			}

			for ( int i = 0; i < n; i++ ){
				array[i] = ordenado[i].clonar( );
				movimenta ++;
			}
			
			elevadoa10 *= 10;
		}
	}

/**
*Pegar somente o ano da data de nascimento
*OBS: Vou colocar o 0 na frente dos negativos e o 1 na frente dos positivos, pois o radixsort analisa os algarismos um por um e com isso, os negativos ficarao antes dos positivos
*@param a String - data de nascimento
*@return int - ano de nascimento
*/
	public int pegarAno (String a){
		String anoa = "";

		if ( a.contains ("de ") ){
			String [ ] parte1 = a.split("de ");
			anoa = Pessoa.SoDigito(parte1[2]);
		}else{
			anoa = "0000";
		}
		if ( a.contains ("a.C.") ){
			if ( a.contains ("ca.") ){
				anoa = "-" + Pessoa.SoDigito (a);
			}else{
				String [ ] parte2 = a.split( "de " );
				anoa = "-" + Pessoa.SoDigito (parte2[2]);
			}
		}
		return  Integer.parseInt(anoa);
	}

/**
*Metodo que retorna o algarismo doidao para datas de morte negativas e positivas
*@param a Pessoa - pessoa a ser estraida a data de morte
*@return int - algarismo doidao
*/
	public int doidao ( Pessoa a ){
		int ano = pegarAno ( a.getDataM( ) );	
		return (ano*1000) + a.getId( );	
	}	

/**
*Metodo para achar o maior numero 
*@return max int - maior numero 
*/
	public int getMaior ( ){
		int max;
		max = doidao(array[0]);
                for ( int i = 0; i < n; i ++ ){
                        if ( doidao(array[i]) > max ){
                               	max = doidao(array[i]);
                        }
                }
		return max;
	}

/**
*Metodo para achar o menor numero 
*@return max int - menor numero 
*/
        public int getMenor ( ){
                int min;
                min = doidao(array[0]);
                for ( int i = 0; i < n; i ++ ){
                        if ( doidao(array[i]) < min ){
                                min = doidao(array[i]);
                        }
                }
                return min;
        }


/**
*Imprimir todo o array
*/
	public void imprimirArray( ){
		for ( int i = 0; i < n; i ++ ){
			String id = String.valueOf(array[i].getId( ));
			String idade = String.valueOf(array[i].getIdade( ));
			MyIO.println ( id + " ## " + array[i].getNome( ).toString( ) + " ## " + array[i].getNacionalidades( ).toString( ) + " ## " + array[i].getDataN( ).toString( ) + " ## " + array[i].getLocalN( ).toString( ) + " ## " + array[i].getDataM( ).toString( ) + " ## " + array[i].getLocalM( ).toString( ) + " ## " + idade );
		
		}
	}

/**
*Funcao que retorna o numero de comparacoes feitas
*@return int - numero de comparacoes
*/
	public int getComparacoes ( ) {
		return this.compara;
	}

/**
*Funcao que retorna o numero de movimentacoes feitas
*@return int - numero de comparacoes
*/
        public int getMovimentacoes ( ) {
                return this.movimenta;
        }

}

	
class TP05Q12Radixsort{

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
	public static void fazerArquivo ( long inicio, long fim, int comparacoes, int movimentacoes ){
		Arq.openWrite("553285_Radixsort.txt");
		Arq.println("553285\t " + ((fim - inicio)/1000.0)  +  "s\t" + "\t" + comparacoes + "\t\t" + movimentacoes);
		Arq.close( );
	}

	public static void main ( String [ ] args ){
		
		//long inicio = now ( );

		MyIO.setCharset("UTF8");
		int quantidade = 0;
		String linha;
		Lista lista = new Lista(1000);
		Pessoa inserida = new Pessoa ( );	
		Pessoa doarray = new Pessoa ( );	

		linha = MyIO.readLine( );
		while ( !linha.equals("FIM")){
			inserida.ler( linha );
			lista.inserirFim(inserida);
			quantidade ++;
			linha = MyIO.readLine( );
		}
		lista.radixsort( );
		lista.imprimirArray( );
		//long fim = now ( );
		//fazerArquivo (inicio, fim, lista.getComparacoes( ), lista.getMovimentacoes( ));
	}
}
