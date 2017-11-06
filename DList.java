/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class DNode
{
    private Object element;
    DNode next=null;
    DNode pre=null;
    
    DNode(Object element,DNode next,DNode pre)
    {
        this.element=element;
        this.next=next;
        this.pre=pre;
    }
    Object getElement()
    {
        return this.element;
    }
    DNode getPre()
    {
        return this.pre;
    }
    DNode getNext()
    {
        return this.next;
    }
    void setElement(Object element)
    {
        this.element=element;
    }
    
    void setPre(DNode pre)
    {
        this.pre=pre;
    }
    void setNext(DNode next)
    {
        this.next=next;
    }
    
}
public class DList {

    private DNode header;
    private DNode trailer;
    
    DList()
    {
        header=new DNode(null,null,null);
        trailer=new DNode(null,null,null);
        header.setNext(trailer);
    }
    
    DNode getHeader()
    {
        return this.header;
    }
     void setHeader(DNode header)
    {
       this.header=header;
    }
     
    DNode getTrailer()
    {
        return this.trailer;
    }
     void setTrailer(DNode trailer)
    {
       this.trailer=trailer;
    }
     
     void print()
     {
         DNode current=header.getNext();
         while(current.getElement()!=null)
         {
             System.out.println(current.getElement());
             current=current.getNext();
         }
     }
     
     void addFirst(DNode current)
     {
         if(header.getNext()==null)
         {
             header.setNext(current);
			 current.setNext(trailer);
			 
         }
         else
         {
             DNode d1=header.getNext();
             d1.setPre(current);
             current.setNext(d1);
			 header.setNext(current);
			 
         }
     }
    
     void addLast(DNode current)
     {
         if(header.getNext()==null)
         {
             header.setNext(current);
			 current.setNext(trailer);
         }
         else
         {
             DNode d1=header.getNext();
             while(d1.getNext()!=trailer)
              {
				  d1=d1.getNext();
             
              }
			  
			  if(d1.getNext()==trailer)
			  {
					d1.setNext(current);
					current.setPre(d1);
					current.setNext(trailer);
			  }
         }
     }
     
     void remove(DNode current)
     {
         DNode next=current.getNext();
         DNode pre=current.getPre();
         
         pre.setNext(next);
         next.setPre(pre);
     }
     
     void reverse()
     {
		 int i=1;
		 DNode current=header.getNext();
		 
		 while(current.getNext() !=trailer)
		 {
			 i++;
			 current=current.getNext();
		 }
		 
		 DNode dlist_ele[]=new DNode[i];
		 
		 current=header.getNext();
		 
		 for(int j=0;j<i;j++)
		 {
			 dlist_ele[j]=current;
			 current=current.getNext();
			 			 
		 }
		 
		 header.setNext(dlist_ele[i-1]);
		 dlist_ele[0].setNext(trailer);
		 
		 
		 for(int j=i-1;j>=1;j--)
		 {
			 dlist_ele[j].setNext(dlist_ele[j-1]);
			 dlist_ele[j-1].setPre(dlist_ele[j]);
		 }
         
     }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        DNode a=new DNode(1,null,null);
        DNode b=new DNode(2,null,null);
        DNode c=new DNode(3,null,null);
		DNode d=new DNode(4,null,null);
		DNode e=new DNode(5,null,null);
		DNode f=new DNode(6,null,null);
		DNode g=new DNode(7,null,null);
		DNode h=new DNode(8,null,null);
		DNode i=new DNode(9,null,null);
		DNode j=new DNode(10,null,null);
		DNode k=new DNode(11,null,null);
		DNode l=new DNode(12,null,null);
		
		
		
		DList dlist=new DList();
		//dlist.print();
		dlist.addFirst(a);
		dlist.addFirst(b);
		dlist.addFirst(c);
		dlist.addFirst(d);
		
		dlist.addLast(e);
		dlist.addLast(f);
		dlist.addLast(g);
		dlist.addLast(h);
		
		dlist.addFirst(i);
		dlist.addFirst(j);
		
		dlist.addLast(k);
		dlist.addLast(l);
		
		System.out.println("Double linked list elements are :");
		dlist.print();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Double linked list elements after removal are :");
		dlist.remove(e);
		dlist.remove(b);
		dlist.remove(a);
		dlist.remove(l);
		dlist.print();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Double linked list elements after Reversal are :");		
		dlist.reverse();
		dlist.print();
		
		
		
    }
    
}
