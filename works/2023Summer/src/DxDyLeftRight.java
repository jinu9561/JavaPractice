import java.util.Scanner;

public class DxDyLeftRight {
	
	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String commands = scanner.nextLine();

	        int[] finalPosition = moveOnCoordinatePlane(commands);
	        System.out.println(finalPosition[0] + " " + finalPosition[1]);
	    }

	    public static int[] moveOnCoordinatePlane(String commands) {
	        int x = 0; // Initial x-coordinate
	        int y = 0; // Initial y-coordinate
	        char direction = 'N'; // Initial direction facing

	        for (int i = 0; i < commands.length(); i++) {
	            char command = commands.charAt(i);

	            if (command == 'L') {
	                switch (direction) {
	                    case 'N':
	                        direction = 'W';
	                        break;
	                    case 'W':
	                        direction = 'S';
	                        break;
	                    case 'S':
	                        direction = 'E';
	                        break;
	                    case 'E':
	                        direction = 'N';
	                        break;
	                }
	            } else if (command == 'R') {
	                switch (direction) {
	                    case 'N':
	                        direction = 'E';
	                        break;
	                    case 'E':
	                        direction = 'S';
	                        break;
	                    case 'S':
	                        direction = 'W';
	                        break;
	                    case 'W':
	                        direction = 'N';
	                        break;
	                }
	            } else if (command == 'F') {
	                switch (direction) {
	                    case 'N':
	                        y++;
	                        break;
	                    case 'E':
	                        x++;
	                        break;
	                    case 'S':
	                        y--;
	                        break;
	                    case 'W':
	                        x--;
	                        break;
	                }
	            }
	        }

	        int[] finalPosition = {x, y};
	        return finalPosition;
	    }

}