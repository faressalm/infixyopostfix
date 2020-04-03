package eg.edu.alexu.csd.datastructure.stack;

public class Application implements IExpressionEvaluator {
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression
* infix expression
* @return postfix expression
*/
	public String infixToPostfix(String expression) {
		Stack obj=new Stack();
		String postfix="";
		if(!check_expression(expression)) {
		throw new RuntimeException();
			
		}
		expression=dummyzero(expression);
		for(int i=0;i<expression.length();i++) {
			char x=expression.charAt(i);
			 if(Character.isDigit(x)) {
				postfix+=x;
				while(i!=expression.length()-1&&Character.isDigit(expression.charAt(i+1))) {
					i++;
					postfix+=expression.charAt(i);
				}
				
				postfix+=' ';
			}
			else if(Character.isAlphabetic(x)) {
				if(i!=expression.length()-1) {
				if(Character.isAlphabetic(expression.charAt(i+1))) {throw new RuntimeException("Wrong input");}}
				postfix+=x;
				postfix+=' ';
			}
			else if(x=='+'||x=='-'||x=='*'||x=='/'||x=='^') {
				if(obj.isEmpty()) {
					obj.push(x);
				}
				else {
					while(!obj.isEmpty()&&precedence((char) obj.peek(), x)) {
						
						postfix+=obj.pop();
						postfix+=' ';
					}
					obj.push(x);
				}
				
			}
			else if(x=='(') {
				obj.push(x);
			}
			else if(x==')') {
				int fix=0;
				while((char)obj.peek()!='(') {
					fix=1;
					postfix+=obj.pop();
					postfix+=' ';
				}if(fix==0) {
					throw new RuntimeException();
				}
				else {
				obj.pop();}
			}
		
		}
		while(!obj.isEmpty()) {
			postfix+=obj.pop();
			postfix+=' ';
		}
		
		
		return postfix.substring(0, postfix.length()-1);
	}

	/**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	public int evaluate(String expression) {
		Stack s=new Stack();
		for(int i=0;i<expression.length();i++) {
			char x=expression.charAt(i);
			
			
			if(Character.isDigit(x)) {
				int j=i;
				while(i!=expression.length()-1&&Character.isDigit(expression.charAt(i+1))) {
					i++;
				}
				s.push(Double.parseDouble(expression.substring(j, i+1)));
			}
			else if(x=='+'||x=='-'||x=='*'||x=='/'||x=='^') {
			
				s.push(preform((double)s.pop(),(double) s.pop(), x));
			 
			}else if(x==' ') {}
			else {
				throw new RuntimeException();
			}	
		}
		
		Double y=(Double) s.pop();
		if(!s.isEmpty()) {throw new RuntimeException();}
		return y.intValue();
	}
	
	/**
	 * determin if the expression is avalid infix or not
	 * @param expression
	 * the infix expression
	 * @return boolean
	 * */
	public boolean check_expression(String expression) {
		String specialCharacters="!#$%&',.:;<=>?@[]_`{|}";
		Stack obj=new Stack();
		for(int i=0;i<expression.length();i++) {
			char x=expression.charAt(i);
			if (specialCharacters.contains(Character.toString(expression.charAt(i)))) {
				return false;
			}
			else if(x=='+'||x=='*'||x=='/'||x=='-') {
				if(i==0&&x!='-') {return false;}
				if(expression.charAt(i+1)==')'||expression.charAt(i-1)=='(') {
					return false;
				}
			}
			else if(x=='(') {
				
				obj.push(x);
			}
			else if(x==')') {
				if(obj.isEmpty()) {
					return false; 
					}
				else {
					obj.pop();
				}
			}
		}
		
		if(obj.isEmpty()) {
			return true ;
		}
		else {
			return false;
		}
		
		
		
	}
	/**
	 * it finds which operator has the highest precedence or same one
	 * @param first_operand 
	 * first operator
	 * @param second_operand
	 * first operator
	 * @return true if first_operand has high precedance
	 * */
   public boolean  precedence (char first_operand,char second_operand) {
	   if(first_operand=='(') {
		   return false;
	   }
	   if(second_operand=='+'||second_operand=='-') {
		   return true;
	   }
	   if( second_operand=='^') {
		   return false;
	   }
	  //second_operand='*' or '/'
	   if(first_operand=='+'||first_operand=='-') {
		   return false;
	   }
	   else {
		   return true;
	   }
		   
	   
	   
   }
   /**
    * it calculate the value of using the operartor between the first number and the second one
    * @param second 
    * second number
    * @param first 
    * first number
    * @param operand
    * operator
    * @return the value calculated 
    * */
   public double preform(double second,double first,char operand) {
	   double ans = 0;
	   switch (operand) {
	case '+':
		ans=first+second;
		break;
	case '-':
		ans=first-second;
		break;
	case '*':
		ans=first*second;
		break;
	case '/':
		if(second==0) {
			throw new RuntimeException("can't divide by zero");
		}
		ans=first/second;
		break;
	case '^':
		ans=Math.pow(first, second);
		break;
	default:
		break;
	}
	   
	   
	   return ans;
   }

 /**
  * it change the -ve sign to a dummy zero if found in the expressin
  * @param expression
  * the infix expression
  * @return the evaluated new expression
  * */  
   public String dummyzero(String expression) {
	   for(int i=0;i<expression.length();i++) {
		   char x= expression.charAt(i);
		   if(x=='-'&&(Character.isAlphabetic(expression.charAt(i+1))||Character.isDigit(expression.charAt(i+1)))){
				
				expression=insertString(expression,"(0",i);
				 i+=3;
				   
					while(i!=expression.length()-1&&Character.isDigit(expression.charAt(i+1))) {
						i++;
					}
					expression=insertString(expression,")",i+1);
					i++;
			}
		  
	   }
	   return expression;
   }
   /**
    * it but the String to be inserted at the original string at this index
    * @param originalString
    * original sring to be updated
    * @param stringToBeInserted
    * the string to be inserted
    * @param index
    * the index at which we insert
    * @return the updated String
    * */
   public  String insertString( String originalString,String stringToBeInserted, int index) 
	    { 
	  
	        // Create a new string 
	        String newString = new String(); 
	  
	        for (int i = 0; i < originalString.length(); i++) { 
	            if (i == index) {
	                newString += stringToBeInserted; 
	            } 
	            newString += originalString.charAt(i); 
	            
	            if (i==index-1&&index==originalString.length()) { 

	                newString += stringToBeInserted; 
	            } 
	        } 
	  
	        // return the modified String 
	        return newString; 
	    } 
}
