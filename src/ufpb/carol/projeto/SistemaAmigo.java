package ufpb.carol.projeto;


import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    // o List precisa ser inicializado com um construtor ou na linha do private
  

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;
    private int maxMensagens;

    //Chama o construtor abaixo para não repetir os atributos
    //Dita o maximo de mensagens

    public SistemaAmigo(){
        this(1000);

    }

    public SistemaAmigo(int maxMensagens){
        this.mensagens = new ArrayList<Mensagem>();
        this.amigos = new ArrayList<Amigo>();
        this.setMaxMensagens(maxMensagens);
    }


 
   public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException{
        Amigo a = new Amigo(nomeAmigo, emailAmigo);
        if(this.amigos.contains(a)) {
        	throw new AmigoJaExisteException ("Amigo já está cadastrado no sistema");        	
        } else {
        	this.amigos.add(a);         	
        }               

    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        for (Amigo i : amigos) {
            if(i.getEmail().equalsIgnoreCase(emailAmigo)){
                return i;
            }            
         } throw new AmigoInexistenteException("Usuário não cadastrado com este e-mail " + emailAmigo);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente , boolean ehAnonima){
        
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mensagem);        
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente,String emailDestinatario, boolean ehAnonima){
        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<Mensagem>(); 
        // Varrer a lista
        for(Mensagem n: this.mensagens){
            if(n.ehAnonima()){
                mensagensAnonimas.add(n);
                // adicionando as mensagens anonimas na lista
            }

        } return mensagensAnonimas;
         
        }
    //Método que pesquisa as mensagens que são anônimas e retorna uma lista com tais mensagens.

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        
        for(Amigo a: this.amigos){
        	System.out.println(a.getEmail());
             if(a.getEmail().equals(emailDaPessoa)){
            	 System.out.println("1");
                
                a.setAmigoSorteado(emailAmigoSorteado);
                } 
             /*else {
                	throw new AmigoInexistenteException("Não foi encontrado participante com o email" + emailDaPessoa);                 	
                }*/ 
             
            }           
                                                              

    }    

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;     
        
    }

    public boolean existeAmigoNoSistema(String emailPesquisa){
        for(Amigo f: this.amigos){
            if (f.getEmail().equalsIgnoreCase(emailPesquisa)){
                return true;
            }
        }
        return false;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                String emailAmigoSorteado = a.getEmailAmigoSorteado();
                if(emailAmigoSorteado == null){
                    throw new AmigoNaoSorteadoException("Ainda não foi sorteado o amigo secreto de "+ emailDaPessoa);
                } else{
                    return emailAmigoSorteado;
                }

            }
        } throw new AmigoInexistenteException("Não existe pessoa no sistema com o email "+ emailDaPessoa);

        }

	public int getMaxMensagens() {
		return maxMensagens;
	}

	public void setMaxMensagens(int maxMensagens) {
		this.maxMensagens = maxMensagens;
	}

	

    } 
