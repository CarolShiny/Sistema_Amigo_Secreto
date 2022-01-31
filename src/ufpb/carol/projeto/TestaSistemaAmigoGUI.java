package ufpb.carol.projeto;

import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {
    
    public static void main(String [] args) throws AmigoJaExisteException {
        int maxMensagens = Integer.parseInt(JOptionPane.showInputDialog("Qual o número máximo de mensagens que o sistema suporta?")); 

        SistemaAmigo sistema = new SistemaAmigo(maxMensagens);

        int numAmigos = Integer.parseInt(JOptionPane.showInputDialog("Quantos amigos participaram da brincadeira?"));

        for(int k=0; k<numAmigos; k++){
            String nome = JOptionPane.showInputDialog("Qual o nome?");
            String email = JOptionPane.showInputDialog("Qual o email?");
            sistema.cadastraAmigo(nome,email); 
        }

        for (int k=0; k< numAmigos; k++){
            String emailDaPessoa = JOptionPane.showInputDialog("Qual o e-mail do participante da brincadeira?");
            String emailAmigoSorteado = JOptionPane.showInputDialog("Qual o e-mail do amigo secreto sorteado para "+ emailDaPessoa);
            try {
                sistema.configuraAmigoSecretoDe(emailDaPessoa, emailAmigoSorteado);
                
            } catch (Exception e) {
                JOptionPane.showInputDialog(e.getMessage());
            }
        }
        String emailRemetente = JOptionPane.showInputDialog("Qual o e-mail de quem mandará mensagem?");
        String textoMensagem = JOptionPane.showInputDialog("Qual o texto da mensagem?");
        String ehAnonima = JOptionPane.showInputDialog("A mensagem é anônima? 1-Sim 2-Não");

        if(ehAnonima.equals("1")){
            sistema.enviarMensagemParaTodos(textoMensagem, emailRemetente, true);
        }else{
            sistema.enviarMensagemParaTodos(textoMensagem, emailRemetente, false);
        }                
    }    
}
