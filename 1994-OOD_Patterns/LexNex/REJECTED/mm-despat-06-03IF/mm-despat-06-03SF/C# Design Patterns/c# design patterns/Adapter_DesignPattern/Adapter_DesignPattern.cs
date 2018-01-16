// Adapter

// Intent: "Convert the interface of a class into another interface 
// clients expect. Adapter lets classes work together that couldn't
// otherwise because of incompatible interfaces". 

// For further information, read "Design Patterns", p139, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Adapters are often used when client code is written to expect classes 
 * from one framework, and it meant to work with classes from a totally 
 * different framework. Assume you cannot change the code of either framework. 
 * the solution is for you to write an adapter, which appears like a 
 * native class to each framework.  
 * 
 * There are two different types of adapters - class adapter and object
 * adapter. Class adapters are based on multiple inheritance - specifically 
 * the interface of the target class and the implementation of the adaptee. 
 * Unfortunately C# supports multiple inheritance for interfaces but not 
 * for classes. Object adapters derive from the target (single inheritance)
 * and maintain a private instance of the adoptee. 
 * 
 * The sample code here shows an object adapter. We have a class called 
 * FrameworkYAdaptee which we wish to use, yet the (bulk of) the client code
 * (in GenericClientCode) is written to expect a class called FrameworkXTarget.
 * To solve the probelm we create an Adapter class, which it a FrameworkXTarget
 * to the client, and calls FrameworkYAdaptee.
 * 
 */
 
namespace Adapter_DesignPattern
{
    using System;

	class FrameworkXTarget 
	{
		virtual public void SomeRequest(int x)
		{
			// normal implementation of SomeRequest goes here					
		}
	}

	class FrameworkYAdaptee
	{
		public void QuiteADifferentRequest(string str) 
		{
			Console.WriteLine("QuiteADifferentRequest = {0}", str);
		}		
	}

	class OurAdapter : FrameworkXTarget
	{
		private FrameworkYAdaptee adaptee = new FrameworkYAdaptee();
		override public void SomeRequest(int a)
		{
			string b;
			b = a.ToString();
			adaptee.QuiteADifferentRequest(b);
		}		
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        void GenericClientCode(FrameworkXTarget x)
		{
			// We assume this function contains client-side code that only 
			// knows about FrameworkXTarget.
			x.SomeRequest(4);
			// other calls to FrameworkX go here
			// ...
		}
		
		public static int Main(string[] args)
        {
			Client c = new Client();
            FrameworkXTarget x = new OurAdapter();
			c.GenericClientCode(x);	
            return 0;
        }
    }
}
