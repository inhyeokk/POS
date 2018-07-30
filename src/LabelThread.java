import javax.swing.JLabel;

// ������ �����ϱ����� Runnable
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
		// �θ�����ڸ� ���� ����
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

	// ��������� �ʿ��� �޼ҵ� 3����
	// 1.
	public void start() {
		// ������ ������ ���� �����ϱ� ���ؼ� �ʱⰩ�� null�϶��� Thread�� ����
		if (myThread == null) {
			myThread = new Thread(this);
			// Thread�� ���۵Ǹ� run�޼ҵ尡 �ڵ����� ȣ���
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
	// Thread�� ��ӹ��� Ŭ������ �ݵ�� run�޼ҵ尡 �־���Ѵ�.
	public void run() {
		int i, j;
		try { // ������� ��µ� ���� 1�ʴ����� ��½�Ű�� ���� ���α׷� ���ۼӵ��� ���������� �����ϴ� sleep�޼ҵ带 ����ؾ��ϴµ� �̶� �߻��ϴ�
				// �ý������� ������ �����ϰ��� try catch�� ����Ѵ�.
			for (i = nStart; i <= nFinish; i += 10) {
				setText("Calculating " + Integer.toString(i) + "%");
				myThread.sleep(300);// 0.2�� 200
			}
			SPP.showValue();
		} catch (

		Exception e) {

		}
	}// run()
}// LabelThread class
