package com.file;

import java.io.IOException;
import java.util.List;

public interface IFileBuilder {
	
	public void writeCoordenatesFile(List<String> coordenatesList, int fileNumber) throws IOException;
	
}
