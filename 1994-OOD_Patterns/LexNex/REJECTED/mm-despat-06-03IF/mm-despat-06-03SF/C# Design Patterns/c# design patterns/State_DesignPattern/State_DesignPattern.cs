// State

// Intent: "Allow an object to alter its behavior when its internal state 
// changes. The object will appear to change its class". 

// For further information, read "Design Patterns", p305, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * 
 * A finite state machine is an appropriate construct to use for a class whose
 * reaction to stimuli depends on previous behavior. In the past, each 
 * method in the class was coded as a switch statement, switching on the state. 
 * If a new state was added, then each method had to be edited. 
 * 
 * With the state design pattern, functionality specific to a state is placed 
 * in a helper class, and the main class delegates those methods that are 
 * state-specific to such helper classes.   
 * 
 */
 
namespace State_DesignPattern
{
    using System;

	abstract class State 
	{
		protected string strStatename;		

		abstract public void Pour();
		// do something state-specific here
	}

	class OpenedState : State 
	{		
		public OpenedState ()
		{
			strStatename = "Opened";
		}
		override public void Pour()
		{
			Console.WriteLine("...pouring...");
			Console.WriteLine("...pouring...");
			Console.WriteLine("...pouring...");
		}
	}
	
	class ClosedState : State 
	{		
		public ClosedState()
		{
			strStatename = "Closed";
		}
		override public void Pour()
		{
			Console.WriteLine("ERROR - bottle is closed - cannot pour");
		}
	}

	class ContextColaBottle 
	{
		public enum BottleStateSetting {
			Closed,
			Opened
		};

		// If teh state classes had large amounts of instance data,
		// we could dynamically create them as needed - if this demo
		// they are tiny, so we just  create them as data members
		OpenedState openedState = new OpenedState();
		ClosedState closedState = new ClosedState();

		public ContextColaBottle ()
		{
			// Initialize to closed
			CurrentState = closedState;
		}

		private State CurrentState;
		
		public void SetState(BottleStateSetting newState)
		{
			if (newState == BottleStateSetting.Closed)
			{
				CurrentState = closedState;
			}
			else 
			{
				CurrentState = openedState;
			}
		}

		public void Pour()
		{
			CurrentState.Pour();
		}	
	}

  	/// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
			ContextColaBottle contextColaBottle = new ContextColaBottle();

			Console.WriteLine("initial state is closed");

			Console.WriteLine("Now trying to pour");
          	contextColaBottle.Pour();

			Console.WriteLine("Open bottle");
			contextColaBottle.SetState(ContextColaBottle.BottleStateSetting.Opened);

			Console.WriteLine("Try to pour again");
			contextColaBottle.Pour();

            return 0;
        }
    }
}
