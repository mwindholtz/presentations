// Memento

// Intent: "Without violating encapsulation, capture and externalize an 
// object's internal state so that an object can be restored to this 
// state later." 

// For further information, read "Design Patterns", p283, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * We often have client code that wishes to record the current state of an 
 * object, without being interested in the actual data values (this is 
 * needed for undo and checkpointing). To support this behavior, we can have
 * the object record its internal data in a helper class called a memento, and
 * the client code can treat this as an opaque store of the object's state. 
 * At some later point, the client can pass the memento back into the object, 
 * to restore it to the previous state. 
 */
 
namespace Memento_DesignPattern
{
    using System;

	class Originator 
	{
		private double manufacturer=0;
		private double distributor = 0;
		private double retailer = 0;

		public void MakeSale(double purchasePrice)
		{
			// We assume sales are divided equally amount the three
			manufacturer += purchasePrice * .40;
			distributor += purchasePrice *.3;
			retailer += purchasePrice *.3;
			// Note: to avoid rounding errors for real money handling 
			// apps, we should be using decimal integers
			// (but hey, this is just a demo!)
		}

		public Memento CreateMemento()
		{
			return (new Memento(manufacturer, distributor, retailer));			
		}
		
		public void SetMemento(Memento m)
		{
			manufacturer = m.A;
			distributor = m.B;
			retailer = m.C;
		}		
	}

	class Memento 
	{
		private double iA;
		private double iB;
		private double iC;

		public Memento(double a, double b, double c)
		{
			iA = a;
			iB = b;
			iC = c;
		}

		public double A 
		{
			get 
			{
				return iA;
			}
		}

		public double B 
		{
			get 
			{
				return iB;
			}
		}

		public double C 
		{
			get 
			{
				return iC;
			}
		}
	}

	class caretaker 
	{
		
	}

	    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {  			
			Originator o = new Originator();
			
			// Assume that during the course of running an application 
			// we we set various data in the originator
			o.MakeSale(45.0);
			o.MakeSale(60.0);

			// Now we wish to record the state of the object
			Memento m = o.CreateMemento();

			// We make further changes to the object
			o.MakeSale(60.0);
			o.MakeSale(10.0);
			o.MakeSale(320.0);

            // Then we decide ot change our minds, and revert to the saved state (and lose the changes since then)
			o.SetMemento(m);

            return 0;
        }
    }
}
