// Factory Method

// Intent: "Define an interface for creating an object, but let subclasses 
// decide which class to instantiate. Factory Method lets a class defer 
// instantiation to subclasses". 

// For further information, read "Design Patterns", p107, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * This design pattern is often used in a framework architecture, which
 * contains a number of related classes inside the framework, and which
 * expects application developers to derive custom classes from them.
 * If the instantiation of some custom application classes needs to be
 * carried out inside framework code, then the Factory Method design
 * pattern is an ideal solution.
 * 
 * The sample below is based on a document view architecture. 
 * It shows the framework providing classes DPApplication and DPDocument
 * and the application providing MyApplication and MyDocument, derived
 * from the corresponding framework classes. Note how the construction
 * of MyDocument is initiated from inside the framework's DPApplication,
 * yet the framework was not written specifically for it.  
 * 
 * It could be extended for views and workspaces along the same lines. 
 */
 
namespace FactoryMethod_DesignPattern
{
    using System;

	// These two classes could be part of a framework,
	// which we will call DP
	// ===============================================
	
	class DPDocument 
	{
	

	}

	abstract class DPApplication 
	{
		protected DPDocument doc;
		
		abstract public void CreateDocument();

		public void ConstructObjects()
		{
			
			// Create objects as needed
			// . . .

			// including document
			CreateDocument();
		}		
		abstract public void Dump();
	}

	// These two classes could be part of an application 
	// =================================================

	class MyApplication : DPApplication 
	{
		override public void CreateDocument()
		{
			doc = new MyDocument();			
		}			

		override public void Dump()
		{
			Console.WriteLine("MyApplication exists");
		}
	}	

	class MyDocument : DPDocument 
	{

	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
            MyApplication myApplication = new MyApplication();

			myApplication.ConstructObjects();

			myApplication.Dump();
			
            return 0;
        }
    }
}
