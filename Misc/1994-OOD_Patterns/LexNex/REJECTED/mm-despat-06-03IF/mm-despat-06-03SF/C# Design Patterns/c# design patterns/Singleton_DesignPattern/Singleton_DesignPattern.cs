// Singleton

// Intent: "Ensure a class only has one instance, and provide a global
// point of access to it". 

// For further information, read "Design Patterns", p127, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * If it makes sense to have only a single instance of a class (a so-called
 * singleton), then it makes sense to enforce this (to elimintate potential 
 * errors, etc). 
 * 
 * A class based on the singleton design pattern protects its constructor, 
 * so that only the class itself (e.g. in a static method) may instantiate itself. 
 * It exposes an Instance method which allows client code to retrieve the 
 * current instance, and if it does not exist to instantiate it.  
 */
 
namespace Singleton_DesignPattern
{
    using System;

	class Singleton 
	{
		private static Singleton _instance;
		
		public static Singleton Instance()
		{
			if (_instance == null)
				_instance = new Singleton();
			return _instance;
		}
		protected Singleton(){}

		// Just to prove only a single instance exists
		private int x = 0;
		public void SetX(int newVal) {x = newVal;}
		public int GetX(){return x;}		
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
            int val;
			// can't call new, because constructor is protected
			Singleton FirstSingleton = Singleton.Instance(); 
			Singleton SecondSingleton = Singleton.Instance();

			// Now we have two variables, but both should refer to the same object
			// Let's prove this, by setting a value using one variable, and 
			// (hopefully!) retrieving the same value using the second variable
			FirstSingleton.SetX(4);
			Console.WriteLine("Using first variable for singleton, set x to 4");		

			val = SecondSingleton.GetX();
			Console.WriteLine("Using second variable for singleton, value retrieved = {0}", val);		
            return 0;
        }
    }
}