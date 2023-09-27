import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<Review> vReview = new Vector<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		String random = "";
		
		while (true) {
			int max = 999;
			int min = 0;
			int num = (int) (Math.random() * (max + 1 - min)) + min;
			
			String id = "";
			if (num<10) {
				id = "Guest#00" + num;
			}else if (num < 100) {
				id = "Guest#0" + num;
			}else {
				id = "Guest#" + num;
			}
			
			random = id;
			break;
		} 
		
		int choose = -1;
		do {
			System.out.println("Welcome " + random);
			System.out.println("================================");
			viewmenu();
			System.out.println("================================");
			System.out.println("1. Insert New Review");
			System.out.println("2. Update Review");
			System.out.println("3. Delete Review");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choose = scanInt();
			
			switch (choose) {
			case 1:
				menu1();
				break;
				
			case 2:
				menu2();
				break;
				
			case 3:
				menu3();
				break;
				
			case 4:
				System.out.println("Thank you for using the application");
				break;

			default:
				break;
			}
			
			
		} while (choose != 4);
		
	}
	
	public void menu1() {
		String name = "";
		Integer score = -1;
		String email = "";
		
		do {
			System.out.print("Insert reviewed product name [10 - 30 characters]: ");
			name = scan.nextLine();
		} while (name.length() < 10 || name.length() > 30);
		
		do {
			System.out.print("Insert review score [0 - 5]: ");
			score = scanInt();
		} while (score < 0 || score > 5);
		
		do {
			System.out.print("Input reviewer email [ends with .com]: ");
			email = scan.nextLine();
		} while (!email.endsWith(".com"));
		
		System.out.println();
		
		Review newReview = new Review();
		newReview.setName(name);
		newReview.setScore(score);
		newReview.setEmail(email);
		vReview.add(newReview);
		
	}
	
	public void menu2() {
		if (vReview.isEmpty()) {
			System.out.println("No reviews to be updated");
			System.out.println();
		}else {
			int update = -1;
			do {
				System.out.print("Input index to be updated [1-" + vReview.size() + "]: ");
				update = scanInt();
			} while (update < 1 || update > vReview.size());
			
			String name = "";
			Integer score = -1;
			String email = "";
			
			do {
				System.out.print("Insert reviewed product name [10 - 30 characters]: ");
				name = scan.nextLine();
			} while (name.length() < 10 || name.length() > 30);
			
			do {
				System.out.print("Insert review score [1 - 5]: ");
				score = scanInt();
			} while (score < 0 || score > 5);
			
			do {
				System.out.print("Input reviewer email [ends with .com]: ");
				email = scan.nextLine();
			} while (!email.endsWith(".com"));
			
			System.out.println();
			
			Review newReview = new Review();
			newReview.setName(name);
			newReview.setScore(score);
			newReview.setEmail(email);
			vReview.set(update-1, newReview);
			
			System.out.println("No. " + update);
			System.out.println("Name :" + vReview.get(update-1).getName());
			System.out.println("Score:" + vReview.get(update-1).getScore());
			System.out.println("Email:" + vReview.get(update-1).getEmail());
			System.out.println();
			System.out.println("Press Enter to continue");
			scan.nextLine();
			
		}
	}
	
	public void menu3() {
		if (vReview.isEmpty()) {
			System.out.println("No reviews to be deleted");
			System.out.println();
		}else {
			int delete = -1;
			do {
				System.out.print("Input index to be deleted [1-" + vReview.size() + "]: ");
				delete = scanInt();
			} while (delete < 1 || delete > vReview.size());
			vReview.remove(delete-1);
			
			System.out.println();
		}
	}
	
	public void viewmenu() {
		if (vReview.isEmpty()) {
			System.out.println("No reviews yet");
		}else {
			for (int i = 0; i < vReview.size()-1; i++) {
				for (int j = 0; j < vReview.size()-1-i; j++) {
					if (vReview.get(j).getScore() < vReview.get(j+1).getScore()) {
						Review temp = vReview.get(j);
						vReview.set(j, vReview.get(j+1));
						vReview.set(j+1, temp);
					}
				}
			}
			for (int i = 0; i < vReview.size(); i++) {
				System.out.println("No. " + (i+1));
				System.out.println("Name : " + vReview.get(i).getName());
				System.out.println("Score: " + vReview.get(i).getScore());
				System.out.println("Email: " + vReview.get(i).getEmail());
				System.out.println();
			}
		}
	}
	
	int scanInt() {
		int input;
		try {
			input = scan.nextInt();
		} catch (Exception e) {
			input = Integer.MIN_VALUE;
		}
		scan.nextLine();
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
