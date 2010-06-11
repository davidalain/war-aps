package br.upe.war.apresentacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.upe.war.comunicacao.comum.ControladorComunicacao;
import br.upe.war.comunicacao.mensagens.Mensagem;
import br.upe.war.comunicacao.mensagens.MensagemChat;
import br.upe.war.comunicacao.mensagens.MensagemCriarSalaJogo;
import br.upe.war.comunicacao.mensagens.MensagemEntrarSalaJogo;
import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacote;
import br.upe.war.comunicacao.recebimento.ThreadRecebimentoPacoteCliente;

public class ProgramClienteCLI {
	/**
	 * @param args
	 * @throws IOException 
	 */
	private static ControladorComunicacao comunicacao = ControladorComunicacao.getInstance();
	private static String servidor = "127.0.0.1";
	
	public static void main(String[] args) throws IOException 
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
		System.out.println("1 - Criar uma sala de jogo");
		System.out.println("2 - Inserir um jogador em uma sala");
		System.out.println("3 - Enviar mensagem no chat");
		System.out.println("4 - SAIR");
	}
	
	private static void criarSalaJogo() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Digite o seu login: ");
		String login = reader.readLine();
		
		System.out.println("Digite o numero de sua cor: ");
		imprimirCores();
		System.out.println();
		int cor = Integer.parseInt(reader.readLine());
		
		System.out.println("Digite o nome da sala: ");
		String nomeSala = reader.readLine();
		
		System.out.println("Tem senha? [s/n]");
		String op = reader.readLine();
		boolean senha = false;
		if(op.equalsIgnoreCase("s"))
			senha = true;
		
		System.out.println("Qual o numero max de participantes?");
		int maxPart = Integer.parseInt(reader.readLine());
		
		MensagemCriarSalaJogo m = new MensagemCriarSalaJogo(login, cor, nomeSala, senha, maxPart, servidor);	
		enviar(m);
	}

	private static void entrarSalaJogo() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o seu login: ");
		String login = reader.readLine();
		
		System.out.println("Digite o numero de sua cor: ");
		imprimirCores();
		System.out.println();
		int cor = Integer.parseInt(reader.readLine());
		
		System.out.println("Digite o nome da sala: ");
		String nomeSala = reader.readLine();
		
		MensagemEntrarSalaJogo m = new MensagemEntrarSalaJogo(login, cor, nomeSala, servidor);
		enviar(m);

	}
	
	private static void mandarMensagemChat() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digite o seu login: ");
		String login = reader.readLine();
		
		System.out.println("Digite a sua mensagem: ");
		String mensagem = reader.readLine();
		System.out.println("\n\n");
		MensagemChat m = new MensagemChat(login, mensagem, servidor);
		enviar(m);
		
	}
	
	private static void imprimirCores() {
		System.out.println("1- Azul; 2 - Verde = 1; 3 - Vermelho; 4 - Branco; 5 - Preto; 6 - Amarelo");
		
	}
}
