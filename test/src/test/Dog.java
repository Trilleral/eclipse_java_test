package test;

public class Dog {
int zvet;
int flag;



	void vivod(){
		System.out.print(zvet);
		System.out.print(" ");
	}
}
class DogTestDrive{
	public static void main(String[] args){
		System.out.print(countN(4));
		
		int S=0;
		Dog[][] myDog = new Dog [3][3];
		for(int i = 0; i < 3; i++){
			System.out.println();
			for(int j = 0; j < 3; j++){
				myDog [i][j] = new Dog();
				myDog [i][j].zvet = 0;
				myDog [i][j].vivod();
			}
		}
		System.out.println();
		myDog [0][0].zvet = 3;
		myDog [1][1].zvet = 3;
		myDog [2][2].zvet = 3;
/*		myDog [1][0].zvet = 3;
		myDog [5][0].zvet = 1;
		myDog [0][2].zvet = 2;
		myDog [3][2].zvet = 1;
		myDog [1][4].zvet = 1;
		myDog [4][4].zvet = 2;
		myDog [2][5].zvet = 2;
		myDog [0][6].zvet = 1;
		myDog [4][6].zvet = 1;
		myDog [6][6].zvet = 6;
		*/
		for(int j = 0; j < 3; j++){
			System.out.println();
			for(int i = 0; i < 3; i++){
				myDog [i][j].vivod();
			}
		}
		for(int j = 0; j < 3; j++){
			for(int i = 0; i < 3; i++){
				area (myDog, i , j, S);
			}
		}
	}
	
	public static int countN(int rows) {
	        if (rows == 1)
	            return 1;
	        else 
	        	return rows * countN(rows - 1);
	    }
	
	
	public static void area (Dog [][] myDog1, int i, int j, int S){
		if (myDog1 [i][j].zvet==0 & myDog1 [i][j].flag==0){
			myDog1[i][j].flag=1;
			S=S+1;
		
			/*	if (myDog1 [i1-1][j1].zvet==0 & myDog1 [i1-1][j1].flag==0){
				myDog1 [i1-1][j1].flag=1;
				S=S+1;
				area (myDog1, i1 , j1, S);
				}
				if (myDog1 [i1+1][j1].zvet==0 & myDog1 [i1+1][j1].flag==0){
					myDog1 [i1+1][j1].flag=1;
					S=S+1;
					area (myDog1, i1 , j1, S);
				}
				if (myDog1 [i1][j1+1].zvet==0 & myDog1 [i1][j1+1].flag==0){
					myDog1 [i1][j1+1].flag=1;
					S=S+1;
					area (myDog1, i1 , j1, S);
				}
				if (myDog1 [i1][j1-1].zvet==0 & myDog1 [i1][j1-1].flag==0){
					myDog1 [i1][j1-1].flag=1;
					S=S+1;
					area (myDog1, i1 , j1, S);
				}*/
				
			}
		}
	}
			
		
