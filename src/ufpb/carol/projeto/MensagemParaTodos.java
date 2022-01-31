package ufpb.carol.projeto;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos (String texto, String emailRemetente, boolean anonima) {

        //super pegou os valores da classe mãe
        super(texto, emailRemetente, anonima);
    }
    public String getTextoCompletoAExibir(){

        //super é para chamar os métodos da classe mãe, mas nesse caso pode só usar ehAnonima.
        
        if(super.ehAnonima()){

            return "Mensagem para todos. Texto: "+ getTexto(); // ou usar só super.getTexto()
        } else{
            return "Mensagem de "+ getEmailRemetente();
        }
    }

    
}

