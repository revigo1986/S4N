package com.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class for generating files with drons coordenates
 * 
 * @author revig
 *
 */
public class FileBuilder implements IFileBuilder {

	@Override
	public void writeCoordenatesFile(List<String> coordenatesList, int fileNumber) throws IOException {
		File file = new File("out" + fileNumber + ".txt");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("== Reporte de entregas ==\n");
		for (String coordenates : coordenatesList) {
			fileWriter.write(coordenates + System.lineSeparator());
		}
		fileWriter.close();
	}
}
