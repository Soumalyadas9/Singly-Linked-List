import java.util.*;
//Singly Liked List
class Node{ 
	int data; // value
 	Node next; //address of next node
}
class  Begining{
	Node root;
	int Length_of_the_Linked_List=Length();
	public void Create(int l){
		Node node = new Node();
		node.data=l;
		node.next=null;
		if(root==null){
			root=node;
		}else{
			Node n = root;
			while(n.next!=null){
				n=n.next;
			}
			n.next=node;
		}
	}
	public void Insert_Begining(int a){
		Node n;
		Node node = new Node();
		node.data=a;
		node.next=null;
		if(root==null){
			root=node;
		}else{
			n=root;
			root=node;
			node.next=n;
		}
	}
	public void show(){
		Node node= root;
		if(node==null){
		    System.out.println("Linked List Empty\n");
		}else{
			while(node.next!=null){
				System.out.print(node.data+"->"+" ");
			    node=node.next;
		        }
		    System.out.print(node.data+"->"+" ");
		}
	}
	public  void Delete_Begining(){
		Node n;
		if(root==null){
			System.out.println("Linked List is empty ");
		}else{
			Node node = root;
			int x =   node.data;
			n=node.next;
			root=n;
			System.out.println(x+" : element was deleted");
		}
	}
	public void Insert_User(int x,int p){//Insert user choice position
		int l=Length(); //Length of the Linked List
		if(p>l){
			System.out.println("\nEnter any other valid position");
		}else{
			int k =1;
			Node node = root;
			while(k<p-1){
				node=node.next;
				k++;
			}
			Node n = new Node();
			n.data=x;
			n.next=node.next;
			node.next=n;
		}
	}
	public void Delete_User(int p){ //Delete user choice Position
	    int l =Length(); //Length of the Liked List
	    if(p>l){
			System.out.println("\nEnter any other valid position");
		}else if(p==1){
			Node temp = root;
			root=temp.next;
			temp.next=null;
		}else{
			int k =1;
			Node node = root;
			while(k<p-1){
				node=node.next;
				k++;
			}
			Node n = node.next;
			node.next=n.next;
		}
	}
	public void Reverse(){
		int l = Length();
		int i=0,j=l-1;
		Node p =root;
		Node q  =  root;
        while(i<j){
			int k=0;
			while(k<j){
			 	q = q.next;
				k++;
			}
			int temp = q.data;
			q.data = p.data;
			p.data=temp;
			i++;
			j--;
			p = p.next;
			q=root;
		}		
	}
	public void Sort(){//Using Bubble Sort 
		Node p,q ;
		for(p=root;p.next!=null;p=p.next){
			for(q=root;q.next!=null;q=q.next){
				if(q.data > q.next.data){
					int temp= q.data;
					q.data=q.next.data;
                    q.next.data=temp;					
				}
			}
		}
	}
	public int Length(){
		Node node = root;
		int count=0;
		if(node==null){
			System.out.println("Linked List is empty");
		}else{
			count++;
			while(node.next!=null){
				count++;
			    node=node.next;
				}
		}
		return count;
	}
}
public class All_Operations_Of_Linked_List{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Begining obj = new Begining();
		while(true){
			System.out.println("\n----------************----------");
			System.out.println("1.Insert new Node ");
		    System.out.println("2.Display");
		    System.out.println("3.Insert at Begining");
		    System.out.println("4.Delete Begining");
			System.out.println("5.Insert a node user choice position");
			System.out.println("6.Delete a node user choice position");
			System.out.println("7.Reverse the Linked List");
			System.out.println("8.Sort the Linked List");
			System.out.println("9.Length of the Liked List");
			System.out.println("10.Exit");
		    System.out.println("Enter the Choice: ");
		    int n = sc.nextInt();
		    switch(n){
				case 1:System.out.println("Enter the number of Elements you want enter:");
			       int k =sc.nextInt();
				   for(int i=0;i<k;i++){
					   int z =i+1;
					   System.out.println("Enter "+z+" element: ");
					   obj.Create(sc.nextInt());
				   }
				   break;
		        case 2: obj.show();
			            break;
			    case 3: System.out.println("Enter the element :");
				        int a=sc.nextInt();
				        obj.Insert_Begining(a);
				        break;
			    case 4: obj.Delete_Begining();
				        break;
				case 5:	System.out.println("Enter the number :");
				        int j = sc.nextInt();
						System.out.println("Enter the position :");
						int l=sc.nextInt();
				        obj.Insert_User(j,l);
						break;
				case 6:	System.out.println("Enter the Position");
				        int p =sc.nextInt();
						obj.Delete_User(p);
						break;
				case 7: obj.Reverse();
                        break;				
				case 8:	obj.Sort();
				        break;
				case 9:	int len=obj.Length();
				        System.out.println("The length is :"+len);
				        break;
				case 10: System.exit(0);		
			}
		}
	}
}