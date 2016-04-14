import java.io.IOException;
import java.util.ArrayList;

import Storage.Data;
import Storage.Manager;

public class Runner {

	public static void main(String[] args) throws IOException {
		Manager storage_manager = new Manager();
		if(storage_manager.checkIfTableExists("gani")) {
			ArrayList<Data> result = storage_manager.retrieveTableData("gani");
			for (Data data : result) {
				System.out.println(data.id + " " + data.first_name + " " + data.last_name + " " + data.email_address + " " + data.contact_number);
			}
		}
	}

}
