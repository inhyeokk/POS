
public class CalculationSetting {
	private int total_Sum; // ī��, ����, �ܻ��� ��ü��
	private int card_Sum, cash_Sum, credit_Sum;
	// ī��, ����, �ܻ��� ��;
	private int number_Customer; // �ش����̺��� �մ�

	// DefaultConstructor
	public CalculationSetting() {
		total_Sum = card_Sum = cash_Sum = credit_Sum = 0;

		number_Customer = 1; // ���Ұ�� �� ���Ǵ� �ν��Ͻ� ����
	} // CalculationSetting()

	public CalculationSetting(int customer) {
		number_Customer = (customer < 1) ? 1 : customer;
		// 1���� ���� ���� �ԷµǸ� 1������ ���
	} // CalculationSetting()

	// get/set methods

	public int getTotalSum() {
		return total_Sum;
	}

	public int getCardSum() {
		return card_Sum;
	}

	public int getCashSum() {
		return cash_Sum;
	}

	public int getCreditSum() {
		return credit_Sum;
	}

	public int getCustomer() {
		return number_Customer;
	}

	public void CalculatingSum() {
		total_Sum = card_Sum + cash_Sum + credit_Sum;
	} // ������ ������ ī�� + ���� + �ܻ����� ������

	public String toString() {
		String str = "������ ����: " + total_Sum;
		return str;
	}
}
