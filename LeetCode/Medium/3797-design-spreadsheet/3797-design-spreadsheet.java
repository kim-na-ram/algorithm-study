class Spreadsheet {
    private final int alphabet = 26;
    private int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[alphabet + 1][rows + 1];
    }
    
    public void setCell(String cell, int value) {
        sheet[getRowLabel(cell)][getRowNumber(cell)] = value;
    }
    
    public void resetCell(String cell) {
        sheet[getRowLabel(cell)][getRowNumber(cell)] = 0;
    }
    
    public int getValue(String formula) {
        String[] XY = formula.split("=")[1].split("\\+");
        
        String X = XY[0];
        String Y = XY[1];
        int sum = 0;

        if(Character.isAlphabetic(X.charAt(0)))
            sum += sheet[getRowLabel(X)][getRowNumber(X)];
        else 
            sum += Integer.parseInt(X);

        if(Character.isAlphabetic(Y.charAt(0)))
            sum += sheet[getRowLabel(Y)][getRowNumber(Y)];
        else 
            sum += Integer.parseInt(Y);

        return sum;
    }

    private int getRowLabel(String cell) {
        return cell.charAt(0) - 'A';
    }

    private int getRowNumber(String cell) {
        return Integer.parseInt(cell.substring(1, cell.length()));
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */