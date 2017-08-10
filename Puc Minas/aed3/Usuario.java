//package aed3;
import java.io.*;

public class Usuario implements Registro {
    protected int codigo;
    protected String nome;
    protected String email;
    protected String senha;
    protected String descricao;
    protected String contato;
    protected boolean orientador;
    protected boolean assinante;
    protected boolean online;
    protected float bonus;

    public Usuario(int codigo, String nome, String email, String senha, 
        String descricao, String contato, boolean orientador, 
        boolean assinante, boolean online, float bonus) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.descricao = descricao;
        this.contato = contato;
        this.orientador = orientador;
        this.assinante = assinante;
        this.online = online;
        this.bonus = bonus;
    }
    public Usuario() {
        this.codigo = 0;
        this.nome = "";
        this.email = "";
        this.senha = "";
        this.descricao = "";
        this.contato = "";
        this.orientador = false;
        this.assinante = false;
        this.online = false;
        this.bonus = 0.0F;
    }
    
    public void setCodigo(int c) {
        codigo = c;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getString() {
        return nome;
    }
    
    public String toString() {
        return "\nCódigo.....:" + codigo +
                "\nNome......:" + nome +
                "\nEmail.....:" + email +
                "\nSenha.....:" + senha +
                "\nDescrição.:" + descricao +
                "\nContato...:" + contato +
                "\nOrientador:" + orientador +
                "\nAssinante.:" + assinante +
                "\nOnline....:" + online +
                "\nbonus.....:" + bonus;

    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream registro = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( registro );
        saida.writeInt(codigo);
        saida.writeUTF(nome);
        saida.writeUTF(email);
        saida.writeUTF(senha);
        saida.writeUTF(descricao);
        saida.writeUTF(contato);
        saida.writeBoolean(orientador);
        saida.writeBoolean(assinante);
        saida.writeBoolean(online);
        saida.writeFloat(bonus);
        return registro.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream registro = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(registro);
        codigo = entrada.readInt();
        nome = entrada.readUTF();
        email = entrada.readUTF();
        senha = entrada.readUTF();
        descricao = entrada.readUTF();
        contato = entrada.readUTF();
        orientador = entrada.readBoolean();
        assinante = entrada.readBoolean();
        online = entrada.readBoolean();
        bonus = entrada.readFloat();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int compareTo( Object b ) {
        return codigo - ((Usuario)b).codigo;
    }

    /*
    public int compareTo( Object b ) {
        return titulo.compareTo(((Livro)b).titulo);
    }
    */
    
}
