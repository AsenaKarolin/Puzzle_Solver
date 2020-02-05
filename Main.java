import java.util.*;
import java.io.*;
import java.lang.Math;
public class Main {
	public static void backTrack(MyNode found, PrintStream ps) {
		Stack<String> st = new Stack<String>();
		MyNode cur=found;
		while(cur.parent!=null) {
			st.push(cur.type);
			cur=cur.parent;
		}
		while(!st.isEmpty()) {
			ps.print(st.pop());
		}
		return;
	}
	public static boolean isSolved(int[][] board, int size) {
		int count=1;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if ((i!=size-1 || j!=size-1) && board[i][j]!=count) {
					return false;
				}
				else if(i==size-1 && j==size-1 && board[i][j]!=0) {
					return false;
				}
				count++;
			}
		}
		return true;
		
	}
	public static void process(MyTree tree, PrintStream ps) {
		MyNode temp;
		Queue<MyNode> q = new LinkedList<MyNode>();
		if (isSolved(tree.root.game.currentState,tree.root.game.size)) {
			ps.print(""); //prints empty string
		}
		q.add(tree.root);
		while(!q.isEmpty()) {
			temp=q.remove();
			tree.goToLeft(temp);
			tree.goToRight(temp);
			tree.goToUp(temp);
			tree.goToDown(temp);
			if (temp.left!=null) {
				if(isSolved(temp.left.game.currentState,temp.game.size)) {
					//System.out.println(temp.left.game);
					backTrack(temp.left,ps);
					return;
				}
				//System.out.println(temp.left.game);
				q.add(temp.left);
			}
			if (temp.right!=null) {
				if(isSolved(temp.right.game.currentState,temp.game.size)) {
					//System.out.println(temp.right.game);
					backTrack(temp.right,ps);
					return;
				}
				//System.out.println(temp.right.game);
				q.add(temp.right);
			}
			if (temp.up!=null) {
				if(isSolved(temp.up.game.currentState,temp.game.size)) {
					//System.out.println(temp.up.game);
					backTrack(temp.up,ps);
					return;
				}
				//System.out.println(temp.up.game);
				q.add(temp.up);
			}
			if (temp.down!=null) {
				if(isSolved(temp.down.game.currentState,temp.game.size)) {
					//System.out.println(temp.down.game);
					backTrack(temp.down,ps);
					return;
				}
				//System.out.println(temp.down.game);
				q.add(temp.down);
			}
			
		}
		ps.println("N");
		return;
	}
	public static void runCode (String[] args) throws Exception{
		File inputfile = new File(args[0]);
		File outputfile = new File(args[1]);
		Scanner sc = new Scanner(inputfile);
		sc.useDelimiter("\\D");
		PrintStream ps = new PrintStream(outputfile);
		int[] arr = new int[50];
		int[] place0 = new int[2];
		double size1;
		int size=0;
		for (int i=0; sc.hasNextInt() ; i++) {
		arr[i]=sc.nextInt();
		size++;
		}
		sc.close();
		size1=Math.sqrt(size);
		size=(int)size1;
		int[][] initialState = new int[size][size];
		int k=0;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (arr[k]==0) {
					place0[0]=i;
					place0[1]=j;
				}
				initialState[i][j]=arr[k];
				k++;
			}
		}
		Game theGame = new Game(size,initialState,place0);
		MyNode theNode = new MyNode(null,theGame);
		MyTree theTree = new MyTree(theNode);
		process(theTree,ps);
		ps.close();
		return;
	}
	public static void main(String[] args) throws Exception {

			runCode(args);

	}
}
