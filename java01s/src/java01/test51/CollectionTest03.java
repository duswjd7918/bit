package java01.test51;

class MyArray2 {
	Object[] list = new Object[10];
	int cursor = 0;

	public int add(Object instance) {

		if (cursor < list.length) {
			list[cursor++] = instance;
			return 0;
		} else {
			return -1;
		}
	}

	public int size() {
		return cursor;
	}

	public Object get(int pos) {
		return list[pos];
	}

	public int remove(int pos) { //pos 2
		if (pos >= 0 && pos < this.cursor) {
			/* System.out.println("this.cursor (remove)  ->"+this.cursor); */

			for (int i = pos; i < this.cursor; i++) {
				if (i == (this.cursor - 1)) { // 10-1 =9
					list[i] = null;
					this.cursor--;
				} else {
					list[i] = list[i + 1];
				} // if
			} // for
			return 0;
		} else {
			return -1;
		} // if
	}

	public int insert(int pos, String value) {

		if (pos >= 0 && pos < list.length) {
			if (this.cursor >= list.length) {
				System.out.println("list ㄷ ㅏ 찼다");
				return -1;
			} else { // 여유공간있으

				System.out.println("여유공간있듸    " + this.cursor); // 9

				for (int i = this.cursor++; i >= pos; i--) {
					
					if (i == pos) {
						list[pos] = value;
					} else {
						list[i] = list[i - 1];
					}
				}
				return 0;
			}
		} else {
			System.out.println("배열사이즈만줘야지바부야!");
			return -1;
		}
	
	}
}

public class CollectionTest03 {

	public static void main(String[] args) {
		System.out.println("-------arr에 add만했어 return 버전----------");
		MyArray2 arr = new MyArray2(); // return 0 or -1하는곳
		System.out.println(arr.add("00000"));// 0
		System.out.println(arr.add("11111"));
		System.out.println(arr.add("22222"));
		System.out.println(arr.add("33333"));
		System.out.println(arr.add("44444"));
		System.out.println(arr.add("55555"));
/*
		System.out.println(arr.add("66666"));
		System.out.println(arr.add("77777"));
		System.out.println(arr.add("88888")); // 10개중 9개차있는거네 this.cursor도 9
		System.out.println(arr.add("99999"));//0
		*/

		System.out.println("-------arr에 add만했어 arr.get(i) 버전----------");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}// for

		/*System.out.println("-------arr.remove(3)ㅜ----------");
		arr.remove(2);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}// for
*/
		System.out.println("-------arr에 insert 버전----------");
		arr.insert(0, "xxxxx");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}// for
	}

}
