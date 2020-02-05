
public class Game {
	public int size;
	public int [][] currentState;
	public int [] placeOf0;
	public Game(int size, int[][]currentState, int[] placeOf0) {
		this.size=size;
		this.currentState=currentState;
		this.placeOf0=placeOf0;
	}
	public String toString() {
		String str="";
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				str = str + currentState[i][j] + " ";
			}
		}
		return str;
	}

}
