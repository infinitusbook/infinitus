package br.com.infinitusProject.infinitusProject.infra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;


public class AccessHistory {

	public void historyLog(String user) throws IOException {

		int line = 999, column = 2;
		String matriz[][] = new String[line][column];
		int usuario = 0;
		Locale locale = new Locale("pt","BR");
		GregorianCalendar calendar = new GregorianCalendar(); 
		SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);		
		
		FileWriter history = new FileWriter("history.txt", true);
		BufferedWriter writer = new BufferedWriter(history);

		String dateAccessStr = formatador.format(calendar.getTime());

		for (int j = 0; j < matriz[0].length; j++) {
			if (usuario != matriz.length - 1) {
				if (j == 0) {
					matriz[usuario][j] = "O usuário " + user;
				} else {
					matriz[usuario][j] = " se logou no dia " + dateAccessStr;
				}
			}
		}
		usuario++;

		for (int i = 0; i < matriz.length; i++){
			if (matriz[i][0] == null) {
				break;
			}
			for (int j = 0; j < matriz[0].length; j++) {
				writer.write(matriz[i][j]);
			}
			writer.write("\r\n");
		}		

		writer.close();
		}
}