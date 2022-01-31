package ufpb.carol.projeto;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario; 

    // Quando uma classe extende da outra é importante colocar o construtor aqui da classe mãe

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

    // Uma classe pode ser abstrata ou apresentar um método abstrato(isso é quando ela é uma classe filha de uma classe abstrata)

     public String getTextoCompletoAExibir(){
        //super é para chamar os métodos da classe mãe
          if(super.ehAnonima()){
             return "Mensagem para "+ getEmailDestinatario() + ". Texto: "+ getTexto(); // ou usar só super.getTexto()
            } else{
                return "Mensagem de "+ getEmailRemetente() + "para " + getEmailDestinatario() + ".Texto: " + getTexto();
            }        
    }
    
}
