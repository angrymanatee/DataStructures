package main;

public class HanoiSolver {
	TowersOfHanoi towerSet;


	/**
	 *	Creates a Hanoi Solver with the specified towers
	 *	@param start tower to put starting blocks on
	 *	@param depth number of blocks to have on starting tower
	 */
	public HanoiSolver(int start, int depth) {
		towerSet = new TowersOfHanoi(start,depth);
	}

	public void SolveTowers() {

	}

	/**
	 *	Creates a simple instance of this Tower Solver
	 */
	public static void main(String[] args) {
		HanoiSolver computer = new HanoiSolver(1, 5);
		System.out.println("Hi Seth!");
	}
}