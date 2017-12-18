import java.util.Arrays;

public class TabularMethode {
	public SinglyLinkedList group[]; 
	public boolean willCont;
	public int variables;
	public int minTerms[], dontCare[];
	public MinTerm[][] result;
	public int primesize;
	public int [][] endofpetrick;
	public int noofsol;
	public int sollen;
	public String solution[];
	public int vars;
	public int recommend;
	
	public void program(SinglyLinkedList x, SinglyLinkedList y,int u) {
		
		minTerms = fromLinkedToArray(x);
		dontCare = fromLinkedToArray(y);
		if(getNoOfVara(minTerms) > getNoOfVara(dontCare)){
			recommend = getNoOfVara(minTerms);
		}else{
			recommend = getNoOfVara(dontCare);
		}
		if(u < getNoOfVara(minTerms) || u < getNoOfVara(dontCare)){
			
			throw null;
		}
		vars = u;
		grouping(minTerms, dontCare);
		tabularMethode();
		removeRedundantG();
		result = patric(MinTermA());
		getSolution(result);
	}
 
	/**
	 * @param minTerms
	 */
	public void grouping(int minTerms[], int dontCare[]) {
		sort(minTerms);
		sort(dontCare);
		if (getNoOfVar(minTerms) >= getNoOfVar(dontCare)) {
			variables = getNoOfVar(minTerms);
			group = new SinglyLinkedList[getNoOfVar(minTerms) + 1];
		} else {
			variables = getNoOfVar(dontCare);
			group = new SinglyLinkedList[getNoOfVar(dontCare) + 1];
		}
		for (int i = 0; i < group.length; i++) {
			group[i] = new SinglyLinkedList();
		}
		for (int i = 0; i < minTerms.length; i++) {
			MinTerm temp = new MinTerm();
			temp.index = minTerms[i];
			temp.dontCare = false;
			temp.covering.add(temp.index);
			group[whichGroup(minTerms[i])].add(temp);
		}
		for (int i = 0; i < dontCare.length; i++) {
			MinTerm temp = new MinTerm();
			temp.index = dontCare[i];
			temp.dontCare = true;
			group[whichGroup(dontCare[i])].add(temp);
		}
	}
 
	/**
	 * @param group1
	 * @param y
	 */
	public void minimize(SinglyLinkedList group1, SinglyLinkedList group2) {
		if (!group1.isEmpty() && !group2.isEmpty()) {
			for (int i = 0; i < group1.size(); i++) {
				MinTerm temp1 = (MinTerm) group1.get(i);
				for (int j = 0; j < group2.size(); j++) {
					MinTerm temp2 = (MinTerm) group2.get(j);
					if (temp2.index > temp1.index) {
						if ((temp2.index - temp1.index == 1) || (whichGroup((temp2.index - temp1.index))  == 1)) {
							if (checkPrevMinEquality(temp1.minimizations, temp2.minimizations)) {
								MinTerm temp3 = new MinTerm();
								temp3.index = temp1.index;
								for (int k = 0; k < temp1.minimizations.size(); k++) {
									temp3.minimizations.add(temp1.minimizations.get(k));
								}
								temp3.minimizations.add(temp2.index - temp1.index);
								temp3.covering = coveringFunc(temp1, temp2);
								temp1.minimized = true;
								temp2.minimized = true;
								i++;
								group1.add(0, temp3);
							}
						}
					}
				}
 
			}
			deleteMinimizedTerm(group1);
		}
	}
 
	public void tabularMethode() {
		for (int i = 0; i < variables; i++) {
			for (int j = 0; j < group.length; j++) {
				if (j + 1 < group.length)
					minimize(group[j], group[j + 1]);
			}
			deleteMinimizedTerm(group[variables - i]);
		}
	}
 
	/**
	 * @param x
	 */
	public void sort(int x[]) {
		int temp;
		boolean flag = true;
		int noOfmoves = 0;
		while (flag) {
			flag = false;
			for (int i = 1; i < x.length - noOfmoves; i++) {
				if (x[i - 1] > x[i]) {
					temp = x[i - 1];
					x[i - 1] = x[i];
					x[i] = temp;
					flag = true;
				}
			}
			noOfmoves++;
		}
	}
 
	/**
	 * @param str
	 * @return
	 */
	public int convertInt(String str) {
		return Integer.parseInt(str);
	}
 
	/**
	 * @param minTerms
	 * @return
	 */
	public int getNoOfVar(int minTerms[]) {
		if(minTerms.length != 0)
			//return Integer.toBinaryString(minTerms[minTerms.length - 1]).length();
			return vars;
		else
			return 0;
	}
	public int getNoOfVara(int minTerms[]) {
		if(minTerms.length != 0)
			return Integer.toBinaryString(minTerms[minTerms.length - 1]).length();
		else
			return 0;
	}
	/**
	 * @param minT
	 * @return
	 */
	public int whichGroup(int minT) {
		return Integer.bitCount(minT);
	}
 
	/**
	 * @param x
	 * @return
	 */
	public int[] fromLinkedToArray(SinglyLinkedList x) {
		int[] array = new int[x.size];
		for (int i = 0; i < x.size; i++) {
			array[i] = (int) x.get(i);
		}
		return array;
	}
 
	/**
	 * 
	 * @return
	 */
	public boolean checkPrevMinEquality(SinglyLinkedList group1M, SinglyLinkedList group2M) {
		if (group1M.size() != group2M.size())
			return false;
		int g1array[] = fromLinkedToArray(group1M);
		int g2array[] = fromLinkedToArray(group2M);
		sort(g1array);
		sort(g2array);
 
		return isEqualArr(g1array, g2array);
 
	}
 
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isEqualArr(int x[], int y[]) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != y[i])
				return false;
		}
		return true;
	}
 
	/**
	 * @param group
	 */
	void deleteMinimizedTerm(SinglyLinkedList group) {
		for (int i = 0; i < group.size(); i++) {
			MinTerm temp = (MinTerm) group.get(i);
			if (temp.minimized) {
				group.remove(i);
				i--;
			}
		}
	}
 
	/**
	 * @param group
	 */
	public void removeRedundant(SinglyLinkedList group) {
		SinglyLinkedList temp = group;
		for (int i = 0; i < group.size(); i++) {
			MinTerm x = (MinTerm) group.get(i);
			for (int j = i + 1; j < temp.size(); j++) {
				MinTerm y = (MinTerm) temp.get(j);
				if (y.index == x.index && checkPrevMinEquality(x.minimizations, y.minimizations)) {
					group.remove(j);
					j--;
				}
			}
		}
	}
 
	/**
	 * 
	 */
	public void removeRedundantG() {
		for (int i = 0; i < group.length; i++) {
			removeRedundant(group[i]);
		}
	}
 
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public SinglyLinkedList coveringFunc(MinTerm x, MinTerm y) {
		SinglyLinkedList covering = new SinglyLinkedList();
		for (int i = 0; i < x.covering.size(); i++) {
			covering.add(x.covering.get(i));
		}
		for (int i = 0; i < y.covering.size(); i++) {
			covering.add(y.covering.get(i));
		}
		int coverA[] = fromLinkedToArray(covering);
		sort(coverA);
		covering = fromArraytoLinked(coverA);
		return covering;
	}
 
	/**
	 * @param x
	 * @return
	 */
	public SinglyLinkedList fromArraytoLinked(int[] x) {
		SinglyLinkedList temp = new SinglyLinkedList();
		for (int i = 0; i < x.length; i++) {
			temp.add(x[i]);
		}
		return temp;
	}
	public MinTerm[] MinTermA(){
		SinglyLinkedList x  = new SinglyLinkedList();
		for(int i = 0;i < group.length;i++){
			for(int j = 0;j < group[i].size();j++){
		       MinTerm temp=(MinTerm) group[i].get(j);
		       if (temp.dontCare&&temp.minimizations.isEmpty())
		    	   continue;
			       x.add(temp);

		       
			}
		}
		MinTerm minterm [] = new MinTerm[x.size()];
		for(int i=0;i<minterm.length;i++){
			minterm[i] = new MinTerm();
			minterm[i] = (MinTerm)x.get(i);
		}
		this.primesize=minterm.length;
		return minterm;
	}
	/**
	 * @param x
	 * @return
	 */
	public MinTerm[][]  patric (MinTerm []x){
		String h="";
		int counter=0;
		SinglyLinkedList c= new SinglyLinkedList();
	/*int [] arr =new int [minTerms.length];
		for (int k=0;k<x.length;k++){
			for(int i=0;i<x[k].covering.size;i++){
				for (int j=0;j<minTerms.length;j++){
					if(x[k].covering.get(i)==(Object)minTerms[j]){
						arr[j]=1;
					}
				}
			}
			for (int n=0;n<arr.length;n++){
				h+=arr[n];
			}
			x[k].patrics=h;
			h="";
			for (int n=0;n<x.length;n++){
				arr[n]=0;
			}
		}*/
		int [] arr =new int [x.length];
		for (int k=0;k<minTerms.length;k++){
			for(int i=0;i<x.length;i++){
					if(x[i].covering.contains(minTerms[k])){
						arr[i]=1;
					}
			}
			for (int n=0;n<x.length;n++){
				h+=arr[n];
			}
	//*****//		x[k].patrics=h;
			x[0].patrico.add(h);
			h="";
			for (int n=0;n<x.length;n++){
				arr[n]=0;
			}
		}

		for (int i=0;i<minTerms.length;i++){
			for (int j=0;j<x.length;j++){
				for (int k=0;k<x[j].covering.size;k++){
					if (x[j].covering.get(k)==(Object)minTerms[i]){
						counter++;
						c.add(j);
					}
				}
			}
			if (counter==1){
				x[(int) c.get(0)].ifessintial=true;
				
			}
			counter=0;
			c.clear();
		}
		String [] o =arrwork(x);
		String [] k = rotate(o); 
		/*for(int i=0;i<o.length;i++){
			System.out.println(o[i]);
		}*/
		/*if (x.length==2){
			for(int i=2;i<x.length+1;i++){
				wtf b= new wtf();
				b.combinations2(k, i, 0, new String[i]);
				if (b.counter!=0){
					int a= 0;
					int [][] sol=new int [b.counter][b.results];
					for(int t=0;t<(b.counter);t++){
						for (int y=0;y<b.results;y++){
							sol[t][y]=(int) b.solution.get(a);
							a++;
							
						}
						
					}
					this.sollen=b.results;
					this.noofsol=b.counter;
					this.endofpetrick=sol;
					break;
				}
			}
			
		}else{*/
		for(int i=1;i<x.length+1;i++){
			wtf b= new wtf();
			b.combinations2(k, i, 0, new String[i]);
			if (b.counter!=0){
				int a= 0;
				int [][] sol=new int [b.counter][b.results];
				for(int t=0;t<(b.counter);t++){
					for (int y=0;y<b.results;y++){
						sol[t][y]=(int) b.solution.get(a);
						a++;	
					}
				}
				this.sollen=b.results;
				this.noofsol=b.counter;
				this.endofpetrick=sol;
				break;
			}
		}
		//}
		
		MinTerm [][] res =new MinTerm[noofsol][sollen];
		for (int i=0;i<noofsol;i++){
			res[i]=new MinTerm[sollen];
			for (int j=0;j<sollen;j++){
				res[i][j]=new MinTerm();
				res[i][j]=x[endofpetrick[i][j]];
			}
		}
		
		return res;
	}
	public void print(){
		for(int i=0;i<minTerms.length;i++){
			System.out.println(minTerms[i]);
		}
	}
	
	public String[] arrwork(MinTerm []x){
		String [] l = new String [minTerms.length];
		for(int i=0;i<minTerms.length;i++){
			l[i]=(String) x[0].patrico.get(i);
		}
		return l;
	}
	
	public  String[] rotate(String [] toRotate)
	  {
		if (toRotate.length==0){
			return null ;
		}

	      String [] returnChar = new String[toRotate[0].length()];
	      String [] result = new String[toRotate[0].length()];
	      Arrays.fill(returnChar, "");

	      for(int rows = 0; rows<toRotate.length; rows++)
	          for(int cols = 0 ; cols < toRotate[rows].length(); cols++)
	              returnChar[cols] = returnChar[cols] + toRotate[rows].charAt(cols);

	      for(int i = 0; i < returnChar.length; i++)
	          result[i] =  new StringBuffer(returnChar[i]).reverse().toString();

	      return result;
	  }
	
	public String [] getSolution(MinTerm[][] x) {
		solution = new String[x.length];
		for (int i = 0; i < x.length; i++) {
			StringBuilder buildsol = new StringBuilder();
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] != null)
					buildsol.append(getValueOfPrime(x[i][j]));
				if (getValueOfPrime(x[i][j]).length() > 0) {
					buildsol.append('+');
				}
			}
			if (buildsol.length() > 0) {
				if (buildsol.charAt(buildsol.length() - 1) == '+') {
					buildsol.deleteCharAt(buildsol.length() - 1);
				}
			}
			solution[i] = String.valueOf(buildsol);
		}
		
		String[] arr= solution;
		return  arr;
	}
	
	public String getValueOfPrime(MinTerm x) {
		String value = new String();
		StringBuilder expressionBuilder = new StringBuilder();
		StringBuilder binary = new StringBuilder();
		binary.append(Integer.toBinaryString(x.index));
		while (binary.length() < variables) {
			binary.insert(0, '-');
		}
		for (int i = 0; i < variables; i++) {
			char literal = (char) (64 + variables - i);
			if (!x.minimizations.contains((int) Math.pow(2, i))) {
				if (binary.charAt(variables - 1 - i) == '1') {
					expressionBuilder.append(literal);
				} else if (binary.charAt(variables - 1 - i) == '0' || binary.charAt(variables - 1 - i) == '-') {
					expressionBuilder.append("'");
					expressionBuilder.append(literal);
 
				}
			}
		}
		expressionBuilder.reverse();
		value = String.valueOf(expressionBuilder);
		return value;
	}
	
	public void varsWillbeUsed() {
		System.out.print("these variables will be used in Expression :");
		for (int i = 0; i < variables; i++) {
			System.out.print(" " + (char) (65 + i));
		}
		System.out.println(".");
	}
 
	public void printSolutions() {
		for (int i = 0; i < solution.length; i++) {
			System.out.printf("Solution (%d) :\n", i + 1);
			System.out.println(solution[i]);
		}
	}


}
