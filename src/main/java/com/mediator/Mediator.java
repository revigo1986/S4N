package com.mediator;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.file.FileBuilder;
import com.file.FileReader;
import com.file.IFileBuilder;
import com.file.IFileReader;
import com.transformer.CoordenatesGenerator;
import com.transformer.ICoordenatesGenerator;

/**
 * Mediator class implementing IMediator for coordinating the whole work from
 * all objects
 * 
 * @author revig
 *
 */
public class Mediator implements IMediator {

	int numFiles = 20;
	int threads = 20;

	@Override
	public boolean executeProcess() {
		ExecutorService exec = Executors.newFixedThreadPool(threads);

		for (int i = 1; i <= numFiles; i++) {			
			exec.submit(new ThreadTask(i));
		}
		exec.shutdown();
		try {
			exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();			
		}
		return true;
	}

	/**
	 * Simultaneous execution class
	 * @author revig
	 *
	 */
	class ThreadTask implements Runnable {
		private int fileNumber;

		public ThreadTask(int fileNumber) {
			this.fileNumber = fileNumber;
		}

		public void run() {
			IFileReader fileReader = new FileReader();
			ICoordenatesGenerator coordenatesGenerator = new CoordenatesGenerator();
			IFileBuilder fileBuilder = new FileBuilder();
			
			List<String> linesList = null;
			try {
				linesList = fileReader.readDronsPathsFile(fileNumber);
				List<String> coordenatesList = coordenatesGenerator.process(linesList);
				fileBuilder.writeCoordenatesFile(coordenatesList, this.fileNumber);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
