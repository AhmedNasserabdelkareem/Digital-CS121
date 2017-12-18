
public class wtf {
	public int counter=0;
	public SinglyLinkedList term = new SinglyLinkedList();
	public SinglyLinkedList solution = new SinglyLinkedList();
	public int results=0;

	
	public void combinations2(String[] arr, int len, int startPosition, String[] result){
		
	    if (len == 0){
	    	wtf by =new wtf();
	    	int a=digit(result[0]);
	    	by.term.add(searchindex(arr, result[0]));
	    	for (int n=1;n<result.length;n++){
	    		a|=digit(result[n]);
	        	by.term.add(searchindex(arr, result[n]));

	    	}
	    	if (a==(Math.pow(2, arr[0].length())-1)){
	    		String s="";
	    		for (int z=0;z<result.length;z++){
	    			s+=by.term.get(z);
	    		}
	    		//System.out.println("Minimized : ");
	    		for (int z=0;z<result.length;z++){
	    		//	System.out.println("Prime Implicant Number"+((int)by.term.get(z)+1));
	    			this.results=result.length;
	    			solution.add((int)by.term.get(z));
	    			
	    		}
	    		counter++;
	    		
	    	}
	    	a=0;
	    	by.term.clear();
	        return;
	    }       
	    for (int i = startPosition; i <= arr.length-len; i++){
	        result[result.length - len] = arr[i];
	        combinations2(arr, len-1, i+1, result);
	    }
	}     
	public int [] gump(String []x){
		int [] arr = new int [x.length];
		for (int i=0;i<x.length;i++){
			arr[i]=Integer.parseInt(x[i]);
		}
		return arr;
	}

	public int  digit(String x){
	 return Integer.parseInt(x, 2);

	}
	public int  searchindex(String [] g,String x){
	 for (int i=0;i<g.length;i++){
		 if(digit(g[i])==digit(x)){
			 return i;
		 }
	 }
	return 0;
	 

	}
}
