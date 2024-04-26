package javabasic;

public class RoofExer {

	public static void main(String[] args) {

		// 별찍기 1
		// *
		// **
		// ***
		// ****
		// *****
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		// 별찍기2
		//     *
		//    **
		//   ***
		//  ****
		// *****
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 별찍기3
		// *****
		// ****
		// ***
		// **
		// *
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();


		// 별찍기4
		// *****  
		// *   *
		// *   *
		// *   *
		// *****
		int keynum = 4;
		for (int i = 0; i < keynum+1; i++) {
			for (int j = 0; j < keynum+1; j++) {
				if (i % keynum == 0 || j % keynum == 0) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// 별찍기5
		// *****  
		// ** **
		// * * *
		// ** **
		// *****
		keynum = 4;
		for (int i = 0; i < keynum+1; i++) {
			for (int j = 0; j < keynum+1; j++) {
				if (i % keynum == 0 || j % keynum == 0 || i == j || i + j == keynum) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// 별찍기6 (Z) 
		// *****
		//    *
		//   *
		//  *
		//*****
		keynum = 4; 
		for (int i = 0; i < keynum+1; i++) {
			for (int j = 0; j < keynum+1; j++) {
				if (i % keynum == 0 || i + j == keynum) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// 별찍기7 (H)
		// *   *
		// *   *
		// *****
		// *   *
		// *   *
		keynum = 4;
		for (int i = 0; i < keynum+1; i++) {
			for (int j = 0; j < keynum+1; j++) {
				if (j % keynum == 0 || i == keynum/2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		// 별찍기8 (다이아몬드)
		//  *
		// ***
		//*****
		// ***
		//  *
		keynum = 4;
		for (int i = 0; i < keynum; i++) {
			for (int j = i; j < keynum-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 0; i < keynum-2; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < keynum-2; j++) {
				System.out.print("*");
			}
			for (int j = i+1; j < keynum-2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
