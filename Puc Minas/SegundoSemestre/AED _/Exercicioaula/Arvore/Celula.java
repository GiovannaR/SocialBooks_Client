class Celula{
	private Contato contato;
	private Celula prox;
	
	Celula(){
		setContato(new Contato());
		setProx(null);
	}
	Celula(Contato contato){
		setContato(contato);
		setProx(null);
	}

	public void setContato(Contato contato){
		this.contato = contato;
	}

	public Contato getContato(){
		return this.contato;
	}
		
	public void setProx(Celula prox){
		this.prox = prox;
	}
		
	public Celula getProx(){
		return this.prox;
	}
	
}



