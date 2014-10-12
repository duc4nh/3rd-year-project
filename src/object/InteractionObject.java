package object;

import java.io.Serializable;

public class InteractionObject implements Serializable {
	
		//TODO maybe ID
		private String name;
		//for now: 1 = big, 0 = small;
		private int size;
		//for now: 1 = move, 0 = stay;
		private int move;
		//TODO more characteristics
		
		public InteractionObject(String name0, int size0, int move0) {
			name = name0;
			size = size0;
			move = move0;
		}
		
		//GETTERS
		public String getName() {
			return name;
		}
		
		public int getSize() {
			return size;
		}
		
		public int getMove() {
			return move;
		}
		
}
