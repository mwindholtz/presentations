// Composite

// Intent: "Compose objects into tree structures to represent part-whole 
// hierarchies. Composite lets clients treat individual objects and 
// compositions of objects uniformly". 

// For further information, read "Design Patterns", p163, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * We often have tree structures where some nodes are containers of 
 * other nodes, and some nodes are leafs. Rather than have separate client
 * code to manage each type of node, Composite lets a client work with
 * either using the same code. 
 * 
 * There is an excellent discussion to be found in "Pattern Hatching", 
 * Vlissides, ISBN: 0-201-43293-5, describing how the Composite design
 * pattern can be used as the basis file system management 
 * (directory = composite, Leaf = file, Component = iNode)
 * 
 */
 
namespace FactoryMethod_DesignPattern
{
    using System;
	using System.Collections;

	abstract class Component 
	{
		protected string strName;

		public Component(string name)
		{
			strName = name;
		}

		abstract public void Add(Component c);
	
		public abstract void DumpContents();
		
		// other operations for delete, get, etc.
	}

	class Composite : Component
	{
		private ArrayList ComponentList = new ArrayList();
		
		public Composite(string s) : base(s) {}

		override public void Add(Component c)
		{
			ComponentList.Add(c);
		}

		public override void DumpContents()
		{
			// First dump the name of this composite node
			Console.WriteLine("Node: {0}", strName);

			// Then loop through children, and get then to dump their contents
			foreach (Component c in ComponentList)
			{
				c.DumpContents();
			}
		}
	}

	class Leaf : Component
	{
		public Leaf(string s) : base(s) {}

		override public void Add(Component c)
		{
			Console.WriteLine("Cannot add to a leaf");
		}

		public override void DumpContents()
		{
			Console.WriteLine("Node: {0}", strName);
		}
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
		Component SetupTree()
		{
			// here we have to create a tree structure, 
			// consisting of composites and leafs. 	
			Composite root = new Composite("root-composite");
			Composite parentcomposite;
			Composite composite;
			Leaf leaf;

			parentcomposite = root;
			composite = new Composite("first level - first sibling - composite");
			parentcomposite.Add(composite);
			leaf = new Leaf("first level - second sibling - leaf");
			parentcomposite.Add(leaf);
			parentcomposite = composite; 
			composite = new Composite("second level - first sibling - composite");
			parentcomposite.Add(composite);
			composite = new Composite("second level - second sibling - composite");
			parentcomposite.Add(composite);

			// we will leaf the second level - first sibling empty, and start 
			// populating the second level - second sibling 
			parentcomposite = composite; 
			leaf = new Leaf("third level - first sibling - leaf");
			parentcomposite.Add(leaf);
			
			leaf = new Leaf("third level - second sibling - leaf");
			parentcomposite.Add(leaf);
			composite = new Composite("third level - third sibling - composite");
			parentcomposite.Add(composite);

			return root;
		}

        public static int Main(string[] args)
        {   
       		Component component;
			Client c = new Client();
			component = c.SetupTree();

			component.DumpContents();
            return 0;
        }
    }
}
