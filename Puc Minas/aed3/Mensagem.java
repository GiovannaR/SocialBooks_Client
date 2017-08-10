//package aed3;
import java.io.*;

public class Mensagem implements Registro {
    protected int codigo;
    protected int idremetente;
    protected int iddestinatario;
    protected long dataHora;
    protected String mensagem;
    protected boolean lido;

    public Mensagem(int codigo, int idremetente, int iddestinatario, long dataHora, 
        String mensagem, boolean lido ) {
        this.codigo = codigo;
        this.idremetente = idremetente;
        this.iddestinatario = iddestinatario;
        this.dataHora = dataHora;
        this.mensagem = mensagem;
        this.lido = lido;
    }
    public Mensagem() {
        this.codigo = 0;
        this.idremetente = 0;
        this.iddestinatario = 0;
        this.dataHora = 0;
        this.mensagem = "";
        this.lido = false;
    }
    
    public void setCodigo(int c) {
        codigo = c;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getString() {
        return mensagem;
    }
    
    public String toString() {
        return "\nCodigo.........:" + codigo +
                "\nidremetente...:" + idremetente +
                "\niddestinatario:" + iddestinatario +
                "\nDataHora......:" + dataHora +
                "\nMensagem......:" + mensagem +
                "\nLido..........:" + lido;

    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream registro = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( registro );
        saida.writeInt(codigo);
        saida.writeInt(idremetente);
        saida.writeInt(iddestinatario);
        saida.writeLong(dataHora);
        saida.writeUTF(mensagem);
        saida.writeBoolean(lido);
        
        return registro.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream registro = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(registro);
        codigo = entrada.readInt();
        idremetente = entrada.readInt();
        iddestinatario = entrada.readInt();
        dataHora = entrada.readLong();
        mensagem = entrada.readUTF();
        lido = entrada.readBoolean();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int compareTo( Object b ) {
        return codigo - ((Mensagem)b).codigo;
    }

    /*
    public int compareTo( Object b ) {
        return titulo.compareTo(((Livro)b).titulo);
    }
    */
    
}
