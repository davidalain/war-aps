package br.upe.war.apresentacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.comunicacao.mensagens.MensagemChat;
import br.upe.war.comunicacao.mensagens.MensagemCriarSalaJogo;
import br.upe.war.comunicacao.mensagens.MensagemEntrarSalaJogo;
import br.upe.war.comunicacao.mensagens.MensagemEstadoTerritorios;
import br.upe.war.comunicacao.mensagens.MensagemIniciarJogo;
import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacote;
import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacoteCliente;
import br.upe.war.negocio.excecoes.WarValidationException;
import br.upe.war.negocio.jogadores.Jogador;

public class ProgramClienteCLI {
	/**
	 * @param args
	 * @throws IOException 
	 */
	private static ControladorComunicacao comunicacao = ControladorComunicacao.getInstance();
	private static String servidor = "192.168.1.1";
	private static Jogador jogador = null;
	private static String nomeSala = null;
	
	public static void main(String[] args) throws IOException, WarValidationException 
	{
		ThreadRecebimentoPacote r = new ThreadRecebimentoPacoteCliente(1234);
		
		Thread nova = new Thread(r);
				
		nova.start();
		boolean sair = false;
				
		while(!sair){
			
			imprimirMenu();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int opcao = Integer.parseInt(reader.readLine());
			
			switch(opcao){
				case 1:
					criarSalaJogo();
					break;
				case 2:
					entrarSalaJogo();
					break;
				case 3:
					mandarMensagemChat();
					break;
				case 4:
					iniciarJogo();
					break;
				case 5:
					estadoTerritorios();
					break;
				case 6:
					sair = true;
					break;
				default:
					break;
					
			}
		}
	
	}

	

	
	private static void enviar(Mensagem m) throws IOException{
		comunicacao.enviarMensagem(m);
	}
	
	private static void imprimirMenu(){
		System.out.println("*** MENU ***");
		System.out.println("Digite a opcao desejada:");
		if(jogador == null){
			System.out.println("1 - Criar uma sala de jogo");
			System.out.println("2 - Inserir um jogador em uma sala");
		}
		System.out.println("3 - Enviar mensagem no chat");
		if(nomeSala != null){
			System.out.println("4 - Inicia Jodo da sala");
			System.out.println("5 - Mostrar estado dos territorios");
		}
		System.out.println("6 - SAIR");
	}
	
	private static void criarSalaJogo() throws IOException, WarValidationException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Digite o seu login: ");
		String login = reader.readLine();
		
		System.out.println("Digite o numero de sua cor: ");
		imprimirCores();
		System.out.println();
		int cor = Integer.parseInt(reader.readLine());
		
		jogador = new Jogador(login, cor);
		
		System.out.println("Digite o nome da sala: ");
		nomeSala = reader.readLine();
		
		System.out.println("Tem senha? [s/n]");
		String op = reader.readLine();
		boolean senha = false;
		if(op.equalsIgnoreCase("s"))
			senha = true;
		
		System.out.println("Qual o numero max de participantes?");
		int maxPart = Integer.parseInt(reader.readLine());
		
		MensagemCriarSalaJogo m = new MensagemCriarSalaJogo(jogador, nomeSala, senha, maxPart, servidor);	
		enviar(m);
	}

	private static void entrarSalaJogo() throws IOException, WarValidationException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o seu login: ");
		String login = reader.readLine();
		
		System.out.println("Digite o numero de sua cor: ");
		imprimirCores();
		System.out.println();
		int cor = Integer.parseInt(reader.readLine());
		
		jogador = new Jogador(login, cor);
		
		System.out.println("Digite o nome da sala: ");
		nomeSala = reader.readLine();
		
		MensagemEntrarSalaJogo m = new MensagemEntrarSalaJogo(jogador, nomeSala, servidor);
		enviar(m);

	}
	
	private static void mandarMensagemChat() throws IOException, WarValidationException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("Digite a sua mensagem: ");
		String mensagem = reader.readLine();
		System.out.println("\n\n");
		
		MensagemChat m = new MensagemChat(jogador, mensagem, servidor);
		enviar(m);
		
	}
	
	private static void iniciarJogo() throws IOException, WarValidationException {
		MensagemIniciarJogo m = new MensagemIniciarJogo(nomeSala, jogador, servidor);
		enviar(m);
	}
	
	private static void estadoTerritorios() throws IOException{
		MensagemEstadoTerritorios m = new MensagemEstadoTerritorios(jogador, nomeSala, servidor);
		enviar(m);
	}
	
	private static void imprimirCores() {
		System.out.println("1- Azul; 2 - Verde = 1; 3 - Vermelho; 4 - Branco; 5 - Preto; 6 - Amarelo");
		
	}
}
