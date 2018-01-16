// Flyweight

// Intent: "Use sharing to support large numbers of fine-grained objects effectively". 

// For further information, read "Design Patterns", p195, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Useful patetn when you have a small(ish) number of objects that might be 
 * needed a very large number of times - with slightly differnt informaiton,
 * that can be externalised outside those objects. 
 */
 
namespace Flyweight_DesignPattern
{
    using System;
	using System.Collections;

	class FlyweightFactory 
	{
		private ArrayList pool = new ArrayList();

		// the flyweightfactory can crete all entries in the pool at startup 
		// (if the pool is small, and it is likely all will be used), or as 
		// needed, if the pool si large and it is likely some will never be used
		public FlyweightFactory()
		{
			pool.Add(new ConcreteEvenFlyweight());		
			pool.Add(new ConcreteUnevenFlyweight());			
		}

		public Flyweight GetFlyweight(int key)
		{
			// here we would determine if the flyweight identified by key 
			// exists, and if so return it. If not, we would create it. 
			// As in this demo we have implementation all the possible 
			// flyweights we wish to use, we retrun the suitable one. 
			int i = key % 2;
			return((Flyweight)pool[i]); 
		}
	}

	abstract class Flyweight 
	{
		abstract public void DoOperation(int extrinsicState);		
	}

	class UnsharedConcreteFlyweight : Flyweight
	{
		override public void DoOperation(int extrinsicState)
		{
			
		}
	}

	class ConcreteEvenFlyweight : Flyweight
	{
		override public void DoOperation(int extrinsicState)
		{
			Console.WriteLine("In ConcreteEvenFlyweight.DoOperation: {0}", extrinsicState);						
		}
	}

	class ConcreteUnevenFlyweight : Flyweight
	{
		override public void DoOperation(int extrinsicState)
		{
			Console.WriteLine("In ConcreteUnevenFlyweight.DoOperation: {0}", extrinsicState);			
		}	
	}

	/// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
            int[] data = {1,2,3,4,5,6,7,8};
			
			FlyweightFactory f = new FlyweightFactory();
			
			int extrinsicState = 3;
			foreach (int i in data)
			{
				Flyweight flyweight = f.GetFlyweight(i);
          		flyweight.DoOperation(extrinsicState);
			}
			
            return 0;
        }
    }
}
