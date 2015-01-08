package vn.edu.vnu.uet.quannk_56.lotterysimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CDataOfYear {
	final int year;
	final int[][] data;

	private static int NUMBER_OF_MONTH_PER_YEAR = 12;
	private static int NUMBER_OF_DAY_PER_MONTH = 31;

	public CDataOfYear() {
		data = new int[NUMBER_OF_MONTH_PER_YEAR][];
		for (int i = 0; i < NUMBER_OF_MONTH_PER_YEAR; i++) {
			data[i] = new int[NUMBER_OF_DAY_PER_MONTH];
		}
		this.year = 2005;
	}

	public void Setup(int year, String fileName) {
		//System.out.println("Data of year " + year);
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int count = 0;
			for (int iDay = 0; iDay <= 31; iDay++) {
				line = bufferedReader.readLine();
				assert (line != null);

				String t[] = line.split(",");
				if (iDay == 0)
					continue;
				for (int iMonth = 0; iMonth <= 12; iMonth++) {
					if (iMonth == 0)
						continue;

					if (!(iMonth >= t.length) && t[iMonth].compareTo("") != 0)
						data[12 - iMonth][iDay - 1] = Integer
								.parseInt(t[iMonth]);
					else
						data[12 - iMonth][iDay - 1] = -1;
					//System.out.print(data[12 - iMonth][iDay - 1] + "\t");
				}
				//System.out.println();
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CDataOfYear(int year, String fileName) {
		this();
		Setup(year, fileName);
	}

	public static void main(String args[]) {
		CDataOfYear data2005 = new CDataOfYear(2005, "data/2005.csv");
	}
}
