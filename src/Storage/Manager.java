package Storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {

	public Manager() {}
	
	public boolean checkIfTableExists(String tableName) {
		tableName = tableName.toUpperCase();
		tableName = tableName.replaceAll("(\\s+)", "")+".txt";
		
		String path = "Data\\" + tableName;
		
		if(new File(path).exists()) return true;
		else return false;
	}
	
	public ArrayList<Data> retrieveTableData(String tableName) throws IOException {
		ArrayList<Data> tableData = new ArrayList<Data>();
		
		tableName = tableName.toUpperCase();
		tableName = tableName.replaceAll("(\\s+)", "")+".txt";
		
		String path = "Data\\" + tableName;
		File file = new File(path);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;
		while((line = br.readLine()) != null) {
			String [] tokens = line.split(",");
			tableData.add(new Data(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4]));
		}
		
		return tableData;
	}
}
