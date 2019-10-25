package pojo;

public class Record {
	private int id;
	private String task;
	private String pro;
	private int type;
	private String A;
	private String B;
	private String C;
	private String D;
	private String useroption;
	private String username;

	public Record(String task, String pro, int type, String a, String b, String c, String d, String useroption,
			String username) {
		this.task = task;
		this.pro = pro;
		this.type = type;
		A = a;
		B = b;
		C = c;
		D = d;
		this.useroption = useroption;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getUseroption() {
		return useroption;
	}

	public void setUseroption(String useroption) {
		this.useroption = useroption;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

}
