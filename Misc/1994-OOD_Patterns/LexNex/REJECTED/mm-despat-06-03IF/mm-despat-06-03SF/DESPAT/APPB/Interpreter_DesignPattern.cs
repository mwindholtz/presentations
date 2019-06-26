// Interpreter

// Intent: "Given a language, define a representation for its grammar along 
// with an interpreter that uses the representation to interpret 
// sentences in the language". 

// For further information, read "Design Patterns", p243, Gamma et al.,
// Addison-Wesley, ISBN:0-201-63361-2

/* Notes:
 * This is used to implement a language using a class hierarchy 
 */
 
namespace Interpreter_DesignPattern
{
    using System;
	using System.Collections;

	class Context 
	{
		
	}

	abstract class AbstractExpression 
	{
		abstract public void Interpret(Context c);
	}

	// class for terminal symbol
	class TerminalExpression : AbstractExpression
	{
		override public void Interpret(Context c)	
		{
			
		}
	}

	// class for grammar rule (one per rule needed)
	class NonterminalExpression : AbstractExpression
	{
		override public void Interpret(Context c)	
		{
			
		}	
	}
	// to extend grammar, just add other NonterminalExpression classes

	/// <summary>
    ///    Summary description for Client.
    /// </summary>
    public class Client
    {
        public static int Main(string[] args)
        {
			Context c = new Context();
			ArrayList l = new ArrayList(); //really need a tree here!

			// build up context information 
			// . . .

            // Populate abstract syntax tree with data
			l.Add(new TerminalExpression());
			l.Add(new NonterminalExpression());

			// interpret
			foreach (AbstractExpression exp in l)
			{
				exp.Interpret(c);
			}
            		
            return 0;
        }
    }
}
