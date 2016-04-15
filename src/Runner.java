import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Storage.Data;
import Storage.Manager;

public class Runner {

	public static void main(String[] args) throws IOException {
		Storage.Manager storage_manager = new Manager();
	
		
		if(storage_manager.checkIfTableExists("gani")) {
			File file = storage_manager.connectTable("gani");
			ArrayList<Data> result = storage_manager.retrieveTableData(file, "gani");
			for (Data data : result) {
				System.out.println(data.id + " " + data.first_name + " " + data.last_name + " " + data.email_address + " " + data.contact_number);
			}
		} else {
			
		}
	}

}
