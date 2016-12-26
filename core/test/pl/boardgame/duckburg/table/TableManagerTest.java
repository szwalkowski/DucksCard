package pl.boardgame.duckburg.table;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.boardgame.duckburg.GameOptions;
import pl.boardgame.duckburg.deck.cards.Card;
import pl.boardgame.duckburg.deck.cards.TownhallCard;

public class TableManagerTest {

	private static TableManager tableManager;

	private Card exampleCard = new TownhallCard(1, "example");

	@BeforeClass
	public static void beforeClass() {
		tableManager = new TableManager();
	}

	@Before
	public void before() {
		tableManager.createGrid(GameOptions.TableSize.SMALL);
	}

	@Test
	public void addRemoveAndCheckIfPlaced() {
		// GIVEN
		Point coords = new Point(1, 1);

		// WHEN
		assertThat(tableManager.addIdAtPosition(coords, exampleCard), is(true));
		assertThat(tableManager.removeAtPosition(coords), is(true));

		// THEN
		assertThat(tableManager.checkIfPointIsFree(coords), is(true));
	}

	@Test
	public void addToGridAndCheckIfPlaced() {
		// GIVEN
		Point coords = new Point(1, 1);

		// WHEN
		assertThat(tableManager.addIdAtPosition(coords, exampleCard), is(true));

		// THEN
		assertThat(tableManager.checkIfPointIsFree(coords), is(false));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addingOutsideOfBounds() {
		// GIVEN
		// WHEN
		int tableSize = GameOptions.TableSize.SMALL.getTableSize();
		tableManager.addIdAtPosition(new Point(tableSize, tableSize), exampleCard);
		// THEN
	}

}
