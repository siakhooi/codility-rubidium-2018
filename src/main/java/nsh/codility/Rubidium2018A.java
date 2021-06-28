package nsh.codility;

public class Rubidium2018A implements Rubidium2018Interface {

	public int solution(int[] X, int[] Y) {
		int N = X.length;
		int R = 1000000;
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				R = Math.min(R, Math.max(Math.abs(X[i] - X[j]), Math.abs(Y[i] - Y[j])));
		return R / 2;
	}
}
