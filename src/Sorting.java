import java.util.ArrayList;
import java.util.Random;

public class Sorting {

	//Test
	public static void main(String[] args) {

		Sorting s = new Sorting();

		//Test insertion and selection sort
		//		ArrayList<String> wordList = new ArrayList<>();
		//
		//		String[] alphabetSorted = /*{"to","be","or","not","to","be","that","is","the","question"};*/{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		//
		//		for (int i = 0; i < alphabetSorted.length; i++) {
		//			wordList.add(alphabetSorted[i]);
		//		}
		//
		//		s.scrambleArray(wordList);
		//
		//		s.printArray(wordList);
		//
		//		s.insertionSort(wordList);
		//
		//		s.printArray(wordList);

		//Test merge two arrays
		//		ArrayList<String> a = s.addRandomLettersToArrayList(3);
		//		s.insertionSort(a);
		//		ArrayList<String> b = s.addRandomLettersToArrayList(1);
		//		s.insertionSort(b);
		//		s.printArray(a);
		//		s.printArray(b);
		//		ArrayList<String> ab_merge = s.merge(a, b);
		//		s.printArray(ab_merge);

		ArrayList<String> wordList = new ArrayList<>();

		String[] alphabetSorted = /*{"to","be","or","not","to","be","that","is","the","question"};*/{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

		for (int i = 0; i < alphabetSorted.length; i++) {
			wordList.add(alphabetSorted[i]);
		}

		s.scrambleArray(wordList);

		s.printArray(wordList);

		wordList= s.mergeSort(wordList);

		s.printArray(wordList);

	}

	public Sorting() {

	} 

	public ArrayList<String> selectionSort(ArrayList<String> wordList){
		int minIndex;
		String selectedWord;
		for (int i = 0; i < wordList.size()-1; i++) {
			minIndex = i;
			for (int j=i+1; j < wordList.size(); j++) {
				if((wordList.get(j).compareTo(wordList.get(minIndex)))<0){
					minIndex = j;
				}
			}
			selectedWord = wordList.get(minIndex);
			wordList.set(minIndex, wordList.get(i));
			wordList.set(i, selectedWord);
		}
		return wordList;
	}

	public ArrayList<String> insertionSort(ArrayList<String> wordList){
		String valueToInsert;
		int holePosition;
		for (int i = 0; i < wordList.size(); i++) {
			valueToInsert = wordList.get(i);
			holePosition = i;
			while(holePosition>0 && valueToInsert.compareTo(wordList.get(holePosition-1))<0){
				wordList.set(holePosition, wordList.get(holePosition-1));
				holePosition--;
			}
			wordList.set(holePosition, valueToInsert);
		}
		return wordList;
	}

	public ArrayList<String> mergeSort(ArrayList<String> wordList){

		if(wordList.size()<=1){
			return wordList;
		}

		ArrayList<String> left = new ArrayList<>();
		ArrayList<String> right = new ArrayList<>();

		for (int i = 0; i < wordList.size(); i++) {
			if(i<(wordList.size())/2){
				left.add(wordList.get(i));
			}else{
				right.add(wordList.get(i));
			}
		}
		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left,right);
	}

	private ArrayList<String> merge(ArrayList<String> a,ArrayList<String> b){
		ArrayList<String> res = new ArrayList<>();
		while(!(a.isEmpty() && b.isEmpty())){
			if(!a.isEmpty() && !b.isEmpty()){
				if(a.get(0).compareTo(b.get(0))<0){
					res.add(a.get(0));
					a.remove(0);
				}else if(!b.isEmpty()){
					res.add(b.get(0));
					b.remove(0);
				}	
			}else if(a.isEmpty() && !b.isEmpty()){
				res.add(b.get(0));
				b.remove(0);
			}else if(b.isEmpty() && !a.isEmpty()){
				res.add(a.get(0));
				a.remove(0);
			}
		}
		return res;
	}

	public void printArray(ArrayList<String> array){
		for (String s : array) {
			System.out.print(s+" ");
		}
		System.out.println();
	}

	public void scrambleArray(ArrayList<String> wordList){
		Random rand = new Random();
		int min = 0;
		int max = wordList.size()-1;
		int r1;
		int r2;
		String tmp;
		for (int i = 0; i < wordList.size()*rand.nextInt(100); i++) {
			r1 = rand.nextInt((max - min) + 1) + min;
			r2 = rand.nextInt((max - min) + 1) + min;
			tmp=wordList.get(r1);
			wordList.set(r1, wordList.get(r2));
			wordList.set(r2, tmp);
		}
	}

	public ArrayList<String> addRandomLettersToArrayList(int sizeOfArray){
		String[] alphabetSorted = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Random rand = new Random();
		int min = 0;
		int max = alphabetSorted.length-1;
		int rand_num;
		ArrayList<String> res = new ArrayList<>();

		for (int i = 0; i < sizeOfArray; i++) {
			rand_num = rand.nextInt((max - min) + 1) + min;
			res.add(alphabetSorted[rand_num]);
		}
		return res;
	}

}
