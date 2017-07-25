package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import maze.astar.AStarExplorer;

public class MazeEscapeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws FileNotFoundException {
		// Scanner input = new Scanner(System.in);
		//Scanner input = new Scanner(new File("large_input.txt"));
		//Scanner input = new Scanner(new File("small.txt"));
		//Scanner input = new Scanner(new File("sparse_medium.txt"));
		//Scanner input = new Scanner(new File("medium_input.txt"));
		 Scanner input = new Scanner(new File("large_input.txt"));
		// Scanner input = new Scanner(new File("medium_input.txt"));
		// Scanner input = new Scanner(new File("medium_input.txt"));
		int WIDTH = input.nextInt();
		int HEIGHT = input.nextInt();
		int START_X = input.nextInt();
		int START_Y = input.nextInt();
		int END_X = input.nextInt();
		int END_Y = input.nextInt();
		int[][] map = new int[WIDTH][HEIGHT];

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				map[x][y] = input.nextInt();
			}
		}

		AStarExplorer explorer = new AStarExplorer();
		List<MazeNode> list = explorer.findPath(map, START_X, START_Y, END_X, END_Y);

		map[START_X][START_Y]=7;
		list.forEach( node-> map[node.getXAxis()][node.getYAxis()] = 8);
		map[END_X][END_Y]=9;

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				System.out.print(intToChar(map[x][y])); 
			}
			System.out.println();
		}
		
		input.close();
	}
	
	static char intToChar(int num) {
		char rtn = ' ';
		switch (num) {
		case 0:
			rtn = ' ';
			break;
			
		case 1:
			rtn = '#';
			break;
			
		case 7:
			rtn = 'S';
			break;
		case 8:
			rtn = 'X';
			break;
			
		case 9:
			rtn = 'E';
			break;
		 
		default:
			 
		}
		return rtn;
	}

}
