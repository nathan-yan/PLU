import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("draw.dat");
		Scanner sc = new Scanner(f);
		
		
		//zero_(sc);
		//math(sc);
		//quad(sc);
		//square(sc);
		//reverse(sc);
		//ornaments(sc);
		draw(sc);
		
	}
	

	
	public static void zero_(Scanner sc){
		int dataSets = sc.nextInt();
		
		for(int i = 0; i < dataSets; i++){
			int a = sc.nextInt();
			
			
			while(true){
				a++;
				if(Integer.toString(a).indexOf('0') < 0){
					break;
				}

			}
			System.out.println(a);
		}
	}
	
	public static void math(Scanner sc){
		int problems = sc.nextInt();
		
		int acc = 0;
		for (int p = 0; p < problems; p++){
			acc += sc.nextInt();
		}
		
		System.out.println(acc);
	}
	
	public static void reverse(Scanner sc){
		int problems = sc.nextInt();
		
		for(int i = 0 ; i < problems;i++){
			String a = sc.next();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			System.out.println(a.substring(0,b) + a.substring(c));
		}
	}
	
	public static void square(Scanner sc){
		int problems = sc.nextInt();
		
		for (int p = 0; p < problems; p++){
			String word = sc.next();
			
			if (word.length() == 1){
				if (p == (problems - 1)){
					System.out.print(word);
				}else{
					System.out.println(word);
				}
			}else{
			
			System.out.println(word);
			String space = "";
			for (int i = 0; i < word.length() - 2; i++){
				space +=  " ";
			}
			
			for (int i = 0; i < word.length() - 2; i++){
				
				System.out.println(word.charAt(i + 1) + space + word.charAt(word.length() - i - 2));
			}
			
			String reverse = "";
			for (int i = 0; i < word.length(); i++){
				reverse += word.charAt(word.length() - i - 1);
			}
			
			if (p == (problems - 1)){
				System.out.print(reverse);
			}else{
				System.out.println(reverse);
			}
			}
		}
	}
	
	public static void quad(Scanner sc){
		int problems = sc.nextInt();
		
		for(int i = 0; i < problems; i++){
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			
			double one = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
			double two = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
			
			System.out.printf("%.03f, ", one);
			System.out.printf("%.03f", two);
			System.out.println();
			
		}
		
	}
	
	
	
	public static void holes(Scanner sc){
		
	}
	
	public static void ornaments(Scanner sc){
		int dataSets = sc.nextInt();
		
		for(int i = 0; i < dataSets; i++){
			int a = sc.nextInt();
			long total = 0;
			
			for(int j = 1; j <= a; j++){
				total += (((long) j)*(((long) j)+1))/2;
			}
			System.out.println(total);
		}
	}
	
	public static void family(Scanner sc){
		
	}
	
	public static void checkpoint(Scanner sc){
		
	}
	
	public static void draw(Scanner sc){
		int dataSets = sc.nextInt();
		
		for(int i = 0; i < dataSets; i++){
			String a = sc.next();
			
			if(a.equals("right")){
				sc.next();
				int dim = sc.nextInt();
				String fil = sc.next();
				
				for(int p = 0; p < dim; p++){
					for(int l = p + 1; l < dim; l++){
						System.out.print(" ");
					}
					for(int r = 0; r <= p; r++){
						if(fil.equals("y")){
							System.out.print("#");
						} else if (fil.equals("n")){
							if(p != 0 && p!=dim-1){
								if(r != 0 && r != p){
									System.out.print(" ");
								} else {
									System.out.print("#");
								}
							} else {
								System.out.print("#");
							}
						}
						
					}
					System.out.println();
				}
				
			} else if (a.equals("rectangle")){
				int height = sc.nextInt();
				int width = sc.nextInt();
				String fil = sc.next();
				
				String[][] matrix = new String[height][width];
				
				for(int j = 0; j < height; j++){
					for(int k = 0; k < width; k++){
						if(fil.equals("n")){
							if(j == 0 || k == 0 || j == height - 1 || k == width -1){
								matrix[j][k] = "#";
							} else {
								matrix[j][k] = " ";
							} 
						} else if (fil.equals("y")){
							matrix[j][k] = "#";
						}
					}
				}
				
				for(int w = 0; w< height; w++){
					for(int v = 0; v < width; v++){
						System.out.print(matrix[w][v]);
					}
					System.out.println();
				}
				
				
			} else if (a.equals("left")) {
				sc.next();
				int dim = sc.nextInt();
				String fil = sc.next();
				
				for(int p = 0; p < dim; p++){
					for(int r = 0; r <= p; r++){
						if(fil.equals("y")){
							System.out.print("#");
						} else if (fil.equals("n")){
							if(p != 0 && p!=dim-1){
								if(r != 0 && r != p){
									System.out.print(" ");
								} else {
									System.out.print("#");
								}
							} else {
								System.out.print("#");
							}
						}
						
					}
					System.out.println();
				}
			} else {
				int dim = sc.nextInt();
				String fil = sc.next();
				
				for(int o = 1; o <= dim; o+=2){
					for(int h = o; h < dim; h+=2){
						System.out.print(" ");
					}
					for(int v = 1; v <= o; v++ ){
						if(fil.equals("y")){
							System.out.print("#");
						} else if (fil.equals("n")){
							if(v == 1 || v == o ){
								System.out.print("#");
							} else {
								System.out.print(" ");
							}
						}
						
					}
					System.out.println();
				}
				
				for(int o = 1; o < dim; o+=2){
					
					for(int x = 1;x <= o; x += 2){
						System.out.print(" ");
					}
					
					for(int v = 1; v <= dim - o - 1; v++ ){
						if(fil.equals("y")){
							System.out.print("#");
						} else if (fil.equals("n")){
							if(v == 1 || v == dim - o - 1 ){
								System.out.print("#");
							} else {
								System.out.print(" ");
							}
						}
					}
					System.out.println();
				}
				
				
			}
		}
	}
	

	


}
