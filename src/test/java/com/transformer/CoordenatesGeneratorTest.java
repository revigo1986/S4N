package com.transformer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoordenatesGeneratorTest {

	private List<String> linesList = new ArrayList<String>();
	
	@Test	
	public void shouldDemonstrateWrongCoordenatesFromDescriptionProblem(){
		linesList.add("AAAAIAA");
		
		ICoordenatesGenerator coordenatesGenerator = new CoordenatesGenerator();
		List<String> coordenatesList = coordenatesGenerator.process(linesList);
		
		assertNotSame("(-2,4) direction NORTH", coordenatesList.get(0));
	}
	
	@Test
	public void shouldGenerateCorrectCoordenatesGivenAPath(){
		linesList.add("AAAAIAA");
		
		ICoordenatesGenerator coordenatesGenerator = new CoordenatesGenerator();
		List<String> coordenatesList = coordenatesGenerator.process(linesList);
		
		assertEquals("(-2,4) direction WEST", coordenatesList.get(0));
	}
	
	@Test
	public void shouldGenerateCorrectCoordenatesGivenThreePaths(){
		linesList.add("AAAAIAA");
		linesList.add("DDDAIAD");
		linesList.add("AAIADAD");
		
		ICoordenatesGenerator coordenatesGenerator = new CoordenatesGenerator();
		List<String> coordenatesList = coordenatesGenerator.process(linesList);
		
		assertEquals("(-2,4) direction WEST", coordenatesList.get(0));
		assertEquals("(-1,3) direction SOUTH", coordenatesList.get(1));
		assertEquals("(0,0) direction WEST", coordenatesList.get(2));
	}
}
