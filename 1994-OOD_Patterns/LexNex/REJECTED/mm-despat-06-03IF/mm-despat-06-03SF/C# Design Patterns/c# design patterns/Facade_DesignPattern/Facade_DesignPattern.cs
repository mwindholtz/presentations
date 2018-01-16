// Facade

// Intent: "Provide a unified interface to a set of interfaces in a subsystem.
// Facade defines a higher-level interface that makes the subsystem easier
// to use". 

// For further information, read "Design Patterns", p185, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Many subsystems are complex to manage - and this is a dis-incentive for 
 * client code to use them. A Facasde design pattern provides a simlified 
 * high-level API to the client, thus shielding it from direct contact 
 * with the (more complex) subsystem classes.  
 * 
 * Often the code that is inside a facade would have to be inside client 
 * code without the facade. The subsystem code beneath the facade can 
 * change, without affecting the client code. 
 */
 
namespace Facade_DesignPattern
{
	using System;

	class SubSystem_class1 
	{
		public void OperationX() 
		{
			Console.WriteLine("SubSystem_class1.OperationX called");
		}
	}

	class SubSystem_class2
	{
		public void OperationY()
		{
			Console.WriteLine("SubSystem_class2.OperationY called");
		}
	}

	class SubSystem_class3 
	{
		public void OperationZ()
		{			
			Console.WriteLine("SubSystem_class3.OperationZ called");
		}	
	}

	class Facade 
	{
		private SubSystem_class1 c1 = new SubSystem_class1();
		private SubSystem_class2 c2 = new SubSystem_class2();
		private SubSystem_class3 c3 = new SubSystem_class3();

		public void OperationWrapper()
		{
			Console.WriteLine("The Facade OperationWrapper carries out complex decision-making");
			Console.WriteLine("which in turn results in calls to the subsystem classes");
			c1.OperationX();
			if (1==1 /*some really complex decision*/)
			{
				c2.OperationY();
			}
			// lots of complex code here . . .
			c3.OperationZ();
		}
		
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
      	public static int Main(string[] args)
		{
			Facade facade = new Facade();
			Console.WriteLine("Client calls the Facade OperationWrapper");
			facade.OperationWrapper();      
            return 0;
        }
    }
}
