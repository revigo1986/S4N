package com.file;

import java.io.IOException;
import java.util.List;

public interface IFileReader {
	
	public List<String> readDronsPathsFile(int fileNumber) throws IOException;
}
