package com.file;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import org.junit.Test;

public class FileReaderTest {

	@Test
	public void shouldReadALineFromFile() throws IOException {
		IFileReader fileReader = new FileReader();
		List<String> fileLines = fileReader.readDronsPathsFile(1);
		
		assertNotNull(fileLines.get(0));
	}
	
	@Test(expected = NoSuchFileException.class)
	public void shouldGenerateAExceptionForANonExistingFile() throws IOException {
		IFileReader fileReader = new FileReader();
		fileReader.readDronsPathsFile(21);
	}
}
