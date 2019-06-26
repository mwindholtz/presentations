// Factory Method

// Intent: "Provide a surrogate or placeholder for another object to 
// control access to it". 

// For further information, read "Design Patterns", p207, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * When there is a large CPU/memory expense attached to handling an object
 * directly, it can be useful to use a lightweight proxy in front of it, 
 * which can take its place until the real object is needed. 
 */
 
namespace Proxy_DesignPattern
{
    using System;
	using System.Threading;

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    abstract class CommonSubject 
	{
		abstract public void Request();		
	}

	class ActualSubject : CommonSubject
	{
		public ActualSubject()
		{
			// Assume constructor here does some operation that takes quite a
			// while - hence the need for a proxy - to delay incurring this 
			// delay until (and if) the actual subject is needed
			Console.WriteLine("Starting to construct ActualSubject");		
			Thread.Sleep(1000); // represents lots of processing! 
			Console.WriteLine("Finished constructing ActualSubject");
		}
			
			override public void Request()
		{
			Console.WriteLine("Executing request in ActualSubject");
		}
	}

	class Proxy : CommonSubject
	{
		ActualSubject actualSubject;

		override public void Request()
		{
			if (actualSubject == null)
				actualSubject = new ActualSubject();
			actualSubject.Request();
		}	
		
	}
	
	public class Client
    {
        public static int Main(string[] args)
        {
			Proxy p = new Proxy();

			// Perform actions here
			// . . . 

			if (1==1)		// at some later point, based on a condition, 
				p.Request();// we determine if we need to use subject
					            
            return 0;
        }
    }
}
