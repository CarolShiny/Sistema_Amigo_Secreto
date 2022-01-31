package ufpb.carol.projeto;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos (String texto, String emailRemetente, boolean anonima) {

        //super pegou os valores da classe m�e
        super(texto, emailRemetente, anonima);
    }
    public String getTextoCompletoAExibir(){

        //super � para chamar os m�todos da classe m�e, mas nesse caso pode s� usar ehAnonima.
        
        if(super.ehAnonima()){

            return "Mensagem para todos. Texto: "+ getTexto(); // ou usar s� super.getTexto()
        } else{
            return "Mensagem de "+ getEmailRemetente();
        }
    }

    
}

