package {
	import flash.display.Sprite;
	import flash.events.Event;
	
	/**
	 * ...
	 * @author David Alain
	 */
	public class Main extends Sprite {
		private var tela:TelaPrincipal;
		
		public function Main():void {
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void {
			removeEventListener(Event.ADDED_TO_STAGE, init);
			
			this.tela = new TelaPrincipal(22,null);
			
			
			
			
			this.addChild(tela);
			
			
		}
		
	}
	
}