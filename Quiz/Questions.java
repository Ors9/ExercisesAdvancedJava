import java.util.Random;

public class Questions {
	private Question[] q;
	
	public Questions( ) {
		q = new Question[10];
		
		for (int i = 0; i < q.length; i++) {
			q[i] = new Question("question " + (i + 1), i % 2 == 0);
		}
	}
	
	public Question getRandomQuestion() {
		Random r = new Random();
		return q[r.nextInt(10)];
	}
	
	public Question getQustion(int index) {
		return q[index];
	}
}
