package mergesort;

public class Mergesort {

	
	public Mergesort(int[] array){
		print(array);
		array = sort(array);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {9,5,1,3,7,4,6,10,20,13,16,12,14,11,18,15,19,2,8,17};
		new Mergesort(array);
	}
	
	
	
	public int[] sort (int[] array){
		int[] a = new int [array.length /2];
		int[] b = new int [(int) Math.ceil(array.length/2.0)];
		
		System.arraycopy(array, 0, a, 0 , a.length);
		System.arraycopy(array, array.length /2, b, 0 , b.length);
		
		return sort(a, b);
	}
	
	public int[] sort(int[] a, int[] b){
		print(a, b);

		if(a.length > 1){
			int[] aa = new int [a.length /2];
			int[] bb = new int [(int) Math.ceil(a.length/2.0)];
			
			System.arraycopy(a, 0, aa, 0 , aa.length);
			System.arraycopy(a, a.length /2, bb, 0 , bb.length);
			
			a = sort(aa, bb);

		}if(b.length > 1){
			int[] aa = new int [b.length /2];
			int[] bb = new int [(int) Math.ceil(b.length/2.0)];
			
			System.arraycopy(b, 0, aa, 0 , aa.length);
			System.arraycopy(b, b.length /2, bb, 0 , bb.length);
			
			b = sort(aa, bb);
		}

		int aPointer = 0, bPointer = 0, counter = 0;
		int[] result = new int[a.length + b.length];
		
		while(counter < result.length){
			
			if(aPointer < a.length && bPointer < b.length ){
				if(a[aPointer] < b[bPointer]) result[counter++] = a[aPointer++];
				else result[counter++] = b[bPointer++];
			}else if(aPointer < a.length && bPointer == b.length){
				result[counter++] = a[aPointer++];
			}else if (aPointer == a.length && bPointer < b.length){
				result[counter++] = b[bPointer++];
			}
		}
		print(result);
		return result;
	}
	
	public void print(int[] array){
		System.out.print("[");
		for(int i = 0; i < array.length; i++){
			if(i == 0) System.out.print(array[i]);
			else System.out.print("," + array[i]);
		}
		System.out.print("]");
			System.out.println("\n\n");
	}
	
	
	public void print(int[] a, int[] b){
		StringBuilder builder = new StringBuilder("[");
		
		for(int i = 0; i < a.length; i++){
			if(i == 0) builder.append(a[i]);
			else builder.append("," + a[i]);
		}
		builder.append("]");
		
		builder.append("\t[");
		for(int i = 0; i < b.length; i++){
			if(i == 0) builder.append(b[i]);
			else builder.append("," + b[i]);
		}
		builder.append("]");
			builder.append("\n\n");

		System.out.println(builder.toString());
	}

}
