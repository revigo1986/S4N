package com.transformer;

import java.util.ArrayList;
import java.util.List;

import com.utils.CardinalPoints;

/**
 * Transformation class: receive drons paths array, returning associate
 * coordenates
 * 
 * @author revig
 *
 */
public class CoordenatesGenerator implements ICoordenatesGenerator {

	private int xCoordenate = 0, yCoordenate = 0;
	private CardinalPoints orientation = CardinalPoints.NORTH;

	@Override
	public List<String> process(List<String> linesList) {
		List<String> coordenatesList = new ArrayList<String>();
		linesList.forEach(line -> {
			for (int i = 0; i < line.length(); i++) {
				checkDronMovements(line.charAt(i));
			}
			coordenatesList.add("("+this.xCoordenate+","+this.yCoordenate+") direction "+this.orientation);
		});
		return coordenatesList;
	}

	private void checkDronMovements(char movement) {
		switch (movement) {
		case 'A':
			if (this.orientation.equals(CardinalPoints.NORTH)) {
				this.yCoordenate++;
			} else if (this.orientation.equals(CardinalPoints.SOUTH)) {
				this.yCoordenate--;
			} else if (this.orientation.equals(CardinalPoints.EAST)) {
				this.xCoordenate++;
			} else if (this.orientation.equals(CardinalPoints.WEST)) {
				this.xCoordenate--;
			}
			break;
		case 'I':
			if (this.orientation.equals(CardinalPoints.NORTH)) {
				this.orientation = CardinalPoints.WEST;
			} else if (this.orientation.equals(CardinalPoints.WEST)) {
				this.orientation = CardinalPoints.SOUTH;
			} else if (this.orientation.equals(CardinalPoints.SOUTH)) {
				this.orientation = CardinalPoints.EAST;
			} else {
				this.orientation = CardinalPoints.NORTH;
			}
			break;
		case 'D':
			if (this.orientation.equals(CardinalPoints.NORTH)) {
				this.orientation = CardinalPoints.EAST;
			} else if (this.orientation.equals(CardinalPoints.EAST)) {
				this.orientation = CardinalPoints.SOUTH;
			} else if (this.orientation.equals(CardinalPoints.SOUTH)) {
				this.orientation = CardinalPoints.WEST;
			} else {
				this.orientation = CardinalPoints.NORTH;
			}
			break;
		}
	}
}
