package ufpb.carol.projeto;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;


class SistemaAmigoMapTest {


	SistemaAmigoMap sistema;
	
	@BeforeEach
	void setUp()  {
		this.sistema = new SistemaAmigoMap();
	}

	@Test
	void testSistemaAmigo() {
		assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
		assertThrows(AmigoInexistenteException.class, 
				()-> sistema.pesquisaAmigo("ayla@teste.com"));
	}

	@Test
	void testPesquisaECadastraAmigo() throws AmigoJaExisteException   {
		try {
			sistema.pesquisaAmigo("ayla@teste.com");
			fail("Deveria falhar pois n�o existe ainda");
		} catch (AmigoInexistenteException e) {
			System.out.println("Ok!!!");
		}
		try {
			sistema.cadastraAmigo("ayla", "ayla@test");
			} catch (AmigoJaExisteException   e) {
			fail("N�o deveria lan�ar exce��o");
		}
		try {
			sistema.cadastraAmigo("ayla", "ayla@test");
			fail ("Deveria lan�ar exce��o");
		}catch ( AmigoJaExisteException  e) {
		System.out.println("OK");
		}
		
	}

	@Test
	void testEnviarMensagemParaTodos() {
		assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
		sistema.enviarMensagemParaTodos("texto", "ayla@dcx.ufpb.br", true);
		List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
		assertTrue(mensagensAchadas.size()==1);
		assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("ayla@dcx.ufpb.br"));
	}

	@Test
	void testEnviarMensagemParaAlguem() {
		assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
		sistema.enviarMensagemParaAlguem("texto", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
		List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
		assertEquals(1, mensagensAchadas.size());
		assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
		assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
	}

	@Test
	void testPesquisaMensagensAnonimas() {
		assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
		sistema.enviarMensagemParaAlguem("texto 1", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", false);
		assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
		sistema.enviarMensagemParaAlguem("texto 2", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
		assertTrue(sistema.pesquisaMensagensAnonimas().size()==1);
	}

	@Test
	void testPesquisaTodasAsMensagens() {
		assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
		sistema.enviarMensagemParaAlguem("texto 1", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", false);
		assertTrue(sistema.pesquisaTodasAsMensagens().size()==1);
		sistema.enviarMensagemParaAlguem("texto 2", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", true);
		assertTrue(sistema.pesquisaTodasAsMensagens().size()==2);
	}

	
	  @Test
	void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
		assertThrows(AmigoInexistenteException.class, 
				()-> sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));
		
		try {
			sistema.cadastraAmigo("Ayla", "ayla@dcx.ufpb.br");
			sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");
			sistema.configuraAmigoSecretoDe("ayla@dcx.ufpb.br", "ana@dcx.ufpb.br");
			sistema.configuraAmigoSecretoDe("ana@dcx.ufpb.br", "ayla@dcx.ufpb.br");
			assertEquals("ayla@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("ana@dcx.ufpb.br"));
			assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));
		} catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
			fail("N�o deveria lan�ar exce��o");
		}
	}
	 


}