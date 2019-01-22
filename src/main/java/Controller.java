import java.util.ArrayList;
import java.util.List;

public class Controller {


	public void runGame() {
//		Service newGame = new Service();
//		newGame.setGame("Stef", "Mef");
		Service test = new Service();
		GarbageDao testDAO = new GarbageDao();
		List<Garbage> garbage = new ArrayList<>(testDAO.getAll());
		List<Integer> win = test.compareTwoGarbage( Positions.SMELL, garbage);
		System.out.println(win);
	}

	public void handleCrud() {

	}
}
