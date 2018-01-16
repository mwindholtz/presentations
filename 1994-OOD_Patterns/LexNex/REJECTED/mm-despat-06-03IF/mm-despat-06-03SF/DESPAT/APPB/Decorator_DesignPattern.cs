// Decorator

// Intent: "Attach additional responsibilites to an object dynamically. 
// Decorators provide a flexible alternative to subclassing for 
// extending functionality". 

// For further information, read "Design Patterns", p175, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Dynamically wrap functionality with additonal functionality, so that
 * the client does not know the difference. 
 */
 
namespace Decorator_DesignPattern
{
    using System;

	abstract class Component
	{
		public abstract void Draw(); 		
	}

	class ConcreteComponent : Component
	{
		private string strName;
		public ConcreteComponent(string s)
		{
			strName = s;			
		}

		public override void Draw()
		{
			Console.WriteLine("ConcreteComponent - {0}", strName);			
		}		
	}

	abstract class Decorator : Component
	{
		protected Component ActualComponent;

		public void SetComponent(Component c)
		{
			ActualComponent = c;
		}
		public override void Draw()
		{
			if (ActualComponent != null)
				ActualComponent.Draw();		
		}
	}

	class ConcreteDecorator : Decorator 
	{
		private string strDecoratorName;
		public ConcreteDecorator (string str)
		{
			// how decoration occurs is localized inside this decorator
			// For this demo, we simply print a decorator name
			strDecoratorName = str; 
		}
		public override void Draw()
		{
			CustomDecoration();
			base.Draw();
		}
		void CustomDecoration()
		{
			Console.WriteLine("In ConcreteDecorator: decoration goes here");
			Console.WriteLine("{0}", strDecoratorName);
		}
	}

	
    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        Component Setup() 
		{
			ConcreteComponent c = new ConcreteComponent("This is the real component");

			ConcreteDecorator d = new ConcreteDecorator("This is a decorator for the component");

			d.SetComponent(c);

			return d;
		}
		
		public static int Main(string[] args)
		{
			Client client = new Client();
			Component c = client.Setup();    

			// The code below will work equally well with the real component, 
			// or a decorator for the component

			c.Draw();
			
            return 0;
        }
    }
}
