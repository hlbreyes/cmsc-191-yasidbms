/*
	This class is for storage and file manager that manages data.
*/

package Storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
	private Log.Manager log_manager = new Log.Manager();

	public Manager() {}
	
	// this method checks whether the requested table is existing in the current file storage unit
	public boolean checkIfTableExists(String table_name) {
		table_name = table_name.toUpperCase();
		table_name = table_name.replaceAll("(\\s+)", "")+".txt";
		
		String path = "Data\\" + table_name;
		
		if(new File(path).exists()) return true;
		else return false;
	}
	
	// this method connects to an existing table for data manipulation
	public File connectTable(String table_name) {
		table_name = table_name.toUpperCase();
		table_name = table_name.replaceAll("(\\s+)", "")+".txt";
		
		String path = "Data\\" + table_name;
		File file = new File(path);
		
		return file;
	}
	
	// this method retrieves the data stored in the table provided that it is existing
	// it reads the the text file and stores all the data in an arraylist which is then returned to the user
	public ArrayList<Data> retrieveTableData(File file, String tableName) throws IOException {
		ArrayList<Data> tableData = new ArrayList<Data>();		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;
		while((line = br.readLine()) != null) {
			String [] tokens = line.split(",");
			tableData.add(new Data(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4]));
		}
		
		br.close();
		
		return tableData;
	}
	
	// this method stores table data into the storage unit dedicated for table data
	// it accepts an arraylist of strings as input wherein in each value is separated by a comma
	public void storeTableData(File file, ArrayList<String> data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		for(int i = 0; i<data.size(); i++) {
			bw.write(data.get(i));
			bw.newLine();
		}
		
		bw.close();
	}
}
