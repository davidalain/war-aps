package {
	import flash.display.MovieClip;
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author David Alain
	 */
	public class Main extends Sprite {
		private var tela:Sprite;
		
		public function Main():void {
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void {
			removeEventListener(Event.ADDED_TO_STAGE, init);
			
			//this.tela = new TelaPrincipal(22,null);
			
			var conexao:Conexao = new Conexao("192.168.0.1", 8080);
			conexao.
			
			
			this.addChild(this.tela);
			
			
		}
		
	}
	
}