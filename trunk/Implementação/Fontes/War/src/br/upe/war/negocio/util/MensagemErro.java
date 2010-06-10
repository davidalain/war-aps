package br.upe.war.negocio.util;

public class MensagemErro 
{

	public static final String POVOAR_FASE_RECEBIMENTO = "N�o � poss�vel povoar territ�rio na fase de recebimento de ex�rcito";
	
	public static final String JOGO_NAO_CADASTRADO = "N�o existe nenhum jogo cadastrado com o id informado.";
	
	public static final String JOGADOR_NAO_ESTA_NO_JOGO = "O jogador n�o est� no jogo.";
	
	public static final String JOGADOR_NAO_ESTA_NA_JOGADA_ATUAL = "O jogador n�o est� na jogada atual";

	public static final String EXERCITO_OCUPACAO_NAO_DESLOCADO = "Ao menos um territ�rio dever� ser deslocado.";
	
	public static final String POVOAMENTO_UTILIZOU_TODOS_EXERCITOS = "O territ�rio de ocupa��o n�o pode ser deslocado.";
	
	public static final String ATAQUE_UTILIZOU_TODOS_EXERCITOS = "O territ�rio de ocupa��o n�o pode ser utilizado no ataque.";
	
	public static final String ATAQUE_INEXISTENTE = "N�o existe um ataque em andamento";
	
	public static final String POVOAMETO_SUPERIOR_DADOS_ATAQUE = "A quantidade de ex�rcitos utilizados para povoar o territ�rio conquistado deve ser igual a no m�ximo o n�mero de ex�rcitos envolvidos no �ltimo ataque.";

	public static final String SALA_JOGO_EXISTENTE = "J� existe sala de jogo criada com os par�metros informados.";

	public static final String NUMERO_JOGADORES_INSUFICIENTES = "O n�mero de jogadores deve ser superior a 3 para iniciar um jogo";

	public static final String NUMERO_JOGADORES_SUPERIOR_LIMITE = "Um jogo deve possuir no m�ximo 6 jogadores";

	public static final String ATAQUE_TERRITORIOS_IGUAIS = "N�o � poss�vel realizar um ataque ao mesmo territ�rio";

	public static final String JOGADOR_DEVE_SER_ATACANTE = "O jogador deve ser o dominante do territ�rio atacante";

	public static final String ATAQUE_EXERCITOS_INCORRETOS = "O n�mero de ex�rcitos para atacar deve ser maior que zero e menor ou igual a tr�s";

	public static final String JOGADOR_VAZIO = "O jogador deve ser informado";

	public static final String COR_NAO_EXISTENTE = "A cor escolhida n�o existe";

	public static final String SALA_JOGO_NOME_VAZIO = "O nome da sala de jogo deve ser informada";

	public static final String NUMERO_JOGADORES_INVALIDO = "O n�mero de jogadores � inv�lido";

	public static final String SALA_JOGO_NULL = "A sala do jogo esta nula";
}
