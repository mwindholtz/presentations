// Bridge

// Intent: "Decouple an abstraction from its implemntation so that the
// two can vary independently". 

// For further information, read "Design Patterns", p151, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Coupling between classes and class libraries is a major maintenance 
 * headache. To ease this problem, often the client talks to an 
 * abstraction description, which in turn calls an implementation.
 * Sometimes these must evolve - when one changes there can be a need 
 * to change the other.  The bridge design pattern lets the abstraction 
 * and its implementation evolve separately.  
 * 
 * So, what is the difference between a bridge and an interface? Interfaces
 * can be used when creating bridges - but it should be noted that bridges 
 * have additional possibilities. Both the abstraction and the 
 * implementation may evolve over time and be the parent of derived classes. 
 * The operations needed in the implementation could be defined in an 
 * interface if there are no standard methods which are available at the 
 * top-level of the implementation.   
 * 
 */
 
namespace Bridge_DesignPattern
{
    using System;

	class Abstraction 
	{
		protected Implementation impToUse;

		public void SetImplementation(Implementation i)
		{
			impToUse = i;
		}

		virtual public void DumpString(string str)
		{
			impToUse.DoStringOp(str);				   
		}
	}

	class DerivedAbstraction_One : Abstraction 
	{
		override public void DumpString(string str)
		{
			str += ".com";
			impToUse.DoStringOp(str);			
		}		
	}

	class Implementation 
	{
		public virtual void DoStringOp(string str)
		{
			Console.WriteLine("Standard implementation - print string as is");
			Console.WriteLine("string = {0}", str);
		}		
	}

	class DerivedImplementation_One : Implementation 
	{
		override public void DoStringOp(string str)
		{
			Console.WriteLine("DerivedImplementation_One - don't print string");
		}	
	}

	class DerivedImplementation_Two : Implementation 
	{
		override public void DoStringOp(string str)
		{
			Console.WriteLine("DerivedImplementation_Two - print string twice");
			Console.WriteLine("string = {0}", str);
			Console.WriteLine("string = {0}", str);
		}	
	}
	
    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        Abstraction SetupMyParticularAbstraction() 
		{
			// we localize to this method the decision which abstraction and
			// which implementation to use. These need to be decided 
			// somewhere and we do it here. All teh rest of the client 
			// code can work against the abstraction object. 
			Abstraction a = new DerivedAbstraction_One();
			a.SetImplementation(new DerivedImplementation_Two());
			return a;
		}

		public static int Main(string[] args)
        {     	
            Client c = new Client();
			Abstraction a = c.SetupMyParticularAbstraction();
            	
			// From here on client code thinks it is talking to the 
			// abstraction, and will not need to be changed as 
			// derived abstractions are changed. 

			// more client code using the abstraction goes here 
			// . . . 
			a.DumpString("Clipcode");

			return 0;
        }
    }
}
