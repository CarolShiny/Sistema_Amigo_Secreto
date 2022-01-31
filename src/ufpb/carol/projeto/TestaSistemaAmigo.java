package ufpb.carol.projeto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) throws AmigoJaExisteException {
        
        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo("José", "jose@jose.com");
        sistema.cadastraAmigo("Maria", "maria@maria.com");

        try {
            sistema.configuraAmigoSecretoDe("jose@jose.com", "maria@maria.com");
             sistema.configuraAmigoSecretoDe("maria@maria.com", "jose@jose.com");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        sistema.enviarMensagemParaAlguem("Oi amigo José" , "maria@maria.com", "jose@jose.com", true);

        sistema.enviarMensagemParaTodos("Que bom participar dessa brincadeira", "maria@maria.com", true);

        List<Mensagem> mensagensAnonimas = sistema.pesquisaMensagensAnonimas();
        for(Mensagem m: mensagensAnonimas){
            System.out.println(m.getTextoCompletoAExibir());
        }
        try {
            String emailDoAmigoDeJose = sistema.pesquisaAmigoSecretoDe("jose@jose.com");
            if(emailDoAmigoDeJose.equals("maria@maria.com")){
                System.out.println("Ok");

            }

        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            e.printStackTrace();
        }

        
    
}
}
