package codingtest.Nhn202205;

import java.util.ArrayList;

public class Nhn2 {
	ArrayList<User> userArray = new ArrayList<>();

	public int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
		int[] result = new int[balance.length];
		def(balance); // 최초유저들 선언
		moveMoney(transaction); // 돈 이동
		deleteAbnormal(abnormal); // 불법유저돈 제거
		
		for (int i = 0; i < userArray.size(); i++) {
			for (int j = 0; j < userArray.get(i).moneyArray.size(); j++) {
				result[i] += userArray.get(i).moneyArray.get(j).val;
			}
		}

		
//		for (int i = 0; i < userArray.size(); i++) {
//			for (int j = 0; j < userArray.get(i).moneyArray.size(); j++) {
//				System.out.print(userArray.get(i).moneyArray.get(j).userNum + " "
//						+ userArray.get(i).moneyArray.get(j).val + "||  ");
//			}
//			System.out.println();
//		}
		
		return result;
	}

	private void deleteAbnormal(int[] abnormal) {
		int abnormalUser = 0;
		for (int k = 0; k < abnormal.length; k++) {
			abnormalUser = abnormal[k];
			for (int i = 0; i < userArray.size(); i++) {
				for (int j = userArray.get(i).moneyArray.size() - 1; j >= 0; j--) {
					if (userArray.get(i).moneyArray.get(j).userNum == abnormalUser) {
						userArray.get(i).moneyArray.remove(j);
					}
				}
			}
		}

	}

	private void moveMoney(int[][] transaction) {
		for (int i = 0; i < transaction.length; i++) {
			int fromNum = transaction[i][0];
			int toNum = transaction[i][1];
			int val = transaction[i][2];
			User fromUser = findUser(fromNum); // 주는놈 찾기
			User toUser = findUser(toNum); // 받는놈 찾기
			// from에서 꺼내서 to에게 주기
			giveMoney(fromUser, toUser, val);
		}

	}

	private void giveMoney(User fromUser, User toUser, int val) {
		int money = val;

		while (money > 0) {
			int index = fromUser.moneyArray.size() - 1;
			if (fromUser.moneyArray.get(index).val == money) { // 돈보내는거 딱맞은 경우
				toUser.moneyArray.add(fromUser.moneyArray.get(index));
				fromUser.moneyArray.remove(index);
				break;
			} else if (fromUser.moneyArray.get(index).val > money) {
				Money tempMoney = new Money(fromUser.moneyArray.get(index).userNum, money);
				toUser.moneyArray.add(tempMoney);
				fromUser.moneyArray.get(index).minusMoney(money);
				break;
			} else {
				toUser.moneyArray.add(fromUser.moneyArray.get(index));
				money = money - fromUser.moneyArray.get(index).val;
				fromUser.moneyArray.remove(index);
			}

		}

	}

	public class User {
		int userNum;
		ArrayList<Money> moneyArray;

		public User(int userNum, int val) {
			this.userNum = userNum;
			moneyArray = new ArrayList<Money>();
			Money money = new Money(userNum, val);
			moneyArray.add(money);
		}

	}

	public class Money {
		int userNum;
		int val;

		public Money(int userNum, int val) {
			this.userNum = userNum;
			this.val = val;
		}

		public void minusMoney(int money) {
			this.val = this.val - money;
		}
	}

	private User findUser(int userNum) {
		User user = null;
		for (int i = 0; i < userArray.size(); i++) {
			if (userArray.get(i).userNum == userNum) {
				user = userArray.get(i);
				break;
			}
		}
		return user;

	}

	private void def(int[] balance) {
		for (int i = 0; i < balance.length; i++) { // 선언
			User user = new User(i + 1, balance[i]);
			userArray.add(user);
		}

	}
}
