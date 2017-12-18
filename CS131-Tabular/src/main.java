
public class main {

	public static void main(String[] args) {
		

	
		
		// TODO Auto-generated method stub
	TabularMethode x = new TabularMethode();
		SinglyLinkedList y = new SinglyLinkedList() , z = new SinglyLinkedList();
 
		y.add(0);
		y.add(1);
        y.add(2);
        y.add(3);
  /*      y.add(8);
        y.add(9);
        y.add(12);
        y.add(13);*/
		z.add(4);
		z.add(5);
		
		
        x.program(y, z, 4);
        MinTerm primeImplicants[][] = x.patric(x.MinTermA());
		for(int i = 0;i < x.group.length;i++){
			if(!x.group[i].isEmpty())
				System.out.println("Group("+i+") :");
 
			for(int j = 0;j < x.group[i].size();j++){
				MinTerm temp = (MinTerm)x.group[i].get(j);
				System.out.print(temp.index+"(");
				for(int k = 0; k < temp.minimizations.size();k++){
					System.out.print(temp.minimizations.get(k));
					if(k < temp.minimizations.size() - 1){
						System.out.print(",");
					}
 
				}
				System.out.print(")");
				System.out.print(" >>> Covering : ");
				for(int l = 0;l < temp.covering.size();l++){
					System.out.print(temp.covering.get(l) + " ");
				}
				String exp = x.getValueOfPrime(temp);
				System.out.print(">> Expression : ");
				System.out.print(exp);
				System.out.println(".");
			}
 
 
		}
	

		
	x.getSolution(primeImplicants);
		x.printSolutions();
		

	}

}
