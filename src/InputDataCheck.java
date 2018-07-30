
public class InputDataCheck {

	// instance data
	private int nTable, nMenu; // final로 선언하지 않은 이유는 추후 테이블의 개수 또한 입력 받기 위함
	private int nMenuPriceCheck;
	private int nMenuCntCheck;
	private int nYear, nMonth, nDay;

	// methods
	// 1. constructor
	public InputDataCheck() {
		nTable = 10; // 초기 테이블 개수를 10개로 설정
		nMenu = 5; // 초기 메뉴의 개수를 5개로 설정

		nYear = 2017; // 초기 2017년으로 설정
		nMonth = nDay = 1; // 초기 날짜를 1월 1일로 설정

		nMenuPriceCheck = 0; // 초기 메뉴체크값을 0으로 설정
		nMenuCntCheck = 1; // 초기 메뉴의 개수를 1개로 설정
	} // DefaultSetting()

	public InputDataCheck(int year, int month, int day) {
		this.nYear = (year < 2010 || year > 2017) ? 0 : year;
		// 입력된 연이 2010보다 작거나 2017보다 크면 초기값 2017년으로 설정하고 그 사잇값이라면 그대로 입력한다.
		this.nMonth = (month < 1 || month > 12) ? 0 : month;
		// 입력된 월이 1~12사이가 아니라면 초기값 1월로 설정하고 사잇값이라면 그대로 입력한다.
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			this.nDay = (day < 1 || day > 31) ? 0 : day;
		// 입력된 월이 1,3,5,7,8,10,12이면 1~31의 사잇값을 입력 받도록 한다.
		else if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			this.nDay = (day < 1 || day > 30) ? 0 : day;
		// 입력된 월이 4, 6, 9, 11이면 1~30의 사잇값을 입력 받도록 한다.
		else if (nMonth == 2)
			this.nDay = (day < 1 || day > 28) ? 0 : day;
		// 입력된 월이 2이면 1~28의 사잇값을 입력 받도록 한다.
	} // DefaultSetting -> 테이블과 메뉴의 개수는 인자로 입력받지 않는다.

	// 2. get/set methods
	public int getTable() {
		return nTable;
	} // 저장된 테이블의 개수를 조회한다.

	public int getMenu() {
		return nMenu;
	} // 저장된 메뉴의 개수를 조회한다.

	public int getYear() {
		return nYear;
	} // 저장된 날짜 중 연을 조회한다.

	public int getMonth() {
		return nMonth;
	} // 저장된 날짜 중 월을 조회한다.

	public int getDay() {
		return nDay;
	} // 저장된 날짜 중 일을 조회한다.

	public int getMenuPrice() {
		return nMenuPriceCheck;
	}

	public int getMenuCnt() {
		return nMenuCntCheck;
	}

	public void setTable(int table) {
		nTable = (table != 10) ? 0 : table;
	} // 저장된 테이블의 개수를 조회한다.

	public void setMenu(int menu) {
		nMenu = (menu != 5) ? 0 : menu;
	} // 저장된 메뉴의 개수를 조회한다.

	public void setYear(int year) {
		this.nYear = (year < 2010 || year > 2017) ? 0 : year;
	} // 날짜 중 연을 입력받아 변경한다.

	public void setMonth(int month) {
		this.nMonth = (month < 1 || month > 12) ? 0 : month;
	} // 날짜 중 월을 입력받아 변경한다.

	public void setDay(int day) {
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			this.nDay = (day < 1 || day > 31) ? 0 : day;
		else if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			this.nDay = (day < 1 || day > 30) ? 0 : day;
		else if (nMonth == 2)
			this.nDay = (day < 1 || day > 28) ? 0 : day;
	} // 날짜 중 일을 입력받아 변경한다.

	public void setDate(int year, int month, int day) {
		this.nYear = (year < 2010 || year > 2017) ? 0 : year;
		this.nMonth = (month < 1 || month > 12) ? 0 : month;
		if (nMonth == 1 || nMonth == 3 || nMonth == 5 || nMonth == 7 || nMonth == 8 || nMonth == 10 || nMonth == 12)
			this.nDay = (day < 1 || day > 31) ? 0 : day;
		else if (nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11)
			this.nDay = (day < 1 || day > 30) ? 0 : day;
		else if (nMonth == 2)
			this.nDay = (day < 1 || day > 28) ? 0 : day;
	} // 날짜 모두를 입력받아 변경한다.

	public void setMenuPrice(int price) {
		nMenuPriceCheck = (price < 0) ? 0 : price;
	}

	public void setMenuCnt(int cnt) {
		nMenuCntCheck = (cnt <= 0) ? 0 : cnt;
	}

	// 3. others
	// 4. toString()
	public String toString() {
		String str = nYear + "년 " + nMonth + "월 " + nDay + "일";
		return str;
	} // 문자열로 입력된 날짜를 출력
}
