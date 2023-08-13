package KNN_String;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_knn {
	
	public void read(List<List<String>> data, String path) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(new File(path)));
			String line_data = buffer.readLine();
			List<String> list = null;
			while (line_data != null) {
				String num[] = line_data.split("\t");
				list = new ArrayList<String>();
				for (int i = 0; i < num.length; i++) {
					list.add(num[i]);
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
		String train_data = new File("").getAbsolutePath() + "/src/KNN_Normalizaion" + File.separator + "train_data";
		String test_data = new File("").getAbsolutePath() + "/src/KNN_Normalizaion" + File.separator + "test_data";
		try {
			List<List<String>> train_list = new ArrayList<List<String>>();
			List<List<String>> test_list = new ArrayList<List<String>>();
			objects.read(train_list, train_data);
			objects.read(test_list, test_data);
			KNN knn = new KNN();
			int k = 0, error_cnt = 0;
			char distance_type;
			String tmp, true_class;
			System.out.print("please input the value of k: ");
			k = new Scanner(System.in).nextInt();
			System.out.println("please choose the distance type to complete the knn algorithm");
			System.out.print("(enter 'e' to choose Euclidean Distance, enter 'm' to choose Manhattan Distance, enter 'c' to choose Chebyshev Distance): ");
			distance_type = new Scanner(System.in).next().charAt(0);
			for (int i = 0; i < test_list.size(); i++) {
				List<String> test = test_list.get(i);
				System.out.print("test data: ");
				for (int j = 0; j < test.size() - 1; j++) {
					System.out.print(test.get(j) + " ");
				}
				tmp = knn.algorithm_knn(train_list, test, k, distance_type);
				true_class = test.get(test.size() - 1);
				System.out.print("belongs to: ");
				System.out.print(tmp);
				if (!tmp.equals(true_class)) {
					error_cnt++;
					System.out.print("\tits real class is: ");
					System.out.print(true_class);
				}
				System.out.println();
			}
			double test_num = (double) test_list.size();
			System.out.print("error rate is: ");
			System.out.print(error_cnt / test_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
