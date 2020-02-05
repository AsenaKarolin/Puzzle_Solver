import java.util.*;
public class MyTree {
	MyNode root;
	TreeSet<MyNode> set;
	public MyTree(MyNode root) {
		this.root=root;
		this.set= new TreeSet<MyNode>();
		set.add(this.root);
	}
	public void goToLeft(MyNode node) {
		if(node.game.placeOf0[1]==0) {
			return;
		}
		int[][] board = new int[node.game.size][node.game.size];
		int[] place0 = new int[2];
		for (int i=0; i<node.game.size; i++) {
			for (int j=0; j<node.game.size; j++) {
				board[i][j]=node.game.currentState[i][j];
			}
		}
		place0[0]=node.game.placeOf0[0];
		place0[1]=node.game.placeOf0[1];
		Game fun = new Game(node.game.size, board, place0);
		MyNode posLeft=node.goLeft(fun);
		if(set.contains(posLeft)) {
			return;
		}
		else {
			node.left=posLeft;
			this.set.add(posLeft);
			return;
		}
	}
	public void goToRight(MyNode node) {
		if(node.game.placeOf0[1]==node.game.size-1) {
			return;
		}
		int[][] board = new int[node.game.size][node.game.size];
		int[] place0 = new int[2];
		for (int i=0; i<node.game.size; i++) {
			for (int j=0; j<node.game.size; j++) {
				board[i][j]=node.game.currentState[i][j];
			}
		}
		place0[0]=node.game.placeOf0[0];
		place0[1]=node.game.placeOf0[1];
		Game fun = new Game(node.game.size, board, place0);
		MyNode posRight=node.goRight(fun);
		if(set.contains(posRight)) {
			return;
		}
		else {
			node.right=posRight;
			this.set.add(posRight);
			return;
		}
	}
	public void goToUp(MyNode node) {
		if(node.game.placeOf0[0]==0) {
			return;
		}
		int[][] board = new int[node.game.size][node.game.size];
		int[] place0 = new int[2];
		for (int i=0; i<node.game.size; i++) {
			for (int j=0; j<node.game.size; j++) {
				board[i][j]=node.game.currentState[i][j];
			}
		}
		place0[0]=node.game.placeOf0[0];
		place0[1]=node.game.placeOf0[1];
		Game fun = new Game(node.game.size, board, place0);
		MyNode posUp=node.goUp(fun);
		if(set.contains(posUp)) {
			return;
		}
		else {
			node.up=posUp;
			this.set.add(posUp);
			return;
		}
	}
	public void goToDown(MyNode node) {
		if(node.game.placeOf0[0]==node.game.size-1) {
			return;
		}
		int[][] board = new int[node.game.size][node.game.size];
		int[] place0 = new int[2];
		for (int i=0; i<node.game.size; i++) {
			for (int j=0; j<node.game.size; j++) {
				board[i][j]=node.game.currentState[i][j];
			}
		}
		place0[0]=node.game.placeOf0[0];
		place0[1]=node.game.placeOf0[1];
		Game fun = new Game(node.game.size, board, place0);
		MyNode posDown=node.goDown(fun);
		if(set.contains(posDown)) {
			return;
		}
		else {
			node.down=posDown;
			this.set.add(posDown);
			return;
		}
	}
}


