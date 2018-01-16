// Observer

// Intent: "Define a one-to-many dependency between objects so that when one 
// object changes state, all its dependents are notified and 
// updated automatically". 

// For further information, read "Design Patterns", p293, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * Often used for Document-View architectures, where a document stores 
 * data and one or more views renders the data. 
 */
 
namespace Observer_DesignPattern
{
    using System;
    using System.Collections;

	class Subject
	{
		private ArrayList list = new ArrayList();

		private string strImportantSubjectData = "Initial";
		
		public string ImportantSubjectData 
		{
			get 
			{
				return strImportantSubjectData;
			}
			set 
			{
				strImportantSubjectData = value;
			}
		}

		public void Attach(Observer o)
		{
			list.Add(o);
			o.ObservedSubject = this;
		}

		public void Detach(Observer o)
		{
			
		}

		public void Notify()
		{
			foreach (Observer o in list)		
			{
				o.Update();
			}			
		}
	}

	class ConcreteSubject : Subject
	{
		public void GetState()
		{
			
		}

		public void SetState()
		{
			
		}	
	}

	abstract class Observer 
	{
		protected Subject s;
		public Subject ObservedSubject 
		{
			get 
			{
				return s;		
			}
			set 
			{
				s = value;
			}
		}	
		abstract public void Update();
	}

	class ConcreteObserver : Observer 
	{
		private string observerName;
		
		public ConcreteObserver(string name)
		{
			observerName = name;
		}

		override public void Update()
		{
			Console.WriteLine("In Observer {0}: data from subject = {1}", 
				observerName, s.ImportantSubjectData);
		}	
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {     
        public static int Main(string[] args)
        {          
			// Set up everything
			ConcreteSubject s = new ConcreteSubject();
			ConcreteObserver o1 = new ConcreteObserver("first observer");
			ConcreteObserver o2 = new ConcreteObserver("second observer");

			s.Attach(o1);
			s.Attach(o2);

			// make changes to subject
			s. ImportantSubjectData = "This is important subject data";

			// Notify all observers
			s.Notify();			
            return 0;
        }
    }
}