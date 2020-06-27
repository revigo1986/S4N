package com.file;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileBuilderTest {

	@Test
	public void shouldWriteIntoAFile() throws IOException {
		List<String> coordenatesList = new ArrayList<String>();
		String coordenate = "(-5,3) direction NORTH";
		coordenatesList.add(coordenate);
		
		IFileBuilder fileBuilder = new FileBuilder();
		fileBuilder.writeCoordenatesFile(coordenatesList, 21);

		Path path = Paths.get("out21.txt");
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

		String currentLine = null;
		List<String> linesList = new ArrayList<String>();
		while ((currentLine = reader.readLine()) != null) {
			linesList.add(currentLine);
		}
		assertEquals("== Reporte de entregas ==", linesList.get(0));
		assertEquals("(-5,3) direction NORTH", linesList.get(1));
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldGenerateAExceptionForANullCoordenatesList() throws IOException {
		IFileBuilder fileBuilder = new FileBuilder();
		fileBuilder.writeCoordenatesFile(null, 21);
	}
}
