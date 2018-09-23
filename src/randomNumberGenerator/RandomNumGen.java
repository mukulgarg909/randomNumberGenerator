package randomNumberGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

// creating class for making constructor and defining 2 random gen fn of which one is inbuilt and other is of my own
class RandomNum {
		int seed1,seed2, mul, inc, mod;// dono built-in or by default wale fn ko alg alg seed dery
	
		RandomNum()
		{
			seed1 = seed2 =3;
			mul = 40;
			inc = 9;
			mod = 99;
		}
		
		RandomNum(int s)
		{
			seed1 = seed2 = s;
			mul = 40;
			inc = 3641;
			mod = 729;
		}
		
		int rand1() 
		{
			Random r = new Random(seed1);
			int n;
			n = r.nextInt(100) ;//% 10 (java ka built-in rng code) 
			seed1 = n; // We have to assign previous random no as seed for next random number
			//System.out.println("" +n);
			return n;
			
		}
		
		int rand2()
		{
			int ans;
			ans= ((mul*seed2)+inc)%mod;
			seed2 = (int)ans;
			//System.out.println("" +ans );
			return (int)ans;
		}
}

// creating final class for random generator with generator fn
public class RandomNumGen
{
	int generator(RandomNum r)
	{
		// RandomNum r1 =  new RandomNum(); taking values from default constructor
		// taking value from parametrised constructer with seed = 5
		int i;
		double sum1, sum2;
		sum1 = sum2 = 0;
		for(i=0; i<10; i++) // phla ek  random num 10 k average ka answer hai
		{
			sum1 += r.rand1();
			sum2 += r.rand2();
		}
		
		int rand= (int)(sum1 + sum2)%10;// here 100 if %100 i.e 2 digit num determines the range of generated final number
		return rand;
	}
	
// fibonacci fn for generating seed joki ek seed(fib series k no) k liye 30 random num generate kryga
	int n1=0, n2=1;
	int fib()
	
    {
		int n3;        
	    n3 = n1+n2;      
	    n1 = n2;    
	    n2 = n3;    
		return n3;
    }
		public static void main(String args[]) throws IOException
		{
			
		    RandomNumGen x2 = new RandomNumGen();// accessing fn of the class having main using objectName.functionName
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your seed to be added: ");
			int b = Integer.parseInt(br.readLine());
			
			int rand; // the final result of random generator is stored in rand variable
			for(int j=0; j<10; j++)// 10 fib number k liye 30 random num generate hori
			{
				int a=x2.fib();	
				RandomNum r1 =  new RandomNum(a+b);// gives us a random no for one value of fib
				System.out.println("\n\nMy seed using fib " +(a+b));// here a+b fib series jo hmesha same aari thi usko user sy ek input lekr hmesha k liye alg bna rha ra
				for(int i=0; i<30; i++)
				{	
					rand = x2.generator(r1); // essi class k object ka use kra joki access kr ra generator fn jo final random no output kr rha
					System.out.print(rand +"   ");
					//r1.seed =(int) rand;
					
				}
				
			}
			
			
	     }
		
}
