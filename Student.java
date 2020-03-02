public class Student {
	private String name;
	private int id;

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void information() {
		System.out.println(name + "  学号：" + id);
	}

	public static void main(String args[]) {
		Student My = new Student("(replace to your name)", /*replace to your number→*/000000);
		My.information();
	}
}