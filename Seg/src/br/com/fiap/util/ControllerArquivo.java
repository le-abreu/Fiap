package br.com.fiap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.security.PrivateKey;
import java.util.Scanner;

public class ControllerArquivo {

	public static void guardarArquivo(File arquivoUpdate, String path,
			String nomeArquivo, PrivateKey chavePrivate) {
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
			String retorno = AssinaturaDigital.assinarDigitalmente(stringBuffer.toString() ,chavePrivate);
			printStream.println(retorno);
			printStream.close();
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String leituraArquivo(String path, String nomeArquivo) {
		Scanner scanner;
		try {
			File file = new File(path+nomeArquivo);
			scanner = new Scanner(file);
			StringBuffer stringBuffer = new StringBuffer();
			while (scanner.hasNextLine()) {
				String a = scanner.nextLine();
				if(scanner.hasNextLine())
					stringBuffer.append(a);
				else
					break;
			}
			scanner.close();
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public static String retornaSign(String path, String nomeArquivo) {
		Scanner scanner;
		try {
			File file = new File(path+nomeArquivo);
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String a = scanner.nextLine();
				if(scanner.hasNextLine())
					continue;
				else
					return a;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void gravarObjetoSerializavel(String path, String nomeArquvio, Object objeto) {
		ObjectOutputStream serializador;
		try {
			File file = new File(path);
			file.mkdirs();
			file = new File(path+nomeArquvio);
			file.createNewFile();

			FileOutputStream fos = new FileOutputStream(file);
			serializador = new ObjectOutputStream(fos);
			serializador.writeObject(objeto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object getObjetoSerializavel(String path, String nomeArquvio) {
		try {
			return new ObjectInputStream(new FileInputStream(path+nomeArquvio)).readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
