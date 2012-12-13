import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;


/**
 *	Towers of Hanoi object. Contains three stacks for the towers  and methods
 *	for playing the game. 
 *	@author angrymanatee
 */
public class TowersOfHanoi {

	private Tower[] tower;



	/**
	 *	Tower of blocks, implemented as a stack.
	 */
	private class Tower {

		private Block top;

		/**
		 *	Creates a tower with the given number of blocks.
		 *	@param startingNumberOfBlocks number of blocks to instantiate the
		 *	tower with.
		 */
		public Tower(int startingNumberOfBlocks) 
				throws IllegalArgumentException {
			if(startingNumberOfBlocks!=0) {
				top = new Block(startingNumberOfBlocks,null);
				for(int i = startingNumberOfBlocks-1; i > 0; i--) {
					top = new Block(i,top);
				}
			}
			else if(startingNumberOfBlocks==0) {
				top = null;
			}
			else {
				throw new IllegalArgumentException(
					"Towers can't go down, dude. (input is " + 
					startingNumberOfBlocks + ").");
			}
		}

		/**
		 *	Puts a new block on top of the tower
		 *	@param newTopBlock block to be put on top of the stack
		 */
		public void push(Block newTopBlock) {
			newTopBlock.setNextBlock(this.top);
			this.top = newTopBlock;
		}

		/**
		 *	Removes the top block of the tower.
		 *	@return The block that was on top of this tower
		 */
		public Block pop()
				throws IllegalStateException {
			if(this.top==null) {
				throw new IllegalStateException("Nothing to pop...");
			}
			Block blockToReturn = this.top;
			this.top = this.top.nextBlock();
			return blockToReturn;
		}

		/**
		 *	Gives String representation of this block and the blocks underneath
		 *	it.
		 *	@param inspectee block to check
		 *	@return String of blocks beneath this one. Ordered from highest
		 *	(smallest) block to lowest (largest) block.
		 *	@throws	
		 */
		public String inspectTower(Block inspectee) {
			if(inspectee.nextBlock()==null) {
				return Integer.toString(inspectee.getSize());
			}
			else {
				return inspectee.getSize() + "," +
					this.inspectTower(inspectee.nextBlock());
			}
		}

		public String toString() {
			return inspectTower(this.top).toString();
		}
		
	}

	/**
	 *	One block in the tower. Has a size and points to the next block 
	 *	beneath it.
	 */
	private class Block {
		private Block next;
		private int size;

		/**
		 *	Creates a block
		 *	@param size Size of this block
		 *	@param next Block that this one sits on. Null if this is the
		 *	bottom block.
		 */
		public Block(int size, Block next) {
			this.size = size;
			this.next = next;
		}

		/**
		 *	Gets the size of the block
		 *	@return Size of block (int)
		 */
		public int getSize() {
			return this.size;
		}

		/**
		 *	Gets the block that this one is on top of
		 *	@return block that this one sits on. Null if this is the bottom.
		 */
		public Block nextBlock() {
			return this.next;
		}

		/**
		 *	Puts this block on top of a different block.
		 *	@param nextBlock block to put this block on top of.
		 */
		public void setNextBlock(Block nextBlock) 
				throws IllegalArgumentException {
			if(nextBlock!=null && nextBlock.getSize() <= this.getSize()) {
				throw new IllegalArgumentException(
					"Cannot put this block of size " + 
					this.getSize() + "On top of a block size " + 
					nextBlock.getSize() + "!!!");
			}
			else {
				this.next = nextBlock;
			}
		}

		/**
		 *	Returns the size of this block in stringy form.
		 */
		public String toString() {
			return Integer.toString(this.getSize());
		}
	}
}