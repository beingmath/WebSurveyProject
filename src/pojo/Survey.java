package pojo;

public class Survey {
	private int id;
	private String task;
	private int time;
 private String intro;
	public Survey(int id, String task, int time, String intro) {
		this.id = id;
		this.task = task;
		this.time = time;
		this.intro = intro;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getTime() {
		return time;
	}
	public Survey(String task, int time, String intro) {
		this.task = task;
		this.time = time;
		this.intro = intro;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}

}
