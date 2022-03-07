class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = Math.abs((ax2 - ax1) * (ay2 - ay1));
        int b = Math.abs((bx2 - bx1) * (by2 - by1));
        
        int combX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        if(combX < 0)combX = 0;
        int combY = Math.min(ay2, by2) - Math.max(ay1, by1);
        if(combY < 0)combY = 0;
        
        return a+b - (combX * combY);
    }
}