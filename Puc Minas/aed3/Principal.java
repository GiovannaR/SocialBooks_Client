//package aed3;
import java.io.*;

public class Principal{

	public static void main ( String [ ] args){
		Mensagem Novo = new Mensagem(1,2, 7,22, "Ola" , true);
		MyIO.println(Novo.toString());
	}

}