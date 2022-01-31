package ufpb.carol.projeto;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class SistemaAmigoMap {
    // o List precisa ser inicializado com um construtor ou na linha do private
  

    private List<Mensagem> mensagens;
    private Map<String,Amigo> amigos;
    private int maxMensagens;

    //Chama o construtor abaixo para não repetir os atributos
    //Dita o maximo de mensagens

    public SistemaAmigoMap(){
        this(1000);

    }

    public SistemaAmigoMap(int maxMensagens){
        this.mensagens = new LinkedList<Mensagem>();
        this.amigos = new HashMap<>();
        this.setMaxMensagens(maxMensagens);
    }


    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
    	Amigo amigo = new Amigo (nomeAmigo, emailAmigo);
    	if(this.amigos.containsKey(amigo.getEmail())) {
    		throw new AmigoJaExisteException("Já existe amigo cadastrado com esse e-mail: "+ amigo);
    	} else {
    		this.amigos.put(amigo.getNome(), amigo);
    	}              
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
    	
    	 if(this.amigos.containsKey(emailAmigo)){            	
                return this.amigos.get(emailAmigo);
                        
         } else {
        	 throw new AmigoInexistenteException("Usuário não cadastrado com este e-mail " + emailAmigo);
        	 
         } 
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
        List<Mensagem> mensagensAnonimas = new LinkedList<Mensagem>(); 
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
        
        for(Amigo a: this.amigos.values()){                        
             if(a.getEmail().equals(emailDaPessoa)){
            	 
                a.setAmigoSorteado(emailAmigoSorteado);
                return ;
                }
            }           
                throw new AmigoInexistenteException("Não foi encontrado participante com o email" + emailDaPessoa);                                               
    }    

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;     
        
    }

    public boolean existeAmigoNoSistema(String emailPesquisa){
        for(Amigo f: this.amigos.values()){
            if (f.getEmail().equalsIgnoreCase(emailPesquisa)){
                return true;
            }
        }
        return false;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo a: this.amigos.values()){
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

