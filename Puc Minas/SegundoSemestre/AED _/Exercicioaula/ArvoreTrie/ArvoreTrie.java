class ArvoreTrie {
	private No raiz;

	public ArvoreTrie(){
		raiz = new No();
	}

	public void inserir(String s) throws Exception {
		inserir(s, raiz, 0);
	}
	public void inserir(String s, No no, int i) throws Exception {
		int local = no.hash(s.charAt(i));

		if(no.prox[local] == null){
			no.prox[local] = new No(s.charAt(i));

			if(i == s.length() - 1){
				System.out.print("(folha)");
				no.prox[local].folha = true;
			}else{
				inserir(s, no.prox[local], i + 1);
			}

		} else if (no.folha == false){
			inserir(s, no.prox[local], i + 1);

		} else {
			throw new Exception("Erro ao inserir!");
		} 
	}


	public boolean pesquisar(String s) throws Exception {
		return pesquisar(s, raiz, 0);
	}

	public boolean pesquisar(String s, No no, int i) throws Exception {
		boolean resp;
		int local = no.hash(s.charAt(i));

		if(no.prox[local] == null){
			resp = false;
		} else if(i == s.length() - 1){
			if (no.prox[local].folha == true){
				resp = true;
			}else{
				resp = false;
			}
		} else if( i < s.length() - 1 ){
			resp = pesquisar(s, no.prox[local], i + 1);
		} else {
			throw new Exception("Erro ao pesquisar!");
		}

		return resp;
	}

	public void mostrar(){
		mostrar("", raiz);
	}

	public void mostrar(String s, No no) {
		if(no.folha == true){
			System.out.println("Palavra: " + (s + no.elemento));
		} else {
			for(int i = 0; i < no.prox.length; i++){
				if(no.prox[i] != null){
					mostrar(s + no.elemento, no.prox[i]);
				}
			}
		}
	}

	public static ArvoreTrie merge ( ArvoreTrie a, ArvoreTrie b )throws Exception{
		ArvoreTrie resp = new ArvoreTrie( );
		merge(resp, "", a.raiz);
		merge(resp, "", b.raiz);
		return resp;
	} 

	public static void merge (ArvoreTrie a, String s, No no)throws Exception{
		if ( no.folha == true ){
			//String total = s + no.elemento;
			String total = s;
			//total.trim( );
			a.inserir(total);
		}else{
			for(int i = 0; i < no.prox.length; i++){
				if ( no.prox[i] != null ){
					//merge (a, s + no.elemento, no.prox[i]);
					merge (a, s + no.prox[i].elemento, no.prox[i]);
				}
			}
		}
	}

}
