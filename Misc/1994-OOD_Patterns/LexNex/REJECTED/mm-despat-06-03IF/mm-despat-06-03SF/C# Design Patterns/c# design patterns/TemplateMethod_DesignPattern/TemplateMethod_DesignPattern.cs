// Template Method

// Intent: "Define the skeleton of an algorithm in an operation, deferring 
// some steps to subclasses. Template Method lets subclasses redefine 
// certain steps of an algorithm without changing the algorithm's structure." 

// For further information, read "Design Patterns", p325, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * If you have an algorithm with multiple steps, and it could be helpful
 * to make some of those steps replaceable, but no the entire algorithm, then 
 * use the Template method. 
 * 
 * If the programming language in use supports generics / templates (C# does
 * not), then they could be used here. It would be educational to take a 
 * good look at the way algorithms in ISO C++'s STL work. 
 */
 
namespace TemplateMethod_DesignPattern
{
    using System;

	class Algorithm 
	{
		public void DoAlgorithm() 
		{
			Console.WriteLine("In DoAlgorithm");
			
			// do some part of the algorithm here
			
			// step1 goes here
			Console.WriteLine("In Algorithm - DoAlgoStep1");			
			// . . . 

			// step 2 goes here
			Console.WriteLine("In Algorithm - DoAlgoStep2");			
			// . . . 

			// Now call configurable/replacable part
			DoAlgoStep3();

			// step 4 goes here
			Console.WriteLine("In Algorithm - DoAlgoStep4");			
			// . . . 

			// Now call next configurable part
			DoAlgoStep5();
		}

		virtual public void DoAlgoStep3()
		{
			Console.WriteLine("In Algorithm - DoAlgoStep3");		
		}

		virtual public void DoAlgoStep5()
		{
			Console.WriteLine("In Algorithm - DoAlgoStep5");			
		}
	}

	class CustomAlgorithm : Algorithm
	{
		public override void DoAlgoStep3()
		{
			Console.WriteLine("In CustomAlgorithm - DoAlgoStep3");
		}

		public override void DoAlgoStep5()
		{
			Console.WriteLine("In CustomAlgorithm - DoAlgoStep5");
		}
	}

    /// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
			CustomAlgorithm c = new CustomAlgorithm();

			c.DoAlgorithm();

            return 0;
        }
    }
}