package test;

public class Dog {
int color;
int flag;



	void vivod(){
		System.out.print(color);
		System.out.print(" ");
	}
}
class DogTestDrive{
	public static void main(String[] args){
		System.out.print(countN(4));
		
		int S=0;
		Dog[][] myDog = new Dog [5][5];
		for(int i = 0; i < 5; i++){
			System.out.println();
			for(int j = 0; j < 5; j++){
				myDog [i][j] = new Dog();
				myDog [i][j].color = 0;
				if (i==0 | i==4 |  j==0  |  j==4 ) myDog [i][j].color = 3;
				myDog [i][j].flag = 0;
				myDog [i][j].vivod();
				
			}
		}
		
		System.out.println();
		myDog [1][3].color = 3;
		myDog [1][1].color = 3;
		myDog [2][2].color = 3;
/*		myDog [1][0].color = 3;
		myDog [5][0].color = 1;
		myDog [0][2].color = 2;
		myDog [3][2].color = 1;
		myDog [1][4].color = 1;
		myDog [4][4].color = 2;
		myDog [2][5].color = 2;
		myDog [0][6].color = 1;
		myDog [4][6].color = 1;
		myDog [6][6].color = 6;
		*/
		for(int j = 1; j < 4; j++){
			System.out.println();
			for(int i = 1; i < 4; i++){
				myDog [i][j].vivod();
			}
		}
		
		for(int j = 1; j < 4; j++){
			for(int i = 1; i < 4; i++){
				S=S+countArea(i,j, myDog);
			}
		}
		System.out.print(S);
	}
	
	public static int countN(int rows) {
	        if (rows == 1)
	            return 1;
	        else 
	        	return rows * countN(rows - 1); 
	        
	    }

	public static int countArea(int i, int j,Dog [][] myDog1) {
		int S=0;
		if (IsEmpty(i,j, myDog1)==false) return 0;
		myDog1 [i][j].flag=1;
		if 		(IsEmpty(i-1,j, myDog1)==false
				& IsEmpty(i+1,j, myDog1)==false
				& IsEmpty(i,j-1, myDog1)==false
			    & IsEmpty(i,j+1, myDog1)==false				){
			return   1;
		}
        else {
        	
        /*	if (IsEmpty(i-1,j, myDog1)==true) {
        		S= S+countArea(i-1,j, myDog1);
        	}
        	if (IsEmpty(i+1,j, myDog1)==true) {
        		S= S+countArea(i+1,j, myDog1);	
        	}
        	if (IsEmpty(i,j-1, myDog1)==true) {
        		S= S+countArea(i,j-1, myDog1);
        	}
        	if (IsEmpty(i,j+1, myDog1)==true) {
        		S=S+countArea(i,j+1, myDog1);
        		
        	}*/
        	
        } 
		return 1+countArea(i,j+1, myDog1)+countArea(i,j-1, myDog1)+countArea(i+1,j, myDog1)+countArea(i-1,j, myDog1);
    }
	
	public static boolean IsEmpty( int i, int j,Dog [][] myDog1) {
		if (myDog1 [i][j].color==0 & myDog1 [i][j].flag==0 ) 
			return true;
		else 
			return false;
		
	}
	
	
	public static void area (Dog [][] myDog1, int i, int j, int S){
		if (myDog1 [i][j].color==0 & myDog1 [i][j].flag==0){
			myDog1[i][j].flag=1;
			S=S+1;
		
			/*	if (myDog1 [i1-1][j1].color==0 & myDog1 [i1-1][j1].flag==0){
				myDog1 [i1-1][j1].flag=1;
				S=S+1;
				area (myDog1, i1 , j1, S);
				}
				if (myDog1 [i1+1][j1].color==0 & myDog1 [i1+1][j1].flag==0){
					myDog1 [i1+1][j1].flag=1;
					S=S+1;
					area (myDog1, i1 , j1, S);
				}
				if (myDog1 [i1][j1+1].color==0 & myDog1 [i1][j1+1].flag==0){
					myDog1 [i1][j1+1].flag=1;
					S=S+1;
					area (myDog1, i1 , j1, S);
				}
				if (myDog1 [i1][j1-1].color==0 & myDog1 [i1][j1-1].flag==0){
					myDog1 [i1][j1-1].flag=1;
					S=S+1;
					area (myDog1, i1 , j1, S);
				}*/
				
			}
		}
	}
			
		
