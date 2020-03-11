package pkg;

public class Draw{
    String[] col0;
    String[] col1;
    String[] col2;
    String[] col3;
    String[] col4;
    public void setArrayZero() {
        col0 = new String[]{"0", "0", "0", "0", "0"};
        col1 = new String[]{"0", "0", "0", "0", "0"};
        col2 = new String[]{"0", "0", "0", "0", "0"};
        col3 = new String[]{"0", "0", "0", "0", "0"};
        col4 = new String[]{"0", "0", "0", "0", "0"};
    }
    public void setArrayContent(int array, int place, String content) {
        switch(array){
            case 0:
                col0[place] = content;
                break;
            case 1:
                col1[place] = content;
                break;
            case 2:
                col2[place] = content;
                break;
            case 3:
                col3[place] = content;
                break;
            case 4:
                col4[place] = content;
                break;
        }
    }
    public void update() {
        for(int i=0;i<col0.length;i++) {
            System.out.print("" + col0[i] + " ");
            System.out.print("" + col1[i] + " ");
            System.out.print("" + col2[i] + " ");
            System.out.print("" + col3[i] + " ");
            System.out.print("" + col4[i] + " ");
            System.out.print("\n");
        }
    }
    public void cls() {for (int i = 0; i < 50; ++i) System.out.println();}
}
