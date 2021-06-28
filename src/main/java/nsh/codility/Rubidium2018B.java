package nsh.codility;

import java.util.Arrays;
import java.util.Comparator;

public class Rubidium2018B implements Rubidium2018Interface {

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Node {
		Point me;
		Node left, right;

		void update(Point p, int l, int u) {
			if (l == u) {
				if (me != null)
					recalcR(me, p);
				me = p;
				return;
			}
			int m = (l + u) >> 1;
			if (me != null) {
				recalcR(me, p);
				if (me.x == p.x) {
					me = p;
					return;
				}
				if (me.x <= m) {
					left = new Node();
					left.me = me;
				} else {
					right = new Node();
					right.me = me;
				}
				me = null;
				if (p.x <= m) {
					if (left == null) {
						left = new Node();
						left.me = p;
					} else
						left.pushDown(p, l, m);
				} else {
					if (right == null) {
						right = new Node();
						right.me = p;
					} else
						right.pushDown(p, m + 1, u);
				}
			} else {
				if (p.x <= m) {
					if (left == null) {
						left = new Node();
						left.me = p;
					} else
						left.update(p, l, m);
					if (p.x + R > m && right != null)
						right.calculateR(p, m + 1, u);
				} else {
					if (right == null) {
						right = new Node();
						right.me = p;
					} else
						right.update(p, m + 1, u);

					if (p.x - R <= m && left != null)
						left.calculateR(p, l, m);
				}
			}
		}

		void calculateR(Point p, int l, int u) {
			if (me != null) {
				recalcR(me, p);
				return;
			}
			int m = (l + u) >> 1;
			if (p.x - R <= m && left != null)
				left.calculateR(p, l, m);
			if (p.x + R > m && right != null)
				right.calculateR(p, m + 1, u);
		}

		void pushDown(Point p, int l, int u) {
			if (l == u)
				return;
			int m = (l + u) >> 1;
			if (me != null) {
				if (me.x <= m) {
					left = new Node();
					left.me = me;
				} else {
					right = new Node();
					right.me = me;
				}
				me = null;
			}
			if (p.x <= m) {
				if (left == null) {
					left = new Node();
					left.me = p;
				} else
					left.pushDown(p, l, m);
			} else {
				if (right == null) {
					right = new Node();
					right.me = p;
				} else
					right.pushDown(p, m + 1, u);
			}
		}
	}

	void recalcR(Point p1, Point p2) {
		R = Math.min(R, Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y)));
	}

	int R = 1000000;

	public int solution(int[] X, int[] Y) {
		int N = X.length;
		Node Top = new Node();
		int Xm = 100000, Ym = 100000, XM = 0, YM = 0;
		Point[] P = new Point[N];
		for (int i = 0; i < N; i++) {
			P[i] = new Point(X[i], Y[i]);
			Xm = Math.min(Xm, P[i].x);
			XM = Math.max(XM, P[i].x);
			Ym = Math.min(Ym, P[i].y);
			YM = Math.max(YM, P[i].y);
		}
		R = Math.max(XM - Xm, YM - Ym);
		Arrays.sort(P, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return (o1.x == o2.x) ? o1.y - o2.y : o1.x - o2.x;
			}
		});

		Top.me = P[0];
		for (int i = 1; i < N; i++)
			Top.update(P[i], Xm, XM);
		return R / 2;
	}
}
