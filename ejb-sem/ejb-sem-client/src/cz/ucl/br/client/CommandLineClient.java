package cz.ucl.br.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommandLineClient {
	public int getChoice(String choiceText, List<? extends Object> choices) {
		System.out.println(choiceText);
		for (int i = 0; i < choices.size(); i++) {
			System.out.println("  " + (i + 1) + " - " + choices.get(i));
		}
		System.out.print("> ");
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(r.readLine().trim());
		} catch (Exception e) {
			return -1;
		}
	}

	public String getInput(String choiceText) {
		String result = null;
		System.out.print(choiceText + ": ");
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try {
			result = r.readLine().trim();
		} catch (Exception e) {
		}
		
		return result;
	}
	
	public Date getDateInput(String choiceText) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String raw = getInput(choiceText + " (format dd.MM.yyyy)");		
		try {
			result = sdf.parse(raw);
		} catch (ParseException e) {
			
		}
		return result;
	}

}
