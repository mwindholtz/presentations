// Abstract Factory

// Intent: "Provide an interface for creating families of related or
// dependent objects without specifying their concrete classes". 

// For further information, read "Design Patterns", p87, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * When the construction needed involves many objects, possible organised
 * in multi-faceted arrangements, the entire construction can be delegated
 * to an abstract factory. This exposes standardised creation functionality
 * which can be customised in concrete implementation to suit your specific
 * needs, and avoid embedding this information in higher level code - it
 * just needs to know how to call the abstract factory.
 * 
 * In this sample, we have a framework with three abstract operating classes, 
 * called DPDocument, DPWorkspace and DPView and one abstract construction 
 * class, called DPFactory. An application-level class, called DPApplication
 * is responsible for construction. 
 * 
 * We have a series of application-level operating classes derived from this
 * framework - MyDocument, MyWorkspace and MyView. For design reasons we 
 * assume we wish to instantiate these from inside DPApplication. As there
 * are multiple objects needed and they could be arranged in different 
 * lattices, we use a factory, MyFactory (in our example, there are all 
 * simple siblings), which is called inside DPApplication. 
 * 
 */
 
namespace AbstractFactory_DesignPattern
{
    using System;

	// These classes could be part of a framework,
	// which we will call DP
	// ===========================================
	
	abstract class DPDocument 
	{
		abstract public void Dump();		
	}

	abstract class DPWorkspace
	{
		abstract public void Dump();
	}
	
	abstract class DPView 
	{
		abstract public void Dump();
	}	
	
	abstract class DPFactory 
	{
		abstract public DPDocument CreateDocument();
		abstract public DPView CreateView();
		abstract public DPWorkspace CreateWorkspace();
	}

	abstract class DPApplication 
	{
		protected DPDocument doc;
		protected DPWorkspace workspace;
		protected DPView view;
		
		public void ConstructObjects(DPFactory factory)
		{
			// Create objects as needed
			doc = factory.CreateDocument();
			workspace = factory.CreateWorkspace();
			view = factory.CreateView();
		}		
		
		abstract public void Dump();

		public void DumpState()
		{
			if (doc != null) doc.Dump();
			if (workspace != null) workspace.Dump();
			if (view != null) view.Dump();
		}
	}

	// These classes could be part of an application 
	class MyApplication : DPApplication 
	{
		MyFactory myFactory = new MyFactory();

		override public void Dump()
		{
			Console.WriteLine("MyApplication exists");
		}

		public void CreateFamily()
		{
			MyFactory myFactory = new MyFactory();
			ConstructObjects(myFactory);			
		}
	}	

	class MyDocument : DPDocument 
	{
		public MyDocument()
		{
				Console.WriteLine("in MyDocument constructor");			
		}
		
		override public void Dump()
		{
			Console.WriteLine("MyDocument exists");
		}
	}

	class MyWorkspace : DPWorkspace 
	{
		override public void Dump()
		{
			Console.WriteLine("MyWorkspace exists");
		}
	}

	class MyView : DPView 
	{
		override public void Dump()
		{
			Console.WriteLine("MyView exists");
		}
	}

	class MyFactory : DPFactory 
	{
		override public DPDocument CreateDocument()
		{
			return new MyDocument();
		}
		override public DPWorkspace CreateWorkspace()
		{
			return new MyWorkspace();
		}		
		override public DPView CreateView()
		{
			return new MyView();
		}
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
			MyApplication myApplication = new MyApplication();

			myApplication.CreateFamily();

			myApplication.DumpState();
			
            return 0;
        }
    }
}
