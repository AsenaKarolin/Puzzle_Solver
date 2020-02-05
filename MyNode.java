
public class MyNode implements Comparable<MyNode>{
	public MyNode left;
	public MyNode right;
	public MyNode up;
	public MyNode down;
	public MyNode parent;
	public Game game;
	public String type;
	public MyNode(MyNode parent, Game game){
		this.parent=parent;
		this.game=game;
		this.left=null;
		this.right=null;
		this.up=null;
		this.down=null;
		this.type=null;
	}

	public MyNode goLeft(Game fun) {
		MyNode node= new MyNode (this,fun);
		node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]]=node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]-1];
		node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]-1]=0;
		node.game.placeOf0[1]--;
		node.type="L";
		return node;
		
	}
	public MyNode goRight(Game fun) {
		MyNode node= new MyNode (this,fun);
		node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]]=node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]+1];
		node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]+1]=0;
		node.game.placeOf0[1]++;
		node.type="R";
		return node;
	}
	public MyNode goUp(Game fun) {
		MyNode node= new MyNode (this,fun);
		node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]]=node.game.currentState[node.game.placeOf0[0]-1][node.game.placeOf0[1]];
		node.game.currentState[node.game.placeOf0[0]-1][node.game.placeOf0[1]]=0;
		node.game.placeOf0[0]--;
		node.type="U";
		return node;
		
	}
	public MyNode goDown(Game fun) {
		MyNode node= new MyNode (this,fun);
		node.game.currentState[node.game.placeOf0[0]][node.game.placeOf0[1]]=node.game.currentState[node.game.placeOf0[0]+1][node.game.placeOf0[1]];
		node.game.currentState[node.game.placeOf0[0]+1][node.game.placeOf0[1]]=0;
		node.game.placeOf0[0]++;
		node.type="D";
		return node;
		
	}
	@Override
	public int compareTo(MyNode node) {
		int result=0;
		for (int i=0; i<this.game.size; i++) {
			for (int j=0; j<this.game.size; j++) {
				result=new Integer(this.game.currentState[i][j]).compareTo(node.game.currentState[i][j]);
				if(result!=0) {
					return result;
				}
			}
		}
		return result;
	}

}
