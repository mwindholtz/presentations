// Builder

// Intent: "Separate the construction of a complex object from its
// representation so that the same construction process can create
// different representations". 

// For further information, read "Design Patterns", p97, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Builder is an object creational design pattern that codifies the 
 * construction process outside of the actual steps that carries out 
 * the construction - thus allowing the construction process itself
 * to be reused. 
 * 
 */
 
namespace Builder_DesignPattern
{
    using System;

	// These two classes could be part of a framework,
	// which we will call DP
	// ===============================================
	
	class Director 
	{
		public void Construct(AbstractBuilder abstractBuilder)
		{
			abstractBuilder.BuildPartA();
			if (1==1 ) //represents some local decision inside director
			{
				abstractBuilder.BuildPartB();			
			}
			abstractBuilder.BuildPartC();			
		}

	}

	abstract class AbstractBuilder 
	{
		abstract public void BuildPartA();
		abstract public void BuildPartB();
		abstract public void BuildPartC();
	}

	// These two classes could be part of an application 
	// =================================================

	class ConcreteBuilder : AbstractBuilder 
	{
		override public void BuildPartA()
		{
			// Create some object here known to ConcreteBuilder
			Console.WriteLine("ConcreteBuilder.BuildPartA called");
		}
				
		override public void BuildPartB()
		{
			// Create some object here known to ConcreteBuilder
			Console.WriteLine("ConcreteBuilder.BuildPartB called");
		}
		
		override public void BuildPartC()
		{
			// Create some object here known to ConcreteBuilder
			Console.WriteLine("ConcreteBuilder.BuildPartC called");
		}
	}	

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
            ConcreteBuilder concreteBuilder = new ConcreteBuilder();
			Director director = new Director();

			director.Construct(concreteBuilder);

            return 0;
        }
    }
}
