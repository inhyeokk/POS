
public class CalculationSetting {
	private int total_Sum; // 카드, 현금, 외상의 전체합
	private int card_Sum, cash_Sum, credit_Sum;
	// 카드, 현금, 외상의 합;
	private int number_Customer; // 해당테이블의 손님

	// DefaultConstructor
	public CalculationSetting() {
		total_Sum = card_Sum = cash_Sum = credit_Sum = 0;

		number_Customer = 1; // 분할계산 시 사용되는 인스턴스 변수
	} // CalculationSetting()

	public CalculationSetting(int customer) {
		number_Customer = (customer < 1) ? 1 : customer;
		// 1명보다 작은 값이 입력되면 1명으로 계산
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
	} // 매출의 총합은 카드 + 현금 + 외상으로 정의함

	public String toString() {
		String str = "매출의 총합: " + total_Sum;
		return str;
	}
}
