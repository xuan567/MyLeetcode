package 蓝桥杯;

public class Node {
    public int x;
    public int y;
    public int step;
    public int preX;
    public int preY;
    public String direction;

    public Node(int x,int y,int preX,int preY,int step,String direction){
        this.x = x;
        this.y = y;
        this.preX = preX;
        this.preY = preY;
        this.direction = direction;
    }
}
