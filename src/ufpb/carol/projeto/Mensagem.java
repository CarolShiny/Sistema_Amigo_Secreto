package ufpb.carol.projeto;

public abstract class Mensagem {

    private String texto;
    private String emailRemetente;
    private boolean anonima; 
   
    public Mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;        
    }

    // Sobrecarga de construtor para pegar o emailRemetente no MensagemParaAlguem
    /*public Mensagem(String emailRemetente){
        this.emailRemetente = emailRemetente;
    }   
    */

    public String getTexto(){
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

// Método abstract usado em uma classe filha dessa aqui
    public abstract String getTextoCompletoAExibir();       
    

    public String getEmailRemetente() {
        return this.emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnonima(){
        return this.anonima;
    }
    
}
