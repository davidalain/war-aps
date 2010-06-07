package  {
	import flash.events.MouseEvent;
	/**
	 * ...
	 * @author David Alain
	 */
	public class TelaPrincipal extends TelaPrincipalSWC{
		
		public function TelaPrincipal(sala:uint,jogadores:Array) {
			
			//TODO: Receber uma lista de jogadores com Nome e Cor do Exercito
			
			this.sala.campoSala.text = "Sala " + sala;
			
			this.jogador1.sinal.gotoAndStop("1");
			this.jogador1.campoNome.text = "Jogador_1";
			this.jogador1.fundo.gotoAndStop("1");
			
			this.jogador2.sinal.gotoAndStop("1");
			this.jogador2.campoNome.text = "Jogador_2";
			this.jogador2.fundo.gotoAndStop("1");
			
			this.jogador3.sinal.gotoAndStop("2");
			this.jogador3.campoNome.text = "Jogador_3";
			this.jogador3.fundo.gotoAndStop("1");
			
			this.jogador4.sinal.gotoAndStop("2");
			this.jogador4.campoNome.text = "Jogador_4";
			this.jogador4.fundo.gotoAndStop("1");
			
			this.jogador5.sinal.gotoAndStop("2");
			this.jogador5.campoNome.text = "Jogador_5";
			this.jogador5.fundo.gotoAndStop("1");
			
			this.jogador6.alpha = 0;
			this.jogador6.campoNome.alpha = 0;
			this.jogador6.sinal.gotoAndStop("2");
			this.jogador6.fundo.gotoAndStop("1");
			this.jogador6.campoNome.text = "";
			
			this.mapaTelaPrincipal = new MapaSWC();
			this.opcoes = new OpcoesJogoSWC();
			
			this.botaoOK.buttonMode = true;
			this.botaoSair.buttonMode = true;
			this.botaoTelaCheia.buttonMode = true;
			this.botaoZoom.buttonMode = true;
			this.barraRolagem.setaBaixo.buttonMode = true;
			this.barraRolagem.setaCima.buttonMode = true;
			this.regras.buttonMode = true;
			this.tabelas.buttonMode = true;
			
			this.botaoOK.addEventListener(MouseEvent.CLICK, onClickOK);
			this.botaoSair.addEventListener(MouseEvent.CLICK, onClickSair);
			this.botaoTelaCheia.addEventListener(MouseEvent.CLICK, onClickTelaCheia);
			this.botaoZoom.addEventListener(MouseEvent.CLICK, onClickZoom);
			this.barraRolagem.setaBaixo.addEventListener(MouseEvent.CLICK, onClickSetaBaixo);
			this.barraRolagem.setaCima.addEventListener(MouseEvent.CLICK, onClickSetaCima);
			this.regras.addEventListener(MouseEvent.CLICK, onClickRegras);
			this.tabelas.addEventListener(MouseEvent.CLICK, onClickTabelas);
		}
		
		private function onClickTabelas(e:MouseEvent):void {
			trace("onClickTabelas");
		}
		
		private function onClickRegras(e:MouseEvent):void {
			trace("onClickRegras");
		}
		
		private function onClickSetaCima(e:MouseEvent):void {
			trace("onClickSetaCima");
		}
		
		private function onClickSetaBaixo(e:MouseEvent):void {
			trace("onClickSetaBaixo");
		}
		
		private function onClickZoom(e:MouseEvent):void {
			trace("onClickZoom");
		}
		
		private function onClickTelaCheia(e:MouseEvent):void {
			trace("onClickTelaCheia");
		}
		
		private function onClickSair(e:MouseEvent):void {
			trace("onClickSair");
		}
		
		private function onClickOK(e:MouseEvent):void {
			trace("onClickOK");
		}
		
	}

}