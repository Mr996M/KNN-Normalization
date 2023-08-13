package KNN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_knn {
	
	public void read(List<List<Double>> data, String path) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(new File(path)));
			String line_data = buffer.readLine();
			List<Double> list = null;
			while (line_data != null) {
				String num[] = line_data.split(" ");
				list = new ArrayList<Double>();
				for (int i = 0; i < num.length; i++) {
					list.add(Double.parseDouble(num[i]));
				}
				data.add(list);
				line_data = buffer.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test_knn objects = new test_knn();
		String train_data = new File("").getAbsolutePath() + "/src/KNN" + File.separator + "train_data";
		String test_data = new File("").getAbsolutePath() + "/src/KNN" + File.separator + "test_data";
		try {
			List<List<Double>> train_list = new ArrayList<List<Double>>();
			List<List<Double>> test_list = new ArrayList<List<Double>>();
			objects.read(train_list, train_data);
			objects.read(test_list, test_data);
			KNN knn = new KNN();
			int k = 0;
			System.out.print("please input the value of k: ");
			k = new Scanner(System.in).nextInt();
			for (int i = 0; i < test_list.size(); i++) {
				List<Double> test = test_list.get(i);
				System.out.print("test data: ");
				for (int j = 0; j < test.size(); j++) {
					System.out.print(test.get(j) + " ");
				}
				System.out.print("belongs to: ");
				System.out.println(Math.round(Float.parseFloat(knn.algorithm_knn(train_list, test, k))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
