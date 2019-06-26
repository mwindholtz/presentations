public class Banker {
    public static int [][] claim = {
	{3,2,4,0,0,1,5,1},
	{5,1,3,2,0,1,1,3},
	{2,2,2,1,2,3,3,3},
	{2,0,3,2,3,1,0,2},
	{3,1,1,1,0,1,2,2},
	{4,1,4,1,2,2,4,1},
	{0,2,2,1,0,1,0,3}
    };

    public static int [][] assign = {
	{2,0,1,0,0,0,1,1},
	{1,0,2,0,0,0,0,1},
	{0,1,0,1,1,1,2,0},
	{1,0,0,0,2,1,0,2},
	{2,0,1,0,0,0,1,1},
	{1,0,0,0,1,0,2,0},
	{0,1,1,1,0,0,0,3}
    };

    public static int [] available = {1,1,2,1,1,4,3,0};
    public static boolean [] executed = {
	false, false, false, false, false, false, false
    };

    public static int next(
	int[][] claim,
	int[][] assign,
	int[] available)
    {
	int nxt = -1;
	for (int p=0; p<7; p++) {
	    if (! executed[p]) {
		boolean flag = true;
		for (int i=0; i<8; i++) {
		    if (available[i]+assign[p][i] < claim[p][i]) {
			flag = false;
			break;
		    }
		}
		if (flag) {
		    nxt = p;
		    break;
		}
	    }
	}
	return nxt;
    }

    public static void checkForDeadlock() {
	System.out.println("Initial Conditions\n");
	Print.printState();

	while (true) {
	    int p = next(claim, assign, available);
	    if (p == -1)
		break;
	    System.out.println ("Running Process " + (p+1));
	    for (int i=0; i<8; i++) {
		available[i] += assign[p][i];
	    }
	    executed[p] = true;
	}
	int c = 0;
	for (int i=0; i<7; i++) {
	    if (! executed[i])
		c++;
	}
	System.out.println ("Remaining Processes: " + c);
	if (c == 0) {
	    System.out.println ("Safe State");
	} else {
	    System.out.println ("Unsafe State");
	}
    }

    public static void main(String args[]) {
	if (args.length==0 || args[0].equals("A")) {
	    System.out.println("Running Scenario A\n");
	}
	else if (args[0].equals("B")) {
	    System.out.println ("Running Scenario B\n");
	    available[0]--;
	    assign[5][0]++;
	}
	else if (args[0].equals("C")) {
	    System.out.println("Running Scenario C\n");
	    available[2] -= 2;
	    assign[3][2] += 2;
	}
	else {
	    System.out.println("Unknown Scenario: " + args[0]);
	    System.exit(1);
	}
	checkForDeadlock();
    }
}
