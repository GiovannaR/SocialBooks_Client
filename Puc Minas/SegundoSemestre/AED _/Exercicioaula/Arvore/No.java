class No{
	private Celula primeiro,ultimo;
	private No esq,dir;
	private char letra;

	No(){
	  	setDir(null); setEsq(null); 		
		setPrimeiro(new Celula()); setUltimo(new Celula());
		setLetra(' ');
	}

	No(char letra){
		setDir(null); setEsq(null);             
                setPrimeiro(new Celula()); setUltimo(new Celula());
		setLetra(letra);
	}


	public void setLetra(char letra){
		this.letra = letra;
	}

	public char getLetra(){
		return this.letra;
	}

	public void setPrimeiro(Celula primeiro){
		this.primeiro = primeiro;
	}

	public Celula getPrimeiro(){
		return this.primeiro;
	}

	public void setUltimo(Celula utlimo){
		this.ultimo = ultimo;
	}

	public Celula getUltimo(){
		return this.ultimo;
	}

	public void setDir(No dir){
		this.dir = dir;
	}

	public No getDir(){
		return this.dir;
	}

	public void setEsq(No esq){
		this.esq = esq;
	}

	public No getEsq(){
		return this.esq;
	}
}

