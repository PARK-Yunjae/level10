package _08제네릭클래스;

/*
# 주요 기능
1. 추가 : add(value)
2. 삭제 : remove(idx), remove(value)
3. 삽입 : add(idx, value)
4. 수정 : set(idx, value)
5. 개수 : size()
6. 값 읽기 : get(idx)
7. 전체 삭제 : clear()
*/
class MyVector<T> {
	Object[] arr;
	int size;
	int capacity;

	MyVector() {
		arr = new Object[10];
		capacity = 10;
	}

	// 사이즈를 늘려야 할때
	void equalsSizeCaparity() {
		Object[] copy = arr;
		arr = new Object[capacity + 10];
		for (int i = 0; i < copy.length; i += 1) {
			arr[i] = copy[i];
		}
		capacity += 10;
	}

	// 추가
	void add(T value) {
		// 사이즈랑 캐파시티랑 같으면
		if (size == capacity) {
			equalsSizeCaparity();
		}
		arr[size++] = value;
	}

	// 삭제 - 인덱스만 구현
	void remove(int idx) {
		if (idx >= size || idx < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = idx; i < size; i += 1) {
			arr[i] = arr[i + 1];
		}
		arr[size] = null;
		size--;
	}

	
	
	// 삽입
	void add(int idx, T value) {
		if (idx >= size || idx < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		// 사이즈랑 캐파시티랑 같으면
		if (size == capacity) {
			equalsSizeCaparity();
		}
		for (int i = size++; i > idx; i -= 1) {
			arr[i] = arr[i - 1];
		}
		arr[idx] = value;

	}

	// 수정
	void set(int idx, T value) {
		if (idx >= size || idx < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[idx] = value;
	}

	// 실제 값
	int size() {
		return size;
	}

	// 배열 크기
	int capacity() {
		return capacity;
	}

	// 값 읽기
	@SuppressWarnings("unchecked")
	T get(int idx) {
		if (idx >= size || idx < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) arr[idx];
	}

	// 전체 삭제
	void clear() {
		size = 0;
		arr = new Object[capacity];
	}

	@Override
	public String toString() {
		if(size == 0) return "[]";
		String data = "[";
		for (int i = 0; i < size; i += 1) {
			data += arr[i] + ",";
		}
		data = data.substring(0, data.length()-1);
		data += "]";
		return data;
	}
}



public class _02백터클래스구현2 {
	public static void main(String[] args) {
		MyVector<Double> v1 = new MyVector<>();

		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());

		for (int i = 0; i < 10; i += 1) {
			v1.add((i + 1) * 10*1.0);
		}

		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1.get(1));

		v1.set(1, 1000.0);
		System.out.println(v1);

		v1.add(1, 20.0);
		System.out.println(v1);

		v1.remove(3);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());

		v1.clear();
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
	}
}
