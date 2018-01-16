// Iterator

// Intent: "Provide a way to access the elements of an aggregate object 
// sequentially without exposing its underlying representation". 

// For further information, read "Design Patterns", p257, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Here wish wish to separate node traversal from the nodes themselves. 
 * STL in ISO C++ is a highly successful application of this pattern.
 * Generic programming is a great way to implement iterators. As this is 
 * not yet in C#, we use inheritance. 
 *  
 */
 
namespace Iterator_DesignPattern
{
    using System;
	using System.Collections;

	class Node 
	{
		private string name;
		public string Name 
		{
			get 
			{
				return name;	
			}
		}
		public Node(string s)
		{
			name = s;
		}
	}
	
	class NodeCollection 
	{
		private ArrayList list = new ArrayList();
		private int nodeMax = 0;
		
		// left as a student exercise - implement collection
		// functions to remove and edit entries also
		public void AddNode(Node n)
		{
			list.Add(n); 
			nodeMax++;			
		}		
		public Node GetNode(int i)
		{
			return ((Node) list[i]);
		}

		public int NodeMax 
		{			
			get 
			{
				return nodeMax;
			}
		}
	}

	/*
	 * The iterator needs to understand how to traverse the collection 
	 * It can do that as way it pleases - forward, reverse, depth-first, 
	 */
	abstract class Iterator 
	{
		abstract public Node Next();		
	}

	class ReverseIterator : Iterator
	{
		private NodeCollection nodeCollection;
		private int currentIndex;

		public ReverseIterator (NodeCollection c)
		{
			nodeCollection = c;			
			currentIndex = c.NodeMax -1; // array index starts at 0!
		}

		// note: as the code stands, if the collection changes,
		// the iterator needs to be restarted 
		override public Node Next()
		{
            if (currentIndex == -1)
				return null;
			else 
				return(nodeCollection.GetNode(currentIndex--));
		}
	}
	
    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {   
			NodeCollection c = new NodeCollection();
			c.AddNode(new Node("first"));
			c.AddNode(new Node("second"));
			c.AddNode(new Node("third"));

			// now use iterator to traverse this
			ReverseIterator i = new ReverseIterator(c);

			// the code below will work with any iterator type
			Node n;
			do 
			{
				n = i.Next();
				if (n != null) 
					Console.WriteLine("{0}", n.Name);
			} while (n != null);
				
            return 0;
        }
    }
}
