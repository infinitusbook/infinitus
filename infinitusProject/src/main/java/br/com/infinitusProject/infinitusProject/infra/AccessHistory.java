package br.com.infinitusProject.infinitusProject.infra;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.util.Date;
import br.com.infinitusProject.infinitusProject.models.User;;

public class AccessHistory {

	public void historyLog(String string) throws IOException {
		int line = 0, column = 0;
		String matriz[][] = new String[line][column];
		
		User user = new User(); 		
		java.util.Date dateAccess = new Date();
		File history = new File("history.txt");
		
		String dateAccessStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dateAccess);

		if (!history.exists()) {
			history.createNewFile();
		}

		line++; 
		column++; 
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = user.getEmail() + dateAccessStr;
			}
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.println(matriz[i][j] + "\t");
				//aqui viria o File lá salvando a matriz no arquivo 
			}
		}
	}
}
