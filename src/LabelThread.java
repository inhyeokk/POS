import javax.swing.JLabel;

// 동작을 실행하기위해 Runnable
public class LabelThread extends JLabel implements Runnable {
	private int nStart, nFinish;
	private Thread myThread;

	private SalesPrintPanel SPP;

	public LabelThread() {
		nStart = nFinish = 0;
		myThread = null;
	} // LabelThread()

	public LabelThread(SalesPrintPanel p) {
		nStart = nFinish = 0;
		myThread = null;

		SPP = p;
	}

	public LabelThread(int s, int f) {
		nStart = s;
		nFinish = f;
		myThread = null;
	} // LabelThread()

	public LabelThread(String str) {
		super(str);
		// 부모생성자를 통해 생성
		// == setText(str);
		nStart = nFinish = 0;
		myThread = null;
	} // LabelThread()

	public int getStart() {
		return nStart;
	}

	public int getFinish() {
		return nFinish;
	}

	public void setStart(int s) {
		nStart = s;
	}

	public void setFinish(int f) {
		nFinish = f;
	}

	public void setRange(int s, int f) {
		nStart = s;
		nFinish = f;
	}

	// 통상적으로 필요한 메소드 3가지
	// 1.
	public void start() {
		// 이전에 실행한 값을 저장하기 위해서 초기갑이 null일때만 Thread를 생성
		if (myThread == null) {
			myThread = new Thread(this);
			// Thread가 시작되면 run메소드가 자동으로 호출됨
			myThread.start();
		}
	} // start()

	// 2.
	public void stop() {
		if (myThread != null) {
			myThread.stop();
			myThread = null;
		}
	} // stop()

	// 3.
	// Thread를 상속받은 클래스는 반드시 run메소드가 있어야한다.
	public void run() {
		int i, j;
		try { // 순서대로 출력된 값을 1초단위로 출력시키기 위해 프로그램 동작속도를 인위적으로 조작하는 sleep메소드를 사용해야하는데 이때 발생하는
				// 시스템적인 문제를 방지하고자 try catch를 사용한다.
			for (i = nStart; i <= nFinish; i += 10) {
				setText("Calculating " + Integer.toString(i) + "%");
				myThread.sleep(300);// 0.2초 200
			}
			SPP.showValue();
		} catch (

		Exception e) {

		}
	}// run()
}// LabelThread class
