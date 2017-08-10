class Agenda{
	private No raiz;

	Agenda(){
		setRaiz(null);	
	}

	public void setRaiz(No raiz){
		this.raiz = raiz;
	}

	public No getRaiz(){
		return this.raiz;
	}
	
	public No inserir(){
		return null;
	}

	public void inserir(Contato contato){

	}

	public void remover(String nome){

	}

	public boolean pesquisar(String nome){
		return true;
	}

	public boolean pesquisar(int cpf){
		return true;
	}
}
