// Visitor

// Intent: "Represent an operation to be performed on the elements of an 
// object structure. Visitor lets you define a new operation without 
// changing the classes of the elements on which it operates." 

// For further information, read "Design Patterns", p331, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * If you have a number of elements, and wish to carry out a number of
 * operations on them, the Visitor design pattern can be helpful.
 * 
 * It lets you extract the operations to be carried out on elements from
 * the elements themselves. It means operations cna change without affecting
 * the elements. 
 */
 
namespace Visitor_DesignPattern
{
    using System;

	abstract class Visitor 
	{
		abstract public void VisitElementA(ConcreteElementA a);
		abstract public void VisitElementB(ConcreteElementB b);
	}

	class ConcreteVisitor1 : Visitor
	{
		override public void VisitElementA(ConcreteElementA a)
		{
			
		}

		override public void VisitElementB(ConcreteElementB b)
		{
			
		}
	}

	abstract class Element 
	{
		abstract public void Accept(Visitor v);
	}

	class ConcreteElementA : Element 
	{
		public Visitor myVisitor;
		override public void Accept(Visitor v)
		{
			myVisitor = v;			
		}

		public void OperationA()
		{
			
		}

		public void DoSomeWork()
		{
			// do some work here
			// . . .

			// Get visitor to visit
			myVisitor.VisitElementA(this);		

			// do some more work here
			// . . .
		}
	}

	class ConcreteElementB : Element 
	{
		override public void Accept(Visitor v)
		{
			
		}

		public void OperationB()
		{
			
		}
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {			
			ConcreteElementA eA = new ConcreteElementA();
			ConcreteElementB eB = new ConcreteElementB();
			ConcreteVisitor1 v1 = new ConcreteVisitor1();

			eA.Accept(v1);
			eA.DoSomeWork();

            return 0;
        }
    }
}
