package  {
	import flash.display.Sprite;
	import flash.display.StageDisplayState;
	import flash.events.DataEvent;
	import flash.events.Event;
	import flash.events.IOErrorEvent;
	import flash.events.MouseEvent;
	import flash.net.XMLSocket;
	import visual.ImagemFundo;
	/**
	 * ...
	 * @author David Alain
	 */
	public class Main extends Sprite{
		
		private var tela:ImagemFundo;
		private var conexao:XMLSocket;
		
		public function Main():void {
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void {
			removeEventListener(Event.ADDED_TO_STAGE, init);
			
			this.tela = new ImagemFundo();
			this.tela.tf.text = "NOME_TESTE";
			this.tela.tf.width = 300;
			this.tela.botao.addEventListener(MouseEvent.CLICK, onClickMouse);
			this.addChild(this.tela);
			
			this.conexao = new XMLSocket("localhost", 6789);
			this.conexao.addEventListener(DataEvent.DATA, onRecebeuMensagem);
			this.conexao.addEventListener(Event.CONNECT, onConexaoEfetuada);
			this.conexao.addEventListener(IOErrorEvent.IO_ERROR, onErroIO);
			
		}
		
		private function onErroIO(e:IOErrorEvent):void {
			trace("Erro IO");
			this.tela.tf.text = "Erro ao conectar o servidor";
		}
		
		private function onConexaoEfetuada(e:Event):void {
			trace("Conexao Efetuada");
			this.tela.tf.text = "Conexao efetuada com sucesso";
		}
		
		private function onRecebeuMensagem(e:DataEvent):void {
			trace("Mensagem Recebida:", e.data);
			this.tela.tf.text = e.data;
		}
		
		private function onClickMouse(e:MouseEvent):void {
			this.conexao.send(this.tela.tf.text);
		}
		
		public function goFullScreen():void {
			if (this.stage.displayState == StageDisplayState.FULL_SCREEN) {
				this.stage.displayState = StageDisplayState.NORMAL;
			}else {
				this.stage.displayState = StageDisplayState.FULL_SCREEN;
			}
		}
		
		private function onData(e:DataEvent):void {
			var texto:String = e.data as String;
			this.tela.tf.appendText(texto);
		}
		
	}

}