package br.upe.war.negocio.util;

public class MensagemErro 
{

	public static final String POVOAR_FASE_RECEBIMENTO = "Não é possível povoar território na fase de recebimento de exército";
	
	public static final String JOGO_NAO_CADASTRADO = "Não existe nenhum jogo cadastrado com o id informado.";
	
	public static final String JOGADOR_NAO_ESTA_NO_JOGO = "O jogador não está no jogo.";
	
	public static final String JOGADOR_NAO_ESTA_NA_JOGADA_ATUAL = "O jogador não está na jogada atual";

	public static final String EXERCITO_OCUPACAO_NAO_DESLOCADO = "Ao menos um território deverá ser deslocado.";
	
	public static final String POVOAMENTO_UTILIZOU_TODOS_EXERCITOS = "O território de ocupação não pode ser deslocado.";
	
	public static final String ATAQUE_UTILIZOU_TODOS_EXERCITOS = "O território de ocupação não pode ser utilizado no ataque.";
	
	public static final String ATAQUE_INEXISTENTE = "Não existe um ataque em andamento";
	
	public static final String POVOAMETO_SUPERIOR_DADOS_ATAQUE = "A quantidade de exércitos utilizados para povoar o território conquistado deve ser igual a no máximo o número de exércitos envolvidos no último ataque.";

	public static final String SALA_JOGO_EXISTENTE = "Já existe sala de jogo criada com os parâmetros informados.";

	public static final String NUMERO_JOGADORES_INSUFICIENTES = "O número de jogadores deve ser superior a 3 para iniciar um jogo";

	public static final String NUMERO_JOGADORES_SUPERIOR_LIMITE = "Um jogo deve possuir no máximo 6 jogadores";

	public static final String ATAQUE_TERRITORIOS_IGUAIS = "Não é possível realizar um ataque ao mesmo território";

	public static final String JOGADOR_DEVE_SER_ATACANTE = "O jogador deve ser o dominante do território atacante";

	public static final String ATAQUE_EXERCITOS_INCORRETOS = "O número de exércitos para atacar deve ser maior que zero e menor ou igual a três";

	public static final String JOGADOR_VAZIO = "O jogador deve ser informado";

	public static final String COR_NAO_EXISTENTE = "A cor escolhida não existe";

	public static final String SALA_JOGO_NOME_VAZIO = "O nome da sala de jogo deve ser informada";

	public static final String NUMERO_JOGADORES_INVALIDO = "O número de jogadores é inválido";

	public static final String SALA_JOGO_NULL = "A sala do jogo esta nula";
}
