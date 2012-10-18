package br.com.fiap.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class UploadArquivo {

	public static String guardarArquivo(File arquivoUpdate, String path,
			String nomeArquivo) {
		Scanner scanner;
		try {
			scanner = new Scanner(arquivoUpdate);
			File file = new File(path);
			file.mkdirs();
			file = new File(path + nomeArquivo);
			file.createNewFile();
			StringBuffer stringBuffer = new StringBuffer();
			PrintStream printStream = new PrintStream(file);
			while (scanner.hasNextLine()) {
				String a = scanner.nextLine();
				printStream.println(a);
				stringBuffer.append(a);
			}
			printStream.close();
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
