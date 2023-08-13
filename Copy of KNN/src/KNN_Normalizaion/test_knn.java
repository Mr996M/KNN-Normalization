package KNN_Normalizaion;

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
	
	public List<String> get_max(List<List<String>> dataSet) {
		//System.out.println("enter the process of calculating the maxium value");
		List<String> max_value = new ArrayList<>();
		for (int i = 0; i < dataSet.get(0).size() - 1; i++) {
			max_value.add(Double.MIN_VALUE + "");
		}
		//System.out.println(max_value);
		for (int i = 0; i < dataSet.size(); i++) {
			List<String> tmp = dataSet.get(i);
			//System.out.print(tmp);
			for (int j = 0; j < tmp.size() - 1; j++) {
				if (Double.parseDouble(tmp.get(j)) > Double.parseDouble(max_value.get(j))) {
					max_value.set(j, tmp.get(j));
				}
			}
			//System.out.println(max_value);
		}
		//System.out.println(max_value);
		return max_value;
	}
	
	public List<String> get_min(List<List<String>> dataSet) {
		List<String> min_value = new ArrayList<>();
		for (int i = 0; i < dataSet.get(0).size() - 1; i++) {
			min_value.add(Double.MAX_VALUE + "");
		}
		for (int i = 0; i < dataSet.size(); i++) {
			List<String> tmp = dataSet.get(i);
			for (int j = 0; j < tmp.size() - 1; j++) {
				if (Double.parseDouble(tmp.get(j)) < Double.parseDouble(min_value.get(j))) {
					min_value.set(j, tmp.get(j));
				}
			}
		}
		return min_value;
	}
	
	public List<List<String>> normalize(List<List<String>> dataSet) {
		//System.out.println("enter the normalization");
		List<List<String>> dataSet_Normalization = new ArrayList<List<String>>();
		List<String> max = get_max(dataSet);
		List<String> min = get_min(dataSet);
		//System.out.println(max.toString());
		//System.out.println(min.toString());
		for (int i = 0; i < dataSet.size(); i++) {
			List<String> tmp = dataSet.get(i);
			List<String> node = new ArrayList<>();
			for (int j = 0; j < tmp.size() - 1; j++) {
				node.add((Double.parseDouble(tmp.get(j)) - Double.parseDouble(min.get(j))) / (Double.parseDouble(max.get(j)) - Double.parseDouble(min.get(j))) + "");
			}
			node.add(tmp.get(tmp.size() - 1));
			dataSet_Normalization.add(node);
		}
		return dataSet_Normalization;
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
			List<List<String>> train_normalize = objects.normalize(train_list);
			List<List<String>> test_normalize = objects.normalize(test_list);
			System.out.println("the normalization of the dataset has been completed");
			KNN knn = new KNN();
			int k = 0, error_cnt = 0;
			char distance_type;
			String tmp, true_class;
			System.out.print("please input the value of k: ");
			k = new Scanner(System.in).nextInt();
			System.out.println("please choose the distance type to complete the knn algorithm");
			System.out.print("(enter 'e' to choose Euclidean Distance, enter 'm' to choose Manhattan Distance, enter 'c' to choose Chebyshev Distance): ");
			distance_type = new Scanner(System.in).next().charAt(0);
			for (int count = 0; count < 10; count++) {
				error_cnt = 0;
				for (int i = 0; i < test_list.size(); i++) {
					List<String> test = test_list.get(i);
					List<String> test_n = test_normalize.get(i);
					/*System.out.print("test data: ");
					for (int j = 0; j < test.size() - 1; j++) {
						System.out.print(test.get(j) + " ");
					}*/
					tmp = knn.algorithm_knn(train_normalize, test_n, k, distance_type);
					true_class = test.get(test.size() - 1);
					/*System.out.print("belongs to: ");
					System.out.print(tmp);*/
					if (!tmp.equals(true_class)) {
						error_cnt++;
						/*System.out.print("\tits real class is: ");
						System.out.print(true_class);*/
					}
					//System.out.println();
				}
				double test_num = (double) test_list.size();
				//System.out.print("error rate is: ");
				System.out.println(error_cnt / test_num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
