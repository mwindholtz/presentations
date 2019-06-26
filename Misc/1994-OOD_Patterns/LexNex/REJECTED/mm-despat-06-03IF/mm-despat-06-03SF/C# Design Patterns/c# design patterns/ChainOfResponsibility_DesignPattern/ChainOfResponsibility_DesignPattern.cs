// Chain Of Responsibility

// Intent: "Avoid coupling the sender of a request to its receiver by giving 
// more than one object a chance to handle the reuqest. Chain the receiving 
// objects and pass the request along the chain until an object handles it." 

// For further information, read "Design Patterns", p223, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * The client sends a request and it will be operated on by one of a number 
 * of potential receivers, in a chain. The client does not know (and does 
 * not need to know) which receiver handles the request. The receivers are
 * in a chain, and the request is passed from one to the next, until one 
 * receiver actually performs the request. 
 */
 
namespace ChainOfResponsibility_DesignPattern
{
    using System;

	abstract class Handler 
	{
		protected Handler successorHandler;
		abstract public void HandleRequest(Request request);		
		public void SetSuccessor(Handler sucessor)
		{
			successorHandler = sucessor;
		}
	}

	class ConcreteHandler1 : Handler
	{
		override public void HandleRequest(Request request)
		{
			// determine if we can handle the request
			if (request.RequestType == 1) // some complex decision making!
			{
				// request handling code goes here
				Console.WriteLine("request handled in ConcreteHandler1");
			}
			else 
			{
				// not handled here - pass on to next in the chain
				if (successorHandler != null)
					successorHandler.HandleRequest(request);
			}
		}
	}

	class ConcreteHandler2 : Handler
	{
		override public void HandleRequest(Request request)
		{
			// determine if we can handle the request
			if (request.RequestType == 2) // some complex decision making!
			{
				// request handling code goes here
				Console.WriteLine("request handled in ConcreteHandler2");
			}
			else 
			{
				// not handled here - pass on to next in the chain
				if (successorHandler != null)
					successorHandler.HandleRequest(request);
			}
		}
	}

	class ConcreteHandler3 : Handler
	{
		override public void HandleRequest(Request request)
		{
			// determine if we can handle the request
			if (request.RequestType == 3) // some complex decision making!
			{
				// request handling code goes here
				Console.WriteLine("request handled in ConcreteHandler3");
			}
			else 
			{
				// not handled here - pass on to next in the chain
				if (successorHandler != null)
					successorHandler.HandleRequest(request);
			}		
		}
	}

	class Request 
	{
		private int iRequestType;
		private string strRequestParameters;

		public Request(int requestType, string requestParameters)
		{
			iRequestType = requestType;	
			strRequestParameters = requestParameters;
		}

		public int RequestType 
		{
			get 
			{
				return iRequestType;
			}
			set 
			{
				iRequestType = value;
			}
		}
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
            // Set up chain (usually one need to be done once)
			Handler firstHandler = new ConcreteHandler1();
			Handler secondHandler = new ConcreteHandler2();
			Handler thirdHandler = new ConcreteHandler3();
			firstHandler.SetSuccessor(secondHandler);
			secondHandler.SetSuccessor(thirdHandler);

			// After setting up the chain of responsibility, we can
			// now generate requests and pass then off to the 
			// chain to be handled

			// generate and fire request
			Request newRequest = new Request(2,"This are the request parameters");
			firstHandler.HandleRequest(newRequest);
			
            return 0;
        }
    }
}
