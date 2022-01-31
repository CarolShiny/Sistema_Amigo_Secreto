package ufpb.carol.projeto;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario; 

    // Quando uma classe extende da outra � importante colocar o construtor aqui da classe m�e

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,boolean anonima){
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }    

    public String getEmailDestinatario() {
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    // Uma classe pode ser abstrata ou apresentar um m�todo abstrato(isso � quando ela � uma classe filha de uma classe abstrata)

     public String getTextoCompletoAExibir(){
        //super � para chamar os m�todos da classe m�e
          if(super.ehAnonima()){
             return "Mensagem para "+ getEmailDestinatario() + ". Texto: "+ getTexto(); // ou usar s� super.getTexto()
            } else{
                return "Mensagem de "+ getEmailRemetente() + "para " + getEmailDestinatario() + ".Texto: " + getTexto();
            }        
    }
    
}
