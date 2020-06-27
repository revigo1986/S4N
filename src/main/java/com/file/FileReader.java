package com.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for drons paths file reading
 * 
 * @author revig
 *
 */
public class FileReader implements IFileReader {

	@Override
	public List<String> readDronsPathsFile(int fileNumber) throws IOException {
		List<String> linesList = new ArrayList<String>();
		Path path = Paths.get("in" + fileNumber + ".txt");
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

		String currentLine = null;
		while ((currentLine = reader.readLine()) != null) {
			linesList.add(currentLine);
		}
		return linesList;
	}
}
