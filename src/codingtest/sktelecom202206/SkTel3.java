package codingtest.sktelecom202206;

import java.util.*;

public class SkTel3 {
	int[] result;

	public int[] solution(int n, String[] plans, String[] clients) {
		result = new int[clients.length];

		Plan[] planArr = new Plan[plans.length];
		planArr = setPlans(n, plans);

		for (int i = 0; i < clients.length; i++) {
			int no = setResult(planArr, clients[i]);
			result[i] = no;
		}

		return result;
	}

	public Plan[] setPlans(int n, String[] plans) {
		Plan[] planArr = new Plan[plans.length];
		int[] service = new int[n + 1];
		for (int i = 0; i < plans.length; i++) {
			String[] plan = plans[i].split(" ");
			int data = Integer.parseInt(plan[0]);

			for (int j = 1; j < plan.length; j++) {
				service[Integer.parseInt(plan[j])] = 1;
			}

			int[] temp = new int[n + 1];
			for (int k = 0; k < service.length; k++) {
				temp[k] = service[k];
			}
			Plan pl = new Plan(i + 1, data, temp);
			planArr[i] = pl;

		}
		return planArr;
	}

	public int setResult(Plan[] planArr, String client) {
		int no = 0;
		String[] def = client.split(" ");
		int data = Integer.parseInt(def[0]);
		int[] service = new int[def.length - 1];
		for (int i = 1; i < def.length; i++) {
			service[i - 1] = Integer.parseInt(def[i]);
		}

		for (int i = 0; i < planArr.length; i++) {
			if (isSatisfied(planArr[i], data, service)) {
				no = planArr[i].no;
				break;
			}
		}
		return no;
	}

	public boolean isSatisfied(Plan plan, int data, int[] service) {
		if (plan.data < data) {
			return false;
		}
		for (int i = 0; i < service.length; i++) {
			if (plan.service[service[i]] != 1) {
				return false;
			}
		}
		return true;
	}

	public class Plan {
		int no;
		int data;
		int[] service;

		public Plan(int no, int data, int[] service) {
			this.no = no;
			this.data = data;
			this.service = service;
		}
	}
}