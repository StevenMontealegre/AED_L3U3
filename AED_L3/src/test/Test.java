package test;


import junit.framework.TestCase;
import modelo.FIBA;
import modelo.Player;

public class Test  extends TestCase{

	private FIBA model;
	
	private void test1() {
		model = new FIBA();
		
		model.addPlayerByAssists(new Player("Juan", "Lakers", 21, 10, 10, 10, 10, 10));
		model.addPlayerBySteals(new Player("Emmanuel", "Chicago Bulls", 19, 20, 20, 20, 20, 20));
		model.addPlayerByPoints(new Player("David", "Denver", 20, 30, 30, 30, 30, 30));
		model.addPlayerByRebounds(new Player("James", "Detroit", 23, 40, 40, 40, 40, 40));
		model.addPlayerByBlocks(new Player("nicolas", "Indiana", 25, 50, 50, 50, 50, 50));
		
	}

	
	public void searchAVL() {
		test1();
		Player p1 = model.searchPlayersAVL(2);
		assertEquals("David", p1.getName());
		
	}
	
	public void searchRedBlack() {
		test1();
//		Player player = model.searchPlayersRB(o);
	}
	


	
}
