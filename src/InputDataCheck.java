
public class InputDataCheck {

	// instance data
	private int nTable, nMenu; // final�� �������� ���� ������ ���� ���̺��� ���� ���� �Է� �ޱ� ����
	private int nMenuPriceCheck;
	private int nMenuCntCheck;
	private int nYear, nMonth, nDay;

	// methods
	// 1. constructor
	public InputDataCheck() {
		nTable = 10; // �ʱ� ���̺� ������ 10���� ����
		nMenu = 5; // �ʱ� �޴��� ������ 5���� ����

		nYear = 2017; // �ʱ� 2017������ ����
		nMonth = nDay = 1; // �ʱ� ��¥�� 1�� 1�Ϸ� ����

		nMenuPriceCheck = 0; // �ʱ� �޴�üũ���� 0���� ����
		nMenuCntCheck = 1; // �ʱ� �޴��� ������ 1���� ����
	} // DefaultSetting()

	public InputDataCheck(int year, int month, int day) {
		this.nYear = (year < 2010 || year > 2017) ? 0 : year;
		// �Էµ� ���� 2010���� �۰ų� 2017���� ũ�� �ʱⰪ 2017������ �����ϰ� �� ���հ��̶�� �״�� �Է��Ѵ�.
		this.nMonth = (month < 1 || month > 12) ? 0 : month;
		// �Էµ� ���� 1~12���̰� �ƴ϶�� �ʱⰪ 1���� �����ϰ� ���հ��̶�� �״�� �Է��Ѵ�.
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			this.nDay = (day < 1 || day > 31) ? 0 : day;
		// �Էµ� ���� 1,3,5,7,8,10,12�̸� 1~31�� ���հ��� �Է� �޵��� �Ѵ�.
		else if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			this.nDay = (day < 1 || day > 30) ? 0 : day;
		// �Էµ� ���� 4, 6, 9, 11�̸� 1~30�� ���հ��� �Է� �޵��� �Ѵ�.
		else if (nMonth == 2)
			this.nDay = (day < 1 || day > 28) ? 0 : day;
		// �Էµ� ���� 2�̸� 1~28�� ���հ��� �Է� �޵��� �Ѵ�.
	} // DefaultSetting -> ���̺�� �޴��� ������ ���ڷ� �Է¹��� �ʴ´�.

	// 2. get/set methods
	public int getTable() {
		return nTable;
	} // ����� ���̺��� ������ ��ȸ�Ѵ�.

	public int getMenu() {
		return nMenu;
	} // ����� �޴��� ������ ��ȸ�Ѵ�.

	public int getYear() {
		return nYear;
	} // ����� ��¥ �� ���� ��ȸ�Ѵ�.

	public int getMonth() {
		return nMonth;
	} // ����� ��¥ �� ���� ��ȸ�Ѵ�.

	public int getDay() {
		return nDay;
	} // ����� ��¥ �� ���� ��ȸ�Ѵ�.

	public int getMenuPrice() {
		return nMenuPriceCheck;
	}

	public int getMenuCnt() {
		return nMenuCntCheck;
	}

	public void setTable(int table) {
		nTable = (table != 10) ? 0 : table;
	} // ����� ���̺��� ������ ��ȸ�Ѵ�.

	public void setMenu(int menu) {
		nMenu = (menu != 5) ? 0 : menu;
	} // ����� �޴��� ������ ��ȸ�Ѵ�.

	public void setYear(int year) {
		this.nYear = (year < 2010 || year > 2017) ? 0 : year;
	} // ��¥ �� ���� �Է¹޾� �����Ѵ�.

	public void setMonth(int month) {
		this.nMonth = (month < 1 || month > 12) ? 0 : month;
	} // ��¥ �� ���� �Է¹޾� �����Ѵ�.

	public void setDay(int day) {
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			this.nDay = (day < 1 || day > 31) ? 0 : day;
		else if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			this.nDay = (day < 1 || day > 30) ? 0 : day;
		else if (nMonth == 2)
			this.nDay = (day < 1 || day > 28) ? 0 : day;
	} // ��¥ �� ���� �Է¹޾� �����Ѵ�.

	public void setDate(int year, int month, int day) {
		this.nYear = (year < 2010 || year > 2017) ? 0 : year;
		this.nMonth = (month < 1 || month > 12) ? 0 : month;
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			this.nDay = (day < 1 || day > 31) ? 0 : day;
		else if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			this.nDay = (day < 1 || day > 30) ? 0 : day;
		else if (nMonth == 2)
			this.nDay = (day < 1 || day > 28) ? 0 : day;
	} // ��¥ ��θ� �Է¹޾� �����Ѵ�.

	public void setMenuPrice(int price) {
		nMenuPriceCheck = (price < 0) ? 0 : price;
	}

	public void setMenuCnt(int cnt) {
		nMenuCntCheck = (cnt <= 0) ? 0 : cnt;
	}

	// 3. others
	// 4. toString()
	public String toString() {
		String str = nYear + "�� " + nMonth + "�� " + nDay + "��";
		return str;
	} // ���ڿ��� �Էµ� ��¥�� ���
}
