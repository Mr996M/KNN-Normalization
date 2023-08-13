package KNN_Normalizaion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KNN {
	
	private Comparator<KNNnode> comparator = new Comparator<KNNnode>() {
		public int compare(KNNnode node1, KNNnode node2) {
			if(node1.getDistance() >= node2.getDistance()) {
				return 1;
			} else {
				return 0;
			}
		}
	};
	
	private String MostNum_Class(PriorityQueue<KNNnode> prio_queue) {
		Map<String, Integer> class_cnt = new HashMap<String, Integer>();
		for (int i = 0; i < prio_queue.size(); i++) {
			KNNnode top = prio_queue.remove();
			String c = top.getC();
			if (class_cnt.containsKey(c)) {
				class_cnt.put(c, class_cnt.get(c) + 1);
			} else {
				class_cnt.put(c, 1);
			}
		}
		int max_index = -1;
		int max_cnt = 0;
		Object[] classes = class_cnt.keySet().toArray();
		for (int i = 0; i < classes.length; i++) {
			if (class_cnt.get(classes[i]) > max_cnt) {
				max_index = i;
				max_cnt = class_cnt.get(classes[i]);
			}
		}
		return classes[max_index].toString();
	}
	
	public List<Integer> get_K_RandNum(int k, int max) {
		List<Integer> rand = new ArrayList<Integer>(k);
		for (int i = 0; i < k; i++) {
			int tmp = (int) (Math.random() * max);
			if (!rand.contains(tmp)) {
				rand.add(tmp);
			} else {
				i--;
			}
		}
		return rand;
	}
	
	public double compute_Distance(List<String> test, List<String> train, char distance_type) {
		double distance = 0.00;
		if (distance_type == 'e') {
			for (int i = 0; i < test.size() - 1; i++) {
				distance += (Double.parseDouble(test.get(i)) - Double.parseDouble(train.get(i))) * (Double.parseDouble(test.get(i)) - Double.parseDouble(train.get(i)));
			}
		} else if (distance_type == 'm') {
			for (int i = 0; i < test.size() - 1; i++) {
				distance += Math.abs(Double.parseDouble(test.get(i)) - Double.parseDouble(train.get(i)));
			}
		} else if (distance_type == 'c') {
			for (int i = 0; i < test.size() - 1; i++) {
				distance = Math.max(distance, Math.abs(Double.parseDouble(test.get(i)) - Double.parseDouble(train.get(i))));
			}
		} else {
			System.out.print("error input");
			System.exit(0);
		}
		return distance;
	}
	
	public String algorithm_knn(List<List<String>> train, List<String> test, int k, char distance_type) {
		PriorityQueue<KNNnode> prio_queue = new PriorityQueue<KNNnode>(k, comparator);
		List<Integer> RandNum = get_K_RandNum(k, train.size());
		for (int i = 0; i < k; i++) {
			int index = RandNum.get(i);
			List<String> cur_train = train.get(index);
			String c = cur_train.get(cur_train.size() - 1);
			KNNnode cur_node = new KNNnode(index, compute_Distance(test, cur_train, distance_type), c);
			prio_queue.add(cur_node);
		}
		for (int i = 0; i < train.size(); i++) {
			List<String> cur_train = train.get(i);
			double distance = compute_Distance(test, cur_train, distance_type);
			KNNnode top = prio_queue.peek();
			if (top.getDistance() > distance) {
				prio_queue.remove();
				prio_queue.add(new KNNnode(i, distance, cur_train.get(cur_train.size() - 1).toString()));
			}
		}
		return MostNum_Class(prio_queue);
	}
	
}
