package pojo;

public class Question {
	private int id;
	private String pro;
    private int type;
    private String A;
    public Question(int id, String pro, int type, String a, String b, String c, String d, String task) {
		this.id = id;
		this.pro = pro;
		this.type = type;
		A = a;
		B = b;
		C = c;
		D = d;
		this.task = task;
	}
	public Question(String pro, int type, String a, String b, String c, String d, String task) {
		super();
		this.pro = pro;
		this.type = type;
		A = a;
		B = b;
		C = c;
		D = d;
		this.task = task;
	}
	private String B;
    private String C;
    private String D;
    private String task;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
}